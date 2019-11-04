package com.colorful.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.security.auth.Subject;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTest {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Test
    public void test1() {

        // 普通邮件

        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        // 1. 发件人
        message.setFrom(from);
        // 2. 收件人    13088805160@163.com
        message.setTo("chengdongyi@aspirecn.com");
        // 3. 主题
        message.setSubject("通知-今晚开会");
        // 4. 内容
        message.setText("今晚7点开会!");

        mailSender.send(message);
    }

    @Test
    public void test2() throws Exception {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        // 1. 发件人
        helper.setFrom(from);
        // 2. 收件人    13088805160@163.com
        helper.setTo("chengdongyi@aspirecn.com");
        // 3. 主题
        helper.setSubject("通知-今晚开会");
        // 4. 内容(html邮件)
        helper.setText("<b style='color:red'>今晚7点开会!</b>", true);

        // 5. 上传文件
        String filePath = "D:\\test\\abc.sql";
        File file = new File(filePath);
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }


    @Test
    public void test3() {

        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        // 1. 发件人
        message.setFrom(from);
        // 2. 收件人    13088805160@163.com
        message.setTo("chengdongyi@aspirecn.com");
        // 3. 主题
        message.setSubject("通知-今晚开会");
        // 4. 内容
        message.setText("今晚7点开会!");

        mailSender.send(message);
    }

    public void sendMail(String subject, String text, String... to) {

        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        // 1. 发件人
        message.setFrom(from);
        // 2. 收件人    13088805160@163.com
        message.setTo(to);
        // 3. 主题
        message.setSubject(subject);
        // 4. 内容
        message.setText(text);

        mailSender.send(message);
    }
}
