package com.example.courseapi.repository;

import com.example.courseapi.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<List<Feedback>> findFeedbacksByCourseId(Long courseId);
}
