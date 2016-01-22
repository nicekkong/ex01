package com.nicekkong.board.persistence;

import com.nicekkong.board.domain.Board;

import java.util.List;

/**
 * Created by 1001857 on 16. 1. 22..
 */
public interface BoardDAO {

    public void create(Board board) throws Exception;

    public Board read(Integer bno) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(Integer bno) throws Exception;

    public List<Board> listAll()  throws Exception;

}