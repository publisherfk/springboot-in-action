package com.heshi.server1.filter;

import com.heshi.server1.utils.JwtUtils;
import com.heshi.server1.vo.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 消息中心的安全配置中心
 */
//@Component
public class MsgCenterSecurityFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Value("${jwt.header:GWAuthorization}")
    private String jwtHeader;
    @Value("${jwt.tokenHead:Bearer }")
    private String jwtTokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.jwtHeader);
        if (null != authHeader && authHeader.toLowerCase().startsWith(jwtTokenHead.toLowerCase())) {
            final String authToken = authHeader2Token(authHeader, jwtTokenHead);
            JwtUser user = jwtUtils.getUserFromToken(authToken);
            request.setAttribute("jwtUser", user);
        } else {
            throw new SecurityException("no Authentication!");
        }
        filterChain.doFilter(request, response);
    }

    private String authHeader2Token(String authHeader, String jwtTokenHead) {
        if (null != authHeader && null != jwtTokenHead && authHeader.startsWith(jwtTokenHead)) {
            return authHeader.substring(jwtTokenHead.length());
        }
        return authHeader;
    }
}
