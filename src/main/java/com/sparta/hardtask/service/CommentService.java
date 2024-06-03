package com.sparta.hardtask.service;

import com.sparta.hardtask.dto.CommentCreateRequest;
import com.sparta.hardtask.dto.CommentResponse;
import com.sparta.hardtask.entity.Comment;
import com.sparta.hardtask.entity.Schedule;
import com.sparta.hardtask.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleService scheduleService;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse save(long scheduleId, CommentCreateRequest request) {

        // DB에 일정이 존재하지 않는 경우
        Schedule schedule = scheduleService.findScheduleById(scheduleId);
        Comment comment = commentRepository.save(new Comment(request.getComment(), request.getUsername(), schedule));
        return CommentResponse.toDto(commentRepository.save(comment));
    }

}