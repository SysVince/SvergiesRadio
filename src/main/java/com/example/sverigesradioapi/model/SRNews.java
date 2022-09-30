package com.example.sverigesradioapi.model;

import com.example.sverigesradioapi.model.entity.SRMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SRNews {
    String copyright;
    SRMessage[] messages;
    SRPagination pagination;
}
