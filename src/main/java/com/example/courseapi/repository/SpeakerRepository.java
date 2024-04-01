package com.example.courseapi.repository;

import com.example.courseapi.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    Optional<Speaker> findSpeakerById(Long id);
}
