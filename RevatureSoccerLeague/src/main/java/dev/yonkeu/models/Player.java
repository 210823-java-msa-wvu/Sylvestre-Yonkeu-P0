package dev.yonkeu.models;

public class Player {
    private Integer id;
    private String firstName;
    private String lastName;
    private String preferedFoot;
    private String preferedPosition;
    private Integer phoneNumber;
    private Integer team_id;

    private Team team;

    public Player() {
    }

    public Player(String phone_number) {

    }
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Player(String prefered_position, Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Player(Integer id, String firstName, String lastName, Team team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public Player(Integer id, String firstName, String lastName, String preferedFoot, String preferedPosition, Integer phoneNumber, Integer team_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferedFoot = preferedFoot;
        this.preferedPosition = preferedPosition;
        this.phoneNumber = phoneNumber;
        this.team_id = team_id;
    }

    public Player(String firstName, String lastName, Integer team_id, String preferedFoot, String preferedPosition, Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferedFoot = preferedFoot;
        this.preferedPosition = preferedPosition;
        this.phoneNumber = phoneNumber;
        this.team = team;
        this.team_id = team_id;
    }

    public Player(Integer id, String firstName, String lastName, String preferedFoot, String preferedPosition, Integer phoneNumber, Integer team_id, Team team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferedFoot = preferedFoot;
        this.preferedPosition = preferedPosition;
        this.phoneNumber = phoneNumber;
        this.team_id = team_id;
        this.team = team;
    }

    public Player(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Team getTeam() {
        return team;
    }

    public String getPreferedFoot() {
        return preferedFoot;
    }

    public String getPreferedPosition() {
        return preferedPosition;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPreferedFoot(String preferedFoot) {
        this.preferedFoot = preferedFoot;
    }

    public void setPreferedPosition(String preferedPosition) {
        this.preferedPosition = preferedPosition;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preferedFoot='" + preferedFoot + '\'' +
                ", preferedPosition='" + preferedPosition + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", team_id=" + team_id +
                ", team=" + team +
                '}';
    }
}
