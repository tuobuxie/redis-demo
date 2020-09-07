package com.jlpay.application.template.controller.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author lishaofeng
 */
@Data
public class QueryRequest {

    public static String HTTP = "http";
    public static String THRIFT = "thrift";
    public static String SPRING_CLOUD = "springCloud";
    @NotEmpty
    @Pattern(regexp = "(http|springCloud|thrift)://.*")
    String uri;
    @NotEmpty
    String content;
    @Min(0)
    @Max(18)
    @JsonProperty("first_delay_level")
    Integer firstDelayLevel;
    @Min(0)
    @Max(18)
    @JsonProperty("interval_delay_level")
    Integer intervalDelayLevel;
    @NotEmpty
    @JsonProperty("log_id")
    String logId;
    @Min(0)
    @Max(10)
    Integer times;
    @NotEmpty()
    @JsonProperty("query_id")
    String queryId;
}
