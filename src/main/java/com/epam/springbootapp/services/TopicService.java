package com.epam.springbootapp.services;

import com.epam.springbootapp.dao.model.TopicJPA;
import com.epam.springbootapp.dao.repository.iTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements ITopicService{

    @Autowired
    private iTopicRepository topicRepository;

    @Override
    public TopicJPA getTopic(Integer id) {
        return topicRepository.findById(id);
    }

    @Override
    public Boolean removeTopic(Integer id) {
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public TopicJPA saveTopic(TopicJPA topic) {
        topicRepository.save(topic);
        return topic;
    }

    @Override
    public List<TopicJPA> getTopics(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }
        Sort.Direction direction = Sort.Direction.ASC;
        org.springframework.data.domain.Pageable page = new PageRequest(0, pageSize, new Sort(direction, "id"));

        Page<TopicJPA> topTopic = topicRepository.findAll(page) ;

        return topTopic.getContent();
    }
}
