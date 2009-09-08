DROP TRIGGER t_insert_member_login_hist_bu;
DELIMITER $$
CREATE TRIGGER t_insert_member_login_hist_bu AFTER UPDATE ON member_login_info
FOR EACH ROW
BEGIN
  INSERT INTO member_login_hist (
    mem_num,
    login_date,
    mem_id,
    nick_name,
    mem_pwd,
    login_ip,
    login_fail_ip,
    login_fail_date,
    login_fail_cnt,
    last_update_ip,
    last_update_date,
    version_no
  ) VALUES (
    NEW.mem_num,
    NEW.login_date,
    NEW.mem_id,
    NEW.nick_name,
    NEW.mem_pwd,
    NEW.login_ip,
    NEW.login_fail_ip,
    NEW.login_fail_date,
    NEW.login_fail_cnt,
    NEW.last_update_ip,
    NEW.last_update_date,
    NEW.version_no
  );
END $$
DELIMITER