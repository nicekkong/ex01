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

import javax.inject.Inject;

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
    public String registerPOST(Board board, Model model) {
        logger.info("Register POST..................");
        logger.info(board.toString());

        try {
            boardService.regist(board);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("result", "success");

        //return "/board/success";
        return "redirect:board/listAll";
    }

    //전체 리스트 화면
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public void listAll(Model model) throws Exception {
        logger.debug("listAll GET .........");
    }
}
