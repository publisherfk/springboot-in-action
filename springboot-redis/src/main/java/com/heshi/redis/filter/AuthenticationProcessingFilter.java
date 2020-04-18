package com.heshi.redis.filter;

import com.heshi.redis.utils.BearerTokenExtractorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: fukun
 * @Date: 2020/4/17 21:06
 * @since
 */
@Component
public class AuthenticationProcessingFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${authentication.api.url}")
    private String hostName;
    private String path = "/oauth2/v1/%s/valid";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authenticationCode = BearerTokenExtractorUtils.extractHeaderToken(request);
        String url = String.format(hostName + path, authenticationCode);
        RestTemplate userInfoRestTemplate = new RestTemplate();
        Map result = userInfoRestTemplate.getForObject(url, Map.class);
        if (null != result && null != result.get("valid") && Boolean.parseBoolean(String.valueOf(result.get("valid")))) {
            filterChain.doFilter(request, response);
        } else {
            logger.error("认证失败");
        }

    }
}
