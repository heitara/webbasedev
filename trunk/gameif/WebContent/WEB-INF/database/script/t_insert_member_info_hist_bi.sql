DELIMITER $$
CREATE TRIGGER T_insert_member_info_hist_bi AFTER INSERT ON member_info
FOR EACH ROW
BEGIN
  INSERT INTO member_info_hist (
    mem_num,
    mem_id,
    nick_name,
    mem_pwd,
    mem_kind_cd,
    mem_atbt_cd,
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
    entry_ip,
    entry_date,
    login_ip,
    login_date,
    login_fail_ip,
    login_fail_date,
    login_fail_cnt,
    last_update_ip,
    last_update_date,
    version_no
  ) VALUES (
    NEW.mem_num,
    NEW.mem_id,
    NEW.nick_name,
    NEW.mem_pwd,
    NEW.mem_kind_cd,
    NEW.mem_atbt_cd,
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
    NEW.entry_ip,
    NEW.entry_date,
    NEW.login_ip,
    NEW.login_date,
    NEW.login_fail_ip,
    NEW.login_fail_date,
    NEW.login_fail_cnt,
    NEW.last_update_ip,
    NEW.last_update_date,
    NEW.version_no
  );
END $$
DELIMITER