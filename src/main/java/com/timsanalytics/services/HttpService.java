package com.timsanalytics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timsanalytics.beans.KeyValueTimestamp;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpService {
    // REF: https://www.baeldung.com/httpclient-post-http-request

    public static void main(String[] args) throws IOException {
        HttpService httpService = new HttpService();
        httpService.executePostRequest();
    }

    private void executePostRequest() throws IOException {
//        String url = "https://server.timsanalytics.com/api/v1/raspberry/test";
        String url = "http://localhost:5001/api/v1/raspberry/test";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        KeyValueTimestamp<String, String> keyValueTimestamp = new KeyValueTimestamp<>("laptop", "success", System.currentTimeMillis());
        ObjectMapper objectMapper = new ObjectMapper();
        String objectStr = objectMapper.writeValueAsString(keyValueTimestamp);
        StringEntity entity  = new StringEntity(objectStr);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        String result = EntityUtils.toString(response.getEntity());
        System.out.println("result: " + result);
    }
}
