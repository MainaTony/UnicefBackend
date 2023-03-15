package com.pinnoserv.portal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class RestTemplateServicesImpl implements RestTemplateServices {

    private final Logger LOG = LoggerFactory.getLogger(RestTemplateServicesImpl.class);

    @Override
    public String GETRequest(String URL, String authorizationKey) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = createHttpHeaders(authorizationKey);
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception ex) {
            LOG.error("** Exception: " + ex.getMessage());
            return null;
        }

    }

    @Override
    public String POSTRequest(String URL, String authorizationKey, Object requestBody) {
        try {
            HttpHeaders headers = createHttpHeaders(authorizationKey);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<Object> request = new HttpEntity<>(requestBody, headers);
            String response = restTemplate.postForObject(URL, request, String.class);
            return response;
        } catch (Exception ex) {
            LOG.error("Error Occured:" + ex.getMessage());
            return null;
        }
    }

    private HttpHeaders createHttpHeaders(String encodedAuth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", encodedAuth);
        return headers;
    }

    @Override
    public String POSTRequestNoAuth(String URL, Object requestBody) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<Object> request = new HttpEntity<>(requestBody);
            String response = restTemplate.postForObject(URL, request, String.class);
            return response;
        } catch (Exception ex) {
            LOG.error("Error Occured:" + ex.getMessage());
            return null;
        }
    }

    @Override
    public String GETRequestNoAuth(String URL) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<String> entity = new HttpEntity<>("parameters");
            ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception ex) {
            LOG.error("** Exception: " + ex.getMessage());
            return null;
        }

    }

    @Override
    public String POSTRequestForParams(String URL, String authorizationKey, Map<String,String> requestBody) {
        try {
            HttpHeaders headers = createHttpHeaders(authorizationKey);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<Object> request = new HttpEntity<>(requestBody, headers);
            String response = restTemplate.postForObject(URL, request, String.class);
            return response;
        } catch (Exception ex) {
            LOG.error("Error Occured:" + ex.getMessage());
            return null;
        }
    }

    @Override
    public String POSTRequestWithParams(String URL, Map<String,String> requestBody) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<Object> request = new HttpEntity<>(requestBody);
            String response = restTemplate.postForObject(URL, request, String.class);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.error("Error Occured:" + ex.getMessage());
            return null;
        }
    }

    @Override
    public String POSTRequestWithParamsAndSession(String URL, Map<String,String> requestBody, String sessionId) {
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Cookie", "JSESSIONID=" + sessionId);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<Object> request = new HttpEntity<>(requestBody, requestHeaders);
            String response = restTemplate.postForObject(URL, request, String.class);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.error("Error Occured:" + ex.getMessage());
            return null;
        }
    }

    @Override
    public String POSTRequestWithSession(String URL, Object requestBody, String sessionId) {
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Cookie", "JSESSIONID=" + sessionId);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<Object> request = new HttpEntity<>(requestBody, requestHeaders);
            String response = restTemplate.postForObject(URL, request, String.class);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.error("Error Occured:" + ex.getMessage());
            return null;
        }
    }
}
