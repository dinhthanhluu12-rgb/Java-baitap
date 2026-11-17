import model.CartItem;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {

    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();

    static void addItem(Product product, int quantity){
        cart.add(new CartItem(product,quantity));
        System.out.println("Da them mat hang thanh cong!");
    }
    static void removeItem(int index){
        if (index < 0 || index >= cart.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        cart.remove(index);
        System.out.println("Da xoa mat hang thanh cong!");
    }
    static void printItems(){
        System.out.println("Khach hang: " + currentCustomer);
        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }
        System.out.println("\n====DANH SACH GIO HANG====");
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            Product p = item.getProduct();
            System.out.printf("%d. %s | %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    p.getId(),
                    p.getName(),
                    p.getPrice(),
                    item.getQuantity(),
                    item.getTotal());
        }
    }
    static double calculateTotal(){
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p1 = new Product("P01", "Áo thun", 150000, 20);
        Product p2 = new Product("P02", "Bình nước", 50000, 10);
        int choose;

        do{
            System.out.println("\n===DANH SACH LUA CHON===");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xóa mặt hàng");
            System.out.println("3. Xem giỏ");
            System.out.println("4. Xem tổng tiền");
            System.out.println("0. Thoát");
            System.out.print("Lua chon cua ban: ");
            choose = sc.nextInt();
            sc.nextLine();


            switch (choose) {
                case 1:
                    System.out.println("Sản phẩm có sẵn:");
                    System.out.println("- " + p1.getId() + ": " + p1.getName());
                    System.out.println("- " + p2.getId() + ": " + p2.getName());
                    System.out.print("Nhập mã sản phẩm: ");
                    String code = sc.nextLine().trim();
                    System.out.print("Nhập số lượng: ");
                    int sl = sc.nextInt();
                    sc.nextLine();

                    Product selected = null;
                    if (p1.getId().equals(code)) {
                        selected = p1;
                    } else if (p2.getId().equals(code)) {
                        selected = p2;
                    }

                    if (selected == null) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    } else if (sl <= 0) {
                        System.out.println("Số lượng phải lớn hơn 0.");
                    } else {
                        addItem(selected, sl);
                    }
                    break;
                case 2:
                    printItems();
                    if (!cart.isEmpty()) {
                        System.out.print("Nhập số thứ tự mặt hàng muốn xóa (tính từ 1): ");
                        int stt = sc.nextInt();
                        sc.nextLine();
                        removeItem(stt - 1);
                    }
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tổng tiền: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }

        }while (choose !=0 );

        sc.close();
    }
}