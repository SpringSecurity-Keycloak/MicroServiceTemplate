package org.todaytech.microservice.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "Problem")
public class Problem {

    private String logRef;
    private String message;

    public Problem(String logRef, String message) {
        super();
        this.logRef = logRef;
        this.message = message;
    }

    public Problem() {
        super();

    }

    public String getLogRef() {
        return logRef;
    }

    public void setLogRef(String logRef) {
        this.logRef = logRef;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

    }
}

