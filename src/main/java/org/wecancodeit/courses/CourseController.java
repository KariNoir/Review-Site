package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

	
	@Resource
	private CourseRepository courseRepo;

	@RequestMapping("/show-courses")

	@GetMapping("/show-courses")
	public String findAllCourses(Model model) {
		model.addAttribute("courseModel", courseRepo.findAllCourses());
		return "courses-template";

	}

	@GetMapping("/show-single-course/{id}")
	public String findSingleCourse(@PathVariable(value = "id") Long id, Model model) throws CourseNotFoundException {
		if (courseRepo.findOneCourse(id) == null) {
			throw new CourseNotFoundException();
		}
		model.addAttribute("courseModel", courseRepo.findOneCourse(id));
		return "course-template";

	}

}