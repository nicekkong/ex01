package com.nicekkong.board.service;

import com.nicekkong.board.dao.BoardDao;
import com.nicekkong.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 1001857 on 16. 1. 26..
 */

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public void regist(Board board) throws Exception {
        boardDao.create(board);
    }

    @Override
    public Board read(Integer bno) throws Exception {
        return boardDao.select(bno);
    }

    @Override
    public void modify(Board board) throws Exception {
        boardDao.update(board);
    }

    @Override
    public void remove(Integer bno) throws Exception {
        boardDao.delete(bno);
    }

    @Override
    public List<Board> listAll() throws Exception {
        return boardDao.selectAll();
    }
}
