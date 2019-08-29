package co.gc.Lab26_MovieData.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gc.Lab26_MovieData.entity.Movies;

public interface MovieRepo extends JpaRepository<Movies, Long> {

	ArrayList<Movies> findByCategory(String category);
	
	ArrayList<Movies> findByTitle(String title);

	@Query("select distinct category from Movies")
	TreeSet<String> findDistinctCategory();
	
	@Query("select random category from Movies")
	TreeSet<String> findRandomCategory();
	
	List<Movies> findByTitleContaining(String title);

	@Query("select distinct author from Movie")
	TreeSet<String> findDistinct();

	
}
	
