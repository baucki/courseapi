package com.example.courseapi.service;

import com.example.courseapi.exception.SpeakerNotFoundException;
import com.example.courseapi.model.entities.Speaker;
import com.example.courseapi.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    private final SpeakerRepository speakerRepository;
    @Autowired
    public SpeakerService(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }
    public Speaker addSpeaker(Speaker speaker) {
        return this.speakerRepository.save(speaker);
    }
    public List<Speaker> findAllSpeakers() {
        return this.speakerRepository.findAll();
    }
    public Speaker findSpeakerById(Long id) {
        return this.speakerRepository.findSpeakerById(id)
                .orElseThrow(() -> new SpeakerNotFoundException("Speaker with id: " + id + " was not found"));
    }
}
