package com.example.demo.business.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StoreDTO {
    private long id;
    private String name;
    private String postCode;
}
