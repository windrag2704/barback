create type location as enum ('bar_counter', 'bar_table');

create table if not exists bar_table
(
    id       serial
        constraint bar_table_pk
            primary key,
    number   integer  not null,
    seat_cnt integer  not null,
    location location not null,
    photo    bytea
);

create unique index if not exists bar_table_number_uindex
    on bar_table (number);

create table if not exists customer
(
    id    serial
        constraint customer_pk
            primary key,
    phone varchar(50) not null,
    name  varchar(255)
);

create table if not exists table_reservation
(
    cutomer_id        integer               not null
        constraint reservation_customer_id_fk
            references customer,
    table_id          integer               not null
        constraint reservation_bar_table_id_fk
            references bar_table,
    reservation_begin timestamp             not null,
    finished          boolean default false not null,
    constraint reservation_pk
        primary key (cutomer_id, table_id)
);

create table if not exists score
(
    customer_id integer not null,
    product_id  integer not null,
    grade       integer not null
        constraint score_border
            check ((grade >= 0) AND (grade <= 5)),
    constraint score_pk
        primary key (customer_id, product_id)
);

create table if not exists alcohol_type
(
    id   serial
        constraint alcohol_type_pk
            primary key,
    name varchar(255) not null
);

create table if not exists product
(
    id          serial
        constraint product_pk
            primary key,
    name        varchar(255)     not null,
    photo       bytea,
    price       integer          not null,
    alcohol     double precision not null,
    size        double precision,
    type_id     integer          not null
        constraint product_alcohol_type_id_fk
            references alcohol_type,
    description varchar(255),
    code        integer          not null
);

create unique index if not exists product_code_uindex
    on product (code);

create table if not exists inventory
(
    id         serial
        constraint inventory_pk
            primary key,
    product_id integer not null
        constraint inventory_product_id_fk
            references product,
    count      integer not null
);

create table if not exists alco_reservation
(
    id          serial
        constraint alco_reservation_pk
            primary key,
    product_id  integer               not null
        constraint alco_reservation_product_id_fk
            references product,
    customer_id integer               not null
        constraint alco_reservation_customer_id_fk
            references customer,
    start_time  timestamp             not null,
    count       integer               not null,
    finished    boolean default false not null
);


