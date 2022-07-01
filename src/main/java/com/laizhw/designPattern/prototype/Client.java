package com.laizhw.designPattern.prototype;

import com.laizhw.designPattern.prototype.model.AdvTemplate;
import com.laizhw.designPattern.prototype.model.Mail;

import java.util.Random;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Client
 */
public class Client {

    private static int MAX_COUNT = 6;

    public static void main(String[] args) {

        int i = 0;
        //把模板定义出来，这个是从数据库中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        while (i < MAX_COUNT) {
            Mail cloneMail = mail.clone();
            //以下是每封邮件不同的地方
            cloneMail.setAppellation(getRandString(5) + " 先生（女士）");
            cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
            // 然后发送邮件
            sendMail(cloneMail);
            i++;
        }

    }

    public static void sendMail(Mail mail) {
        System.out.println("标题：" + mail.getSubject() + "\t收件人： " + mail.getReceiver() + "\t....发送成功！");
    }

    public static String getRandString(int maxLength) {
        String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }


}
