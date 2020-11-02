package com.gateway.filter;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;

/**
 * 将请求的method置为POST
 * @author lw
 */
public class MethodToPost implements RequestFilter {

    @Override
    public void filter(HttpRequest request) {
        request.setMethod(HttpMethod.POST);
    }
}