package com.mashans.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class VehiclesController {

    @Autowired(required = true)
    VehicleRepo vRepo;

    @Autowired(required = true)
    MemberRepo mRepo;


//    @GetMapping("/vehicles")
//    public String vehicles(@RequestParam(name = "name", required = false,defaultValue = "World") String name, Model model){
//        model.addAttribute("name", name);
//        return "vehicles";
//    }


    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public String vehiclesList(Model model){
        model.addAttribute("vehicles", vRepo.findAll());
        Iterable<Vehicle> lis = vRepo.findAll();
        lis.forEach(l-> System.out.println(l.getType()));
        return "vehicles";
    }

}

