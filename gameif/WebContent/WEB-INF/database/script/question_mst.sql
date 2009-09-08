create table question_mst (
question_code int not null,
question_name varchar(50),
created_date datetime,
created_user varchar(50),
last_update_date datetime,
last_update_user varchar(50),
primary key (question_code)
)
