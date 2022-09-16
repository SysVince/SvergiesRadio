package com.example.sverigesradiodemo.model.sverigesradio;

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
