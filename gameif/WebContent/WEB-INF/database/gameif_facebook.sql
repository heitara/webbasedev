

DROP TABLE IF EXISTS `facebook_member`;
CREATE TABLE  `facebook_member` (
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
) ENGINE=InnoDB AUTO_INCREMENT=5000000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `facebook_play_summary`;
CREATE TABLE IF NOT EXISTS `facebook_play_summary` (
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


DROP TABLE IF EXISTS `facebook_play_hist`;
CREATE TABLE IF NOT EXISTS `facebook_play_hist` (
  `mem_num` bigint(20) NOT NULL,
  `title_id` int(11) NOT NULL,
  `server_id` int(11) NOT NULL,
  `play_date` datetime DEFAULT NULL,
  `play_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mem_num`,`title_id`,`server_id`,`play_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `facebook_settlement_hist`;
CREATE TABLE  `facebook_settlement_hist` (
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
) ENGINE=InnoDB AUTO_INCREMENT=5000000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `facebook_invite`;
CREATE TABLE  `facebook_invite` (
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

