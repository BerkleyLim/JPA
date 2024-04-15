package com.example.demo.service;

import com.example.demo.dto.BoardListDto;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    /**
     * 보드 리스트 조회
     *
     * @param bno : 게시판 번호
     * @return : 게시판 제목, 댓글 내용 조회
     */
    public List<BoardListDto> findByBoardList(Long bno) {
        return boardRepository.findByBoardList(bno);
    }
}
