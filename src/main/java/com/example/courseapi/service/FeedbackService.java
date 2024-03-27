package com.example.courseapi.service;

import com.example.courseapi.exception.FeedbackNotFoundException;
import com.example.courseapi.model.Feedback;
import com.example.courseapi.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    public List<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    public List<Feedback> findFeedbacksByCourseId(Long courseId) {
        return feedbackRepository.findFeedbacksByCourseId(courseId)
                .orElseThrow(() -> new FeedbackNotFoundException("Course by id" + courseId + "was not found"));
    }
}
