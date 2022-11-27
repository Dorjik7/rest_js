package ru.dorjik.rest_js.utils;

public class UserErrorResponse {

    private String message;
    private long time;

    public UserErrorResponse(String message, long timestamp) {
        this.message = message;
        this.time = time;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
