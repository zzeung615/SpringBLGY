package com.springblgy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springblgy.dao.MainDao;
import com.springblgy.dto.MainDto;
import com.springblgy.dto.SearchDto;

@Controller
public class MainController {
	
	@Autowired
	private SqlSession sqlSession; // 해줘야함***
	
	@RequestMapping("/mainForm.bill")
	public String mainPage(HttpServletRequest request, Model model) {
		int userseq = -1;
		if(request.getParameter("userseq")==null) {
		}else {
			userseq = Integer.parseInt(request.getParameter("userseq"));
		}
		request.setAttribute("userseq", userseq);
		MainDao dao = sqlSession.getMapper(MainDao.class);
		ArrayList<MainDto> maindtios = dao.mainDao();
		request.setAttribute("MainList", maindtios);
		
		return "mainPage/mainForm";
	}
	
	@RequestMapping("/searchAfter.bill")
	public String searchAfter(HttpServletRequest request, Model model) {
		MainDao dao = sqlSession.getMapper(MainDao.class);
		
		String keyword = request.getParameter("search");
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String select = request.getParameter("selectsearch");
		String liked2 = null;
		if(date1.length()<5) {
			date1 = "2100-12-12";
		}if(date2.length()<5) {
			date2 = "1945-08-15";
		}			
		
		int userseq = -1;
		
		if(request.getParameter("userseq")==null) {
			
		}
		else {
			userseq = Integer.parseInt(request.getParameter("userseq"));
		}
		
		if(select.equals("조회수순")) {
			request.setAttribute("SearchList", dao.searchDao(keyword, date1, date2, userseq));
		}else {
			request.setAttribute("SearchList", dao.searchDao2(keyword, date1, date2, userseq));
		}
		
		return "mainPage/searchAfter";
	}

}