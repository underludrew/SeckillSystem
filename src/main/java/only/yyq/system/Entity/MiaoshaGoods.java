package only.yyq.system.Entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MiaoshaGoods extends Goods{
    private int id;
    private int goods_id;
    private int stock_count;
    private double miaosha_price;
    private Date start_date;
    private Date end_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }


    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getMiaosha_price() {
        return miaosha_price;
    }

    public void setMiaosha_price(double miaosha_price) {
        this.miaosha_price = miaosha_price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }
}
