package com.example.courseapi.resource;

import com.example.courseapi.model.Speaker;
import com.example.courseapi.service.SpeakerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/speakers")
public class SpeakerResource {
    private final SpeakerService speakerService;

    public SpeakerResource(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Speaker>> getAllSpeakers() {
         List<Speaker> speakers =  speakerService.findAllSpeakers();
         return new ResponseEntity<>(speakers, HttpStatus.OK);
    }
}
