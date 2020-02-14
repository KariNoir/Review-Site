package org.wecancodeit.courses.AllOfReview;

public class Review {


	private Long id;
	private String name;
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
