package uz.tatu.hotelbookingservice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tatu.hotelbookingservice.common.exceptions.NoHotelFoundException;
import uz.tatu.hotelbookingservice.model.Hotel;
import uz.tatu.hotelbookingservice.repository.HotelBookingServiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelBookingService {

    private final HotelBookingServiceRepository hotelBookingServiceRepository;

    public List<Hotel> availableHotels() {
        return hotelBookingServiceRepository.findAll();
    }

    public Hotel hotel(int id) {
        Optional<Hotel> hotel = hotelBookingServiceRepository.findById(id);
        if (hotel.isEmpty()) {
            throw new NoHotelFoundException(id);
        }
        return hotel.get();
    }

    public List<Hotel> addHotels(List<Hotel> hotels) {
        return hotelBookingServiceRepository.saveAll(hotels);
    }

    public List<Hotel> updateHotels(List<Hotel> hotels) {
        List<Hotel> modifiedHotels = new ArrayList<>();
        for (Hotel hotel: hotels) {
            Optional<Hotel> hotelInDb = hotelBookingServiceRepository.findById(hotel.getId());
            if (hotelInDb.isPresent()) {
                Hotel modifiedHotel = hotelBookingServiceRepository.save(hotel);
                modifiedHotels.add(modifiedHotel);
            }
        }
        return modifiedHotels;
    }

    public void deleteHotel(int id) {
        hotelBookingServiceRepository.deleteById(id);
    }

    public List<Hotel> search(@NonNull String nameLookLike) {
        return hotelBookingServiceRepository.searchByName(nameLookLike);
    }
}
