package com.nfc.portal.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nfc.portal.entity.Staff;
import com.nfc.portal.entity.User;
import com.nfc.portal.service.DepartmentService;
import com.nfc.portal.service.StaffService;
import com.nfc.portal.service.UserService;
import com.nfc.portal.validators.SysAdminCreateUserFormValidator;
import com.nfc.portal.validators.SysAdminUpdateUserFormValidator;



@Controller

@Secured("ROLE_IT")
@RequestMapping("/sysAdmin")
public class SysAdminContoller {
	
	@Autowired
	DepartmentService departmentService; 
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	UserService userService;

	@Autowired
	SysAdminCreateUserFormValidator sysAdminCreateUserFormValidator;
	
	@Autowired
	SysAdminUpdateUserFormValidator sysAdminUpdateUserFormValidator;

	@RequestMapping(value = "/")
	public ModelAndView index(ModelAndView mv) {

		mv.addObject("pg_hd", "sys.admin");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" } });
		mv.addObject("pg_app_name", "sys.admin");
		mv.addObject("pg_hd", "sys.admin");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("admin/main");
		return mv;
	}

	
	@RequestMapping(value = "/users/")
	public ModelAndView users(ModelAndView mv) {
		//List<User> activeList = userService.getByEnabled(true);
		List<User> userList = userService.getAllUsers();
		
		mv.addObject("activeList", userList);
		

		mv.addObject("js_add", new String[] { "dataTables.bootstrap.min.js","jquery.dataTables.min.js" });
		mv.addObject("pg_css_items", new String[] { "dataTables.bootstrap.min.css","datatables.min.css","jquery.dataTables.min.css" });
		
		mv.addObject("pg_hd", "sys.admin");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" }, { "sys.admin.users", "./sysAdmin/" } });
		mv.addObject("pg_app_name", "sys.admin");
		mv.addObject("pg_hd", "sys.admin.users");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("admin/user_list");
		return mv;
	}
	
	@RequestMapping(value = "/users/add/")
	public ModelAndView user_add(ModelAndView mv) {

		mv.addObject("pg_hd", "sys.admin");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" }, { "sys.admin.users", "./sysAdmin/" } });
		mv.addObject("pg_app_name", "sys.admin");
		mv.addObject("pg_hd", "sys.admin.users");
		mv.addObject("pg_menu", this.getPgMenu());
		
		//bootstrap-datepicker.css
		mv.addObject("pg_css_items", new String[] { "bootstrap-datepicker.css" });

		mv.addObject("depts",departmentService.finAll());
		mv.addObject("staffs",staffService.findAll());
		
		mv.addObject("user",new User());
		mv.addObject("staff",new Staff());
		
		mv.setViewName("admin/user_create");
		return mv;
	}

	

	@RequestMapping(value = "/users/add/done/",method=RequestMethod.POST)
	public ModelAndView user_add_check(ModelAndView mv ,@Valid User user, BindingResult br ) {
		
		
		sysAdminCreateUserFormValidator.validate(user, br);
		
		if(br.hasErrors() ){
			System.out.println("ERR "+br.getFieldErrorCount());
			
			mv.addObject("pg_hd", "sys.admin");
			mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" }, { "sys.admin.users", "./sysAdmin/" } });
			mv.addObject("pg_app_name", "sys.admin");
			mv.addObject("pg_hd", "sys.admin.users");
			mv.addObject("pg_menu", this.getPgMenu());
			

			mv.addObject("pg_css_items", new String[] { "bootstrap-datepicker.css" });

			mv.addObject("depts",departmentService.finAll());
			mv.addObject("staffs",staffService.findAll());
			
			mv.addObject("user",user);
			mv.addObject("staff",user.getStaff());
			
			mv.setViewName("admin/user_create");
			return mv;
		}else{
			
			//create user
			Staff newStaff= new Staff();
			newStaff.setStaff_id(user.getStaff().getStaff_id());
			
			
			userService.create(user);

			mv.addObject("pg_hd", "sys.admin");
			mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" }, { "sys.admin.users", "./sysAdmin/" } });
			mv.addObject("pg_app_name", "sys.admin");
			mv.addObject("pg_hd", "sys.admin.users");
			mv.addObject("pg_menu", this.getPgMenu());
			mv.setViewName("admin/main");
			return mv;
			
		}

	}

	@RequestMapping(value = "/users/edit/{user_id}")
	public ModelAndView user_edit(ModelAndView mv,@PathVariable("user_id") Long user_id) {
		User user = userService.getUserById(user_id);
		
		mv.addObject("user", user);
		

		mv.addObject("js_add", new String[] { "dataTables.bootstrap.min.js","jquery.dataTables.min.js" });
		mv.addObject("pg_css_items", new String[] { "dataTables.bootstrap.min.css","datatables.min.css","jquery.dataTables.min.css" });
		
		mv.addObject("pg_hd", "sys.admin");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" }, { "sys.admin.users", "./sysAdmin/" } });
		mv.addObject("pg_app_name", "sys.admin");
		mv.addObject("pg_hd", "sys.admin.users");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("admin/user_edit");
		return mv;
	}
	

	@RequestMapping(value = "/users/edit/done/",method=RequestMethod.POST)
	public ModelAndView user_edit_check(ModelAndView mv ,@Valid User user, BindingResult br ) {
		

		
		sysAdminUpdateUserFormValidator.validate(user, br);
		
			
			userService.update(user);

			mv.addObject("pg_hd", "sys.admin");
			mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "sys.admin", "./sysAdmin/" }, { "sys.admin.users", "./sysAdmin/" } });
			mv.addObject("pg_app_name", "sys.admin");
			mv.addObject("pg_hd", "sys.admin.users");
			mv.addObject("pg_menu", this.getPgMenu());
			mv.setViewName("admin/main");
			return mv;
			
		/*}*/

	}
	
	
	// generate app menu
	public String[][] getPgMenu() {




			return new String[][] { { "sys.admin.add_user", "./sysAdmin/users/add/" },
				{ "sys.admin.users", "./sysAdmin/users/" },
				/*{ "sys.admin.privileges_manage", "./sysAdmin/privileges_manage/" }*/ };

		

	}
}
