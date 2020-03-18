package com.raj.DataBaseOneOne;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@NoArgsConstructor
public class UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    //@JoinColumn(name = "userDetails_id")
    private Integer id;

    private String address;

    private String pesel;
/*
        nazwa pola w klasie User
 */

    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "userDetails")
    @OneToOne(mappedBy = "userDetails")
    //@JoinColumn(name = "user_id")
    private User user;
}
