package com.example.fredrik.rattrackers;

/**
 * Created by fredrik on 2017-10-11.
 */

public class User {

    private String firstName;
    private String lastName;
    private String emailID;
    private String password;
    private boolean accountLocked;
    private static int id = 0;
    private boolean isUser;
    private boolean activeSession = false;

    public User() {
        this ("","", "", "", false, false);
    }

    public User(String emailID, String password, boolean flag, boolean user) {
        this ("", "", emailID, password,  flag, user);
    }

    public User(String emailID, String password) {
        this ("", "", emailID, password, false, false);
    }

    public boolean isActiveSession() {
        return activeSession;
    }

    public User(String firstName, String lastName,
                String emailID, String password, boolean flag, boolean user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.password = password;
        this.accountLocked = false;
        id++;
        activeSession = flag;
        isUser = user;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserType(boolean isUser) {
        this.isUser = isUser;
    }

    public String getPassword(){
        return this.password;
    }



    public void setctiveSession(boolean loggedIn) {
        this.activeSession = loggedIn;
    }
}