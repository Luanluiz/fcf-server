package com.fcfadmin.fcf.model;

public class RecordDto {

    private Integer id;

    private Integer gender;

    private Integer age;

    private Boolean hypertension;

    private Boolean heartDisease;

    private Double avgGlucoseLevel;

    private Double bmi;

    private Integer smokingStatus;

    private Boolean stroke;

    private Double similarity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHypertension() {
        return hypertension;
    }

    public void setHypertension(Boolean hypertension) {
        this.hypertension = hypertension;
    }

    public Boolean getHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(Boolean heartDisease) {
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

    public Integer getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(Integer smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public Boolean getStroke() {
        return stroke;
    }

    public void setStroke(Boolean stroke) {
        this.stroke = stroke;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }
}
