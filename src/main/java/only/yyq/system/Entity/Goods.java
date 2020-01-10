package only.yyq.system.Entity;

import org.springframework.stereotype.Component;

@Component
public class Goods {
    private int id;
    private String Goods_Name;
    private String Goods_type;
    private double price;
    private String imgpath;
    private String content;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_Name() {
        return Goods_Name;
    }

    public void setGoods_Name(String goods_Name) {
        Goods_Name = goods_Name;
    }

    public String getGoods_type() {
        return Goods_type;
    }

    public void setGoods_type(String goods_type) {
        Goods_type = goods_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
