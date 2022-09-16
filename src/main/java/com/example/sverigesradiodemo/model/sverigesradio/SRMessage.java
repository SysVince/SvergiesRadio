package com.example.sverigesradiodemo.model.sverigesradio;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "srmessage")
public class SRMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int localId;
    @Column(name = "message_id")
    private int id;
    @Column(name = "priority")
    private int priority;
    @Column(name = "created_date")
    private String createddate;
    @Column(name = "title")
    private String title;
    @Column(name = "exact_location")
    private String exactlocation;
    @Column(name = "description")
    private String description;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "category")
    private int category;
    @Column(name = "sub_category")
    private String subcategory;



}
