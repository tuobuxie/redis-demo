package com.jlpay.application.template.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lishaofeng
 */
@ConfigurationProperties(value = "client.http")
@Data
public class RestTemplateProperties {
    /**
     * 设置整个连接池最大连接数 根据自己的场景决定
     */
    private int maxTotal = 200;
    /**
     * 路由是对maxTotal的细分
     */
    private int defaultMaxPerRoute = 50;
    /**
     * 服务器返回数据(response)的时间，超过该时间抛出read timeout
     */
    private int socketTimeout = 3000;
    /**
     * 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
     */
    private int connectTimeout = 1000;
    /**
     * 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
     */
    private int connectionRequestTimeout = 10;

}
