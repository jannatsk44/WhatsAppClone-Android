package com.example.whatsapp.Models;

public class Users {
    String profilepic, userName, mail, password, userId, status, lastMessage;

    public Users(String profilepic, String userName, String mail, String password, String userId, String status, String lastMessage) {
        this.profilepic = profilepic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.status = status;
        this.lastMessage = lastMessage;
    }

    public  Users() {}

        //SignUp Constructor
         public Users(String userName, String mail, String password){
        this.userName = userName;
        this.mail = mail;
        this.password = password;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public String getUserName() {
        return userName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() { return userId; }



    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
