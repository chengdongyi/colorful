package com.colorful.mail;

import com.colorful.mail.domain.Mail;

import java.io.File;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/10/30 23:18
 */
public class Demo {

    public static void main(String[] args) {


        Mail mail = new Mail();

        if (mail.getFile() != null) {
            for (File file : mail.getFile()) {
                System.out.println(file.getName());
            }
        }


    }


}
