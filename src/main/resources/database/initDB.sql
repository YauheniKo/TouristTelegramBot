create table if not exists citybot (
    id integer not null auto_increment,
    description varchar(255),
    name varchar(255),
    primary key (id)
) engine=InnoDB;
