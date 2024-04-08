package com.example.courseapi.model.requests;

public class ChangeUsernameRequest {

    private String oldUsername;

    private String newUsername;

    public ChangeUsernameRequest() {}

    public ChangeUsernameRequest(String oldUsername, String newUsername) {
        this.oldUsername = oldUsername;
        this.newUsername = newUsername;
    }

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }
}
