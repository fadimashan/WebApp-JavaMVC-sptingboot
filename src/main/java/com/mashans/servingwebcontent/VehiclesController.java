package com.mashans.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class VehiclesController {

    @Autowired(required = true)
    VehicleRepo vRepo;

    @Autowired(required = true)
    MemberRepo mRepo;


    /** Get all vehicles */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String vehiclesList(Model model) {
        model.addAttribute("vehicles", vRepo.findAll());
        Iterable<Vehicle> lis = vRepo.findAll();
        lis.forEach(l -> System.out.println(l.getType()));
        return "vehicles";
    }

    /** Get the members for a specific vehicle by vehicle ID */
    @RequestMapping("/vehicle/{id}")
    public String memberDetails(@PathVariable Long id, Model model) {
        model.addAttribute("vehicle", vRepo.findById(id));
        Member m1 = vRepo.findById(id).get().getMembers().get(0);
        model.addAttribute("vehicle", m1);
        return "vehicle";
    }



}

