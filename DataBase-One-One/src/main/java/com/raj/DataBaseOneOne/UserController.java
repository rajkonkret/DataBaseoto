package com.raj.DataBaseOneOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserDetailsMapper userDetailsMapper = new UserDetailsMapper();

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/api/")
        //@ResponseBody
    List<UserDto> findAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        users.forEach(u -> {
            userDtos.add(userMapper.mapToDto(u));
        });

//        while (users.iterator().hasNext()) {
//            User userItrator = users.iterator().next();
//            userDtos.add(userMapper.mapToDto(userItrator));
//            System.out.println(userDtos.iterator().next());
//        }
//        userDtos = users.stream()
//                .map(u -> userMapper.mapToDto(u))
//                .collect(Collectors.toList());
        return userDtos;

    }

    @PostMapping("users/add")
    public User addUsers(@RequestBody User user){
       return userRepository.save(user);

    }

}
