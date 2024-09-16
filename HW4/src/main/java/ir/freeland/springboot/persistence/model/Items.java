package ir.freeland.springboot.persistence.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ISC_STUDENTS")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Item_NAME", length = 50, nullable = false, unique = false)
	private String name;
	private Double Price;
	private String Cataloge;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return Price;
	}



	public void setPrice(Double price) {
		Price = price;
	}



	public String getCataloge() {
		return Cataloge;
	}



	public void setCataloge(String cataloge) {
		Cataloge = cataloge;
	}



	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", price=" + Price
				+ ", cataloge=" + Cataloge + "]";
	}
	

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private Citems corruptedItem;
}
