package jdiTestSite.beans;

public class UserBean {
    public String login;
    public String password;
	public String name;

    UserBean(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}

