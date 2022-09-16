package com.example.sverigesradiodemo.model.sverigesradio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class SRPagination {
    int page;
    int size;
    int totalhits;
    int totalpages;
    String nextpage;
}
