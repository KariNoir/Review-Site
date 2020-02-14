package org.wecancodeit.courses;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

public class CoursesRepositoryTest {

	private Course courseTwo = new Course(2L, "course name", "description");
	private Course courseOne = new Course(1L, "course name", "description");

	@Resource
	private CourseRepository underTest;

	@Test
	public void shouldFindCourseOneById() {
		underTest = new CourseRepository(courseOne);
		Course foundCourse = underTest.findOneCourse(1L);
		assertThat(foundCourse, is(courseOne));
	}

	@Test
	public void shouldFindCourseTwoById() {
		underTest = new CourseRepository(courseTwo);
		Course foundCourse = underTest.findOneCourse(2L);
		assertThat(foundCourse, is(courseTwo));
	}

	@Test
	public void shouldFindAllCourses() {
		underTest = new CourseRepository(courseOne, courseTwo);
		Collection<Course> foundCourses = underTest.findAllCourses();
		assertThat(foundCourses, containsInAnyOrder(courseOne, courseTwo));
	}

}
