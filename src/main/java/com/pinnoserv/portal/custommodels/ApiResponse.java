package com.pinnoserv.portal.custommodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * API Response Wrapper
 *
 * @param <T> Particular entity type
 * @author kenny
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {"responseCode", "responseDescription", "entity", "recordCount"})
@XmlType(propOrder = {"responseCode", "responseDescription", "entity", "recordCount"})
public class ApiResponse<T> {

    protected String responseCode;
    protected String responseDescription;
    private T entity;
    private Integer recordCount;

    public ApiResponse() {
    }

    public ApiResponse(String responseCode, String responseDescription, T entity,
                       Integer recordCount) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.entity = entity;
        this.recordCount = recordCount;
    }

    public ApiResponse(String responseCode, String responseDescription, T entity) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.entity = entity;
    }

    public ApiResponse(String responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }


    /**
     * @return Payload of the response.
     */
    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    /**
     * @return Response code
     */
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return Description of the response. It is optional.
     */
    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }


    /**
     * @return recordCount for results on each request
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    @Override
    public String toString() {
        return String.format("ApiResponse[responseCode=%s,responseDescription=%s,entity=%s]",
                responseCode, responseDescription, entity);
    }
}