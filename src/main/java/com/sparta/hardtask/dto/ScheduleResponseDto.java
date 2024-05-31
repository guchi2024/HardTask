package com.sparta.hardtask.dto;

import com.sparta.hardtask.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.username = schedule.getUsername();
        this.password = schedule.getPassword();
        this.contents = schedule.getContents();
    }

    public ScheduleResponseDto(Long id, String title, String username, String contents, String password) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }

    public ScheduleResponseDto(Long id, String username, String contents) {
        this.id = id;
        this.username = username;
        this.contents = contents;
    }

//    public ScheduleResponseDto(Long id, String username, String contents, String password) {
//        this.id = id;
//        this.username = username;
//        this.contents = contents;
//        this.password = password;
//    }
}

// Memo entity와 매우 유사함에도 Dto로 따로 분리하는 이유는 DB와 소통하는 클래스는 다룰때 매우 조심스럽기 때문

// JPA
