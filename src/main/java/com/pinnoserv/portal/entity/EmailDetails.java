package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;
}
