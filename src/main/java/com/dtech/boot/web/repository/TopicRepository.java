package com.dtech.boot.web.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtech.boot.web.resource.Topic;

@Repository
@Transactional
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
