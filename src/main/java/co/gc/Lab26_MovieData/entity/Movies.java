package co.gc.Lab26_MovieData.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Movies {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String category;
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movies(Long id, String title, String category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", category=" + category + "]";
	}

	

}
