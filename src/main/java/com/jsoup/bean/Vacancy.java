package com.jsoup.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by vladimir on 04.01.2016.
 */
@JsonAutoDetect
public class Vacancy {

    private String link;
    private String title;
    private String city;
    private String description;
    private String dateOfPublication;
    private String companyName;
    private String typeOfEmployment;
    private String experienceOfWork;
    private String keyWord;
    private boolean show;


    public Vacancy() {
    }

    public Vacancy(String link, String title, String city, String description, String dateOfPublication, String typeOfEmployment, String companyName, String experienceOfWork, boolean show, String keyWord) {
        setLink(link);
        setTitle(title);
        setCity(city);
        setDescription(description);
        setDateOfPublication(dateOfPublication);
        setTypeOfEmployment(typeOfEmployment);
        setCompanyName(companyName);
        setExperienceOfWork(experienceOfWork);
        setShow(show);
        setKeyWord(keyWord);
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTypeOfEmployment() {
        return typeOfEmployment;
    }

    public void setTypeOfEmployment(String typeOfEmployment) {
        this.typeOfEmployment = typeOfEmployment;
    }

    public String getExperienceOfWork() {
        return experienceOfWork;
    }

    public void setExperienceOfWork(String experienceOfWork) {
        this.experienceOfWork = experienceOfWork;
    }
}