package com.gateway.client;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.asynchttpclient.Dsl.*;

public class ClientTest {

    @Test
    public void getResponseTest() throws InterruptedException, ExecutionException {
        byte[] response = Client.getResponse("http://192.168.101.105:8080/");
        System.out.println(response.toString());
    }

    @Test
    public void asyncClientTest() throws ExecutionException, InterruptedException {
        AsyncHttpClient asyncHttpClient = asyncHttpClient();
        Future<Response> responseFuture = asyncHttpClient.prepareGet("http://192.168.101.105:8080/").execute();
        Response response = responseFuture.get();
        System.out.println(response.toString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders().toString());
        System.out.println(response.getResponseBody().toString().getBytes());
    }
}
