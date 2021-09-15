package dev.yonkeu.models;

public class Team {

    private Integer id;
    private String teamName;
    private Integer gamesPlayed;
    private Integer wins;
    private Integer draws;
    private Integer loses;
    private Integer points;

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(Integer id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public Team(String teamName, Integer gamesPlayed, Integer wins, Integer draws, Integer loses, Integer points) {
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.points = points;
    }

    public Team(Integer id, String teamName, Integer gamesPlayed, Integer wins, Integer draws, Integer loses, Integer points) {
        this.id = id;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.points = points;
    }

    public Team(String teamName, Integer gamesPlayed) {
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public Integer getLoses() {
        return loses;
    }

    public Integer getPoints() {
        return points;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", wins=" + wins +
                ", draws=" + draws +
                ", loses=" + loses +
                ", points=" + points +
                '}';
    }
}
