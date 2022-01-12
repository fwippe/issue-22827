package com.example;

import java.util.Set;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "https://docs.googleapis.com")
@RegisterProvider(OidcClientRequestReactiveFilter.class)
public interface DocService {
    @Path("/v1/documents")
    @POST
    public String createDocument(String param);
}
