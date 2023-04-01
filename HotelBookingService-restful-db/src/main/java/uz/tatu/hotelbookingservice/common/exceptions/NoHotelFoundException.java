package uz.tatu.hotelbookingservice.common.exceptions;

public class NoHotelFoundException extends RuntimeException {

    public NoHotelFoundException(int hotelId) {
        super("Hotel ID not found: " + hotelId);
    }
}
