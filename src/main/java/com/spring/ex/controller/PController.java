package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.PCommand;
import com.spring.ex.command.PContentCommand;
import com.spring.ex.command.PDeleteCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PModifyCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
	
	PCommand command = null;
	
	
	@RequestMapping("write_view")
	public String write_view() {
		return "write_view";
	}
	
	@RequestMapping("write")
	public String write(HttpServletRequest request) {
		command = new PWriteCommand();
		command.execute(request);
		return "redirect:/list";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		command = new PListCommand();
		command.execute(request); 
		return "list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request) {
		command = new PContentCommand();
		command.execute(request);
		return "content_view";
	}
	
	@RequestMapping("modify")
	public String modify(HttpServletRequest request) {
		command = new PModifyCommand();
		command.execute(request);
		return "redirect:/list";
	}
	
	@RequestMapping("delete_view")
	public String delete_view(HttpServletRequest request) {
		command = new PDeleteCommand();
		command.execute(request);
		return "redirect:/list";
	}
}
