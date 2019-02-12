package com.epam.springbootapp.services;

import com.epam.springbootapp.dao.model.TopicJPA;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ITopicService {

    TopicJPA getTopic(Integer id);

    Boolean removeTopic(Integer id);

    TopicJPA saveTopic(TopicJPA topic);

    List<TopicJPA> getTopics(Integer pageSize);

}

