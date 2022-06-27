package com.example.demo.data.entity;

import com.example.demo.data.entity.constants.ToolConstants;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = ToolConstants.TABLE_NAME)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tool {

    @Id
    @Column(name = ToolConstants.ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = ToolConstants.DESCRIPTION)
    private String description;

    @Column(name = ToolConstants.HIRE_PRICE)
    private BigDecimal hirePrice;
}
