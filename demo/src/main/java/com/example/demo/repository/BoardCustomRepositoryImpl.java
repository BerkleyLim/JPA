package com.example.demo.repository;


import com.example.demo.dto.BoardListDto;
import com.example.demo.dto.QBoardListDto;
import com.example.demo.entity.QBoard;
import com.example.demo.entity.QComment;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final JPAQueryFactory queryFactory;

    private final QBoard board = QBoard.board;
    private final QComment comment = QComment.comment;


    @Override
    public List<BoardListDto> findByBoardList(Long bno) {
//        return queryFactory.selectFrom(board)
//                .innerJoin(comment).on(board.bno.eq(comment.boardBno));
        JPAQuery<BoardListDto> query = queryFactory.select(new QBoardListDto(
                board.bno, comment.cno, board.title, comment.contents)
                )
                .from(board)
                .innerJoin(comment)
                .on(board.bno.eq(comment.boardBno))
                .where(board.bno.eq(bno));

        return query.fetch();
//        return queryFactory.select(new QBoardListDto(board.bno, comment.cno, board.title, comment.contents))
//                .from(board)
//                .innerJoin(comment)
//                .on(board.bno.eq(comment.boardBno))
//                .where(board.bno.eq(bno))
//                .fetchAll();
    }
}
