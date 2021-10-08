create table certificates.gift
(
    id serial
        constraint gifts_pk
            primary key,
    name varchar not null,
    description varchar,
    price int not null,
    create_date timestamp not null,
    last_update_date timestamp,
    duration int not null
);

create table certificates.tag
(
    id serial
        constraint gifts_pk
            primary key,
    name varchar
);

create table certificates.tag_gift
(
    tag_id int not null
        constraint tag__fk
            references certificates.tag,
    gift_id int not null
        constraint gift__fk
            references certificates.gift
);