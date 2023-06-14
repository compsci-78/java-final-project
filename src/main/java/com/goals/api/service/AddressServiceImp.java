package com.goals.api.service;

import com.goals.api.model.Address;
import com.goals.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address get(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No address matches the provided id"));
    }

    @Override
    public Address create(Address entity) {
        return null;
    }

    @Override
    public Address update(Integer id, Address entity) {
        return null;
    }

    @Override
    public Address delete(Integer id) {
        return null;
    }
}
