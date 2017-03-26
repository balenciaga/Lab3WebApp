/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author IT353S741
 */
public class ProfileBean {
    private String firstname;
    private String lastname;
    private String userid;
    private String password;
    private String confirmpassword;
    private String email;
    private String secquestion;
    private String secanswer;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the secquestion
     */
    public String getSecquestion() {
        return secquestion;
    }

    /**
     * @param secquestion the secquestion to set
     */
    public void setSecquestion(String secquestion) {
        this.secquestion = secquestion;
    }

    /**
     * @return the secanswer
     */
    public String getSecanswer() {
        return secanswer;
    }

    /**
     * @param secanswer the secanswer to set
     */
    public void setSecanswer(String secanswer) {
        this.secanswer = secanswer;
    }

    /**
     * @return the confirmpassword
     */
    public String getConfirmpassword() {
        return confirmpassword;
    }

    /**
     * @param confirmpassword the confirmpassword to set
     */
    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    public String getInfo() {
        String userInfo;
        
        String passStars = "";
        for (int i = 0; i < this.getPassword().length(); i++) {
            passStars += "*";
        }
        
        userInfo = "Name: " + this.getFirstname() + " " + this.getLastname()
            +  " " +"E-mail: " + this.getEmail()
            + " " + "ID:" + this.getUserid()
            + " " + "Password: " + passStars
            + " " + "Security Question: " + this.getSecquestion()
            + " " + "Security Answer: " + this.getSecanswer();
        
        return userInfo;
    }
    //found part of above code on staackoverflow and edited to work with this
    
    public void sendEmail() {

        // Recipient's email ID needs to be mentioned.
        String to = "bvaglica1551@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "bovagli@ilstu.edu";
        
        // Assuming you are sending email from this host
        String host = "outlook.office365.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("bovagli@ilstu.edu", "removedpassword");
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Congratulations!");

            // Send the actual HTML message, as big as you like
            message.setContent("<h1>You have signed up for the webapp!</h1>",
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}