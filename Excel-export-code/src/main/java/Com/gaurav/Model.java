package Com.gaurav;

import org.springframework.stereotype.Service;

@Service
public class Model {
    private Integer cid;
    private String name;
    private Double price;

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Model{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
