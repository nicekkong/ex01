package com.nicekkong.board.controller;

import com.nicekkong.board.domain.Board;
import com.nicekkong.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by 1001857 on 16. 1. 26..
 */

@Controller
@RequestMapping("/board")
public class BoardController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardService boardService;

    // 등록 화면 이동
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGET(Board board, Model model) throws Exception {
        logger.info("Register get..........");

        return "board/register";
    }

    // 등록 처리
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //public String registerPOST(Board board, Model model) {
    public String registerPOST(Board board, RedirectAttributes attributes) {
        logger.info("Register POST..................");
        logger.info(board.toString());

        try {
            boardService.regist(board);
        } catch (Exception e) {
            e.printStackTrace();
        }

        attributes.addFlashAttribute("msg", "SUCCESS");

        //return "/board/success";
        return "redirect:/board/listAll";
    }

    //전체 리스트 화면
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model) throws Exception {
        logger.debug("listAll GET .........");

        List<Board> boardList = null;

        try {
            boardList = boardService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("boardList", boardList);

        return "board/listAll";
    }

    // 게시판 상세 조회
    @RequestMapping(value="/read", method = RequestMethod.GET)
    public String read(@RequestParam("bno")int bno, Model model) throws Exception{

        logger.debug("read() GET.......");

        // model.addAttribute(boardService.read(bno));  // addAttribute()에 키값이 없으면 리턴되는 클래스의 소문자 이름으로 키값이 자동 맵핑된다.

        Board board = boardService.read(bno);

        model.addAttribute("board", board);

        return "board/read";
    }

    //게시물 수정
    @RequestMapping(value="/modify", method = RequestMethod.GET)
    public String modify(@RequestParam("bno")int bno, Model model) throws Exception {

        logger.debug("modify()...GET.....");

        //logger.debug("==============>>>>>\n" + board.toString());
        model.addAttribute("board", boardService.read(bno));


        return "board/modify";
    }


    @RequestMapping(value="/modify", method = RequestMethod.POST)
    public String modify(Board board, RedirectAttributes attributes) throws Exception {

        logger.debug("modify()...POST.....");
        logger.debug("==============>>>>>\n" + board.toString());

        boardService.modify(board);
        attributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/board/listAll";
    }

    // 게시물 삭제
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("bno")int bno, RedirectAttributes attributes) throws Exception {

        logger.debug("remove()......");

        boardService.remove(bno);
        attributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/board/listAll";
    }
}
