package com.example.demo.repository;

import com.example.demo.dto.BoardListDto;

import java.util.List;

public interface BoardCustomRepository {
    List<BoardListDto> findByBoardList(Long bno);
}
