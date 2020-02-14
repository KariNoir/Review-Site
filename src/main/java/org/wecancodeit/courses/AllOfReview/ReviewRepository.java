package org.wecancodeit.courses.AllOfReview;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	// put the review in the "database" i.e. the @Repository under the private Map
	// section
	private Map<Long, Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1L, "The Best", "category", "content");
	private Review reviewTwo = new Review(2L, "I got to have it", "category", "content");
	private Review reviewThree = new Review(3L, "I'll pass", "category", "content");

	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);
	}

	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review);

		}
	}

	public Review findOneReview(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {

		return reviewList.values();
	}

}
