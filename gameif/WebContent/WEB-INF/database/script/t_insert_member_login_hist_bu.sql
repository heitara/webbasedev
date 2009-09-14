DROP TRIGGER t_insert_member_login_hist_bu;
DELIMITER $$
CREATE TRIGGER t_insert_member_login_hist_bu AFTER UPDATE ON member_login_info
FOR EACH ROW
BEGIN
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
DELIMITER