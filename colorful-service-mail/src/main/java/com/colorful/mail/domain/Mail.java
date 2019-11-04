package com.colorful.mail.domain;

import java.io.File;

public class Mail {

    /**
     * 发件人
     */
    private String from;

    /**
     * 收件人
     */
    private String[] to;

    /**
     * 抄送
     */
    private String[] cc;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String text;

    /**
     * 附件
     */
    private File[] file;

    /**
     * 邮件类型: 1-普通邮件; 2-复杂邮件(html或带附件的);
     */
    private String type;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = new String[]{to};
    }

    public void setTo(String... to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = new String[]{cc};
    }

    public void setCc(String... cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public File[] getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = new File[]{file};
    }

    public void setFile(File... file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
