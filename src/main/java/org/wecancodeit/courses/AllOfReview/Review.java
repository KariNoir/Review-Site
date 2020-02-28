package org.wecancodeit.courses.AllOfReview;
	
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.lob;

	@Entity
	public class Review {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
		@Lob
	private String category;
	private String content;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	
	}
	
	public Review(long id, String name, String category, String content) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.content = content;
	}

}
