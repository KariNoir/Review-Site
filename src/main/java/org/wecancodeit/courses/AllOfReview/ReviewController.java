package org.wecancodeit.courses.AllOfReview;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/show-courses")
public class ReviewController {

	@Resource
	private ReviewRepository reviewRepo;

	@GetMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviewModel", reviewRepo.findAllReviews());
		return "reviews-template";

	}

	@GetMapping("/show-single-review/{id}")
	public String findSingleReview(@PathVariable(value = "id") Long id, Model model) throws ReviewNotFoundException {
		if (reviewRepo.findOneReview(id) == null) {
			throw new ReviewNotFoundException();
		}
		model.addAttribute("reviewModel", reviewRepo.findOneReview(id));
		return "review-template";

	}

}