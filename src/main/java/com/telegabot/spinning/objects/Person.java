package com.telegabot.spinning.objects;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private int idPerson;
    private int placePerson;
    private String namePerson;
    private String teamPerson;
    private String homePerson;
    private int score;
    private int takeFish;
    private String zones;
    private int sumPlace;


    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getPlacePerson() {
        return placePerson;
    }

    public void setPlacePerson(int placePerson) {
        this.placePerson = placePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getTeamPerson() {
        return teamPerson;
    }

    public void setTeamPerson(String teamPerson) {
        this.teamPerson = teamPerson;
    }

    public String getHomePerson() {
        return homePerson;
    }

    public void setHomePerson(String homePerson) {
        this.homePerson = homePerson;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTakeFish() {
        return takeFish;
    }

    public void setTakeFish(int takeFish) {
        this.takeFish = takeFish;
    }

    public String getZones() {
        return zones;
    }

    public void setZones(String zones) {
        this.zones = zones;
    }

    public int getSumPlace() {
        return sumPlace;
    }

    public void setSumPlace(int sumPlace) {
        this.sumPlace = sumPlace;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", placePerson=" + placePerson +
                ", namePerson='" + namePerson + '\'' +
                ", teamPerson='" + teamPerson + '\'' +
                ", homePerson='" + homePerson + '\'' +
                ", score=" + score +
                ", take=" + takeFish +
                '}';
    }

    public String toStringZone() {
        return "<b>" + placePerson +"." + namePerson +
                " \"" + teamPerson + "\" </b>" +
                "\n    Баллы - " + score + ", " +
                "Шт. - " + takeFish;
    }

    public String toStringToss() {
        return "<b>№ " + idPerson +
                " " + namePerson +
                "</b>\n    " + zones;
    }

    public String toStringPersonalCredit() {
        return "<b>" + placePerson + ". " +
                namePerson + " \"" + teamPerson +
                "\"</b>\n    Сум.мест - " + sumPlace +
                ", Баллы - " + score +
                ", Шт. - " + takeFish;
    }

    public String toStringTeamResult() {
        return "<b>" + placePerson +
                ". \"" + namePerson +
                "\"</b>\n    Сум.мест - " + sumPlace +
                ", Баллы - " + score +
                ", Шт. - " + takeFish;
    }
}
