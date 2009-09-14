
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
  `mem_id` varchar(20) DEFAULT NULL,
  `company_name` varchar(40) DEFAULT NULL,
  `company_media_name` varchar(40) DEFAULT NULL,
  `company_user_name` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_mailadd` varchar(100) DEFAULT NULL,
  `tel_num` varchar(10) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `inquiry_type` int(11) DEFAULT NULL,
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
  `version_no` int(11) DEFAULT 0,
  PRIMARY KEY (`mem_num`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;



DROP TABLE IF EXISTS `member_info_hist`;
CREATE TABLE IF NOT EXISTS `member_info_hist` (
  `mem_num` bigint(20) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
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
  PRIMARY KEY (`mem_num`,`update_date`)
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
  `valid_start_date` datetime DEFAULT NULL,
  `valid_end_date` datetime DEFAULT NULL,
  `site_url` varchar(50) DEFAULT NULL,
  `small_icon_url` varchar(50) DEFAULT NULL,
  `big_icon_url` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `last_update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`title_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



--
-- Definition of trigger `t_insert_member_info_hist_bu`
--
DROP TRIGGER /*!50030 IF EXISTS */ `t_insert_member_info_hist_bu`;
DELIMITER $$
CREATE TRIGGER `t_insert_member_info_hist_bu` AFTER UPDATE ON `member_info` FOR EACH ROW BEGIN
  IF mem_pwd <> NEW.mem_pwd
    || mem_kind_cd <> NEW.mem_kind_cd
    || mem_atbt_cd <> NEW.mem_atbt_cd
    || mem_valid_yn_cd <> NEW.mem_valid_yn_cd
    || question_cd <> NEW.question_cd
    || answer <> NEW.answer
    || mail_pc <> NEW.mail_pc
    || mail_mobile <> NEW.mail_mobile
    || kanji_fname <> NEW.kanji_fname
    || kanji_lname <> NEW.kanji_lname
    || kana_fname <> NEW.kana_fname
    || kana_lname <> NEW.kana_lname
    || sex_cd <> NEW.sex_cd
    || birth_ymd <> NEW.birth_ymd
    || divis_cd <> NEW.divis_cd
    || occup_cd <> NEW.occup_cd
    || city_name <> NEW.city_name
    || building_name <> NEW.building_name
    || tel_num <> NEW.tel_num
    || mailmag_req_cd <> NEW.mailmag_req_cd
    || mailmag_obj_cd <> NEW.mailmag_obj_cd
    || note <> NEW.note
    || last_update_date <> NEW.last_update_date
    || last_update_ip <> NEW.last_update_ip
  THEN
    INSERT INTO member_info_hist (
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
      last_update_ip
    ) VALUES (
      NEW.mem_pwd,
      NEW.mem_kind_cd,
      NEW.mem_atbt_cd,
      NEW.mem_valid_yn_cd,
      NEW.question_cd,
      NEW.answer,
      NEW.mail_pc,
      NEW.mail_mobile,
      NEW.kanji_fname,
      NEW.kanji_lname,
      NEW.kana_fname,
      NEW.kana_lname,
      NEW.sex_cd,
      NEW.birth_ymd,
      NEW.divis_cd,
      NEW.occup_cd,
      NEW.city_name,
      NEW.building_name,
      NEW.tel_num,
      NEW.mailmag_req_cd,
      NEW.mailmag_obj_cd,
      NEW.note,
      NEW.last_update_date,
      NEW.last_update_ip
    );
   END IF;
END $$
DELIMITER ;




--
-- Definition of trigger `t_insert_member_login_hist_bu`
--
DROP TRIGGER /*!50030 IF EXISTS */ `t_insert_member_login_hist_bu`;
DELIMITER $$
CREATE TRIGGER `t_insert_member_login_hist_bu` AFTER UPDATE ON `member_login_info` FOR EACH ROW BEGIN
  IF NEW.login_date <> login_date THEN
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
  ELSEIF NEW.login_fail_date <> login_fail_date THEN
      INSERT INTO member_login_hist (
        mem_num,
        login_date,
        login_ip,
        success_flg
      ) VALUES (
        NEW.mem_num,
        NEW.login_date,
        NEW.login_ip,
        '0'
      );
  END IF;
END $$
DELIMITER ;


