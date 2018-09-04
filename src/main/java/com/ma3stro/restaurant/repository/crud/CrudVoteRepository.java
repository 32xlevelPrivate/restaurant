package com.ma3stro.restaurant.repository.crud;

import com.ma3stro.restaurant.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {
    @Query("SELECT v FROM Vote v WHERE v.userId=:userId ORDER BY v.dateTime DESC")
    List<Vote> findAllByUserId(@Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.userId=:userId AND v.dateTime=:dateTime ORDER BY v.dateTime DESC")
    List<Vote> findAllByUserIdAndDateTime(@Param("userId") int userId, @Param("dateTime") LocalDateTime dateTime);

    @Query("SELECT v FROM Vote v WHERE v.userId=:userId AND v.restaurant.id=:restaurantId ORDER BY v.dateTime DESC")
    List<Vote> findAllByUserIdAndRestaurant(@Param("userId") int userId, @Param("restaurantId") int restaurantId);

    @Query("SELECT v FROM Vote v WHERE v.userId=:userId AND v.dateTime BETWEEN :fromDate AND :toDate ORDER BY v.dateTime DESC")
    List<Vote> getBetween(int userId, LocalDateTime fromDate, LocalDateTime toDate);

    @Transactional
    Vote save(Vote item);
}
