package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class albumCharacteristic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private Date date;
    private String style;
    private Integer countTracks;
    private Integer length;

    public albumCharacteristic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getCountTracks() {
        return countTracks;
    }

    public void setCountTracks(Integer countTracks) {
        this.countTracks = countTracks;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(String carrierType) {
        this.carrierType = carrierType;
    }

    public albumCharacteristic(String name, Date date, String style, Integer countTracks, Integer length, String carrierType) {
        this.name = name;
        this.date = date;
        this.style = style;
        this.countTracks = countTracks;
        this.length = length;
        this.carrierType = carrierType;
    }

    private String carrierType;

}
