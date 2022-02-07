package com.timsanalytics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timsanalytics.beans.DataSample;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpService {
    // REF: https://www.baeldung.com/httpclient-post-http-request

    @Value("${api.url}")
    private String url;

    public static void main(String[] args) throws IOException {
        HttpService httpService = new HttpService();
        httpService.executePostRequest();
    }

    public void executePostRequest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        DataSample<String, String> dataSample = new DataSample<>("test-device", "test-sample", "success", System.currentTimeMillis());
        ObjectMapper objectMapper = new ObjectMapper();
        String objectStr = objectMapper.writeValueAsString(dataSample);
        StringEntity entity = new StringEntity(objectStr);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println("result: " + result);
    }
}
