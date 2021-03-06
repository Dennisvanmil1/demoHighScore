package nl.ycp.demoHighScore.model;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighScoreRepository extends CrudRepository<HighScore, Long> {

	//void delete();
	//List<HighScore> findAllByScore();
	//List<HighScore> findAll();
	
	List<HighScore> findByName(String name);
	
	//List<HighScore> findAllOrderByScoreAsc();
	//List<HighScore> findTop10ByOrderByScoreAsc();
	//List<HighScore> findByScore(int score);
	
	List<HighScore> findByScoreOrderByNameAsc(int currentScore);
	
	//List<HighScore> findAllByOrderByScoreDesc();

	

	List<HighScore> findAllByOrderByIdDesc();

	List<HighScore> findAllByOrderByOldHighScoreDesc();

	List<HighScore> findTop10ByOrderByScoreDesc();

	List<HighScore> findAllByOrderByScoreDesc();

	//@Query("SELECT p FROM HighScore hs WHERE LOWER(p.Id) = LOWER(:Id)")
	//public List<HighScore> find(@Param("Id") long Id);

	

	

	

	//List<HighScore> findAllOrderByScoreDesc();

	//List<HighScore> findAllByScoreOrderByScoreDesc();



	
	
	
	
	


	
}
