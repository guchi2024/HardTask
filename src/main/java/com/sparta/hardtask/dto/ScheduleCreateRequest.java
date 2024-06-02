package com.sparta.hardtask.dto;

import com.sparta.hardtask.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    private String title;

    private String password;

    private String description;

    private String username;

    public ScheduleCreateRequest(String title, String password, String description, String username) {
        this.title = title;
        this.password = password;
        this.description = description;
        this.username = username;
    }

    public Schedule toEntity() {
        return new Schedule(this.title,
                this.description,
                this.username,
                this.password);
    }
}