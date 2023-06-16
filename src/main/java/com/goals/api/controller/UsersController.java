package com.goals.api.controller;

import com.goals.api.model.Address;
import com.goals.api.model.User;
import com.goals.api.model.dto.ReadAddressDto;
import com.goals.api.model.dto.ReadUserDto;
import com.goals.api.model.dto.Response;
import com.goals.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public ResponseEntity<?> getAll(){

        List<ReadUserDto> readUserDtos = userService.getAll().stream()
                .map(user -> {
                    Address address = user.getAddress();
                    return new ReadUserDto(
                            user.getId(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail(),
                            new ReadAddressDto(
                                    address.getId(),
                                    address.getLine1(),
                                    address.getLine2(),
                                    address.getPostalCode(),
                                    address.getCity(),
                                    address.getCountry()));
                }).toList();

        return new ResponseEntity<>(
                new Response<>(true,"success", readUserDtos), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        User user = userService.get(id);
        Address address = user.getAddress();

        ReadUserDto readUserDto = new ReadUserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                new ReadAddressDto(
                        address.getId(),
                        address.getLine1(),
                        address.getLine2(),
                        address.getPostalCode(),
                        address.getCity(),
                        address.getCountry()));

        return new ResponseEntity<>(
                new Response<>(true,"success", readUserDto), HttpStatus.OK);
    }
}
