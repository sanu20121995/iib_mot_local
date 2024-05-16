package com.iib.gov.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestipService {

	
	String getClientIp(HttpServletRequest request);
}
