create table inquiry_kind_mst (
inquiry_kind_code int not null,
inquiry_kind_name varchar(30),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (inquiry_kind_code)
)
