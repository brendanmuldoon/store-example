package com.example.demo.data.entity;

import com.example.demo.data.entity.constants.StoreConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = StoreConstants.TABLE_NAME)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Store {

    @Id
    @Column(name = StoreConstants.ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = StoreConstants.NAME)
    private String name;

    @Column(name = StoreConstants.POST_CODE)
    private String postCode;
}
