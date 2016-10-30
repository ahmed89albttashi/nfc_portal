package com.nfc.portal.module;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service("mailService")
public class Mailer {

	private static final Logger logger = Logger.getLogger(Mailer.class);

	@Autowired(required = true)
	JavaMailSenderImpl javaMailSenderImpl;


	@Autowired
	private VelocityEngine velocityEngine;




	public void send(PortalMessage portalMessage) throws Exception {

		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		MimeMessageHelper mailMsg;

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

		System.out.println("---Done---");

		javaMailSenderImpl.send(mimeMessage);

	}
	

}
