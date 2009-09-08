create table title_mst (
title_id int not null,
title_name varchar(40),
valid_start_date datetime,
valid_end_date datetime,
site_url varchar(50),
small_icon_url varchar(50),
big_icon_url varchar(50),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (title_id)
)
