package com.fy.dailypaper.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@Component
public class MailUtils {
    // 当前类的实例
    private static MailUtils INSTANCE = new MailUtils();

    @Resource
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String from;

    // @PostConstruct 当前对象MailUtils初始化完成组件注入后，执行后置的处理
    @PostConstruct
    public void init() {
        // 给当前实例注入属性
        this.INSTANCE.mailSender = mailSender;
        this.INSTANCE.from = from;
    }

    //  发送普通邮件的方法
    public static void sendMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom(INSTANCE.from);
        // 收件人
        message.setTo(to);
        // 主题
        message.setSubject(subject);
        // 正文
        message.setText(content);
        // 发送时间
        message.setSentDate(new Date());
        // 执行发送
        INSTANCE.mailSender.send(message);
    }

    //  发送多媒体的邮件的方法
    public static void sendMimeMail(String[] to, String subject, String content, File attachment) throws MessagingException {
        // 获取多媒体消息对象
        MimeMessage message = INSTANCE.mailSender.createMimeMessage();
        // 获取发送邮件的助手
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        // 使用助手设置收/发件人/主题/时间/正文
        helper.setFrom(INSTANCE.from);
        helper.setTo(to);
        helper.setSubject(subject);
        // true 表示是否是html格式内容
        helper.setText(content, true);
        helper.addAttachment(attachment.getName(), attachment);
        // 执行发送
        INSTANCE.mailSender.send(message);
    }
}

