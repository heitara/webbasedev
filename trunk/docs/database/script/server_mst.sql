create table server_mst (
server_id int not null,
title_id int not null,
server_name varchar(30),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (server_id)
)
