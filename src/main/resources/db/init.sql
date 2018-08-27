drop table if exists votes;
drop table if exists dishes;
drop table if exists user_roles;
drop table if exists restaurants;
drop table if exists users;
drop sequence if exists global_seq;
drop index if exists date_time_user_unique;

create sequence global_seq start 1;

create table users(
  id integer primary key default nextval('global_seq'),
  name varchar not null,
  email varchar not null,
  password varchar not null,
  registered timestamp default now() not null
);
create unique index user_email_index on users (email);

create table user_roles(
  user_id integer not null,
  role varchar,
  constraint user_roles_idx unique (user_id, role),
  foreign key (user_id) references users (id) on delete cascade
);

create table restaurants (
  id integer primary key default nextval('global_seq'),
  name varchar not null
);

create table dishes(
  id integer primary key default nextval('global_seq'),
  name varchar not null,
  price double precision not null,
  restaurant_id integer not null,
  foreign key (restaurant_id) references restaurants (id) on delete cascade
);

create table votes(
  id integer primary key default nextval('global_seq'),
  date_time timestamp not null,
  user_id integer not null,
  restaurant_id integer not null,
  constraint date_time_user_unique unique (user_id, date_time, restaurant_id),
  foreign key (user_id) references users (id) on delete cascade,
  foreign key (restaurant_id) references restaurants (id) on delete cascade
);
-- create unique index user_datetime_restaurant_vote_index on votes (user_id, date_time, restaurant_id);