create table occupation_mst (
occup_code int not null,
occup_name varchar(40),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (occup_code)
)
