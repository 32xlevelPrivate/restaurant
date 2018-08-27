package com.ma3stro.restaurant.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RestaurantWithVote {
    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    private int votes;

    public RestaurantWithVote() {
    }

    public RestaurantWithVote(Integer id, String name, int votes) {
        this.id = id;
        this.name = name;
        this.votes = votes;
    }

    public RestaurantWithVote(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RestaurantWithVote(RestaurantWithVote restaurantWithVote) {
        this(restaurantWithVote.getId(), restaurantWithVote.getName(), restaurantWithVote.getVotes());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
