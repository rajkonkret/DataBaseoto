package com.raj.DataBaseOneOne;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private UserDetailsId userDetailsId;


}
