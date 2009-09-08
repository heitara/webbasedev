create table invite_template_mst (
invite_template_id int not null,
title_id int not null,
invite_template_subject varchar(50) not null,
invite_template_msg varchar(2000),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (invite_template_id)
)
