package com.nfc.portal.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.A1Track;
import com.nfc.portal.entity.A1Tracker;
import com.nfc.portal.entity.A1Attachment;
import com.nfc.portal.entity.A1AttachmentFile;
import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.Staff;
import com.nfc.portal.entity.User;
import com.nfc.portal.helper.CheckSum;
import com.nfc.portal.module.MailService;
import com.nfc.portal.module.Messages;
import com.nfc.portal.module.PortalMessage;
import com.nfc.portal.service.A1TicketService;
import com.nfc.portal.service.A1TrackService;
import com.nfc.portal.service.AttachmentService;
import com.nfc.portal.service.DepartmentService;
import com.nfc.portal.service.StaffService;
import com.nfc.portal.service.UserService;

@Controller
@RequestMapping(value = "/a/itTicket/")
public class A1TricketController {
	@Autowired
	A1TicketService a1TicketService;

	@Autowired
	A1TrackService a1TrackService;

	@Autowired
	MailService mailService;

	@Value("${app.baseUrl}")
	private String baseUrl;

	@Autowired
	UserService userService;

	@Autowired
	StaffService staffService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	AttachmentService attachmentService;

	@Autowired
	Messages messages;

	String[][] df_pg_menu = new String[][] { { "a.it_ticket.create", "./a/itTicket/create/" },
			{ "a.it_ticket.my_tickets", "./a/itTicket/my_tickets" }, { "gen.administration", "./a/itTicket/admin" } };

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main_page() {

		ModelAndView mv = new ModelAndView("app/it_ticket/main");
		mv.addObject("pg_hd", "Login Page ");

		mv.addObject("pg_nav",
				new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "tmplt.apps.it_ticket");
		mv.addObject("pg_menu", this.getPgMenu());
		return mv;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(ModelAndView mv) {
		A1Ticket a_IT_Ticket = new A1Ticket();

		List<Department> deps = departmentService.finAll();
		System.out.println("deps 1 size " + deps.get(0).getStaff().size());
		System.out.println("deps size " + deps.size());

		mv.addObject("deps", deps);
		mv.addObject("js_add", new String[] { "dropzone.js", "chosen.jquery.js" });
		mv.addObject("pg_css_items", new String[] { "fine-uploader-new.min.css", "bootstrap-chosen.css" });
		mv.addObject("a_IT_Ticket", a_IT_Ticket);
		mv.addObject("pg_hd", "a.it_ticket.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.create");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/create");
		return mv;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create_ticket_done(ModelAndView mv, @Valid A1Ticket a_IT_Ticket, BindingResult bindingResult,
			HttpServletRequest request, @RequestParam(value = "uploads[]", required = false) String[] uploads) {

		if (bindingResult.hasErrors()) {
			mv.setViewName("app/it_ticket/create");
		} else {
			mv.setViewName("app/it_ticket/create_done");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User logged_user = userService.getUserByEmail(auth.getName());
			a_IT_Ticket.setCreated_by(logged_user);

			// check if user behind proxy or load balancer
			String ipAddress = request.getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
				a_IT_Ticket.setIp(ipAddress);
			}

			a1TicketService.create(a_IT_Ticket);

			A1Track a1Track = new A1Track();
			a1Track.setCreated_by(logged_user);
			a1Track.setTrack("new");
			a1Track.setA1Ticket(a_IT_Ticket);
			a1Track.setDetail(a_IT_Ticket.getDetail());

			// bring track ID to link with attachment
			A1Track savedTrack = a1TrackService.create(a1Track);

			// check if there is uploads before start record in attachment
			// tables
			if (uploads != null && uploads.length > 0)
				attachmentService.assign(uploads, "track", savedTrack.getA1Track_id());

			PortalMessage pm = new PortalMessage();
			pm.setSubject("New Ticket || مذكرة جديدة");

			ArrayList<String> cc = new ArrayList<String>();
			for (Staff s : a_IT_Ticket.getRecipients()) {
				cc.add(s.getUser().getEmail());
			}
			cc.add(logged_user.getEmail());
			cc.add("it@nfc.om");
			// cc.addAll(a_IT_Ticket.getRecipients().toArray());
			pm.setTo(cc);

			pm.setTemplate("a_it_ticket_create");
			Staff Logged_staff = logged_user.getStaff();
			pm.setMessageDetail(new HashMap<String, Object>() {
				{
					put("user", logged_user);
					put("staff", Logged_staff.getFullName_en());
					put("baseUrl", baseUrl);
					put("ticket", a_IT_Ticket);
				}
			});

			// mailService = new Mailer();
			mailService.setPortalMessage(pm);
			mailService.sendMail();

			mv.setViewName("redirect:/a/itTicket/create/done");

		}

		mv.addObject("a_IT_Ticket", a_IT_Ticket);
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_menu", this.getPgMenu());
		return mv;
	}

	@RequestMapping(value = "/create/done", method = RequestMethod.GET)
	public ModelAndView ticket_create_done(ModelAndView mv) {
		A1Ticket a_IT_Ticket = new A1Ticket();

		mv.addObject("a_IT_Ticket", a_IT_Ticket);
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/create_done");
		return mv;
	}

	@PreAuthorize("@a1SecurityService.canAccessTrack(authentication,#ticket_id)")
	@RequestMapping(value = "/track/{ticket_id}/", method = RequestMethod.GET)
	public ModelAndView ticket_track_div(ModelAndView mv, @PathVariable Long ticket_id) {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		// System.out.println("user Auth = "+authorities.size());

		A1Ticket a_IT_Ticket = new A1Ticket();
		a_IT_Ticket.setA1_ticket_ticket_id(ticket_id);

		List<A1Tracker> involvedTracker = a1TrackService.findTrackersByTicket(a_IT_Ticket);
		// System.out.println("Involved T "+involvedTracker.size());

		List<A1Track> tracks = a1TrackService.getByTicket(a_IT_Ticket);

		Department it_dept = departmentService.findByCode("IT");

		List<Staff> it_staff = staffService.getStaffByDepartment(it_dept);

		/*
		 * for(User tr:it_staff){ System.out.println("USER : >> "+tr); }
		 */

		mv.addObject("tracks", tracks);

		A1Ticket ex_ticket = a1TicketService.findByA1_ticket_ticket_id(ticket_id);
		mv.addObject("ticket", ex_ticket);
		mv.addObject("involvedTracker", involvedTracker);

		mv.addObject("pg_hd", "a.it_ticket.track");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.track", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.track");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.addObject("it_staff", it_staff);
		mv.addObject("js_add", new String[] { "tinymce.min.js", "jquery.fine-uploader.min.js" });
		mv.addObject("pg_css_items", new String[] { "app/it_ticket/main.css", "fine-uploader-new.min.css" });
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/ticket_track");
		return mv;

	}

	@RequestMapping(value = "/track/{ticket_id}/update", method = RequestMethod.POST)
	public ModelAndView ticket_track_post(ModelAndView mv, @PathVariable Long ticket_id, @Valid A1Track a1Track,
			BindingResult bindingResult, @RequestParam(value = "trackers", required = false) List<String> trackers,
			@RequestParam(value = "uploads[]", required = false) String[] uploads)

	{

		A1Ticket ticket = new A1Ticket();
		System.out.println(a1Track);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User loggedUser = userService.getUserByEmail(auth.getName());
		a1Track.setCreated_by(loggedUser);

		if (a1Track.getTrack().equals("assigned") && trackers != null && trackers.size() > 0) {
			A1Ticket ticket1 = a1TicketService
					.findByA1_ticket_ticket_id(a1Track.getA1Ticket().getA1_ticket_ticket_id());

			a1TrackService.unAssigned(ticket1);

			// System.out.println(" TRACKERS "+trackers+" SIZE
			// "+trackers.size());
			for (String i : trackers) {
				// System.out.println(" I "+i);

				Staff tr = staffService.getStaffById(Long.parseLong(i));

				A1Tracker tkr = new A1Tracker();
				tkr.setTicket_id(ticket1);
				tkr.setTracker_id(tr);

				a1TrackService.Assigned(tkr);

			}

		}

		// bring track ID to link with attachment
		
		A1Track savedTrack = a1TrackService.create(a1Track);
		System.out.println("DFR");
		System.out.println(savedTrack);
		// check if there is uploads before start record in attavhment tables
		if (uploads != null && uploads.length > 0)
			attachmentService.assign(uploads, "track", savedTrack.getA1Track_id());

		ticket.setCreated_by(loggedUser);
		//List<A1Ticket> myTickets = a1TicketService.findByCreated_by(loggedUser);

		// email update

		PortalMessage pm = new PortalMessage();

		ArrayList<String> cc = new ArrayList<String>();
		for (Staff s : savedTrack.getA1Ticket().getRecipients()) {
			cc.add(s.getUser().getEmail());
		}
		cc.add(savedTrack.getA1Ticket().getCreated_by().getEmail());
		cc.add(loggedUser.getEmail());
		cc.add("it@nfc.om");
		// cc.addAll(a_IT_Ticket.getRecipients().toArray());
		pm.setTo(cc);

		pm.setSubject(" Ticket Updated || تحديث مذكرة ");
		// pm.setTo(new
		// ArrayList<>(Arrays.asList(savedTrack.getCreated_by().getEmail(),
		// "it@nfc.om")));
		pm.setTemplate("a1_ticket_update");
		pm.setMessageDetail(new HashMap<String, Object>() {
			{
				put("updated_by", savedTrack.getCreated_by().getStaff().getFullName_en());
				put("baseUrl", baseUrl);
				put("ticket", savedTrack.getA1Ticket());
				put("track", savedTrack);
				put("status_en", messages.getEn("a.it_ticket.status." + savedTrack.getTrack()));
				put("status_ar", messages.getAr("a.it_ticket.status." + savedTrack.getTrack()));

			}
		});

		mailService.setPortalMessage(pm);
		mailService.sendMail();

		mv.addObject("lu", ticket);
		//mv.addObject("tickets", myTickets);
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("redirect:/a/itTicket/my_tickets");
		return mv;

	}

	@RequestMapping(value = "/my_tickets", method = RequestMethod.GET)
	public ModelAndView my_ticket_main(ModelAndView mv) {
		A1Ticket a_IT_Ticket = new A1Ticket();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User loggedUser = userService.getUserByEmail(email);
		a_IT_Ticket.setCreated_by(loggedUser);

		List<A1Track> tracks = a1TicketService.findByCreatedByAndTrack(loggedUser, "closed");
		List<A1Track> not_closed_tracks = a1TicketService.findByCreatedByAndTrackNotClosed(loggedUser);
		List<A1Ticket> to_follow = a1TicketService.findByRecipients(loggedUser.getStaff());

		mv.addObject("lu", a_IT_Ticket);
		mv.addObject("closed_tracks", tracks);
		mv.addObject("to_follow", to_follow);
		mv.addObject("not_closed_tracks", not_closed_tracks);
		mv.addObject("pg_hd", "a.it_ticket.my_tickets");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.my_tickets", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.my_tickets");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/my_tickets");
		return mv;
	}

	// to delete
	@Secured("ROLE_IT")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView c_edit(ModelAndView mv, @RequestParam("ticket_id") String ticket_id) {
		A1Ticket a_IT_Ticket = new A1Ticket();
		a_IT_Ticket.setA1_ticket_ticket_id(Long.parseLong(ticket_id));
		List<A1Ticket> tickets = a1TicketService.get(a_IT_Ticket);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User loggedUser = userService.getUserByEmail(email);
		a_IT_Ticket.setCreated_by(loggedUser);

		List<A1Ticket> myTickets = a1TicketService.findByCreated_by(loggedUser);

		mv.addObject("a_IT_Ticket", tickets.get(0));
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/edit");
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView t_edit(ModelAndView mv, @Valid A1Ticket a_IT_Ticket, BindingResult bindingResult,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			mv.setViewName("app/it_ticket/create");
		} else {
			mv.setViewName("app/it_ticket/edit_done");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User logged_user = userService.getUserByEmail(auth.getName());
			a_IT_Ticket.setCreated_by(logged_user);

			// check if user behind proxy or load balancer
			String ipAddress = request.getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
				a_IT_Ticket.setIp(ipAddress);
			}

			A1Ticket exist_ticket = a1TicketService.get(a_IT_Ticket).get(0);

			exist_ticket.setTitle(a_IT_Ticket.getTitle());
			exist_ticket.setType(a_IT_Ticket.getType());
			exist_ticket.setSub_type(a_IT_Ticket.getSub_type());
			exist_ticket.setDetail(a_IT_Ticket.getDetail());

			a1TicketService.update(exist_ticket);

			mv.setViewName("redirect:/a/itTicket/edit/done");

		}

		mv.addObject("a_IT_Ticket", a_IT_Ticket);
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_menu", this.getPgMenu());
		return mv;

	}

	@RequestMapping(value = "/edit/done", method = RequestMethod.GET)
	public ModelAndView t_edit_done(ModelAndView mv) {
		A1Ticket a_IT_Ticket = new A1Ticket();

		mv.addObject("a_IT_Ticket", a_IT_Ticket);
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.create", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/edit_done");
		return mv;
	}


	@PreAuthorize("@a1SecurityService.canAccessAdmin(authentication)")
	@RequestMapping(value = "/admin")
	public ModelAndView admin_main(ModelAndView mv) {

		mv.addObject("pg_hd", "admin.create");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.admin", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.admin");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.addObject("stats", a1TrackService.getStatistics());
		mv.addObject("l_new", a1TrackService.getLatestTenByTrack("new"));
		mv.addObject("l_assigned", a1TrackService.getLatestTenByTrack("assigned"));
		mv.addObject("l_in_progress", a1TrackService.getLatestTenByTrack("in_progress"));
		mv.addObject("l_info_request", a1TrackService.getLatestTenByTrack("info_request"));
		mv.addObject("l_solved", a1TrackService.getLatestTenByTrack("solved"));
		mv.addObject("l_hold", a1TrackService.getLatestTenByTrack("hold"));
		mv.addObject("l_closed", a1TrackService.getLatestTenByTrack("closed"));

		mv.addObject("js_add", new String[] { "tinymce.min.js" });

		mv.addObject("pg_css_items", new String[] { "app/it_ticket/main.css" });
		mv.setViewName("app/it_ticket/admin_main");
		return mv;
	}

	@RequestMapping(value = "/upload_attach/", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object uploadAttach(@RequestParam("qqfile") MultipartFile file,
			@RequestParam("qqfilename") String qqfilename) throws IOException, NoSuchAlgorithmException {

		A1Attachment attachment = new A1Attachment();
		A1AttachmentFile attachmentFile = new A1AttachmentFile();

		// create checksum SHA1
		CheckSum cs = new CheckSum();
		FileInputStream fis = (FileInputStream) file.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		Map<String, Object> map = new HashMap<String, Object>();

		String sha1 = cs.calculateSHA1(fis);

		attachment.setHash_sha1(sha1);
		attachment.setSf_name(qqfilename);
		attachmentFile.setData(file.getBytes());

		Long attch_id = attachmentService.upload(attachment, attachmentFile);

		try {
			map.put("success", true);

			map.put("SHA1", sha1);

			map.put("attch_id", attch_id);

			json = mapper.writeValueAsString(map);
			System.out.println("upload --");

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}

	@RequestMapping(value = "/track/download_attch/{id}", method = RequestMethod.GET)
	public HttpEntity<byte[]> createFile(@PathVariable("id") Long AttachmentId) throws IOException {

		A1Attachment id = attachmentService.findByAttachmentID(AttachmentId);
		A1AttachmentFile attachmentFile = attachmentService.findAttachmentFileByAttachmentId(id);
		byte[] buffer = attachmentFile.getData();

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", id.getFile_extension()));
		header.set("Content-Disposition", "attachment; filename=" + id.getSf_name().replace(" ", "_"));
		header.setContentLength(buffer.length);

		return new HttpEntity<byte[]>(buffer, header);
	}

	@PreAuthorize("@a1SecurityService.canAccessAdmin(authentication)")
	@RequestMapping(value = "/admin/{ticket_status}/", method = RequestMethod.GET)
	public ModelAndView ticket_status(ModelAndView mv, @PathVariable String ticket_status) {

		List<A1Track> tracks = a1TrackService.findTicketsByTrack(ticket_status);

		mv.addObject("ticket_status", ticket_status);
		mv.addObject("tracks", tracks);
		mv.addObject("pg_hd", "a.it_ticket.my_tickets");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.admin", "a/itTicket/admin/" }, { "a.it_ticket.status." + ticket_status, "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.admin");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/r_track");
		return mv;
	}

	@RequestMapping(value = "/faq")
	public ModelAndView faq_main(ModelAndView mv) {

		mv.addObject("pg_hd", "a.it_ticket.faq");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.faq", "./a/itTicket/faq" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.faq");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.addObject("pg_css_items", new String[] { "app/it_ticket/main.css" });
		mv.setViewName("app/it_ticket/faq_main");
		return mv;
	}



	@PreAuthorize("@a1SecurityService.canAccessAdmin(authentication)")
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView report(ModelAndView mv) {
		List<A1Track> tracks = a1TrackService.trackReport();
		A1Ticket a_IT_Ticket = new A1Ticket();



		mv.addObject("tracks", tracks);

		mv.addObject("js_add", new String[] { "dataTables.bootstrap.min.js",
				"jquery.dataTables.min.js",
				"dataTables.buttons.min.js" ,
				"buttons.flash.min.js",
				"buttons.html5.min.js",
				"buttons.print.min.js",
				"jszip.min.js",
				"pdfmake.min.js",
				"vfs_fonts.js"
				});
		mv.addObject("pg_css_items", new String[] { "dataTables.bootstrap.min.css",
				"datatables.min.css",
				"jquery.dataTables.min.css",
				"buttons.dataTables.min.css"});
		
		mv.addObject("a_IT_Ticket", a_IT_Ticket);
		mv.addObject("pg_hd", "a.it_ticket.report");
		mv.addObject("pg_nav", new String[][] { { "tmplt.nav.home", "./" }, { "tmplt.apps.it_ticket", "./a/itTicket/" },
				{ "a.it_ticket.report", "" } });
		mv.addObject("pg_app_name", "tmplt.apps.it_ticket");
		mv.addObject("pg_hd", "a.it_ticket.report");
		mv.addObject("pg_menu", this.getPgMenu());
		mv.setViewName("app/it_ticket/admin_report");
		return mv;
	}
	
	
	// generate app menu
	public String[][] getPgMenu() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedun_email = auth.getName();
		User loged_user = userService.getUserByEmail(loggedun_email);

		Staff Logged_staff = loged_user.getStaff();

		/*Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		boolean hasRole = false;

		for (SimpleGrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals("ROLE_IT");
			if (hasRole) {
				break;
			}
		}*/

		if (Logged_staff.getDepartment().getCode().toLowerCase().equals("it")) {
			return new String[][] { { "a.it_ticket.create", "./a/itTicket/create/" },
					{ "a.it_ticket.my_tickets", "./a/itTicket/my_tickets" }, { "a.it_ticket.faq", "./a/itTicket/faq" },
					{ "a.it_ticket.report", "./a/itTicket/report" },
					{ "gen.administration", "./a/itTicket/admin" } };

		} else {
			return new String[][] { { "a.it_ticket.create", "./a/itTicket/create/" },
					{ "a.it_ticket.my_tickets", "./a/itTicket/my_tickets" },
					{ "a.it_ticket.faq", "./a/itTicket/faq" } };

		}

	}



}
