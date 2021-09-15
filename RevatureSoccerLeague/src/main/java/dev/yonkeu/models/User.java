package dev.yonkeu.models;

public class User {
    private Integer users_id;
    private String username;
    private String password;
    private boolean administrator;

    private Player player;

    public User() {
    }

    public User(Integer users_id, String username, String password, Player player) {
        this.users_id = users_id;
        this.username = username;
        this.password = password;
        this.player = player;
    }

    public User(String username, String password, Player player) {
        this.username = username;
        this.password = password;
        this.player = player;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer users_id, String username, String password) {
        this.users_id = users_id;
        this.username = username;
        this.password = password;
    }

    public User(Integer users_id, String username, String password, boolean administrator) {
        this.users_id = users_id;
        this.username = username;
        this.password = password;
        this.administrator = administrator;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public Integer getUsers_id() {
        return users_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setId(Integer users_id) {
        this.users_id = users_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + users_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
