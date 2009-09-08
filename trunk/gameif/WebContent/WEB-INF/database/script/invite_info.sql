create table invite_info (
invite_id bigint not null auto_increment,
mem_num bigint not null,
invite_mail_from varchar(100),
invite_mail_to varchar(100),
invite_date datetime not null,
invite_msg varchar(2000),
title_id int,
invite_status varchar(1),
friend_create_date datetime,
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (invite_id)
)
