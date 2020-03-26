package com.heshi.server1.utils;

import com.heshi.server1.vo.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fukun
 */
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    public static final String ROLE_REFRESH_TOKEN = "ROLE_REFRESH_TOKEN";

    private static final String CLAIM_KEY_USER_ID = "user_id";
    private static final String CLAIM_KEY_USER_NAME = "user_name";
    private static final String CLAIM_KEY_COMPANY_ID = "company_id";
    private static final String CLAIM_KEY_STAFF_ID = "staff_id";
    private static final String CLAIM_KEY_STAFF_NAME = "staff_name";
    private static final String CLAIM_KEY_STAFF_CODE = "staff_code";
    private static final String CLAIM_KEY_LANGUAGE = "language";

    private Map<String, String> tokenMap = new ConcurrentHashMap<>(32);

    @Value("${jwt.secret:123qwe!@#}")
    private String secret;

    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public JwtUser getUserFromToken(String token) {
        JwtUser user;
        try {
            final Claims claims = getClaimsFromToken(token);
            Long companyId = Long.parseLong(String.valueOf(claims.get(CLAIM_KEY_COMPANY_ID)));
            Long userId = Long.parseLong(String.valueOf(claims.get(CLAIM_KEY_USER_ID)));
            Long staffId = Long.parseLong(String.valueOf(claims.get(CLAIM_KEY_STAFF_ID)));
            String staffCode = String.valueOf(claims.get(CLAIM_KEY_STAFF_CODE));
            String staffName = String.valueOf(claims.get(CLAIM_KEY_STAFF_NAME));
            String language = String.valueOf(claims.get(CLAIM_KEY_LANGUAGE));
            String username = claims.getSubject();
            user = new JwtUser(companyId, userId, staffId, staffCode, staffName, language);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            user = null;
        }
        return user;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate(long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

}
