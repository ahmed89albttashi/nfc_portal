package com.nfc.portal.controller;

import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nfc.portal.entity.A1Ticket;

@Controller

public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView ticket_track(ModelAndView mv) {

		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");

		mv.addObject("js_add", new String[] { "tinymce.min.js" });
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("mainTemplate/first_page");
		return mv;
	}

	

	public String[][] getPgMenu() {

		/*Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		boolean hasRole = false;

		for (SimpleGrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals("ROLE_IT");
			if (hasRole) {
				break;
			}
		}

		if (hasRole) {
			return new String[][] { { "a.it_ticket.create", "./a/itTicket/create/" },
					{ "a.it_ticket.my_tickets", "./a/itTicket/my_tickets" },
					{ "gen.administration", "./a/itTicket/admin" } };

		} else {
			return new String[][] { { "a.it_ticket.create", "./a/itTicket/create/" },
					{ "a.it_ticket.my_tickets", "./a/itTicket/my_tickets" } };

		}
*/
		return new String[][] { { "a.it_ticket.create", "./a/itTicket/create/" },
				{ "a.it_ticket.my_tickets", "./a/itTicket/my_tickets" } };


	}
}
