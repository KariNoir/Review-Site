package org.wecancodeit.courses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

	// put the course in the "database" i.e. the @Repository under the private Map
	// section
	private Map<Long, Course> courseList = new HashMap<>();
	private Course courseOne = new Course(1L, "course one", "description");
	private Course courseTwo = new Course(2L, "course two", "description");

	public CourseRepository() {
		courseList.put(courseOne.getId(), courseOne);
		courseList.put(courseTwo.getId(), courseTwo);
	}

	public CourseRepository(Course... courses) {
		for (Course course : courses) {
			courseList.put(course.getId(), course);

		}
	}

	public Course findOneCourse(long id) {
		return courseList.get(id);
	}

	public Collection<Course> findAllCourses() {

		return courseList.values();
	}

}
