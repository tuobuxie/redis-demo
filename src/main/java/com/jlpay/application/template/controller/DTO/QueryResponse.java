package com.jlpay.application.template.controller.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lishaofeng
 */
@Data
public class QueryResponse {

    @JsonProperty("ret_code")
    String retCode;

    @JsonProperty("ret_msg")
    String retMsg;


}
