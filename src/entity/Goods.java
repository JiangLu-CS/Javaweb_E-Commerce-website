package entity;

public class Goods {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private String name;
    private String img1;
    private String img2;
    private String img3;
    private double price;
    private int stock;

    public Goods() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Goods(String id, String name, double price, int stock, String img1,
                 String img2, String img3) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}