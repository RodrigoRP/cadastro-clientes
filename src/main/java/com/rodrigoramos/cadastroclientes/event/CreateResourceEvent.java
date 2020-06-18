package com.rodrigoramos.cadastroclientes.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class CreateResourceEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private Long id;

    public CreateResourceEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
