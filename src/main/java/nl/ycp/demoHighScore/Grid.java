package nl.ycp.demoHighScore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grid {
	
	private Long id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
	    return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	private String columnA;
	private String columnB;
	private String columnC;
	private String columnD;
	private String columnE;
	private String columnF;
	private String columnG;
	private String columnH;
	
	private String token = "<img src=\"/images/empty.jpg\">";
	
	public String getColumnC() {
		return columnC;
	}

	public void setColumnC(String columnC) {
		this.columnC = columnC;
	}

	public String getColumnD() {
		return columnD;
	}

	public void setColumnD(String columnD) {
		this.columnD = columnD;
	}

	public String getColumnE() {
		return columnE;
	}

	public void setColumnE(String columnE) {
		this.columnE = columnE;
	}

	public String getColumnF() {
		return columnF;
	}

	public void setColumnF(String columnF) {
		this.columnF = columnF;
	}

	public String getColumnG() {
		return columnG;
	}

	public void setColumnG(String columnG) {
		this.columnG = columnG;
	}

	public String getColumnH() {
		return columnH;
	}

	public void setColumnH(String columnH) {
		this.columnH = columnH;
	}

	
	
	public String getToken() {
		return token;
	}

	public void setToken(String x) {
		this.token = x;
	}

	public String getColumnA() {
		return columnA;
	}

	public void setColumnA(String columnA) {
		this.columnA = columnA;
	}

	public String getColumnB() {
		return columnB;
	}

	public void setColumnB(String columnB) {
		this.columnB = columnB;
	}

	


}
