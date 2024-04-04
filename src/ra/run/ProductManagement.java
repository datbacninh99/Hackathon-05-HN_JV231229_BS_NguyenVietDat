package ra.run;

import ra.business.IProduct;
import ra.businessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManagement {
    private static ArrayList<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"Áo","Áo Man United","Mô tả 1",100000,200000,true));
        productList.add(new Product(2,"Áo","Áo Man City","Mô tả 2",200000,400000,true));
        productList.add(new Product(3,"Áo","Áo Chelsea","Mô tả 3",250000,500000,true));
        productList.add(new Product(4,"Áo","Áo Liverpool","Mô tả 4",300000,600000,true));
        productList.add(new Product(4,"Áo","Áo Arsenal","Mô tả 5",350000,700000,true));
        productList.add(new Product(4,"Áo","Áo Tottenham","Mô tả 4",400000,800000,true));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU****************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm\n" +
                    "7. Thoát\n" +
                    "Mời chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputData();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    sortProductByInterest();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    changeProductStatusById();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn lại");
            }
        } while (true);
    }

    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sản phẩm: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputData();
            productList.add(product);
        }
    }

    private static void displayData() {
        for (IProduct product : productList) {
            product.displayData();
        }
    }

    private static void sortProductByInterest() {
        Collections.sort(productList);
        System.out.println("Sắp xếp thành công");
        displayData();
    }

    private static void deleteProductById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = scanner.nextInt();
        productList.removeIf(product -> ((Product) product).getProductid() == id);
    }

    private static void searchProductByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.next();
        for (IProduct product : productList) {
            if (((Product) product).getProductName().equalsIgnoreCase(name)) {
                product.displayData();
            }
        }
    }

    private static void changeProductStatusById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm cần thay đổi trạng thái: ");
        int idChange = scanner.nextInt();
        for (IProduct product : productList) {
            if (((Product) product).getProductid() == idChange) {
                ((Product) product).setProductStatus(!((Product) product).isProductStatus());
            }
        }
    }
}