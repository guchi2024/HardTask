package com.sparta.hardtask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.hardtask.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {

    private Long id;

    private String title;

    private String description;

    private String username;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public ScheduleResponse(Long id, String title, String description, String username,
                            LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.username = username;
        this.createdAt = createdAt;
    }

    public static ScheduleResponse toDto(Schedule schedule) {
        return new ScheduleResponse(schedule.getId(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getUsername(),
                schedule.getCreatedAt());
    }
}