package com.example.courseapi.exception;

public class SpeakerNotFoundException extends RuntimeException{
    public SpeakerNotFoundException(String message) {
        super(message);
    }
}
