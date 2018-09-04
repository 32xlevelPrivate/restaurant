package com.ma3stro.restaurant.repository;

import com.ma3stro.restaurant.model.Vote;
import com.ma3stro.restaurant.repository.crud.CrudRestaurantRepository;
import com.ma3stro.restaurant.repository.crud.CrudUserRepository;
import com.ma3stro.restaurant.repository.crud.CrudVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {
    @Autowired
    private CrudVoteRepository crudVoteRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Override
    public List<Vote> getAll(int userId) {
        return crudVoteRepository.findAllByUserId(userId);
    }

    @Override
    public List<Vote> getAll(int userId, LocalDateTime dateTime) {
        return crudVoteRepository.findAllByUserIdAndDateTime(userId, dateTime);
    }

    @Override
    public List<Vote> getAll(int userId, int restaurantId) {
        return crudVoteRepository.findAllByUserIdAndRestaurant(userId, restaurantId);
    }

    @Override
    public List<Vote> getBetween(int userId, LocalDateTime fromDate, LocalDateTime toDate) {
        return crudVoteRepository.getBetween(userId, fromDate, toDate);
    }

    //TODO: realization
    @Override
    public Vote save(Vote vote, int userId, int restaurantId) {
//        if (!vote.isNew() && ge)
        return null;
    }
}
