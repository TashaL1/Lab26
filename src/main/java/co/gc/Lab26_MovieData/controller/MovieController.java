package co.gc.Lab26_MovieData.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.gc.Lab26_MovieData.entity.Movies;
import co.gc.Lab26_MovieData.repo.MovieRepo;

@RestController
public class MovieController {

	@Autowired
	MovieRepo m;

	Random rand = new Random();
	
	@GetMapping("/")
	public List<Movies> listMovies() {
		List<Movies> movieList = m.findAll();
		return movieList;
	}

	@GetMapping("find-category/{category}")
	public ArrayList<Movies> findCat(@PathVariable("category") String category) {
		ArrayList<Movies> movie = m.findByCategory(category);
		return movie;
	}
	
	@GetMapping("rand-movie")
	public Movies randMovie() {
		List<Movies> movieList = m.findAll();
		int r = rand.nextInt(movieList.size());
	return movieList.get(r);
	}

	@GetMapping("rand-movies")
	public List<Movies> randMovies() {
		List<Movies> movieList = m.findAll();
		int r = rand.nextInt(movieList.size());
	return (List<Movies>) movieList.get(r);
	}

	@GetMapping("category-types")
	public TreeSet<String> findDistinctCat() {
		return m.findDistinctCategory();
	}

	@GetMapping("find-title/{title}")
	public ArrayList<Movies> findTitle(@PathVariable("title") String title) {
		ArrayList<Movies> movie = m.findByTitle(title);
		return movie;
	}
	
	@GetMapping("find-by-title/{title}")
	public List<Movies> findByTitleLike(@PathVariable("title") String title) {
		List<Movies> movie = m.findByTitleContaining(title);
		return movie;
	}
//	@GetMapping("author-types")
//	public TreeSet<String> findDistinctAuth(){
//		return m.findDistinctAuthor();
//	}
//	@GetMapping("find-book-author/{author}")
//	public ArrayList<Movies> findAuthor(@PathVariable("author") String author) {
//		ArrayList<Movies> movie = m.findByAuthor(author);
//		return movie;
//	}
}
