DROP TRIGGER t_insert_member_info_hist_bu; 

DELIMITER $$
CREATE TRIGGER t_insert_member_info_hist_bu AFTER UPDATE ON member_info
FOR EACH ROW
BEGIN
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
DELIMITER