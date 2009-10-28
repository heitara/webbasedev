
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";




DROP TABLE IF EXISTS `division_mst`;
CREATE TABLE IF NOT EXISTS `division_mst` (
  `division_code` int(11) NOT NULL,
  `division_name` varchar(30) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`division_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `inquiry_kind_mst`;
CREATE TABLE IF NOT EXISTS `inquiry_kind_mst` (
  `inquiry_kind_code` int(11) NOT NULL,
  `inquiry_kind_name` varchar(30) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`inquiry_kind_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `inquiry_info`;
CREATE TABLE IF NOT EXISTS `inquiry_info` (
  `inquiry_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `inquiry_date` datetime DEFAULT NULL,
  `mem_num` bigint(20) DEFAULT NULL,
  `company_name` varchar(40) DEFAULT NULL,
  `company_media_name` varchar(40) DEFAULT NULL,
  `company_user_name` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_mailadd` varchar(100) DEFAULT NULL,
  `tel_num` varchar(20) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `inquiry_type` int(11) DEFAULT NULL,
  `inquiry_ip` varchar(15) DEFAULT NULL,
  `inquiry_kind_code` int(11) DEFAULT NULL,
  `inquiry_object` varchar(240) DEFAULT NULL,
  `inquiry_contents` text,
  `response_date` datetime DEFAULT NULL,
  `response_subject` varchar(240) DEFAULT NULL,
  `response_contents` text,
  `from_subject` varchar(40) DEFAULT NULL,
  `from_mailadd` varchar(100) DEFAULT NULL,
  `reply_to` varchar(100) DEFAULT NULL,
  `correspond_status` int(11) DEFAULT NULL,
  `correspond_user_id` varchar(20) DEFAULT NULL,
  `correspond_user_name` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`inquiry_num`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `invite_template_mst`;
CREATE TABLE IF NOT EXISTS `invite_template_mst` (
  `invite_template_id` int(11) NOT NULL,
  `title_id` int(11) NOT NULL,
  `invite_template_subject` varchar(50) NOT NULL,
  `invite_template_msg` varchar(2000) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`invite_template_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `invite_info`;
CREATE TABLE  `invite_info` (
  `invite_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) NOT NULL,
  `invite_mail_from` varchar(100) DEFAULT NULL,
  `invite_mail_to` varchar(100) DEFAULT NULL,
  `invite_date` datetime NOT NULL,
  `invite_msg` varchar(2000) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `invite_status` char(1) DEFAULT NULL,
  `friend_create_date` datetime DEFAULT NULL,
  `friend_name` varchar(100) DEFAULT NULL,
  `child_mem_num` bigint(20) DEFAULT NULL,
  `delete_flag` char(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`invite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `member_info`;
CREATE TABLE IF NOT EXISTS `member_info` (
  `mem_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_id` varchar(20) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `mem_pwd` varchar(32) NOT NULL,
  `mem_kind_cd` char(1) DEFAULT NULL,
  `mem_atbt_cd` char(1) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `question_cd` int(11) NOT NULL,
  `answer` varchar(32) NOT NULL,
  `mail_pc` varchar(100) NOT NULL,
  `mail_mobile` varchar(10) DEFAULT NULL,
  `kanji_fname` varchar(10) DEFAULT NULL,
  `kanji_lname` varchar(10) DEFAULT NULL,
  `kana_fname` varchar(10) DEFAULT NULL,
  `kana_lname` varchar(10) DEFAULT NULL,
  `sex_cd` char(1) DEFAULT NULL,
  `birth_ymd` datetime DEFAULT NULL,
  `divis_cd` int(11) DEFAULT NULL,
  `occup_cd` int(11) DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  `building_name` varchar(50) DEFAULT NULL,
  `tel_num` varchar(20) DEFAULT NULL,
  `mailmag_req_cd` char(1) DEFAULT NULL,
  `mailmag_obj_cd` char(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `entry_date` datetime DEFAULT NULL,
  `entry_ip` varchar(15) DEFAULT NULL,
  `withdraw_date` datetime DEFAULT NULL,
  `withdraw_ip` varchar(15) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_ip` varchar(15) DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  `version_no` int(11) DEFAULT 0,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `member_info_hist`;
CREATE TABLE IF NOT EXISTS `member_info_hist` (
  `mem_num` bigint(20) NOT NULL,
  `backup_date` datetime NOT NULL,
  `mem_id` varchar(20) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `mem_pwd` varchar(32) NOT NULL,
  `mem_kind_cd` char(1) DEFAULT NULL,
  `mem_atbt_cd` char(1) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `question_cd` int(11) NOT NULL,
  `answer` varchar(32) NOT NULL,
  `mail_pc` varchar(100) NOT NULL,
  `mail_mobile` varchar(10) DEFAULT NULL,
  `kanji_fname` varchar(10) DEFAULT NULL,
  `kanji_lname` varchar(10) DEFAULT NULL,
  `kana_fname` varchar(10) DEFAULT NULL,
  `kana_lname` varchar(10) DEFAULT NULL,
  `sex_cd` int(11) DEFAULT NULL,
  `birth_ymd` datetime DEFAULT NULL,
  `divis_cd` int(11) DEFAULT NULL,
  `occup_cd` int(11) DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  `building_name` varchar(50) DEFAULT NULL,
  `tel_num` varchar(20) DEFAULT NULL,
  `mailmag_req_cd` char(1) DEFAULT NULL,
  `mailmag_obj_cd` char(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_ip` varchar(15) DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`backup_date`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `member_login_hist`;
CREATE TABLE IF NOT EXISTS `member_login_hist` (
  `mem_num` bigint(20) NOT NULL,
  `login_date` datetime NOT NULL,
  `login_ip` varchar(15) DEFAULT NULL,
  `success_flg` char(1) DEFAULT 0,
  PRIMARY KEY (`mem_num`,`login_date`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `member_login_info`;
CREATE TABLE IF NOT EXISTS `member_login_info` (
  `mem_num` bigint(20) NOT NULL,
  `mem_id` varchar(20) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `mem_pwd` varchar(32) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `login_date` datetime DEFAULT NULL,
  `login_ip` varchar(15) DEFAULT NULL,
  `login_fail_date` datetime DEFAULT NULL,
  `login_fail_ip` varchar(15) DEFAULT NULL,
  `login_fail_cnt` int(11) DEFAULT NULL,
  `version_no` int(11) DEFAULT 0,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `occupation_mst`;
CREATE TABLE IF NOT EXISTS `occupation_mst` (
  `occup_code` int(11) NOT NULL,
  `occup_name` varchar(40) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`occup_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `question_mst`;
CREATE TABLE IF NOT EXISTS `question_mst` (
  `question_code` int(11) NOT NULL,
  `question_name` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`question_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `server_mst`;
CREATE TABLE IF NOT EXISTS `server_mst` (
  `server_id` int(11) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_name` varchar(30) DEFAULT NULL,
  `service_start_date` datetime DEFAULT NULL,
  `service_end_date` datetime DEFAULT NULL,
  `service_status` char(1) DEFAULT NULL,
  `server_domain` varchar(50) DEFAULT NULL,
  `play_url` varchar(100) DEFAULT NULL,
  `charge_url` varchar(100) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `players_num` int(11) NOT NULL,
  `popularity_flag` char(1) DEFAULT NULL,
  `recommend_flag` char(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`server_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `title_mst`;
CREATE TABLE IF NOT EXISTS `title_mst` (
  `title_id` int(11) NOT NULL,
  `title_name` varchar(40) DEFAULT NULL,
  `title_about` varchar(500) DEFAULT NULL,
  `service_start_date` datetime DEFAULT NULL,
  `service_end_date` datetime DEFAULT NULL,
  `service_status` char(1) DEFAULT NULL,
  `site_url` varchar(100) DEFAULT NULL,
  `news_url` varchar(100) DEFAULT NULL,
  `forum_url` varchar(100) DEFAULT NULL,
  `payment_url` varchar(100) DEFAULT NULL,
  `big_icon_url` varchar(100) DEFAULT NULL,
  `small_icon_url` varchar(100) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `players_num` int(11) NOT NULL,
  `announce` varchar(500) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`title_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `play_hist`;
CREATE TABLE IF NOT EXISTS `play_hist` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `play_date` datetime DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`,`play_date`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `temp_pwd_info`;
CREATE TABLE  `temp_pwd_info` (
  `mail_pc` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `mem_num` bigint(20) NOT NULL,
  `temp_key` varchar(32) NOT NULL,
  PRIMARY KEY (`mail_pc`,`created_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `point_mst`;
CREATE TABLE  `point_mst` (
  `point_id` int(11) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `point_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_start_date` datetime DEFAULT NULL,
  `point_end_date` datetime DEFAULT NULL,
  `point_status` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT '0',
  `point_amount_act` decimal(10,0) DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `settlement_mst`;
CREATE TABLE  `settlement_mst` (
  `settlement_code` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `settlement_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `icon_url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `settlement_status` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`settlement_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `mem_settlement_trns`;
CREATE TABLE  `mem_settlement_trns` (
  `settlement_trns_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `settlement_code` varchar(20) DEFAULT NULL,
  `mem_num` bigint(20) DEFAULT NULL,
  `mem_atbt_cd` char(1) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `point_id` int(11) DEFAULT NULL,
  `settlement_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `point_amount_act` decimal(10,0) DEFAULT NULL,
  `settlement_log` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`settlement_trns_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `mem_settlement_hist`;
CREATE TABLE  `mem_settlement_hist` (
  `settlement_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `settlement_trns_num` bigint(20) DEFAULT NULL,
  `settlement_code` varchar(20) DEFAULT NULL,
  `mem_num` bigint(20) DEFAULT NULL,
  `mem_atbt_cd` char(1) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `point_id` int(11) DEFAULT NULL,
  `settlement_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `point_amount_act` decimal(10,0) DEFAULT NULL,
  `settlement_log` varchar(200) DEFAULT NULL,
  `settlement_remarks` varchar(200) DEFAULT NULL,
  `res_result` varchar(2) DEFAULT NULL,
  `res_tracking_id` varchar(14) DEFAULT NULL,
  `res_sps_cust_no` varchar(12) DEFAULT NULL,
  `res_sps_payment_no` varchar(3) DEFAULT NULL,
  `res_payinfo_key` varchar(32) DEFAULT NULL,
  `res_payment_date` varchar(14) DEFAULT NULL,
  `res_err_code` varchar(4) DEFAULT NULL,
  `res_date` varchar(14) DEFAULT NULL,
  `limit_second` varchar(4) DEFAULT NULL,
  `sps_hashcode` varchar(40) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`settlement_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `cbt_tester`;
CREATE TABLE  `cbt_tester` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  PRIMARY KEY (`mem_num`,`title_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `service_point`;
CREATE TABLE  `service_point` (
  `service_point_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `give_date` datetime DEFAULT NULL,
  `point_start_date` datetime DEFAULT NULL,
  `point_end_date` datetime DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`service_point_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `game_login_count`;
CREATE TABLE  `game_login_count` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `game_login_count` int(11) DEFAULT NULL,
  `last_login_ymd` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mem_num`, `title_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `service_point_type_mst`;
CREATE TABLE  `service_point_type_mst` (
  `service_point_type_id` int(11) NOT NULL,
  `service_point_type_code` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT '0',
  `standard_level` int(11) NOT NULL,
  `remarks` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`service_point_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `service_point_give_hist`;
CREATE TABLE  `service_point_give_hist` (
  `service_point_give_hist_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `service_point_no` bigint(20) NOT NULL,
  `service_point_type_id` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `give_date` datetime DEFAULT NULL,
  `point_start_date` datetime DEFAULT NULL,
  `point_end_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`service_point_give_hist_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TRIGGER IF EXISTS `t_insert_member_info_hist_bu`;
DELIMITER $$
CREATE TRIGGER `t_insert_member_info_hist_bu` AFTER UPDATE ON `member_info` FOR EACH ROW BEGIN
  IF ( OLD.mem_id <> NEW.mem_id
    || OLD.nick_name <> NEW.nick_name
    || OLD.mem_pwd <> NEW.mem_pwd
    || OLD.mem_kind_cd <> NEW.mem_kind_cd
    || OLD.mem_atbt_cd <> NEW.mem_atbt_cd
    || OLD.mem_valid_yn_cd <> NEW.mem_valid_yn_cd
    || OLD.question_cd <> NEW.question_cd
    || OLD.answer <> NEW.answer
    || OLD.mail_pc <> NEW.mail_pc
    || OLD.mail_mobile <> NEW.mail_mobile
    || OLD.kanji_fname <> NEW.kanji_fname
    || OLD.kanji_lname <> NEW.kanji_lname
    || OLD.kana_fname <> NEW.kana_fname
    || OLD.kana_lname <> NEW.kana_lname
    || OLD.sex_cd <> NEW.sex_cd
    || OLD.birth_ymd <> NEW.birth_ymd
    || OLD.divis_cd <> NEW.divis_cd
    || OLD.occup_cd <> NEW.occup_cd
    || OLD.city_name <> NEW.city_name
    || OLD.building_name <> NEW.building_name
    || OLD.tel_num <> NEW.tel_num
    || OLD.mailmag_req_cd <> NEW.mailmag_req_cd
    || OLD.mailmag_obj_cd <> NEW.mailmag_obj_cd
    || OLD.note <> NEW.note
    || OLD.last_update_date <> NEW.last_update_date
    || OLD.last_update_ip <> NEW.last_update_ip 
    || OLD.last_update_user <> NEW.last_update_user )
  THEN
    INSERT INTO member_info_hist (
      mem_num,
      backup_date,
      mem_id,
      nick_name,
      mem_pwd,
      mem_kind_cd,
      mem_atbt_cd,
      mem_valid_yn_cd,
      question_cd,
      answer,
      mail_pc,
      mail_mobile,
      kanji_fname,
      kanji_lname,
      kana_fname,
      kana_lname,
      sex_cd,
      birth_ymd,
      divis_cd,
      occup_cd,
      city_name,
      building_name,
      tel_num,
      mailmag_req_cd,
      mailmag_obj_cd,
      note,
      last_update_date,
      last_update_ip,
      last_update_user
    ) VALUES (
      OLD.mem_num,
      NEW.last_update_date,
      OLD.mem_id,
      OLD.nick_name,
      OLD.mem_pwd,
      OLD.mem_kind_cd,
      OLD.mem_atbt_cd,
      OLD.mem_valid_yn_cd,
      OLD.question_cd,
      OLD.answer,
      OLD.mail_pc,
      OLD.mail_mobile,
      OLD.kanji_fname,
      OLD.kanji_lname,
      OLD.kana_fname,
      OLD.kana_lname,
      OLD.sex_cd,
      OLD.birth_ymd,
      OLD.divis_cd,
      OLD.occup_cd,
      OLD.city_name,
      OLD.building_name,
      OLD.tel_num,
      OLD.mailmag_req_cd,
      OLD.mailmag_obj_cd,
      OLD.note,
      OLD.last_update_date,
      OLD.last_update_ip,
      OLD.last_update_user
    );
   END IF;
END $$
DELIMITER ;



DROP TRIGGER  IF EXISTS `t_insert_member_login_hist_bu`;
DELIMITER $$
CREATE TRIGGER t_insert_member_login_hist_bu AFTER UPDATE ON member_login_info
FOR EACH ROW
BEGIN
	
	IF (NEW.login_date <> OLD.login_date) THEN
	
		INSERT INTO member_login_hist (		
			mem_num,
			login_date,
			login_ip,
			success_flg
		) VALUES (
			NEW.mem_num,
			NEW.login_date,
			NEW.login_ip,
			'1'
		);
	
	ELSEIF (NEW.login_fail_date <> OLD.login_fail_date) THEN	
	
		INSERT INTO member_login_hist (		
			mem_num,
			login_date,
			login_ip,
			success_flg
		) VALUES (
			NEW.mem_num,
			NEW.login_fail_date,
			NEW.login_fail_ip,
			'0'
		);
	
	END IF;
END $$
DELIMITER ;