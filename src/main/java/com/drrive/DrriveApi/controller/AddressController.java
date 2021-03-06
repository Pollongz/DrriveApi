package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Address;
import com.drrive.DrriveApi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddress() {
        return addressService.getAddress();
    }

    @GetMapping(path = "/{idAddress}")
    public Address getOneAddress(@PathVariable Integer idAddress) {
        return addressService.getAddressById(idAddress);
    }

    @PostMapping
    public Address addNewAddress(@RequestBody Address address) {
        return addressService.addNewAddress(address);
    }

    @DeleteMapping(path = "/{idAddress}")
    public void deleteAddress(@PathVariable Integer idAddress) {
        addressService.deleteAddress(idAddress);
    }

    @PutMapping(path = "/{idAddress}")
    public String updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }
}
