package com.colorful.mail.service.impl;

import com.colorful.mail.domain.Mail;
import com.colorful.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 功能描述: 发送邮件
     * @author chengdongyi
     * @date 2019/11/2 17:19
     * @param mail 邮件信息
     * @return boolean 0-成功; 1-失败；
     */
    @Override
    public boolean sendMail(Mail mail) {

        boolean send_status = true;
        try {
            if ("1".equals(mail.getType())) {
                sendMimeMessage(mail);
            } else if ("2".equals(mail.getType())) {
                sendSimpleMailMessage(mail);
            } else {
                send_status = false;
            }
        } catch (Exception e) {
            log.error("邮件发送失败, 异常信息: {}", e);
            send_status = false;
        }
        return send_status;
    }

    /**
     * 功能描述: 普通邮件
     * @author chengdongyi
     * @date 2019/11/2 17:19
     * @param mail 邮件信息
     */
    private void sendMimeMessage(Mail mail) {

        // 邮件设置
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(mail.getTo());
        message.setCc(mail.getCc());
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        mailSender.send(message);

    }

    /**
     * 功能描述: HTML邮件或带附件的邮件
     * @author chengdongyi
     * @date 2019/11/2 17:19
     * @param mail 邮件信息
     */
    private void sendSimpleMailMessage(Mail mail) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(mail.getTo());
        helper.setCc(mail.getCc());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getText(), true);

        // 上传文件
        if (mail.getFile() != null) {
            for (File file : mail.getFile()) {
                helper.addAttachment(file.getName(), file);
            }
        }
        mailSender.send(message);
    }

}
