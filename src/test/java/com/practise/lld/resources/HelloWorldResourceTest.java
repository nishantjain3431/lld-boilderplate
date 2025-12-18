package com.practise.lld.resources;


import com.practise.lld.service.HelloWorldService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloWorldResourceTest {

    @Mock
    private HelloWorldService helloWorldService;

    @InjectMocks
    private HelloWorldResource helloWorldResource;

    @BeforeEach
    public void beforeMethod() {
        when(helloWorldService.getMessage()).thenReturn("helloWorld");
    }

    @Test
    void shouldTestHelloWorldResource() {
        Assertions.assertEquals("helloWorld", helloWorldResource.helloworld().getEntity());
    }
}