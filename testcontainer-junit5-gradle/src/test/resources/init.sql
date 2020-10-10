create table mydb.member (
    email varchar(40) not null,
    name varchar(20) not null,
    reg datetime,
    primary key (email)
)
engine=innodb
default charset=utf8
;