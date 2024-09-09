package Com.gaurav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="COURSE_DTLS")
public class Course {
	
	@Id
	private Integer cid;
	private String name;
	private Double price;

	private  String brand;

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
		return "Course{" +
				"cid=" + cid +
				", name='" + name + '\'' +
				", price=" + price +
				", brand='" + brand + '\'' +
				'}';
	}
}
