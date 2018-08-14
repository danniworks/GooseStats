package server.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * The purpose of this class is to utilize Apache HTTP Client to return jSON
 */
public class HttpHelper {

    public HttpHelper() { }

    public String getJson(String url) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);

        return content;
    }

}
