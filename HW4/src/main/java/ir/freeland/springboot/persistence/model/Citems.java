package ir.freeland.springboot.persistence.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ISC_STUDENTS")
public class Citems {
//its for Corrupted Item
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Corrupted_NAME", length = 50, nullable = false, unique = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Items item;
	private  String problem;
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	

}
