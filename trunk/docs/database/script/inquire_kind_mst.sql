create table inquire_kind_mst (
inquire_kind_code int not null,
inquire_kind_name varchar(30),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (inquire_kind_code)
)
