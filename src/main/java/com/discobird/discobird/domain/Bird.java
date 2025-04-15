package com.discobird.discobird.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bird {

    @Id
    private String speciesCode;
    private String sciName;
    private String comName;
    private String category;
    private Double taxonOrder;
    private String bandingCodes;
    private String comNameCodes;
    private String sciNameCodes;
    private String order;
    private String familyCode;
    private String familyComName;
    private String familySciName;
    public String getSciName() {
        return sciName;
    }

    public void setSciName(String sciName) {
        this.sciName = sciName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFamilyComName() {
        return familyComName;
    }

    public void setFamilyComName(String familyComName) {
        this.familyComName = familyComName;
    }

    public String getFamilySciName() {
        return familySciName;
    }

    public void setFamilySciName(String familySciName) {
        this.familySciName = familySciName;
    }
}