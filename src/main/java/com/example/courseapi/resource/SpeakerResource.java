package com.example.courseapi.resource;

import com.example.courseapi.model.Speaker;
import com.example.courseapi.service.SpeakerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/find/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable("id") Long id) {
        Speaker speaker = speakerService.findSpeakerById(id);
        return new ResponseEntity<>(speaker, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Speaker> addSpeaker(@RequestBody Speaker speaker) {
        Speaker newSpeaker = speakerService.addSpeaker(speaker);
        return new ResponseEntity<>(newSpeaker, HttpStatus.OK);
    }
}
