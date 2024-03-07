package com.spring.todo1.models;

import lombok.Data;

import java.util.List;

@Data
public class UpdateStatusRequest {
    private List<Long> articleIds;
    private String newStatus;
}
