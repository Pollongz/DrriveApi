package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Address;
import com.drrive.DrriveApi.rest.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer idAddress) {
        return addressRepository.findById(idAddress).orElse(null);
    }

    public Address addNewAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Integer idAddress) {
        boolean exists = addressRepository.existsById(idAddress);
        if (!exists) {
            throw new IllegalStateException("Address with id: " + idAddress + "doesn't exist.");
        }

        addressRepository.deleteById(idAddress);
    }

    public String updateAddress(Address address) {
        Address existingAddress = addressRepository.findById(address.getIdAddress())
                .orElseThrow(() -> new IllegalStateException(
                        "Address with id: " + address.getIdAddress() + "doesn't exist."
                ));
        existingAddress.setCountry(address.getCountry());
        existingAddress.setZipCode(address.getZipCode());
        existingAddress.setCity(address.getCity());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setBuildingNumber(address.getBuildingNumber());

        addressRepository.save(existingAddress);
        return "Address edited successfully!";
    }
}
