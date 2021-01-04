package com.huyhoang.instagram.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huyhoang.instagram.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class AuthEntryPointExceptionHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {

        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED,
                Collections.singletonMap("authentication", "Unable to authenticate"));


        httpServletResponse.setContentType("application/json");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), apiError);
    }
}
