package org.wecancodeit.courses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerMockMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private Course courseOne;

	@Mock
	private Course courseTwo;

	@MockBean
	private CourseRepository courseRepo;

	@Test
	public void shouldGetStatusOfOkWhenNavigatignToAllCourses() throws Exception {
		this.mockMvc.perform(get("/show-courses")).andExpect(status().isOk());
		andExpect(view().name("courses-template"));
	}

	private void andExpect(ResultMatcher name) {
		// TODO Auto-generated method stub

	}

	@Test
	public void shouldGetStatusOfOkWhenNavigatignToCoursesOnePage() throws Exception {
		when(courseRepo.findOneCourse(1L)).thenReturn(courseOne);
		this.mockMvc.perform(get("/show-single-course?id=1")).andExpect(status().isOk());
		andExpect(view().name("course-template"));
	}

	@Test
	public void shouldAddAllCoursesToTheModel() throws Exception {
		when(courseRepo.findAllCourses()).thenReturn(Arrays.asList(courseOne, courseTwo));
		this.mockMvc.perform(get("/show-courses"));
		andExpect(model().attribute("coursesModel", hasSize(2)));

	}

	@Test
	public void shouldAddSingleCourseToTheModel() throws Exception {
		when(courseRepo.findOneCourse(1L)).thenReturn(courseOne);
		this.mockMvc.perform(get("/show-single-course?id=1"))
				.andExpect(model().attribute("courseModel", is(courseOne)));

	}

	@Test
	public void shouldReturnNotFoundForBadRequest() throws Exception {
		long badId = 5L;
		when(courseRepo.findOneCourse(badId)).thenReturn(null);
		this.mockMvc.perform(get("/show-single-course?id=5")).andExpect(status().isNotFound());
	}
}
