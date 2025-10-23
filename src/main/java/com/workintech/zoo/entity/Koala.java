package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Koala {
    private int id;
    private String name;
    private double weight;
    private double sleepHour;
    private String gender;

    public Koala(int id, String name,  double sleepHour, double weight, String gender) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.sleepHour = sleepHour;
        this.gender = gender;
    }

    public Koala() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSleepHour() {
        return sleepHour;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSleepHour(double sleepHour) {
        this.sleepHour = sleepHour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
