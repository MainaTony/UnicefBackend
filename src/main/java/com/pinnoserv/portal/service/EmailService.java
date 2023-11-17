package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.EmailDetails;
import org.springframework.stereotype.Service;


public interface EmailService {
    void sendEmailAlerts(EmailDetails emailDetails);
}
