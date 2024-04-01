package com.example.courseapi.resource;

import com.example.courseapi.model.Feedback;
import com.example.courseapi.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackResource {
    private final FeedbackService feedbackService;
    public FeedbackResource(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.findAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }
    @GetMapping("/find/{courseId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCourseId(@PathVariable("courseId")Long courseId) {
        List<Feedback> feedbacks = feedbackService.findFeedbacksByCourseId(courseId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        Feedback newFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.OK);
    }
}
