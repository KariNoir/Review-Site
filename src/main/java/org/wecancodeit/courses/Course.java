package org.wecancodeit.courses;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Course {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@Lob
	private String description;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Course(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
