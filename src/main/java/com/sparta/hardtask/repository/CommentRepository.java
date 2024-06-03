package com.sparta.hardtask.repository;

import com.sparta.hardtask.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
