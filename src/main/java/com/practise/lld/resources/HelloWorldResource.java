package com.practise.lld.resources;

import com.google.inject.Inject;
import com.practise.lld.service.HelloWorldService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class HelloWorldResource {

    private final HelloWorldService helloWorldService;


    @GET
    public Response helloworld() {
        return Response.ok()
                .entity(helloWorldService.getMessage())
                .build();
    }
}

