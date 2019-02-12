package com.epam.springbootapp.controllers;

import com.epam.springbootapp.dao.model.ProjectJPA;
import com.epam.springbootapp.dao.repository.iProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private iProjectRepository iProjectRepository;

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {

        ProjectJPA project = iProjectRepository.findByProjectId("243");


        return "Hello Epam !";
    }
}
