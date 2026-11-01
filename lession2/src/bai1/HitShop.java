package bai1;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {

    static final List<String> tenhang = new ArrayList<>();
    static final List<Double> giatien = new ArrayList<>();
    static final List<Integer> soluong = new ArrayList<>();

    static void themhang(String hang,double gia,int sl){
        tenhang.add(hang);
        giatien.add(gia);
        soluong.add(sl);
        System.out.println("Da them mat hang thanh cong!");
    }
    static void xoahang(int index){
        if (index < 0 || index >= tenhang.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        tenhang.remove(index);
        giatien.remove(index);
        soluong.remove(index);
        System.out.println("Da xoa mat hang thanh cong!");
    }
    static void xemgio(){
        if (tenhang.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }
        System.out.println("\n====DANH SACH GIO HANG====");
        for (int i = 0; i < tenhang.size(); i++) {
            double lineTotal = giatien.get(i) * soluong.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    tenhang.get(i),
                    giatien.get(i),
                    soluong.get(i),
                    lineTotal);
        }
    }
    static double tinhtong(){
        double total = 0;
        for (int i = 0; i < tenhang.size(); i++) {
            total += giatien.get(i) * soluong.get(i);
        }
        return total;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    System.out.print("\nNhập tên hàng: ");
                    String hang = sc.nextLine();
                    System.out.print("Nhập giá tiền: ");
                    double gia = sc.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int sl = sc.nextInt();
                    themhang(hang, gia, sl);
                    break;
                case 2:
                    xemgio();
                    if (!tenhang.isEmpty()) {
                        System.out.print("Nhập số thứ tự mặt hàng muốn xóa (tính từ 1): ");
                        int stt = sc.nextInt();
                        xoahang(stt - 1);
                    }
                    break;
                case 3:
                    xemgio();
                    break;
                case 4:
                    double tongTien = tinhtong();
                    System.out.printf("Tổng tiền trong giỏ hàng: %.1f%n", tongTien);
                    break;
                case 0:
                    ;
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }

        }while (choose !=0 );

        sc.close();
    }
}