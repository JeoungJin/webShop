package com.shinhan.email;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
3.1) 발신자의 메일계정과 비밀번호를 설정한다.
3.2) Property에 SMTP 서버 정보를 설정한다. 
3.3) SMTP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성한다.
3.4) Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
3.5) Transport 클래스를 사용하여 작성한 메세지를 전달한다.
 */
public class EmailTest {
	private static final String HOST = "smtp.naver.com";
	/** 메일 PORT **/
	private static final String PORT = "587";
	/** 메일 ID **/
	private static final String MAIL_ID = "보낸는 사람 이메일";
	/** 메일 PW **/
	private static final String MAIL_PW = "보내는 사람 비밀번호";
	public static void naverMailSend(String subejct, String body) {
		try {
			InternetAddress[] receiverList = new InternetAddress[2];
			receiverList[0] = new InternetAddress("zzahee366@gmail.com");
			receiverList[1] = new InternetAddress(MAIL_ID);

			// SMTP 발송 Properties 설정
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.port", PORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", "*");
			props.put("mail.smtp.ssl.enabled", "true");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.smtp.auth", "true");

			// SMTP Session 생성
			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(MAIL_ID, MAIL_PW);
				}
			});

			// Mail 조립
			Message mimeMessage = new MimeMessage(mailSession);
			mimeMessage.setFrom(new InternetAddress(MAIL_ID));
			mimeMessage.setRecipients(Message.RecipientType.TO, receiverList);
			// 메일 제목
			mimeMessage.setSubject(subejct);
			// 메일 본문 (.setText를 사용하면 단순 텍스트 전달 가능)
			mimeMessage.setContent(body, "text/html; charset=UTF-8");

			// Mail 발송
			Transport.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("메일 발송 오류!!");
		}

	}
	 
}
