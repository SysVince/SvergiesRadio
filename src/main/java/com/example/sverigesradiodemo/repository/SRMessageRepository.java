package com.example.sverigesradiodemo.repository;

import com.example.sverigesradiodemo.model.sverigesradio.SRMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SRMessageRepository extends CrudRepository<SRMessage, Integer> {

    List<SRMessage> findAll();


}
