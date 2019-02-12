package com.epam.springbootapp.controllers;

import com.epam.springbootapp.dao.model.TopicJPA;
import com.epam.springbootapp.dao.repository.iTopicRepository;
import com.epam.springbootapp.services.TopicService;
import com.epam.springbootapp.services.exceptions.Error;
import com.epam.springbootapp.services.responce.ResponseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Context
    private HttpHeaders requestHeaders;

    private String getHeaderVersion() {
        return "version 1.0";
    }

    @RequestMapping("/test")
    @ResponseBody
    String hello() {
        return "This is test of topic !";
    }

    // get row by id
    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response getTopic(@PathVariable String id) {
        Integer paramId = Integer.parseInt(id);
        TopicJPA topic = topicService.getTopic(paramId);

        if (topic != null) {
            return ResponseCreator.success(getHeaderVersion(), topic);
        } else {
            return ResponseCreator.error(500, Error.NOT_FOUND.getCode(), Error.NOT_FOUND.getDescription(),
                    getHeaderVersion());
        }
    }

    @RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response removeTopic(@PathVariable String id) {
        Integer paramId = Integer.parseInt(id);
        Boolean rez =  topicService.removeTopic(paramId);
        if (rez) {
            return ResponseCreator.success(getHeaderVersion(), "row was deleted id = "+paramId);
        }
        return ResponseCreator.error(500, Error.NOT_FOUND.getCode(), Error.NOT_FOUND.getDescription(), getHeaderVersion());
    }

    // create row topic and returns created topic as
    // object->JSON structure
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    @ResponseBody
    @Consumes(value={"text/xml", "application/json"})
    public Response createTopic(@Valid @RequestBody TopicJPA topic) {
        System.out.println("POST");
        if (topic.getId() != null ) {
            return ResponseCreator.error(20002, Error.ID_ERROR.getCode(), Error.ID_ERROR.getDescription(),
                    getHeaderVersion());
        }
        try {
            topicService.saveTopic(topic);
            //     returnTopic = iTopicRepository.findById(topic.getId());
        } catch (Exception e) {
            return ResponseCreator.error(500, Error.SERVER_ERROR.getCode(), Error.SERVER_ERROR.getDescription(),
                    getHeaderVersion());
        }
        return ResponseCreator.success(getHeaderVersion(), topic);
    }

    @RequestMapping(value= "/update", method = RequestMethod.POST)
    @ResponseBody
    @Consumes(value={"text/xml", "application/json"})
    public Response updateTopic(@Valid @RequestBody TopicJPA topic) {
        System.out.println("POST");
        if (topic.getId() == null ) {
            return ResponseCreator.error(20002, Error.NULLID_ERROR.getCode(), Error.NULLID_ERROR.getDescription(),
                    getHeaderVersion());
        }
        try {
            topicService.saveTopic(topic);
        } catch (Exception e) {
            return ResponseCreator.error(500, Error.SERVER_ERROR.getCode(), Error.SERVER_ERROR.getDescription(),
                    getHeaderVersion());
        }
        return ResponseCreator.success(getHeaderVersion(), topic);
    }

    @RequestMapping(value= "/getlist/{pagesize}", method = RequestMethod.GET)
    @ResponseBody
    public Response getTopics(@PathVariable("pagesize") Integer pageSize) {
        List<TopicJPA> topTopic = topicService.getTopics(pageSize) ;

        if (topTopic != null) {
            return ResponseCreator.success(getHeaderVersion(), topTopic);
        } else {
            return ResponseCreator.error(404, Error.SERVER_ERROR.getCode(), Error.SERVER_ERROR.getDescription(),
                    getHeaderVersion());
        }
    }

}
