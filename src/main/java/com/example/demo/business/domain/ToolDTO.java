package com.example.demo.business.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ToolDTO {
    private long id;
    private String description;
    private BigDecimal hirePrice;
}
