package com.raj.DataBaseOneOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserDetailsMapper userDetailsMapper = new UserDetailsMapper();

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
        //@ResponseBody
    List<UserDto> findAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();

        while (users.iterator().hasNext()) {
            User userItrator = users.iterator().next();
            userDtos.add(userMapper.mapToDto(userItrator));
            System.out.println(userDtos.iterator().next());
        }
//        userDtos = users.stream()
//                .map(u -> userMapper.mapToDto(u))
//                .collect(Collectors.toList());
        return userDtos;

    }

}
