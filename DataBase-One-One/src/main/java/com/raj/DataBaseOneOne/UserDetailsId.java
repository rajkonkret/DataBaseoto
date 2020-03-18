package com.raj.DataBaseOneOne;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class UserDetailsId {
    private Integer id;
    private String pesel;
    private String userName;
}
