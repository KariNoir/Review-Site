package org.wecancodeit.courses.AllOfReview;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Category {

	
	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping("/review")
	public String showAllReview(Model model) {
		model.addAttribute("review", reviewRepo.findAllReviews());
		return "review";
	}
}
