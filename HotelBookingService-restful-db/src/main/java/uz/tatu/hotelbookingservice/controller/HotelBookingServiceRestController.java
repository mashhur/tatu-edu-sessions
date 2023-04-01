package uz.tatu.hotelbookingservice.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.tatu.hotelbookingservice.model.Hotel;
import uz.tatu.hotelbookingservice.service.HotelBookingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelBookingServiceRestController {

    private final HotelBookingService hotelBookingService;

    @Autowired
    public HotelBookingServiceRestController(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> hotels() {
        List<Hotel> hotels = hotelBookingService.availableHotels();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "HOTEL-BOOKING-SERVICE-HEADER");

        // we can also create our own Generic Response entity
        return new ResponseEntity<>(hotels, headers, HttpStatus.OK);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> hotel(@PathVariable int id) {
        return new ResponseEntity<>(hotelBookingService.hotel(id), HttpStatus.OK);
    }

    @PostMapping("/hotels")
    public ResponseEntity<List<Hotel>> hotels(@NonNull @RequestBody List<Hotel> hotels) {
        List<Hotel> createdHotels = hotelBookingService.addHotels(hotels);
        return new ResponseEntity<>(createdHotels, HttpStatus.OK);
    }

    @PutMapping("/hotels")
    public ResponseEntity<List<Hotel>> updateHotels(@RequestBody @NonNull List<Hotel> hotels) {
        List<Hotel> updatedHotels = hotelBookingService.updateHotels(hotels);
        return new ResponseEntity<>(updatedHotels, HttpStatus.OK);
    }

    @DeleteMapping("/hotels/{id}")
    public void deleteHotel(@PathVariable int id) {
        hotelBookingService.deleteHotel(id);
    }


    @GetMapping("/search-hotels")
    public ResponseEntity<List<Hotel>> hotels(@RequestParam String name) {
        List<Hotel> hotels = hotelBookingService.search(name);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
