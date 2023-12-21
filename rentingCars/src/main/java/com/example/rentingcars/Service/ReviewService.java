package com.example.rentingcars.Service;


import com.example.rentingcars.API.ApiException;
import com.example.rentingcars.DTO.ReviewDTO;
import com.example.rentingcars.Model.Car;
import com.example.rentingcars.Model.Review;
import com.example.rentingcars.Model.Supplier;
import com.example.rentingcars.Model.User;
import com.example.rentingcars.Repository.CarRepository;
import com.example.rentingcars.Repository.ReviewRepository;
import com.example.rentingcars.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final RentalService rentalService;
    private final CarService carService;



    public List<Review> getALLReview() {

        return reviewRepository.findAll();
    }





    public void addReview(ReviewDTO reviewDTO) {

        Car car = carRepository.findCarById(reviewDTO.getCar_id());
        User user = userRepository.findUserById(reviewDTO.getUser_id());
        List<Review> reviews =getALLReview();

        if (car == null || user == null) {
            throw new ApiException("car id or user id not found");
        }

        Integer sum=0;
        Integer c=1;
        for (int i = 0; i < getALLReview().size(); i++) {
            if(getALLReview().get(i).getCar().getId().equals(reviewDTO.getCar_id())){
                sum = sum + getALLReview().get(i).getRating();
                c++;
            }

        }

        Integer totalRating = reviewDTO.getRating() + sum;
        Integer avg = totalRating /c;


//       Integer totalRating = reviews.stream().mapToInt(Review::getRating).sum();
//       int x  = totalRating / reviews.size();

        Review review = new Review(null, reviewDTO.getFeedback(),avg, user, car);
        reviewRepository.save(review);

    }


        public List<Car> findAllByFeedback(String feedback) {
              List<Car> cars = new ArrayList<>();
            for (int i = 0; i <getALLReview().size() ; i++) {
                if(getALLReview().get(i).getFeedback().contains(feedback)){
                    cars.add(getALLReview().get(i).getCar());
            }
            }
        return cars;
    }


}
