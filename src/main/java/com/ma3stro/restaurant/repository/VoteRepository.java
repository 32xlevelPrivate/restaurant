package com.ma3stro.restaurant.repository;

import com.ma3stro.restaurant.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteRepository {
    List<Vote> getAll(int userId);

    List<Vote> getAll(int userId, LocalDateTime dateTime);

    List<Vote> getAll(int userId, int restaurantId);

    List<Vote> getBetween(int userId, LocalDateTime fromDate, LocalDateTime toDate);

//    Vote get(int id);

    Vote save(Vote vote, int userId, int restaurantId);

//    boolean delete(int id, int userId, int restaurantId);
}
