package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

public interface PCommand {
	public void execute(HttpServletRequest request);
}
