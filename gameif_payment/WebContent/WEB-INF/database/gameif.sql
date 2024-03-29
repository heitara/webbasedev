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
  `approve_status` char(1) DEFAULT NULL,
  `parent_cookie` varchar(50) DEFAULT NULL,
  `parent_approve_cookie` varchar(50) DEFAULT NULL,
  `child_cookie` varchar(50) DEFAULT NULL,
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
  `mem_id` varchar(150) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `mem_pwd` varchar(32) NOT NULL,
  `mem_kind_cd` char(1) DEFAULT NULL,
  `mem_atbt_cd` char(1) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `question_cd` int(11) DEFAULT NULL,
  `answer` varchar(32) DEFAULT NULL,
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
  `mem_id` varchar(150) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `mem_pwd` varchar(32) NOT NULL,
  `mem_kind_cd` char(1) DEFAULT NULL,
  `mem_atbt_cd` char(1) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `question_cd` int(11) DEFAULT NULL,
  `answer` varchar(32) DEFAULT NULL,
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
  `mem_id` varchar(150) NOT NULL,
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
  `provider_id` varchar(5) DEFAULT NULL,
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
  PRIMARY KEY (`server_id`, `title_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


ALTER TABLE `gameif_portal`.`server_mst` DROP COLUMN `provider_id`;


DROP TABLE IF EXISTS `provider_server_mst`;
CREATE TABLE IF NOT EXISTS `provider_server_mst` (
  `server_id` int(11) NOT NULL,
  `title_id` int(11) NOT NULL,
  `provider_id` varchar(5) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`server_id`, `title_id`, `provider_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `title_mst`;
CREATE TABLE IF NOT EXISTS `title_mst` (
  `title_id` int(11) NOT NULL,
  `title_name` varchar(40) DEFAULT NULL,
  `title_about` varchar(500) DEFAULT NULL,
  `service_start_date` datetime DEFAULT NULL,
  `service_end_date` datetime DEFAULT NULL,
  `service_status` char(1) DEFAULT NULL,
  `recruit_status` char(1) DEFAULT NULL,
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
  `play_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`,`play_date`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `play_guaranty`;
CREATE TABLE  `play_guaranty` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `play_ip` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




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
  `server_id` int(11) DEFAULT NULL,
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
  `order_by` int(11) DEFAULT NULL,
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
  `provider_id` varchar(5) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `point_id` int(11) DEFAULT NULL,
  `settlement_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `point_amount_act` decimal(10,0) DEFAULT NULL,
  `settlement_log` varchar(1000) DEFAULT NULL,
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
  `settlement_log` varchar(1000) DEFAULT NULL,
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




DROP TABLE IF EXISTS `beta_tester`;
CREATE TABLE  `beta_tester` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(10) NOT NULL,
  `elect_status` char(1) NOT NULL,
  PRIMARY KEY (`mem_num`,`title_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `service_point`;
CREATE TABLE  `service_point` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `point_end_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`)
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
  `service_point_type_code` varchar(10) DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT '0',
  `standard_level` int(11) NOT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_point_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `service_point_give_hist`;
CREATE TABLE `service_point_give_hist` (
  `service_point_give_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) NOT NULL,
  `service_point_type_id` int(11) DEFAULT NULL,
  `service_point_type_cd` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `give_date` datetime DEFAULT NULL,
  `point_end_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_point_give_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `service_point_change_hist`;
CREATE TABLE `service_point_change_hist` (
  `service_point_change_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) NOT NULL,
  `from_title_id` int(11) NOT NULL,
  `from_point_end_date` datetime DEFAULT NULL,
  `from_point_amount` decimal(10,0) DEFAULT NULL,
  `to_title_id` int(11) NOT NULL,
  `to_point_end_date` datetime DEFAULT NULL,
  `to_point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`service_point_change_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `service_point_use_hist`;
CREATE TABLE `service_point_use_hist` (
  `service_point_use_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `use_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_point_use_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `authority_mst`;
CREATE TABLE  `authority_mst` (
  `authority_code` varchar(20) NOT NULL,
  `authority_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`authority_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `authority_detail_mst`;
CREATE TABLE  `authority_detail_mst` (
  `authority_code` varchar(20) NOT NULL,
  `function_code` varchar(10) NOT NULL DEFAULT '',
  `authority_level` char(1) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`authority_code`,`function_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `login_user`;
CREATE TABLE  `login_user` (
  `user_id` varchar(20) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `nick_name` varchar(30) DEFAULT NULL,
  `authority_code` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `function_mst`;
CREATE TABLE  `function_mst` (
  `function_code` varchar(20) NOT NULL,
  `function_name` varchar(50) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`function_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `temp_member_info`;
CREATE TABLE  `temp_member_info` (
  `mem_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_id` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `nick_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mem_pwd` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `mail_pc` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `auth_key` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `invite_id` bigint(20) DEFAULT NULL,
  `advert_num` int(11) DEFAULT NULL,
  `link_key` varchar(50) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_ip` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `media_kind_mst`;
CREATE TABLE  `media_kind_mst` (
  `media_kind_num` int(11) NOT NULL,
  `media_kind_name` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`media_kind_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `media_mst`;
CREATE TABLE  `media_mst` (
  `media_num` int(11) NOT NULL,
  `media_name` varchar(50) DEFAULT NULL,
  `media_kind_num` int(11) DEFAULT NULL,
  `manager_type` char(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`media_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `media_mst`;
CREATE TABLE  `media_mst` (
  `media_num` int(11) NOT NULL,
  `media_name` varchar(50) DEFAULT NULL,
  `media_kind_num` int(11) DEFAULT NULL,
  `manager_type` char(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`media_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `advert_mst`;
CREATE TABLE  `advert_mst` (
  `advert_num` int(11) NOT NULL AUTO_INCREMENT,
  `advert_name` varchar(50) DEFAULT NULL,
  `advert_agency_num` int(11) DEFAULT NULL,
  `media_num` int(11) DEFAULT NULL,
  `pay_kind` smallint(6) DEFAULT NULL,
  `advert_budget` decimal(10,0) DEFAULT NULL,
  `advert_actual` decimal(10,0) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`advert_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `mem_advert_actual_info`;
CREATE TABLE  `mem_advert_actual_info` (
  `mem_num` bigint(20) NOT NULL,
  `advert_num` int(11) NOT NULL,
  `mem_login_date` datetime DEFAULT NULL,
  `mem_login_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`advert_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `invite_link`;
CREATE TABLE  `invite_link` (
  `mem_num` bigint(20) NOT NULL,
  `link_key` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `cookie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `invite_link_hist`;
CREATE TABLE  `invite_link_hist` (
  `child_mem_num` bigint(20) NOT NULL,
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) DEFAULT NULL,
  `approve_status` char(1) DEFAULT NULL,
  `cookie` varchar(50) DEFAULT NULL,
  `approve_cookie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`child_mem_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `maintenance_info`;
CREATE TABLE  `maintenance_info` (
  `function_code` varchar(4) NOT NULL,
  `mainten_status` char(1) DEFAULT NULL,
  PRIMARY KEY (`function_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `inquiry_sendmail_template`;
CREATE TABLE  `inquiry_sendmail_template` (
  `inquiry_sendmail_id` int(11) NOT NULL AUTO_INCREMENT,
  `inquiry_sendmail_name` varchar(50) DEFAULT NULL,
  `inquiry_sendmail_contents`  text,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`inquiry_sendmail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `questionnaire_mst`;
CREATE TABLE  `questionnaire_mst` (
  `question_no` int(11) NOT NULL,
  `question_name` varchar(100) DEFAULT NULL,
  `html_contents` text,
  PRIMARY KEY (`question_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `questionnaire_answer`;
CREATE TABLE  `questionnaire_answer` (
  `mem_num` bigint(20) NOT NULL,
  `question_no` int(11) NOT NULL,
  `answer_date` datetime DEFAULT NULL,
  `question1` smallint(6) DEFAULT NULL,
  `remarks1` varchar(800) DEFAULT NULL,
  `question2` smallint(6) DEFAULT NULL,
  `remarks2` varchar(800) DEFAULT NULL,
  `question3` smallint(6) DEFAULT NULL,
  `remarks3` varchar(800) DEFAULT NULL,
  `question4` smallint(6) DEFAULT NULL,
  `remarks4` varchar(800) DEFAULT NULL,
  `question5` smallint(6) DEFAULT NULL,
  `remarks5` varchar(800) DEFAULT NULL,
  `question6` smallint(6) DEFAULT NULL,
  `remarks6` varchar(800) DEFAULT NULL,
  `question7` smallint(6) DEFAULT NULL,
  `remarks7` varchar(800) DEFAULT NULL,
  `question8` smallint(6) DEFAULT NULL,
  `remarks8` varchar(800) DEFAULT NULL,
  `question9` smallint(6) DEFAULT NULL,
  `remarks9` varchar(800) DEFAULT NULL,
  `question10` smallint(6) DEFAULT NULL,
  `remarks10` varchar(800) DEFAULT NULL,
  `question11` int(11) DEFAULT NULL,
  `remarks11` varchar(800) DEFAULT NULL,
  `question12` int(11) DEFAULT NULL,
  `remarks12` varchar(800) DEFAULT NULL,
  `question13` int(11) DEFAULT NULL,
  `remarks13` varchar(800) DEFAULT NULL,
  `question14` int(11) DEFAULT NULL,
  `remarks14` varchar(800) DEFAULT NULL,
  `question15` int(11) DEFAULT NULL,
  `remarks15` varchar(800) DEFAULT NULL,
  `question16` int(11) DEFAULT NULL,
  `remarks16` varchar(800) DEFAULT NULL,
  `question17` int(11) DEFAULT NULL,
  `remarks17` varchar(800) DEFAULT NULL,
  `question18` int(11) DEFAULT NULL,
  `remarks18` varchar(800) DEFAULT NULL,
  `question19` int(11) DEFAULT NULL,
  `remarks19` varchar(800) DEFAULT NULL,
  `question20` int(11) DEFAULT NULL,
  `remarks20` varchar(800) DEFAULT NULL,
  `question21` varchar(800) DEFAULT NULL,
  `question22` varchar(800) DEFAULT NULL,
  `question23` varchar(800) DEFAULT NULL,
  `question24` varchar(800) DEFAULT NULL,
  `question25` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`question_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





DROP TABLE IF EXISTS `member_withdraw_info`;
CREATE TABLE `member_withdraw_info` (
  `mem_num` bigint(20) NOT NULL,
  `withdraw_date` datetime DEFAULT NULL,
  `withdraw_reason` int(11) DEFAULT NULL,
  `remarks` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `ticket_mst`;
CREATE TABLE `ticket_mst` (
  `ticket_id` int(11) NOT NULL,
  `ticket_name` varchar(50) DEFAULT NULL,
  `ticket_type_cd` smallint(6) DEFAULT NULL,
  `ticket_model_id` int(11) NOT NULL,
  `delay_days` smallint(6) DEFAULT NULL,
  `valid_days` smallint(6) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `icon_url` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `ticket_model_mst`;
CREATE TABLE `ticket_model_mst` (
  `model_id` int(11) NOT NULL,
  `limit_point_lower` decimal(10,0) NOT NULL,
  `limit_point_upper` decimal(10,0) NOT NULL,
  `model_name` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`model_id`,`limit_point_upper`,`limit_point_lower`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `ticket_model_detail`;
CREATE TABLE `ticket_model_detail` (
  `model_detail_id` int(11) NOT NULL,
  `model_id` int(11) NOT NULL,
  `limit_point_lower` decimal(10,0) NOT NULL,
  `limit_point_upper` decimal(10,0) NOT NULL,
  `person_count` int(11) DEFAULT NULL,
  `person_count_lower` int(11) DEFAULT NULL,
  `person_count_upper` int(11) DEFAULT NULL,
  `prize_point` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`model_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `ticket_info`;
CREATE TABLE `ticket_info` (
  `mem_num` bigint(20) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `ticket_start_date` datetime DEFAULT NULL,
  `ticket_end_date` datetime DEFAULT NULL,
  `ticket_count` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `ticket_give_hist`;
CREATE TABLE `ticket_give_hist` (
  `ticket_give_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `ticket_type_cd` smallint(6) DEFAULT NULL,
  `ticket_give_date` datetime DEFAULT NULL,
  `ticket_start_date` datetime DEFAULT NULL,
  `ticket_end_date` datetime DEFAULT NULL,
  `ticket_count` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ticket_give_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `ticket_use_hist`;
CREATE TABLE `ticket_use_hist` (
  `ticket_use_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `ticket_use_date` datetime DEFAULT NULL,
  `ticket_start_date` datetime DEFAULT NULL,
  `ticket_end_date` datetime DEFAULT NULL,
  `ticket_count` int(11) DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ticket_use_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `campaign_mst`;
CREATE TABLE `campaign_mst` (
  `campaign_id` int(11) NOT NULL AUTO_INCREMENT,
  `title_id` int(11) DEFAULT NULL,
  `campaign_subject` varchar(400) DEFAULT NULL,
  `campaign_contents`   text,
  `campaign_start_date` datetime DEFAULT NULL,
  `campaign_end_date` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`campaign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `function_control_info`;
CREATE TABLE  `function_control_info` (
  `function_code` varchar(4) NOT NULL,
  `service_status` char(1) DEFAULT NULL,
  `service_start_date` datetime DEFAULT NULL,
  `service_end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`function_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




DROP TABLE IF EXISTS `opensocial_member`;
CREATE TABLE  `opensocial_member` (
  `mem_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_id` varchar(150) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `provider_id` varchar(5) NOT NULL,
  `mem_atbt_cd` char(1) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `mail_pc` varchar(100) DEFAULT NULL,
  `mail_mobile` varchar(10) DEFAULT NULL,
  `kanji_fname` varchar(10) DEFAULT NULL,
  `kanji_lname` varchar(10) DEFAULT NULL,
  `kana_fname` varchar(10) DEFAULT NULL,
  `kana_lname` varchar(10) DEFAULT NULL,
  `sex_cd` char(1) DEFAULT NULL,
  `birth_ymd` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `entry_date` datetime DEFAULT NULL,
  `entry_ip` varchar(15) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_ip` varchar(15) DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `opensocial_play_summary`;
CREATE TABLE IF NOT EXISTS `opensocial_play_summary` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `first_play_date` datetime DEFAULT NULL,
  `first_play_ip` varchar(15) DEFAULT NULL,
  `last_play_date` datetime DEFAULT NULL,
  `last_play_ip` varchar(15) DEFAULT NULL,
  `play_count` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `opensocial_play_hist`;
CREATE TABLE IF NOT EXISTS `opensocial_play_hist` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `play_date` datetime DEFAULT NULL,
  `play_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`,`play_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `opensocial_settlement_hist`;
CREATE TABLE  `opensocial_settlement_hist` (
  `settlement_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `settlement_trns_num` bigint(20) DEFAULT NULL,
  `settlement_code` varchar(20) DEFAULT NULL,
  `mem_num` bigint(20) DEFAULT NULL,
  `mem_atbt_cd` char(1) DEFAULT NULL,
  `provider_id` varchar(5) NOT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `point_id` int(11) DEFAULT NULL,
  `settlement_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `point_amount_act` decimal(10,0) DEFAULT NULL,
  `settlement_log` varchar(1000) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `opensocial_invite`;
CREATE TABLE  `opensocial_invite` (
  `invite_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_num` bigint(20) NOT NULL,
  `friend_id` varchar(20) NOT NULL,
  `provider_id` varchar(5) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `invite_status` char(1) DEFAULT NULL,
  `invite_date` datetime DEFAULT NULL,
  `freind_entry_date` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`invite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `joint_member`;
CREATE TABLE  `joint_member` (
  `mem_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `mem_id` varchar(150) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `provider_id` varchar(5) NOT NULL,
  `mem_atbt_cd` char(1) NOT NULL,
  `mem_valid_yn_cd` char(1) NOT NULL,
  `mail_pc` varchar(100) DEFAULT NULL,
  `mail_mobile` varchar(10) DEFAULT NULL,
  `kanji_fname` varchar(10) DEFAULT NULL,
  `kanji_lname` varchar(10) DEFAULT NULL,
  `kana_fname` varchar(10) DEFAULT NULL,
  `kana_lname` varchar(10) DEFAULT NULL,
  `sex_cd` char(1) DEFAULT NULL,
  `birth_ymd` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `entry_date` datetime DEFAULT NULL,
  `entry_ip` varchar(15) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_ip` varchar(15) DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2000000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `joint_play_hist`;
CREATE TABLE IF NOT EXISTS `joint_play_hist` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `play_date` datetime DEFAULT NULL,
  `play_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`,`play_date`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `joint_settlement_hist`;
CREATE TABLE  `joint_settlement_hist` (
  `settlement_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `settlement_trns_num` bigint(20) DEFAULT NULL,
  `settlement_code` varchar(20) DEFAULT NULL,
  `mem_num` bigint(20) DEFAULT NULL,
  `mem_atbt_cd` char(1) DEFAULT NULL,
  `provider_id` varchar(5) NOT NULL,
  `title_id` int(11) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `point_id` int(11) DEFAULT NULL,
  `settlement_date` datetime DEFAULT NULL,
  `point_amount` decimal(10,0) DEFAULT NULL,
  `point_amount_act` decimal(10,0) DEFAULT NULL,
  `settlement_log` varchar(1000) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2000000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `provider_mst`;
CREATE TABLE IF NOT EXISTS `provider_mst` (
  `provider_id` varchar(5) NOT NULL,
  `provider_name` varchar(50) NOT NULL,
  `provider_kind_cd` char(1) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `provider_title_mst`;
CREATE TABLE IF NOT EXISTS `provider_title_mst` (
  `provider_id` varchar(5) NOT NULL,
  `title_id` int(11) NOT NULL,
  `title_name` varchar(30) DEFAULT NULL,
  `security_code` varchar(32) DEFAULT NULL,
  `agent_login` char(1) DEFAULT NULL,
  `site_url` varchar(100) DEFAULT NULL,
  `select_server_url` varchar(100) DEFAULT NULL,
  `error_url` varchar(100) DEFAULT NULL,
  `maintenance_url` varchar(100) DEFAULT NULL,
  `charge_success_url` varchar(100) DEFAULT NULL,
  `charge_cancel_url` varchar(100) DEFAULT NULL,
  `charge_error_url` varchar(100) DEFAULT NULL,
  `charge_maintenance_url` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`provider_id`, `title_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



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