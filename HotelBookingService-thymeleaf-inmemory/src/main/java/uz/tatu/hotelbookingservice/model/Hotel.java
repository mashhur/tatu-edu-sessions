package uz.tatu.hotelbookingservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Builder(toBuilder = true)
@Getter
@Setter
public class Hotel {

    public int id;

    public String name;
}
