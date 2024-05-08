package com.iib.gov.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class SeurityEntryPointHandler extends BasicAuthenticationEntryPoint {


@Override
public void afterPropertiesSet() {
// TODO Auto-generated method stub
setRealmName("sample-application");
super.afterPropertiesSet();
}
@Override
public void commence(HttpServletRequest request, HttpServletResponse response,
AuthenticationException authException) throws IOException {
response.addHeader("www-Authnticate", "BasicRealName"+getRealmName());
response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
PrintWriter writer=response.getWriter();
writer.println("Incorrect Username and Password");
}

}
