drop database if exists pocket_pal;

create database pocket_pal;
use pocket_pal;

create table card_types
(
    id        int auto_increment
        primary key,
    card_type enum ('Debit', 'Credit') null
);

create table categories
(
    category_id int auto_increment
        primary key,
    name        varchar(20) not null
);

create table currency
(
    currency_id int auto_increment
        primary key,
    name        enum ('BGN', 'EUR', 'USD') not null
);

create table status
(
    status_id int auto_increment
        primary key,
    name      enum ('Active', 'Blocked', 'Disabled', 'Unverified', 'Pending', 'Waiting') null
);

create table users
(
    user_id     int auto_increment
        primary key,
    username    varchar(20)  null,
    password    varchar(30)  null,
    email       varchar(50)  not null,
    first_name  varchar(20)  not null,
    last_name   varchar(20)  not null,
    photo       varchar(300) not null,
    joined_data datetime     not null,
    wallet_id   int          not null,
    isAdmin     tinyint(1)   not null,
    status_id   int          not null,
    constraint users_status_status_id_fk
        foreign key (status_id) references status (status_id)
);

create table transactions
(
    transaction_id int auto_increment
        primary key,
    sender_id      int      not null,
    recipient_id   int      not null,
    amount         decimal(10,2)      not null,
    date           datetime not null,

    constraint transactions_users_user_id_fk
        foreign key (sender_id) references users (user_id),
    constraint transactions_users_user_id_fk2
        foreign key (recipient_id) references users (user_id)
);

create table wallet
(
    wallet_id   int auto_increment
        primary key,
    name        varchar(30) not null,
    amount       decimal(10,2)         not null,
    currency_id int         not null,
    user_id     int         not null,
    category_id int         not null ,
    constraint wallet_categories_category_id_fk
foreign key (category_id) references categories (category_id),
    constraint wallet_currency_currency_id_fk
        foreign key (currency_id) references currency (currency_id),
    constraint wallet_users_user_id_fk
        foreign key (user_id) references users (user_id)
);

create table cards
(
    cards_id        int auto_increment
        primary key,
    number          int(16)  not null,
    card_holder     int      not null,
    check_number    int(3)   not null,
    expiration_date datetime not null,
    type_id         int      not null,
    user_id         int      not null,

    constraint cards___fk
        foreign key (user_id) references users (user_id),
    constraint cards_card_types_id_fk
        foreign key (type_id) references card_types (id)

);

