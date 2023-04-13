package com.ryan.aspect;

import com.ryan.constant.ResponseCode;
import com.ryan.exception.GlobalAppException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class InternalRequestAspect {
    private static final String HEADER_TOKEN = "x-api-key";
    private static final List<String> TOKENS = List.of("123", "abc", "abc123");

    @Before("@annotation(InternalEndpoint)")
    public void logRequestHeaders() {
        log.info("[RequestHeaderAspect] Start...");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            log.warn("[RequestHeaderAspect] No header...");
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(HEADER_TOKEN);
        if (!validateHeaderToken(token)) throw new GlobalAppException(ResponseCode.FORBIDDEN);
        log.info("Token: {}", token);
    }

    private boolean validateHeaderToken(String token) {
        if (!StringUtils.hasText(token)) return false;
        return TOKENS.contains(token);
    }
}
