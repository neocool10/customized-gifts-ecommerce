package com.neodev.cupgift.tempmodel;

public class TempTheme {
    
    private Long themeId;
    private String themeName;
    private String themeDetails;
    private int themePrice;


    public TempTheme(Long themeId, String themeName, String themeDetails, int themePrice) {
        super();
    	this.themeId = themeId;
        this.themeName = themeName;
        this.themeDetails = themeDetails;
        this.themePrice = themePrice;
    }

    public TempTheme() {
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
