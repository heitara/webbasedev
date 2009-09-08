create table member_login_hist (
mem_num bigint not null,
login_date datetime not null,
mem_id varchar(20) not null,
nick_name varchar(32),
mem_pwd varchar(32) not null,
login_ip varchar(15),
login_fail_ip varchar(15),
login_fail_date datetime,
login_fail_cnt int,
last_update_ip varchar(15),
last_update_date datetime,
version_no int,
primary key (mem_num, login_date)
)
