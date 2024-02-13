package userConstructor;

public class user {
    String userName;
    String userEmail;
    String sessionID;

    public user(String usernames, String email, String sessionID) {
        this.sessionID = sessionID;
        this.userName = usernames;
        this.userEmail = email;
    }
}