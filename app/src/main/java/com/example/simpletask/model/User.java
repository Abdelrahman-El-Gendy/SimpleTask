package com.example.simpletask.model;

public class User {
    public String Loginname;
    public String FullName;
    public String Country;
    public int CountryId;
    public Object RegionId;
    public Object Region;
    public Object ShortNumber;
    public int UserId;
    public String Text;

    // Getters and Setters (Optional, for encapsulation)
    public String getLoginname() {
        return Loginname;
    }

    public void setLoginname(String loginname) {
        Loginname = loginname;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public Object getRegionId() {
        return RegionId;
    }

    public void setRegionId(Object regionId) {
        RegionId = regionId;
    }

    public Object getRegion() {
        return Region;
    }

    public void setRegion(Object region) {
        Region = region;
    }

    public Object getShortNumber() {
        return ShortNumber;
    }

    public void setShortNumber(Object shortNumber) {
        ShortNumber = shortNumber;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
