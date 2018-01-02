package com.nfc.portal.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nfc.portal.entity.User;
import com.nfc.portal.entity.UserResetPassword;
import com.nfc.portal.module.MailService;
import com.nfc.portal.module.PortalMessage;
import com.nfc.portal.service.UserResetPasswordService;
import com.nfc.portal.service.UserService;




@Controller
@RequestMapping(value = "/sec")
@SessionAttributes("reset_user_email")
public class SecurityController {

	@Autowired
	MailService mailService;

	@Autowired
	UserResetPasswordService userResetPasswordService;
	
	
	Long rand;


	@Value("${app.baseUrl}")
	private String baseUrl;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService  userService;
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();

	String[][] df_pg_menu = new String[][] { { "tmplt.apps", "./a/" } };

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login_page() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String en = encoder.encode("123");

		
		ModelAndView mv = new ModelAndView("security/login");
		mv.addObject("pg_hd", "sec.login");
		mv.addObject("en", en);
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
				{ "tmplt.nav.sec.login", "./sec/" } });
		mv.addObject("pg_app_name", "sec");
		
		mv.addObject("pg_menu", df_pg_menu);

		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login_page_do() {

		ModelAndView mv = new ModelAndView("security/login");
		mv.addObject("pg_hd", "NFC Portal~ Login Page ");

		return mv;
	}

	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public ModelAndView forget_page() {
		User user = new User();
		

		
		ModelAndView mv = new ModelAndView("security/forget");
		mv.addObject("user",user);
		mv.addObject("pg_hd", "sec.reset_pass");
		
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
				{ "tmplt.nav.sec.login", "./sec/" } });
		mv.addObject("pg_app_name", "sec");
		mv.addObject("pg_css_items", new String[] { });
		mv.addObject("js_add", new String[] { "jquery.validate.min.js" });
		mv.addObject("pg_menu", df_pg_menu);

		return mv;
	}
	

	@RequestMapping(value = "/forget/", method = RequestMethod.POST)
	public ModelAndView forget_page_d(@ModelAttribute User user, ModelAndView mv,HttpServletRequest request) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
		
		request.getSession().setAttribute("reset_user_email",user.getEmail());
		
		
		mv.addObject("user", user);
		mv.addObject("reset_user_email", user.getEmail());
		System.out.println("First recieved email "+user.getEmail());
		
		
		
		User existUser=userService.getUserByEmail(user.getEmail().toLowerCase());
		
		if( existUser == null){
			
		}else{
			//compound date with user-id to generate daily key for activate 
			//Date cDate = new Date();
			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			//Long currentDateText= cDate.getTime();
			 
		      
			PortalMessage pm = new PortalMessage();
			pm.setSubject("NFC : Reset Password || إستعادة كلمة المرور");
			pm.setTo(new ArrayList<>(Arrays.asList(existUser.getEmail())));
			pm.setTemplate("sec_reset_password");
			
			Random rnd = new Random();
			rand = rnd.nextLong();
			
			if(rand<0){
				rand=rand*-1;
			}
			

			
			pm.setMessageDetail(new HashMap<String, Object>() {
				{

					//put("cDateT", currentDateText);
					
					put("user", existUser.getStaff().getFullName_en());
					put("email", existUser.getEmail());
					put("baseUrl",baseUrl);
					put("randString",rand);
					
				}
			});

			try {
				/*UserResetPassword upr = new UserResetPassword(existUser,rand,new Date(),new Date());*/
				UserResetPassword upr = new UserResetPassword(); 
				upr.setUser(existUser);
				upr.setHash_code(rand);
				upr.setCreated_on(new Date(0));
				upr.setChanged_on(new Date(0));
				
				userResetPasswordService.save(upr);
				
				mailService.setPortalMessage(pm);
				mailService.sendMail();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

		mv.setViewName("redirect:/sec/forget/user/"+existUser.getEmail()+"/");
		
		return mv;
	}

	

	@RequestMapping(value = "/forget/user/{email_id}/", method = RequestMethod.GET)
	public ModelAndView forget_page_p(HttpServletRequest request, @PathVariable("email_id") String email_id) {
		 ModelAndView mv =new ModelAndView();
		String email =(String)request.getSession().getAttribute("reset_user_email");
		System.out.println("email" + email);

		mv.setViewName("security/forget_renew");
		//System.out.println("a GET user mail = " +email);
		mv.addObject("email",email);

		mv.addObject("pg_hd", "sec.reset_pass");
		
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
				{ "tmplt.nav.sec.login", "./sec/" } });
		mv.addObject("pg_app_name", "sec");

		mv.addObject("js_add", new String[] { "jquery.validate.min.js" });
		mv.addObject("pg_menu", df_pg_menu);

		return mv;
	}
	
	
	@RequestMapping(value="/forget/user/a/done", method = RequestMethod.POST)
	public ModelAndView forget_renew_d(@ModelAttribute String reset_user_email,@RequestParam("pass1") String pass,
										@RequestParam("reset_code") String reset_code, ModelAndView mv,
										@RequestParam("email") String resetEmail,HttpServletRequest request){

		
		System.out.println("a POST user mail = " +resetEmail);
		
		System.out.println("a POST user Pass = " +pass);
		
		
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String ep= encoder.encode(pass);
		
		User exUser = userService.getUserByEmail(resetEmail);
		List<UserResetPassword> urpList = userResetPasswordService.findByUser(exUser);
		
		if(urpList.size()>0 ){
			String hashDb = urpList.get(0).getHash_code().toString();
			System.out.println("HASH CODE DB "+urpList.get(0).getHash_code());
			System.out.println("HASH CODE UR "+reset_code);
			
			if(hashDb.equals(reset_code)){
				exUser.setPassword(ep);
				userService.update(exUser);
				
				mv.setViewName("security/forget_done");
				mv.addObject("pg_hd", "sec.reset_pass");
				
				mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
						{ "tmplt.nav.sec.login", "./sec/" } });
				mv.addObject("pg_app_name", "sec");

				mv.addObject("js_add", new String[] { "jquery.validate.min.js" });
				mv.addObject("pg_menu", df_pg_menu);
			}else{
				//not correct RESET CODE
				mv.setViewName("security/forget_fail");
				mv.addObject("pg_hd", "sec.reset_pass");
				
				mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
						{ "tmplt.nav.sec.login", "./sec/" } });
				mv.addObject("pg_app_name", "sec");

				mv.addObject("js_add", new String[] { "jquery.validate.min.js" });
				mv.addObject("pg_menu", df_pg_menu);
				
				
				
			}

			
						
		}else{
			mv.setViewName("security/forget_fail");
			mv.addObject("pg_hd", "sec.reset_pass");
			
			mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
					{ "tmplt.nav.sec.login", "./sec/" } });
			mv.addObject("pg_app_name", "sec");

			mv.addObject("js_add", new String[] { "jquery.validate.min.js" });
			mv.addObject("pg_menu", df_pg_menu);
		}
	
		return mv;
	}

	@RequestMapping(value = "/login?error", method = RequestMethod.GET)
	public ModelAndView login_page_error() {
		ModelAndView mv = new ModelAndView("security/login");
		//mv.addObject("pg_hd", "NFC Portal~ Login Page ");
		return mv;
	}

	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public ModelAndView logout_page() {
		SecurityContextHolder.clearContext();

		ModelAndView mv = new ModelAndView("security/login");
		mv.addObject("pg_hd", "tmplt.hdr.signout");
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");

		return mv;
	}
	
	

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/change_password/", method = RequestMethod.GET)
	public ModelAndView change_pass_page(ModelAndView mv) {
		


		mv.addObject("pg_hd", "sec.change_pass");
		mv.addObject("js_add", new String[] { "jquery.validate.min.js" });

		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
				{ "tmplt.nav.sec.login", "./sec/" } });
		mv.addObject("pg_app_name", "sec");
		
		mv.addObject("pg_menu", df_pg_menu);

		mv.setViewName("security/change_password");

		return mv;
	}

	
	


	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/change_password/", method = RequestMethod.POST)
	public ModelAndView change_pass_page_post(ModelAndView mv,@RequestParam("email") String email,@RequestParam("password") String password
			,@RequestParam("new_password") String new_password,@RequestParam("confirm_password") String confirm_password) {
		
		boolean isCorrect=true;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User logged_user = userService.getUserByEmail(auth.getName());
		
		

		System.out.println("email "+email);

		System.out.println("logged "+auth.getName());
		
		if(!email.equals(auth.getName()))
			isCorrect=false;

		System.out.println("isCorrect -> username"+isCorrect);

		String enc_old_pass= passwordEncoder.encode(password);
		String enc_new_pass= passwordEncoder.encode(new_password);
		
		/*
		if(!enc_old_pass.equals(logged_user.getPassword()))
			isCorrect=false;
			*/
		System.out.println(" matches" + passwordEncoder.matches(password, logged_user.getPassword()));

		if(!passwordEncoder.matches(password, logged_user.getPassword()))
			isCorrect=false;
		
		System.out.println("isCorrect currect password "+isCorrect);
		System.out.println(" DB Pass "+logged_user.getPassword());
		System.out.println(" user Pass "+enc_old_pass);

		if(isCorrect){
			System.out.println("updating pass");

			logged_user.setPassword(enc_new_pass);
			userService.update(logged_user);
			
			PortalMessage pm = new PortalMessage();
			pm.setSubject("Password changed || تم تغيير رمز المرور");
			pm.setTo(new ArrayList<>(Arrays.asList(logged_user.getEmail())));
			pm.setTemplate("a_change_password");
			String randString = RandomStringUtils.random(6, false, true);
			pm.setMessageDetail(new HashMap<String, Object>() {
				{
					put("user", logged_user);
					put("staff_name",logged_user.getStaff().getFullName_en());

				}
			});

			//mailService = new Mailer();
			mailService.setPortalMessage(pm);
			mailService.sendMail();

			
			mv.setViewName("redirect:/");
			return mv;
			
		}else{

			mv.addObject("pg_hd", "sec.change_pass");
			
			mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" },
					{ "tmplt.nav.sec.login", "./sec/" } });
			mv.addObject("pg_app_name", "sec");

			mv.addObject("js_add", new String[] { "jquery.validate.min.js" });

			mv.addObject("pg_menu", df_pg_menu);
			mv.addObject("current_password_wrong", true);
			mv.setViewName("security/change_password");
			return mv;
		}
		
		
		

		
		
	}
}
