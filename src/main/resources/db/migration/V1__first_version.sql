create table if not exists book (
    id              int             primary key     auto_increment ,
    isbn            varchar(24)     unique          not null ,
    name            varchar(255)    not null ,
    author          varchar(100) ,
    publisher       varchar(100)
)