package com.mashans.servingwebcontent;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String color;
    private Integer wheelNumber;
    @ManyToMany
    private List<Member> members;


    public Vehicle(String type, String color, Integer wheelNumber, List<Member> members) {
        this.type = type;
        this.color = color;
        this.wheelNumber = wheelNumber;
        this.members = members;
    }

    public Vehicle() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public Integer getWheelNumber() {
        return wheelNumber;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWheelNumber(Integer wheelNumber) {
        this.wheelNumber = wheelNumber;
    }

    public void setMember(List<Member> members) {
        this.members = members;
    }
}
