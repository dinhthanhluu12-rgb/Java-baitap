import java.util.Scanner;

public class Hitshop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String tenHang;
        double dongia;
        int sl;

        do {
            System.out.print("Nhap ten mat hang: " );
            tenHang = sc.nextLine();
            if(tenHang.isEmpty()){
                System.out.println("Ban phai nhap ten mat hang!");
            }
        } while (tenHang.isEmpty());

        do {
            System.out.print("Nhap don gia mat hang: " );
            dongia = sc.nextDouble();
            if(dongia < 0){
                System.out.println("Don gia phai lon hon 0!");
            }
        } while (dongia < 0);

        do {
            System.out.print("Nhap so luong hang: " );
            sl = sc.nextInt();
            if(sl < 0){
                System.out.println("So luong phai la so nguyen duong!");
            }
        } while (sl < 0);

        double thanhTien = dongia * sl;

        System.out.println("=============Thong Tin Mat Hang=============");
        System.out.println("Ten mat hang: " +tenHang);
        System.out.println("Don gia: " +dongia);
        System.out.println("So luong mat hang: " +sl);
        System.out.println("============================================");
        System.out.println("===================HOA DON==================");
        System.out.printf("%-10s | %-10s | %-10s | %-12s\n", "Tên Hàng", "Số Lượng", "Đơn Giá", "Thành Tiền");
        System.out.printf("%-10s | %-10s | %-10s | %-12s\n", tenHang, sl, dongia, thanhTien);
        System.out.println("============================================");
        sc.close();

    }
}