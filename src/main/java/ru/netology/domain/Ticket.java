package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departurePoint;
    private String arrivalPoint;
    private int timeInMinute;

    public Ticket(int id, int price, String departurePoint, String arrivalPoint, int timeInMinute) {
        this.id = id;
        this.price = price;
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.timeInMinute = timeInMinute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public int getTimeInMinute() {
        return timeInMinute;
    }

    public void setTimeInMinute(int timeInMinute) {
        this.timeInMinute = timeInMinute;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
