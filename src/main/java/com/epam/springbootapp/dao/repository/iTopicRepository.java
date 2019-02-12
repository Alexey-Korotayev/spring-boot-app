package com.epam.springbootapp.dao.repository;

import com.epam.springbootapp.dao.model.ProjectJPA;
import com.epam.springbootapp.dao.model.TopicJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

public interface iTopicRepository extends JpaRepository<TopicJPA, String> {

    //Get
    TopicJPA findById(Integer id);

    //Delete
    @Query("DELETE FROM TopicJPA topic WHERE topic.id = :id")
    @Modifying
    @Transactional
    void deleteById(@Param("id") Integer workloadId);

    //list paje
    Page<TopicJPA> findAll(org.springframework.data.domain.Pageable pageable);


}
