package com.nicekkong.test;

import com.nicekkong.board.domain.Board;
import com.nicekkong.board.dao.BoardDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1001857 on 16. 1. 25..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class BoardDaoTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    BoardDao boardDao;

    @Test
    public void testCreate() throws Exception {

        Board board = new Board();
        board.setTitle("테스트 Title 입니다.");
        board.setContent("테스트 Contents 입니다.");
        board.setWriter("nicekkong");
        boardDao.create(board);

        board = new Board();
        board.setTitle("테스트 Title2 입니다.");
        board.setContent("2테스트 Contents 입니다.");
        board.setWriter("nicekkong");
        boardDao.create(board);

        board = new Board();
        board.setTitle("테스트 Title3 입니다.");
        board.setContent("3테스트 Contents 입니다.");
        board.setWriter("nicekkongWorld");
        boardDao.create(board);

    }

    @Test
    public void testListAll() throws Exception {
        logger.debug("=[START]=================================================");
        logger.debug(boardDao.selectAll().toString());
        logger.debug("==[END]================================================");
    }

    @Test
    public void testRead() throws Exception {

        logger.debug(boardDao.select(2).toString());
    }

    @Test
    public void testUpdate() throws Exception {

        Board board = new Board();

        board = boardDao.select(3);

        //board.setBno(2);
        board.setTitle("Update된 Title333");
        //board.setContent("Update된 내용입니다.");
        //board.setWriter("nicekkong_Update");

        boardDao.update(board);

    }

    @Test
    public void testDelete() throws Exception {
        boardDao.delete(1);
    }


    @Test
    public void testRamda() {

        Map<String, String> map = new HashMap<String, String>();

        map.put("String1", "a");
        map.remove("String1");
    }


}
