package nl.ycp.demoHighScore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridRepository extends CrudRepository<Grid, Long> {

	List<Grid> findTop10ByOrderByColumnADesc();

	List<Grid> findTop10ByOrderByColumnBDesc();

	List<Grid> findTop10ByOrderByColumnCDesc();

	List<Grid> findTop10ByOrderByColumnEDesc();

	List<Grid> findTop10ByOrderByColumnDDesc();

	List<Grid> findTop10ByOrderByColumnFDesc();

	List<Grid> findTop10ByOrderByColumnGDesc();

	List<Grid> findTop10ByOrderByColumnHDesc();

}
