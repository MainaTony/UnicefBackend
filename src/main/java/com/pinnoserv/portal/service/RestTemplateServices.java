package com.pinnoserv.portal.service;

import java.util.Map;

public interface RestTemplateServices {

    String GETRequest(String URL, String authorizationKey);

    String POSTRequest(String URL, String authorizationKey, Object requestBody);

    String POSTRequestNoAuth(String URL, Object requestBody);

    String POSTRequestWithSession(String URL, Object requestBody, String sessionId);

    String GETRequestNoAuth(String URL);

    String POSTRequestForParams(String URL, String authorizationKey, Map<String,String> requestBody);

    String POSTRequestWithParams(String URL, Map<String,String> requestBody);

    String POSTRequestWithParamsAndSession(String URL, Map<String,String> requestBody, String sessionId);
}
