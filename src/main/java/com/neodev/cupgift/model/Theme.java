package com.neodev.cupgift.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theme")
public class Theme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long themeId;
    private String themeName;
    private String themeDetails;
    private int themePrice;


    public Theme(Long themeId, String themeName, String themeDetails, int themePrice) {
        super();
    	this.themeId = themeId;
        this.themeName = themeName;
        this.themeDetails = themeDetails;
        this.themePrice = themePrice;
    }

    public Theme() {
    }


    public Long getThemeId() {
        return this.themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return this.themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeDetails() {
        return this.themeDetails;
    }

    public void setThemeDetails(String themeDetails) {
        this.themeDetails = themeDetails;
    }

    public int getThemePrice() {
        return this.themePrice;
    }

    public void setThemePrice(int themePrice) {
        this.themePrice = themePrice;
    }

    @Override
    public String toString() {
        return "{" +
            " themeId='" + getThemeId() + "'" +
            ", themeName='" + getThemeName() + "'" +
            ", themeDetails='" + getThemeDetails() + "'" +
            ", themePrice='" + getThemePrice() + "'" +
            "}";
    }


}
