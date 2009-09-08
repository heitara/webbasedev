create table division_mst (
division_code int not null,
division_name varchar(30),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (division_code)
)
