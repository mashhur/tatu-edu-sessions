package uz.tatu.hotelbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.tatu.hotelbookingservice.model.Hotel;

import java.util.List;

@Repository
public interface HotelBookingServiceRepository extends JpaRepository<Hotel, Integer> {

    @Query(value = "select * from hotel where name like CONCAT('%', :name, '%')", nativeQuery = true)
    List<Hotel> searchByName(@Param(value = "name") String name);
}
