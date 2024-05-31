package com.sparta.hardtask.repository;

import com.sparta.hardtask.dto.ScheduleRequestDto;
import com.sparta.hardtask.dto.ScheduleResponseDto;
import com.sparta.hardtask.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Schedule save(Schedule schedule) {

        // DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO memo (username, contents) VALUES (?, ?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, schedule.getUsername());
                    preparedStatement.setString(2, schedule.getContents());
                    return preparedStatement;
                },
                keyHolder);

        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        schedule.setId(id);

        return schedule;
    }

    public List<ScheduleResponseDto> findAll() {
        // DB 조회
        String sql = "SELECT * FROM memo";

        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String contents = rs.getString("contents");
                return new ScheduleResponseDto(id, username, contents);
            }
        });
    }

    public void update(Long id, ScheduleRequestDto requestDto) {
        // 메모 내용 수정
        String sql = "UPDATE memo SET username = ?, contents = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getUsername(), requestDto.getContents(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM memo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Schedule findById(Long id) {
        // DB 조회
        String sql = "SELECT * FROM memo WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Schedule schedule = new Schedule(requestDto);
                schedule.setUsername(resultSet.getString("username"));
                schedule.setContents(resultSet.getString("contents"));
                return schedule;
            } else {
                return null;
            }
        }, id);
    }
}
