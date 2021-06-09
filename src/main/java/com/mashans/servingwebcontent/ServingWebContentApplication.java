package com.mashans.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class ServingWebContentApplication implements CommandLineRunner {

    /** Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.**/
    @Autowired(required = true)
    VehicleRepo vRepo;

    @Autowired(required = true)
    MemberRepo mRepo;

    /** SpringApplication */
    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    /** Add seed data to the app*/
    @Override
    public void run(String... args) throws Exception {
        Member m1 = new Member("Fadi",22);
        Member m2 = new Member("Shadi",52);
        Member m3 = new Member("Wael",24);
        mRepo.save(m1);
        mRepo.save(m2);
        mRepo.save(m3);


        Vehicle v1 = new Vehicle("Volvo","Red",4, Collections.singletonList(m1));
        Vehicle v2 = new Vehicle("BMW","Black",4, Collections.singletonList(m2));
        Vehicle v3 = new Vehicle("S4","Green",4, Collections.singletonList(m3));

        List<Vehicle> vehicles = new LinkedList<Vehicle>();
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        vRepo.saveAll(vehicles);

    }
}