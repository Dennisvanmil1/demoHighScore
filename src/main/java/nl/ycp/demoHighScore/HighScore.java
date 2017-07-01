package nl.ycp.demoHighScore;







import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HighScore {
	private Long id;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
	    return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	
	
    
	private int oldHighScore = 0;
	private int score;
	private String date;
	private String name;
	
	public int getScore() {
		return score;
	}

	public int getOldHighScore() {
		return oldHighScore;
	}

	public void setOldHighScore(int oldHighScore) {
		this.oldHighScore = oldHighScore;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String ldt) {
		this.date = ldt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

}
