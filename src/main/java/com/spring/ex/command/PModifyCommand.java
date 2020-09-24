package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;

public class PModifyCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PDao dao = PDao.getInstance();
	
		dao.updateData(num,id,name,age);
	}

}
