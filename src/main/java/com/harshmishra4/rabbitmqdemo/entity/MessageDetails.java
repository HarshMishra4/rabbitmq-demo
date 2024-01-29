package com.harshmishra4.rabbitmqdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDetails {
    private String toEmail;
    private String subject;
    private String downloadLink;
}
