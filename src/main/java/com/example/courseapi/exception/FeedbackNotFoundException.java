package com.example.courseapi.exception;

public class FeedbackNotFoundException extends RuntimeException{
    public FeedbackNotFoundException (String message) {
        super(message);
    }
}
