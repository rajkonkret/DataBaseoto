package com.raj.DataBaseOneOne;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        UserDetailsId userDetailsId = new UserDetailsId();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());

        userDetailsId.setPesel(user.getUserDetails().getPesel());
        userDetailsId.setId(user.getUserDetails().getId());
        userDetailsId.setUserName(user.getUserDetails().getUser().getUsername());

        userDto.setUserDetailsId(
                userDetailsId
        );
        return userDto;
    }
}
