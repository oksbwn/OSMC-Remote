package com.oksbwn.server_activity;

/**
 * Created by OKSBWN on 21/Dec/2015.
 * Used to send data to server.
 * Methods :
 *   protected PasswordAuthentication getPasswordAuthentication();
 *   public authoRize(String username,String password);
 */
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class authoRize extends Authenticator {
    private String username, password;

    public authoRize(String username,String password) {
        this.username = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}
