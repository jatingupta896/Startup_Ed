package com.animator_abhi.gcethackathon.Models;

/**
 * Created by ankur on 14-04-2017.
 */

public class InvesterModel {
    String name;
    String companyName;
    String about;

    public InvesterModel() {
    }

    public InvesterModel(String name, String companyName, String about) {
        this.name = name;
        this.companyName = companyName;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
