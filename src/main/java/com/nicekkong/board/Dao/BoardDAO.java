package com.nicekkong.board.Dao;

import com.nicekkong.board.domain.Board;

import java.util.List;

/**
 * Created by 1001857 on 16. 1. 22..
 */
public interface BoardDao {

    public void create(Board board) throws Exception;

    public Board select(Integer bno) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(Integer bno) throws Exception;

    public List<Board> selectAll()  throws Exception;

}