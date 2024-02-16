package com.any.filter;

import com.any.utils.enc.Encryption;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class Filter implements ContainerRequestFilter, ContainerResponseFilter {


    @Transactional
    @Override
    public void filter(ContainerRequestContext containerRequestContext){
        FilterMethods.filter(containerRequestContext);
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        FilterMethods.filter(containerRequestContext,containerResponseContext);
    }
}
