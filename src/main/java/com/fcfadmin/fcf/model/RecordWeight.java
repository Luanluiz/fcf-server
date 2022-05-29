package com.fcfadmin.fcf.model;



public class RecordWeight {

    private Double gender;

    private Double age;

    private Double hypertension;

    private Double heartDisease;

    private Double avgGlucoseLevel;

    private Double bmi;

    private Double smokingStatus;


    public Double getGender() {
        return gender;
    }

    public void setGender(Double gender) {
        this.gender = gender;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }


    public Double getHypertension() {
        return hypertension;
    }

    public void setHypertension(Double hypertension) {
        this.hypertension = hypertension;
    }

    public Double getHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(Double heartDisease) {
        this.heartDisease = heartDisease;
    }

    public Double getAvgGlucoseLevel() {
        return avgGlucoseLevel;
    }

    public void setAvgGlucoseLevel(Double avgGlucoseLevel) {
        this.avgGlucoseLevel = avgGlucoseLevel;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(Double smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public RecordWeight() {
        this.gender = 0.2;
        this.age = 0.5;
        this.hypertension = 1.0;
        this.heartDisease = 0.8;
        this.avgGlucoseLevel = 0.8;
        this.bmi = 0.8;
        this.smokingStatus = 0.8;
    }

}
