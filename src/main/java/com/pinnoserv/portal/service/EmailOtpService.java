package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.entity.DataSource;

public interface EmailOtpService {
    ApiResponse findByEmail();
}
