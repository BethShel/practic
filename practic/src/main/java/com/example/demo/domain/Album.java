package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer songID;

    private Integer characteristicID;

    public Album() {
    }

    public Album(Integer songID, Integer characteristicID) {
            this.songID = songID;
            this.characteristicID = characteristicID;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public Integer getCharacteristicID() {
        return characteristicID;
    }

    public void setCharacteristicID(Integer characteristicID) {
        this.characteristicID = characteristicID;
    }
}
