package com.ma3stro.restaurant.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Dish> menu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Vote> votes;

    public Restaurant() {}

    public Restaurant(Integer id, String name, List<Dish> menu, List<Vote> votes) {
        super(id, name);
        this.menu = menu;
        this.votes = votes;
    }

    public Restaurant(Restaurant r) {
        this(r.getId(), r.getName(), r.getMenu(), r.getVotes());
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
