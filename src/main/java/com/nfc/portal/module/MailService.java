package com.nfc.portal.module;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

//@Service("mailService")
//@Component
//@Service("mailService")
@Service("mailService")
@Scope("prototype")
public class MailService {
	

    @Autowired
    Messages messages;

    
	PortalMessage portalMessage;

	private static final Logger logger = Logger.getLogger(MailService.class);

	@Autowired(required=true)
	JavaMailSenderImpl javaMailSenderImpl;


	@Autowired
	private VelocityEngine velocityEngine;


	private JavaMailSender javaMailSender;
	
	@Autowired
	public MailService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}




	@Async
	public void sendMail(){


		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		System.out.println(mimeMessage);
		MimeMessageHelper mailMsg;

		try {
			mailMsg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		

		mailMsg.setFrom("portal@nfc.om");

		System.out.println("XSD"+portalMessage.getTo().size());
		logger.info("aa");
		for (String toAddr : portalMessage.getTo()) {
			System.out.println("DEDE"+toAddr);
			mailMsg.addTo(toAddr);
		
		}


		mailMsg.setSubject(portalMessage.getSubject());
		mailMsg.setReplyTo("it@nfc.om");

		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, "templates/" + portalMessage.getTemplate()
						+ ".vm", "UTF-8", portalMessage.getMessageDetail());
		mailMsg.setText(text, true);

		ClassPathResource logo_img = new ClassPathResource("/images/logo.png");

		mailMsg.addInline("rid1", logo_img);
		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---Done---");

		javaMailSenderImpl.send(mimeMessage);

		
		
	}
	

	
	public void setPortalMessage(PortalMessage pm){
		this.portalMessage=pm;
	}
	


	
	


	

}
