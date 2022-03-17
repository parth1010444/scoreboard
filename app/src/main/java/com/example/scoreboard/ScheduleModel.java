package com.example.scoreboard;

public class ScheduleModel {
    int MatchNumber;
    String Team1Name;
    String Team2Name;
    int Team1Score;
    int Team2Score;
    int Team1Over;
    int Team2Over;
    int Team1WicketsFallen;
    int Team2WicketsFallen;

    ScheduleModel(){

    }
    public ScheduleModel(int matchNumber, String team1Name, String team2Name, int team1Score, int team2Score, int team1Over, int team2Over, int team1WicketsFallen, int team2WicketsFallen) {
        this.MatchNumber = matchNumber;
        this.Team1Name = team1Name;
        this.Team2Name = team2Name;
        this.Team1Score = team1Score;
        this.Team2Score = team2Score;
        this.Team1Over = team1Over;
        this.Team2Over = team2Over;
        this.Team1WicketsFallen = team1WicketsFallen;
        this.Team2WicketsFallen = team2WicketsFallen;
    }

    public int getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        MatchNumber = matchNumber;
    }

    public String getTeam1Name() {
        return Team1Name;
    }

    public void setTeam1Name(String team1Name) {
        Team1Name = team1Name;
    }

    public String getTeam2Name() {
        return Team2Name;
    }

    public void setTeam2Name(String team2Name) {
        Team2Name = team2Name;
    }

    public int getTeam1Score() {
        return Team1Score;
    }

    public void setTeam1Score(int team1Score) {
        Team1Score = team1Score;
    }

    public int getTeam2Score() {
        return Team2Score;
    }

    public void setTeam2Score(int team2Score) {
        Team2Score = team2Score;
    }

    public int getTeam1Over() {
        return Team1Over;
    }

    public void setTeam1Over(int team1Over) {
        Team1Over = team1Over;
    }

    public int getTeam2Over() {
        return Team2Over;
    }

    public void setTeam2Over(int team2Over) {
        Team2Over = team2Over;
    }

    public int getTeam1WicketsFallen() {
        return Team1WicketsFallen;
    }

    public void setTeam1WicketsFallen(int team1WicketsFallen) {
        Team1WicketsFallen = team1WicketsFallen;
    }

    public int getTeam2WicketsFallen() {
        return Team2WicketsFallen;
    }

    public void setTeam2WicketsFallen(int team2WicketsFallen) {
        Team2WicketsFallen = team2WicketsFallen;
    }
}
