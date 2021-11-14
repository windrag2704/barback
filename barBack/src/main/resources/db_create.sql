create table if not exists bar_table
(
    id       serial
        constraint bar_table_pk
            primary key,
    number   integer  not null,
    seat_cnt integer  not null,
    location varchar(50) not null,
    photo    bytea
);

comment on table bar_table is 'Таблица столиков бара';
comment on column bar_table.id is 'Уникальный идентификатор столика';
comment on column bar_table.number is 'Номер столика';
comment on column bar_table.seat_cnt is 'Количество мест';
comment on column bar_table.location is 'Расположение столика в зале: барная стойка, у окна, просто в зале';
comment on column bar_table.photo is 'Фото столика';

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

comment on table customer is 'Таблица клиентов бара';
comment on column customer.id is 'Уникальный идентификатор клиента';
comment on column customer.phone is 'Номер телефона';
comment on column customer.name is 'Имя клиента';

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

comment on table table_reservation is 'Таблица для хранения времени бранирования столиков';
comment on column table_reservation.customer_id is 'Уникальный идентификатор клиента';
comment on column table_reservation.table_id is 'Уникальный идентификатор столика';
comment on column table_reservation.reservation_begin is 'Дата и время начала бронирования';
--comment on column table_reservation.finished is 'Закончилась ли бронь??';

create table if not exists score
(
    customer_id integer not null,
    good_id  integer not null,
    grade       integer not null
        constraint score_border
            check ((grade >= 0) AND (grade <= 5)),
    constraint score_pk
        primary key (customer_id, good_id)
);

comment on table score is 'Таблица оценок алкоголя пользователями';
comment on column score.customer_id is 'Уникальный идентификатор клиента';
comment on column score.good_id is 'Уникальный идентификатор товара';
comment on column score.grade is 'Оценка товара';

create table if not exists alcohol_type
(
    id   serial
        constraint alcohol_type_pk
            primary key,
    name varchar(255) not null
);

comment on table alcohol_type is 'Таблица типов алкоголя (пиво, сидр и т.д.)';
comment on column alcohol_type.id is 'Уникальный идентификатор типа алкоголя';
comment on column alcohol_type.name is 'Название типа алкоголя';

create table if not exists good
(
    id          serial
        constraint good_pk
            primary key,
    name        varchar(255)     not null,
    -- photo       bytea,
    price       double precision not null,
    alcohol     double precision not null,
    volume      double precision,
    type_id     integer          not null
        constraint good_alcohol_type_id_fk
            references alcohol_type,
    description varchar(255),
    code        integer          not null
);

comment on table good is 'Таблица ассортимента алкоголя бара';
comment on column good.id is 'Уникальный идентификатор товара';
comment on column good.photo is 'Фотография товара';
comment on column good.price is 'Цена';
comment on column good.alcohol is 'Крепость напитка';
comment on column good.volume is 'Объем напитка';
comment on column good.type_id is 'Ид типа алкоголя';
comment on column good.description is 'Описание напитка';
comment on column good.code is 'Штрих код??';

create unique index if not exists product_code_uindex
    on good (code);

create table if not exists inventory
(
    id         serial
        constraint inventory_pk
            primary key,
    good_id integer not null
        constraint inventory_good_id_fk
            references good,
    count      integer not null
);

--дописать комментарии к таблице

create table if not exists alco_reservation
(
    id          serial
        constraint alco_reservation_pk
            primary key,
    good_id  integer               not null
        constraint alco_reservation_good_id_fk
            references product,
    customer_id integer               not null
        constraint alco_reservation_customer_id_fk
            references customer,
    start_time  timestamp             not null,
    count       integer               not null,
    finished    boolean default false not null
);

comment on table alco_reservation is 'Таблица бронирования алкоголя';
comment on column alco_reservation.id is 'Ид брони';
comment on column alco_reservation.good_id is 'Ид товара';
comment on column alco_reservation.customer_id is 'Ид клиента';
comment on column alco_reservation.start_time is 'Дата и время брони';
comment on column alco_reservation.count is '';
comment on column alco_reservation.finished is '';
