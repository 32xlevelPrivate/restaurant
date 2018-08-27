delete from user_roles;
delete from votes;
delete from dishes;
delete from restaurants;
delete from users;
alter sequence global_seq restart with 1;

insert into users (name, email, password)
values ('User', 'user@yandex.ru', 'password'), -- 1
       ('Admin', 'admin@gmail.com', 'adminpass'); -- 2

insert into user_roles(role, user_id)
values ('ROLE_USER', 1),
        ('ROLE_ADMIN', 2),
        ('ROLE_USER', 2);

insert into restaurants (name)
values ('MCDonalds'), -- 3
       ('KFC'), -- 4
       ('BurgerKing'); -- 5

insert into dishes (name, price, restaurant_id)
values ('Фреш ролл', 5.3, 3),
       ('Цыплята', 6.0, 3),
       ('Бургер малый', 2.2, 3),
       ('Курочка', 4.9, 4),
       ('Большой набор', 7.2, 4),
       ('Английские цыплята', 8.4, 4),
       ('Бургер необычный', 4.9, 5),
       ('Бургер огромный', 8.9, 5),
       ('Бургер с двойным беконом и снеками', 9.0, 5);

insert into votes (date_time, user_id, restaurant_id)
values ('2018-08-01 15:00', 1, 3),
       ('2018-08-02 10:00', 1, 3),
       ('2018-08-03 11:30', 1, 4),
       ('2018-08-04 16:15', 2, 5),
       ('2018-08-05 10:45', 2, 4),
       ('2018-08-06 8:17', 2, 4);
