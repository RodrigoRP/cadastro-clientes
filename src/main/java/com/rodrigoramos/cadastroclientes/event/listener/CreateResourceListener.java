package com.rodrigoramos.cadastroclientes.event.listener;

import com.rodrigoramos.cadastroclientes.event.CreateResourceEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class CreateResourceListener implements ApplicationListener<CreateResourceEvent> {

    @Override
    public void onApplicationEvent(CreateResourceEvent createResourceEvent) {
        HttpServletResponse response = createResourceEvent.getResponse();
        Long id = createResourceEvent.getId();

        addHeaderLocation(response, id);
    }

    private void addHeaderLocation(HttpServletResponse response, Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
