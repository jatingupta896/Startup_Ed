package com.animator_abhi.gcethackathon.Models;

/**
 * Created by ankur on 14-04-2017.
 */

public class StartupModel {
    String startup_Name;
    String startup_Founder;
    String description;

    public StartupModel(String startup_Name, String startup_Founder, String description) {
        this.startup_Name = startup_Name;
        this.startup_Founder = startup_Founder;
        this.description = description;
    }

    public StartupModel() {
    }


    public String getStartup_Name() {
        return startup_Name;
    }

    public void setStartup_Name(String startup_Name) {
        this.startup_Name = startup_Name;
    }

    public String getStartup_Founder() {
        return startup_Founder;
    }

    public void setStartup_Founder(String startup_Founder) {
        this.startup_Founder = startup_Founder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
