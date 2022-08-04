package com.example.demo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class groupC {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer artistId;
    private Integer characteristicId;
    private Date joindate;
    private Date leavedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(Integer characteristicId) {
        this.characteristicId = characteristicId;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public groupC(Integer artistId, Integer characteristicId, Date joindate, Date leavedate) {
        this.artistId = artistId;
        this.characteristicId = characteristicId;
        this.joindate = joindate;
        this.leavedate = leavedate;
    }

    public groupC() {
    }
}
