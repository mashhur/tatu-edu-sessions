package uz.tatu.hotelbookingservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tatu.hotelbookingservice.common.exceptions.NoHotelFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class HotelBookingService {

    // Map is not safe?
    private final ConcurrentMap<Integer, String> hotels = new ConcurrentHashMap<>();

    {
        hotels.put(1, "Inter Continental");
        hotels.put(2, "Sheraton");
    }

    public Map<Integer, String> availableHotels() {
        return hotels;
    }

    public String hotel(int id) {
        if (Objects.isNull(hotels.get(id))) {
            throw new NoHotelFoundException(id);
        }

        return this.hotels.get(id);
    }

    public Map<Integer, String> addHotelsSynchronized(List<String> hotels) {
        synchronized (this) {
            // use non-thread safe Map if you are not using ConcurrentMap
        }
        return this.hotels;
    }

    public Map<Integer, String> addHotels(List<String> hotels) {
        hotels.forEach((name) -> this.hotels.put(this.hotels.size() + 1, name));
        return this.hotels;
    }

    public Map<Integer, String> updateHotel(int id, String name) {
        if (Objects.isNull(hotels.get(id))) {
            throw new NoHotelFoundException(id);
        }

        hotels.put(id, name);
        return this.hotels;
    }

    public void deleteHotel(int id) {
        if (Objects.isNull(hotels.get(id))) {
            throw new NoHotelFoundException(id);
        }

        hotels.remove(id);
    }
}
