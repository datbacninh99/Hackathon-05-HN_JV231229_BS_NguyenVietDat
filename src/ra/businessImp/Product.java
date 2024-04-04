package ra.businessImp;

import ra.business.IProduct;

import java.util.Scanner;

public class Product implements IProduct, Comparable<Product> {
    private int productid;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productid, String productName, String title, String descriptions, float importPrice, float exportPrice, boolean productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = exportPrice - importPrice;
        this.productStatus = productStatus;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        this.productid = scanner.nextInt();
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.next();
        System.out.print("Nhập tiêu đề: ");
        this.title = scanner.next();
        System.out.print("Nhập mô tả: ");
        this.descriptions = scanner.next();
        System.out.print("Nhập giá nhập: ");
        this.importPrice = scanner.nextFloat();
        System.out.print("Nhập giá xuất: ");
        this.exportPrice = scanner.nextFloat();
        this.interest = this.exportPrice - this.importPrice;
        System.out.print("Nhập trạng thái sản phẩm: ");
        this.productStatus = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productid);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Tiêu đề: " + this.title);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("Trạng thái sản phẩm: " + (this.productStatus ? "Hoạt động" : "Không hoạt động"));
    }

    @Override
    public int compareTo(Product otherProduct) {
        return Float.compare(this.interest, otherProduct.interest);
    }
}