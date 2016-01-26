package com.nicekkong.board.Dao;

import com.nicekkong.board.domain.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 1001857 on 16. 1. 25..
 */
@Repository
public class BoardDaoImpl implements BoardDao {

    @Inject
    private SqlSession session;

    private static String namespace = "com.nicekkong.mapper.BoardMapper"; // mapper.xml 파일에서 namespace로 작성한 이름

    @Override
    public void create(Board board) throws Exception {
        session.insert(namespace+".create", board);
    }

    @Override
    public Board select(Integer bno) throws Exception {
        return session.selectOne(namespace + ".read", bno);
    }

    @Override
    public void update(Board board) throws Exception {
        session.update(namespace + ".update", board);
    }

    @Override
    public void delete(Integer bno) throws Exception {
        session.delete(namespace + ".delete", bno);
    }

    @Override
    public List<Board> selectAll() throws Exception {
        return session.selectList(namespace + ".listAll");
    }
}
