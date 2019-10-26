package com.lukban.a25octoberlabexerciselistview;

public class AndroidCompanies {
    int logo;
    String compName, compCountry, compIndustry, compCEO, compDesc;

    public AndroidCompanies(int logo, String compName, String compCountry, String compIndustry, String compCEO, String compDesc) {
        this.logo = logo;
        this.compName = compName;
        this.compCountry = compCountry;
        this.compIndustry = compIndustry;
        this.compCEO = compCEO;
        this.compDesc = compDesc;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompCountry() {
        return compCountry;
    }

    public void setCompCountry(String compCountry) {
        this.compCountry = compCountry;
    }

    public String getCompIndustry() {
        return compIndustry;
    }

    public void setCompIndustry(String compIndustry) {
        this.compIndustry = compIndustry;
    }

    public String getCompCEO() {
        return compCEO;
    }

    public void setCompCEO(String compCEO) {
        this.compCEO = compCEO;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }
}
