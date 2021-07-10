package com.faisal.visitciletuhapi.services;

import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.Hotel;
import com.faisal.visitciletuhapi.model.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelServices {
    
    @Autowired HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getOneHotel(Long id) {
        Optional<Hotel> temp = hotelRepository.findById(id);

        if (!temp.isPresent()) {
            return null;
        }

        return temp.get();
    }

    public Iterable<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
