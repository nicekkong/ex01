package com.nicekkong.board.service;

import com.nicekkong.board.domain.Board;

import java.util.List;

/**
 * Created by 1001857 on 16. 1. 26..
 */
public interface BoardService {

    public void regist(Board board) throws Exception;

    public Board read(Integer bno) throws Exception;

    public void modify(Board board) throws Exception;

    public void remove(Integer bno) throws Exception;

    public List<Board> listAll() throws Exception;
}
