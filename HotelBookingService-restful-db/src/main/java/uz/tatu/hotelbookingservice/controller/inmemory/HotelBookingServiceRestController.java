//package uz.tatu.hotelbookingservice.controller.inmemory;
//
//import lombok.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import uz.tatu.hotelbookingservice.service.HotelBookingService;
//
//import javax.websocket.server.PathParam;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class HotelBookingServiceRestController {
//
////    @GetMapping("/hello-world")
////    public String helloWorld() {
////        return "Hello World!";
////    }
//
////    @GetMapping("/hotels")
////    public List<String> hotels() {
////        List<String> hotels = new ArrayList<>();
////        hotels.add("Inter Continental");
////        hotels.add("Sheraton");
////        return hotels;
////    }
//
//    // @Autowired
//    private final HotelBookingService hotelBookingService;
//
//    @Autowired
//    public HotelBookingServiceRestController(HotelBookingService hotelBookingService) {
//        this.hotelBookingService = hotelBookingService;
//    }
//
//    @GetMapping("/hotels")
//    public Map<Integer, String> hotels() {
//        return hotelBookingService.availableHotels();
//    }
//
//    @GetMapping("/hotels/{id}")
//    public String hotel(@PathVariable int id) {
//        return hotelBookingService.hotel(id);
//    }
//
//    @PostMapping("/hotels")
//    public Map<Integer, String> hotels(@NonNull @RequestBody List<String> hotels) {
//        return hotelBookingService.addHotels(hotels);
//    }
//
//    @PutMapping("/hotels/{id}")
//    public Map<Integer, String> updateHotel(@PathVariable int id,
//                                            @RequestBody @NonNull String hotelName) {
//        return hotelBookingService.updateHotel(id, hotelName);
//    }
//
//
//    @DeleteMapping("/hotels/{id}")
//    public void deleteHotel(@PathVariable int id) {
//        hotelBookingService.deleteHotel(id);
//    }
//
//}
