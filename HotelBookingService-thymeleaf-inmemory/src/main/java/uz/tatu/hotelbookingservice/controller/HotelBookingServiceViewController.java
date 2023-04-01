package uz.tatu.hotelbookingservice.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tatu.hotelbookingservice.model.Hotel;
import uz.tatu.hotelbookingservice.service.HotelBookingService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelBookingServiceViewController {

    private final HotelBookingService hotelBookingService;

    @Autowired
    public HotelBookingServiceViewController(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

    @GetMapping("/hotels")
    public ModelAndView hotels(Model model) {
        model.addAttribute("hotels", hotelBookingService.availableHotels());
        return new ModelAndView("hotels");
    }

    @GetMapping("/add-hotel")
    public String addHotel(Hotel hotel) {
        return "add-hotel";
    }

    @PostMapping("/add-hotel")
    public String addHotel(@RequestParam @NonNull String name) {
        List<String> hotelCandidates = new ArrayList<>();
        hotelCandidates.add(name);
        hotelBookingService.addHotels(hotelCandidates);
        return "redirect:/hotels";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateForm(@PathVariable("id") int id, Model model) {
        String hotelName = hotelBookingService.hotel(id);

        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setName(hotelName);
        model.addAttribute("hotel", hotel);
        return "edit-hotel";
    }

    @PostMapping("/edit/{id}")
    public String updateHotel(@PathVariable("id") int id, @RequestParam @NonNull String name) {
        hotelBookingService.updateHotel(id, name);
        return "redirect:/hotels";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        hotelBookingService.deleteHotel(id);
        return "redirect:/hotels";
    }
}
