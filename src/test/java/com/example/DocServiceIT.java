package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

@QuarkusTest
public class DocServiceIT {
    @Inject @RestClient
    DocService docService;

    @Test
    public void mustCreateDocument() {
        WebApplicationException thrown = assertThrows(WebApplicationException.class, () -> docService.createDocument("test"));
        assertThat(thrown.getResponse().getStatus(), is(400));
    }
}
