package nl.ycp.demoHighScore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Drank {
	private Long id;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
	    return id;
	}

	public void setId(Long id){
	    this.id = id;
	}

	private String name;
	private int price;
	private boolean healthy;
	private int alcohol;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isHealthy() {
		return healthy;
	}
	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}
	public int getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}
}

