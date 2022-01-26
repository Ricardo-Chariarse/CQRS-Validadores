package com.simulacion.proyecto.ecommerce.CQRSValidadores.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse implements Serializable {
    private Boolean success;
    private ArrayList<String> messages;
    private Object data;
    private int code = 200;

    public StatusResponse() {
        this(false, null, null, 200);
    }

    public StatusResponse(Boolean success) {
        this(success, null, null, 200);
    }

    public StatusResponse(Boolean success, String message) {
        this(success, message, null, 200);
    }

    public StatusResponse(Boolean success, String message, Object data) {
        this(success, message, data, 200);
    }

    public StatusResponse(Boolean success, String message, Object data, int statusCode) {
        this.success = success;
        if (message == null || message.length() == 0)
            this.messages = new ArrayList<>();
        else
            this.messages = new ArrayList<>(Arrays.asList(message));

        this.data = data;
        this.code = statusCode;
    }

    public void AddMessage(String message) {
        if (!(message == null || message.length() == 0)) {
            this.messages.add(message);
        }
    }

    public void Clear() {
        this.messages.clear();
    }
}
