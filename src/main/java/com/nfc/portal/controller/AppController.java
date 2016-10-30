package com.nfc.portal.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController implements ErrorController {

	String[][] df_pg_menu = new String[][] { { "tmplt.apps", "./a/" } };
	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public ModelAndView error_p(ModelAndView mv) {
		mv.setViewName("welcome/error");
		mv.addObject("pg_hd", "tmplt.hdr.error_page");

		mv.addObject("pg_app_name", "sec");

		mv.addObject("pg_menu", df_pg_menu);
		return mv;
		
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
