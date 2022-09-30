package com.example.sverigesradioapi.repository;

import com.example.sverigesradioapi.model.entity.SRMessage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SRMessageRepository extends CrudRepository<SRMessage, Integer> {

    List<SRMessage> findAll();


}
