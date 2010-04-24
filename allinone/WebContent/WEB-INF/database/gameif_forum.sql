-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- ホスト: localhost
-- 生成時間: 2009 年 11 月 03 日 01:57
-- サーバのバージョン: 5.1.36
-- PHP のバージョン: 5.2.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- データベース: `jforum`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_api`
--

DROP TABLE IF EXISTS `jforum_api`;
CREATE TABLE IF NOT EXISTS `jforum_api` (
  `api_id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(32) NOT NULL,
  `api_validity` datetime NOT NULL,
  PRIMARY KEY (`api_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_api`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_attach`
--

DROP TABLE IF EXISTS `jforum_attach`;
CREATE TABLE IF NOT EXISTS `jforum_attach` (
  `attach_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) DEFAULT NULL,
  `privmsgs_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`attach_id`),
  KEY `idx_att_post` (`post_id`),
  KEY `idx_att_priv` (`privmsgs_id`),
  KEY `idx_att_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_attach`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_attach_desc`
--

DROP TABLE IF EXISTS `jforum_attach_desc`;
CREATE TABLE IF NOT EXISTS `jforum_attach_desc` (
  `attach_desc_id` int(11) NOT NULL AUTO_INCREMENT,
  `attach_id` int(11) NOT NULL,
  `physical_filename` varchar(255) NOT NULL,
  `real_filename` varchar(255) NOT NULL,
  `download_count` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `mimetype` varchar(50) DEFAULT NULL,
  `filesize` int(11) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `thumb` tinyint(1) DEFAULT '0',
  `extension_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attach_desc_id`),
  KEY `idx_att_d_att` (`attach_id`),
  KEY `idx_att_d_ext` (`extension_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_attach_desc`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_attach_quota`
--

DROP TABLE IF EXISTS `jforum_attach_quota`;
CREATE TABLE IF NOT EXISTS `jforum_attach_quota` (
  `attach_quota_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `quota_limit_id` int(11) NOT NULL,
  PRIMARY KEY (`attach_quota_id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_attach_quota`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_banlist`
--

DROP TABLE IF EXISTS `jforum_banlist`;
CREATE TABLE IF NOT EXISTS `jforum_banlist` (
  `banlist_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `banlist_ip` varchar(15) DEFAULT NULL,
  `banlist_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`banlist_id`),
  KEY `idx_user` (`user_id`),
  KEY `banlist_ip` (`banlist_ip`),
  KEY `banlist_email` (`banlist_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_banlist`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_banner`
--

DROP TABLE IF EXISTS `jforum_banner`;
CREATE TABLE IF NOT EXISTS `jforum_banner` (
  `banner_id` int(11) NOT NULL AUTO_INCREMENT,
  `banner_name` varchar(90) DEFAULT NULL,
  `banner_placement` int(11) NOT NULL DEFAULT '0',
  `banner_description` varchar(250) DEFAULT NULL,
  `banner_clicks` int(11) NOT NULL DEFAULT '0',
  `banner_views` int(11) NOT NULL DEFAULT '0',
  `banner_url` varchar(250) DEFAULT NULL,
  `banner_weight` tinyint(1) NOT NULL DEFAULT '50',
  `banner_active` tinyint(1) NOT NULL DEFAULT '0',
  `banner_comment` varchar(250) DEFAULT NULL,
  `banner_type` int(11) NOT NULL DEFAULT '0',
  `banner_width` int(11) NOT NULL DEFAULT '0',
  `banner_height` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`banner_id`),
  KEY `banner_id` (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_banner`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_bookmarks`
--

DROP TABLE IF EXISTS `jforum_bookmarks`;
CREATE TABLE IF NOT EXISTS `jforum_bookmarks` (
  `bookmark_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `relation_id` int(11) NOT NULL,
  `relation_type` int(11) NOT NULL,
  `public_visible` int(11) DEFAULT '1',
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookmark_id`),
  KEY `book_idx_relation` (`relation_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_bookmarks`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_categories`
--

DROP TABLE IF EXISTS `jforum_categories`;
CREATE TABLE IF NOT EXISTS `jforum_categories` (
  `categories_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '',
  `display_order` int(11) NOT NULL DEFAULT '0',
  `moderated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`categories_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- テーブルのデータをダンプしています `jforum_categories`
--

INSERT INTO `jforum_categories` (`categories_id`, `title`, `display_order`, `moderated`) VALUES
(1, 'レジオン・創世伝説', 1, 1);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_config`
--

DROP TABLE IF EXISTS `jforum_config`;
CREATE TABLE IF NOT EXISTS `jforum_config` (
  `config_name` varchar(255) NOT NULL DEFAULT '',
  `config_value` varchar(255) NOT NULL DEFAULT '',
  `config_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- テーブルのデータをダンプしています `jforum_config`
--

INSERT INTO `jforum_config` (`config_name`, `config_value`, `config_id`) VALUES
('most.users.ever.online', '4', 1),
('most.users.ever.online.date', '1257071770480', 2);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_extensions`
--

DROP TABLE IF EXISTS `jforum_extensions`;
CREATE TABLE IF NOT EXISTS `jforum_extensions` (
  `extension_id` int(11) NOT NULL AUTO_INCREMENT,
  `extension_group_id` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `upload_icon` varchar(100) DEFAULT NULL,
  `extension` varchar(10) DEFAULT NULL,
  `allow` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`extension_id`),
  KEY `extension_group_id` (`extension_group_id`),
  KEY `extension` (`extension`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_extensions`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_extension_groups`
--

DROP TABLE IF EXISTS `jforum_extension_groups`;
CREATE TABLE IF NOT EXISTS `jforum_extension_groups` (
  `extension_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `allow` tinyint(1) DEFAULT '1',
  `upload_icon` varchar(100) DEFAULT NULL,
  `download_mode` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`extension_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_extension_groups`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_forums`
--

DROP TABLE IF EXISTS `jforum_forums`;
CREATE TABLE IF NOT EXISTS `jforum_forums` (
  `forum_id` int(11) NOT NULL AUTO_INCREMENT,
  `categories_id` int(11) NOT NULL DEFAULT '1',
  `forum_name` varchar(150) NOT NULL DEFAULT '',
  `forum_desc` varchar(255) DEFAULT NULL,
  `forum_order` int(11) DEFAULT '1',
  `forum_topics` int(11) NOT NULL DEFAULT '0',
  `forum_last_post_id` int(11) NOT NULL DEFAULT '0',
  `moderated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`forum_id`),
  KEY `categories_id` (`categories_id`),
  KEY `idx_forums_cats` (`categories_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- テーブルのデータをダンプしています `jforum_forums`
--

INSERT INTO `jforum_forums` (`forum_id`, `categories_id`, `forum_name`, `forum_desc`, `forum_order`, `forum_topics`, `forum_last_post_id`, `moderated`) VALUES
(1, 1, '雑談', 'レジオン・創世伝説について、話題に限らず自由に話しましょう！', 1, 0, 0, 0),
(2, 1, '攻略戦術', '攻略、戦術、戦果について情報を共有しましょう！', 2, 0, 0, 0),
(3, 1, '意見要望', 'ゲームシステムについて、改善の要望と意見を提出しましょう！', 3, 0, 0, 0),
(4, 1, 'スクリーンショット', 'プレイ画面、戦果画面等を見せましょう！', 4, 0, 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_forums_watch`
--

DROP TABLE IF EXISTS `jforum_forums_watch`;
CREATE TABLE IF NOT EXISTS `jforum_forums_watch` (
  `forum_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `idx_fw_forum` (`forum_id`),
  KEY `idx_fw_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_forums_watch`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_groups`
--

DROP TABLE IF EXISTS `jforum_groups`;
CREATE TABLE IF NOT EXISTS `jforum_groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(40) NOT NULL DEFAULT '',
  `group_description` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- テーブルのデータをダンプしています `jforum_groups`
--

INSERT INTO `jforum_groups` (`group_id`, `group_name`, `group_description`, `parent_id`) VALUES
(1, '会員', '', 0),
(2, '管理', '', 0),
(3, '訪問者', '', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_karma`
--

DROP TABLE IF EXISTS `jforum_karma`;
CREATE TABLE IF NOT EXISTS `jforum_karma` (
  `karma_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `post_user_id` int(11) NOT NULL,
  `from_user_id` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `rate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`karma_id`),
  KEY `post_id` (`post_id`),
  KEY `topic_id` (`topic_id`),
  KEY `post_user_id` (`post_user_id`),
  KEY `from_user_id` (`from_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_karma`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_mail_integration`
--

DROP TABLE IF EXISTS `jforum_mail_integration`;
CREATE TABLE IF NOT EXISTS `jforum_mail_integration` (
  `forum_id` int(11) NOT NULL,
  `forum_email` varchar(100) NOT NULL,
  `pop_username` varchar(100) NOT NULL,
  `pop_password` varchar(100) NOT NULL,
  `pop_host` varchar(100) NOT NULL,
  `pop_port` int(11) DEFAULT '110',
  `pop_ssl` tinyint(4) DEFAULT '0',
  KEY `forum_id` (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_mail_integration`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_moderation_log`
--

DROP TABLE IF EXISTS `jforum_moderation_log`;
CREATE TABLE IF NOT EXISTS `jforum_moderation_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `log_description` text NOT NULL,
  `log_original_message` text,
  `log_date` datetime NOT NULL,
  `log_type` tinyint(4) DEFAULT '0',
  `post_id` int(11) DEFAULT '0',
  `topic_id` int(11) DEFAULT '0',
  `post_user_id` int(11) DEFAULT '0',
  PRIMARY KEY (`log_id`),
  KEY `user_id` (`user_id`),
  KEY `post_user_id` (`post_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_moderation_log`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_posts`
--

DROP TABLE IF EXISTS `jforum_posts`;
CREATE TABLE IF NOT EXISTS `jforum_posts` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `forum_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `post_time` datetime DEFAULT NULL,
  `poster_ip` varchar(15) DEFAULT NULL,
  `enable_bbcode` tinyint(1) NOT NULL DEFAULT '1',
  `enable_html` tinyint(1) NOT NULL DEFAULT '1',
  `enable_smilies` tinyint(1) NOT NULL DEFAULT '1',
  `enable_sig` tinyint(1) NOT NULL DEFAULT '1',
  `post_edit_time` datetime DEFAULT NULL,
  `post_edit_count` int(11) NOT NULL DEFAULT '0',
  `status` tinyint(1) DEFAULT '1',
  `attach` tinyint(1) DEFAULT '0',
  `need_moderate` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  KEY `topic_id` (`topic_id`),
  KEY `forum_id` (`forum_id`),
  KEY `post_time` (`post_time`),
  KEY `need_moderate` (`need_moderate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_posts`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_posts_text`
--

DROP TABLE IF EXISTS `jforum_posts_text`;
CREATE TABLE IF NOT EXISTS `jforum_posts_text` (
  `post_id` int(11) NOT NULL,
  `post_text` text,
  `post_subject` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_posts_text`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_privmsgs`
--

DROP TABLE IF EXISTS `jforum_privmsgs`;
CREATE TABLE IF NOT EXISTS `jforum_privmsgs` (
  `privmsgs_id` int(11) NOT NULL AUTO_INCREMENT,
  `privmsgs_type` tinyint(4) NOT NULL DEFAULT '0',
  `privmsgs_subject` varchar(255) NOT NULL DEFAULT '',
  `privmsgs_from_userid` int(11) NOT NULL DEFAULT '0',
  `privmsgs_to_userid` int(11) NOT NULL DEFAULT '0',
  `privmsgs_date` datetime DEFAULT NULL,
  `privmsgs_ip` varchar(15) NOT NULL DEFAULT '',
  `privmsgs_enable_bbcode` tinyint(1) NOT NULL DEFAULT '1',
  `privmsgs_enable_html` tinyint(1) NOT NULL DEFAULT '0',
  `privmsgs_enable_smilies` tinyint(1) NOT NULL DEFAULT '1',
  `privmsgs_attach_sig` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`privmsgs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_privmsgs`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_privmsgs_text`
--

DROP TABLE IF EXISTS `jforum_privmsgs_text`;
CREATE TABLE IF NOT EXISTS `jforum_privmsgs_text` (
  `privmsgs_id` int(11) NOT NULL,
  `privmsgs_text` text,
  PRIMARY KEY (`privmsgs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_privmsgs_text`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_quota_limit`
--

DROP TABLE IF EXISTS `jforum_quota_limit`;
CREATE TABLE IF NOT EXISTS `jforum_quota_limit` (
  `quota_limit_id` int(11) NOT NULL AUTO_INCREMENT,
  `quota_desc` varchar(50) NOT NULL,
  `quota_limit` int(11) NOT NULL,
  `quota_type` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`quota_limit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_quota_limit`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_ranks`
--

DROP TABLE IF EXISTS `jforum_ranks`;
CREATE TABLE IF NOT EXISTS `jforum_ranks` (
  `rank_id` int(11) NOT NULL AUTO_INCREMENT,
  `rank_title` varchar(50) NOT NULL DEFAULT '',
  `rank_min` int(11) NOT NULL DEFAULT '0',
  `rank_special` tinyint(1) DEFAULT NULL,
  `rank_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_ranks`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_roles`
--

DROP TABLE IF EXISTS `jforum_roles`;
CREATE TABLE IF NOT EXISTS `jforum_roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT '0',
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`),
  KEY `idx_group` (`group_id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=289 ;

--
-- テーブルのデータをダンプしています `jforum_roles`
--

INSERT INTO `jforum_roles` (`role_id`, `group_id`, `name`) VALUES
(231, 2, 'perm_attachments_enabled'),
(232, 2, 'perm_create_poll'),
(233, 2, 'perm_moderation_post_edit'),
(234, 2, 'perm_create_sticky_announcement_topics'),
(235, 2, 'perm_full_moderation_log'),
(236, 2, 'perm_moderation'),
(237, 2, 'perm_moderation_topic_lockUnlock'),
(238, 2, 'perm_bookmarks_enabled'),
(239, 2, 'perm_administration'),
(240, 2, 'perm_anonymous_post'),
(241, 2, 'perm_moderation_forums'),
(242, 2, 'perm_forum'),
(243, 2, 'perm_moderation_post_remove'),
(244, 2, 'perm_html_disabled'),
(245, 2, 'perm_vote'),
(246, 2, 'perm_attachments_download'),
(247, 2, 'perm_karma_enabled'),
(248, 2, 'perm_moderation_approve_messages'),
(249, 2, 'perm_reply_only'),
(250, 2, 'perm_moderation_log'),
(251, 2, 'perm_moderation_topic_move'),
(252, 2, 'perm_reply_without_moderation'),
(253, 2, 'perm_read_only_forums'),
(254, 2, 'perm_category'),
(255, 1, 'perm_attachments_enabled'),
(256, 1, 'perm_bookmarks_enabled'),
(257, 1, 'perm_administration'),
(258, 1, 'perm_anonymous_post'),
(259, 1, 'perm_moderation_forums'),
(260, 1, 'perm_forum'),
(261, 1, 'perm_html_disabled'),
(262, 1, 'perm_attachments_download'),
(263, 1, 'perm_karma_enabled'),
(264, 1, 'perm_reply_only'),
(265, 1, 'perm_reply_without_moderation'),
(266, 1, 'perm_read_only_forums'),
(267, 1, 'perm_category'),
(279, 3, 'perm_attachments_enabled'),
(280, 3, 'perm_anonymous_post'),
(281, 3, 'perm_moderation_forums'),
(282, 3, 'perm_forum'),
(283, 3, 'perm_html_disabled'),
(284, 3, 'perm_attachments_download'),
(285, 3, 'perm_reply_only'),
(286, 3, 'perm_reply_without_moderation'),
(287, 3, 'perm_read_only_forums'),
(288, 3, 'perm_category');

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_role_values`
--

DROP TABLE IF EXISTS `jforum_role_values`;
CREATE TABLE IF NOT EXISTS `jforum_role_values` (
  `role_id` int(11) NOT NULL,
  `role_value` varchar(255) DEFAULT NULL,
  KEY `idx_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_role_values`
--

INSERT INTO `jforum_role_values` (`role_id`, `role_value`) VALUES
(231, '4'),
(231, '3'),
(231, '2'),
(231, '1'),
(240, '4'),
(240, '3'),
(240, '2'),
(240, '1'),
(241, '4'),
(241, '3'),
(241, '2'),
(241, '1'),
(242, '4'),
(242, '3'),
(242, '2'),
(242, '1'),
(244, '4'),
(244, '3'),
(244, '2'),
(244, '1'),
(246, '4'),
(246, '3'),
(246, '2'),
(246, '1'),
(249, '4'),
(249, '3'),
(249, '2'),
(249, '1'),
(252, '4'),
(252, '3'),
(252, '2'),
(252, '1'),
(253, '4'),
(253, '3'),
(253, '2'),
(253, '1'),
(254, '1'),
(255, '4'),
(255, '3'),
(255, '2'),
(255, '1'),
(258, '4'),
(258, '3'),
(258, '2'),
(258, '1'),
(260, '4'),
(260, '3'),
(260, '2'),
(260, '1'),
(262, '4'),
(262, '3'),
(262, '2'),
(262, '1'),
(264, '4'),
(264, '3'),
(264, '2'),
(264, '1'),
(265, '4'),
(265, '3'),
(265, '2'),
(265, '1'),
(266, '4'),
(266, '3'),
(266, '2'),
(266, '1'),
(267, '1'),
(280, '4'),
(280, '3'),
(280, '2'),
(280, '1'),
(282, '4'),
(282, '3'),
(282, '2'),
(282, '1'),
(285, '4'),
(285, '3'),
(285, '2'),
(285, '1'),
(286, '4'),
(286, '3'),
(286, '2'),
(286, '1'),
(287, '4'),
(287, '3'),
(287, '2'),
(287, '1'),
(288, '1');

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_sessions`
--

DROP TABLE IF EXISTS `jforum_sessions`;
CREATE TABLE IF NOT EXISTS `jforum_sessions` (
  `session_id` varchar(150) NOT NULL DEFAULT '',
  `session_user_id` int(11) NOT NULL DEFAULT '0',
  `session_start` datetime DEFAULT NULL,
  `session_time` bigint(20) DEFAULT '0',
  `session_ip` varchar(15) NOT NULL DEFAULT '',
  `session_page` int(11) NOT NULL DEFAULT '0',
  `session_logged_int` tinyint(1) DEFAULT NULL,
  KEY `idx_sessions_users` (`session_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_sessions`
--

INSERT INTO `jforum_sessions` (`session_id`, `session_user_id`, `session_start`, `session_time`, `session_ip`, `session_page`, `session_logged_int`) VALUES
('3A9E0F46D35B8372EA2BB96EAFA9FE11', 1, '2009-11-01 19:44:33', 0, '', 0, NULL),
('FC9EA835649BBFAB5A802268F68A907D', 2, '2009-11-01 19:13:17', 0, '', 0, NULL),
('A60BC16C29A39B1DEE09F2ACC8A7AA31', 4, '2009-11-01 19:45:06', 0, '', 0, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_smilies`
--

DROP TABLE IF EXISTS `jforum_smilies`;
CREATE TABLE IF NOT EXISTS `jforum_smilies` (
  `smilie_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `url` varchar(100) DEFAULT NULL,
  `disk_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`smilie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- テーブルのデータをダンプしています `jforum_smilies`
--

INSERT INTO `jforum_smilies` (`smilie_id`, `code`, `url`, `disk_name`) VALUES
(1, ':)', '<img src="#CONTEXT#/images/smilies/3b63d1616c5dfcf29f8a7a031aaa7cad.gif" />', '3b63d1616c5dfcf29f8a7a031aaa7cad.gif'),
(2, ':-)', '<img src="#CONTEXT#/images/smilies/3b63d1616c5dfcf29f8a7a031aaa7cad.gif"/>', '3b63d1616c5dfcf29f8a7a031aaa7cad.gif'),
(3, ':D', '<img src="#CONTEXT#/images/smilies/283a16da79f3aa23fe1025c96295f04f.gif" />', '283a16da79f3aa23fe1025c96295f04f.gif'),
(4, ':-D', '<img src="#CONTEXT#/images/smilies/283a16da79f3aa23fe1025c96295f04f.gif" />', '283a16da79f3aa23fe1025c96295f04f.gif'),
(5, ':(', '<img src="#CONTEXT#/images/smilies/9d71f0541cff0a302a0309c5079e8dee.gif" />', '9d71f0541cff0a302a0309c5079e8dee.gif'),
(6, ':mrgreen:', '<img src="#CONTEXT#/images/smilies/ed515dbff23a0ee3241dcc0a601c9ed6.gif" />', 'ed515dbff23a0ee3241dcc0a601c9ed6.gif'),
(7, ':-o', '<img src="#CONTEXT#/images/smilies/47941865eb7bbc2a777305b46cc059a2.gif"  />', '47941865eb7bbc2a777305b46cc059a2.gif'),
(8, ':shock:', '<img src="#CONTEXT#/images/smilies/385970365b8ed7503b4294502a458efa.gif" />', '385970365b8ed7503b4294502a458efa.gif'),
(9, ':?:', '<img src="#CONTEXT#/images/smilies/0a4d7238daa496a758252d0a2b1a1384.gif" />', '0a4d7238daa496a758252d0a2b1a1384.gif'),
(10, '8)', '<img src="#CONTEXT#/images/smilies/b2eb59423fbf5fa39342041237025880.gif"  />', 'b2eb59423fbf5fa39342041237025880.gif'),
(11, ':lol:', '<img src="#CONTEXT#/images/smilies/97ada74b88049a6d50a6ed40898a03d7.gif" />', '97ada74b88049a6d50a6ed40898a03d7.gif'),
(12, ':x', '<img src="#CONTEXT#/images/smilies/1069449046bcd664c21db15b1dfedaee.gif"  />', '1069449046bcd664c21db15b1dfedaee.gif'),
(13, ':P', '<img src="#CONTEXT#/images/smilies/69934afc394145350659cd7add244ca9.gif" />', '69934afc394145350659cd7add244ca9.gif'),
(14, ':-P', '<img src="#CONTEXT#/images/smilies/69934afc394145350659cd7add244ca9.gif" />', '69934afc394145350659cd7add244ca9.gif'),
(15, ':oops:', '<img src="#CONTEXT#/images/smilies/499fd50bc713bfcdf2ab5a23c00c2d62.gif" />', '499fd50bc713bfcdf2ab5a23c00c2d62.gif'),
(16, ':cry:', '<img src="#CONTEXT#/images/smilies/c30b4198e0907b23b8246bdd52aa1c3c.gif" />', 'c30b4198e0907b23b8246bdd52aa1c3c.gif'),
(17, ':evil:', '<img src="#CONTEXT#/images/smilies/2e207fad049d4d292f60607f80f05768.gif" />', '2e207fad049d4d292f60607f80f05768.gif'),
(18, ':twisted:', '<img src="#CONTEXT#/images/smilies/908627bbe5e9f6a080977db8c365caff.gif" />', '908627bbe5e9f6a080977db8c365caff.gif'),
(19, ':roll:', '<img src="#CONTEXT#/images/smilies/2786c5c8e1a8be796fb2f726cca5a0fe.gif" />', '2786c5c8e1a8be796fb2f726cca5a0fe.gif'),
(20, ':wink:', '<img src="#CONTEXT#/images/smilies/8a80c6485cd926be453217d59a84a888.gif" />', '8a80c6485cd926be453217d59a84a888.gif'),
(21, ';)', '<img src="#CONTEXT#/images/smilies/8a80c6485cd926be453217d59a84a888.gif" />', '8a80c6485cd926be453217d59a84a888.gif'),
(22, ';-)', '<img src="#CONTEXT#/images/smilies/8a80c6485cd926be453217d59a84a888.gif" />', '8a80c6485cd926be453217d59a84a888.gif'),
(23, ':!:', '<img src="#CONTEXT#/images/smilies/9293feeb0183c67ea1ea8c52f0dbaf8c.gif" />', '9293feeb0183c67ea1ea8c52f0dbaf8c.gif'),
(24, ':?', '<img src="#CONTEXT#/images/smilies/136dd33cba83140c7ce38db096d05aed.gif" />', '136dd33cba83140c7ce38db096d05aed.gif'),
(25, ':idea:', '<img src="#CONTEXT#/images/smilies/8f7fb9dd46fb8ef86f81154a4feaada9.gif" />', '8f7fb9dd46fb8ef86f81154a4feaada9.gif'),
(26, ':arrow:', '<img src="#CONTEXT#/images/smilies/d6741711aa045b812616853b5507fd2a.gif" />', 'd6741711aa045b812616853b5507fd2a.gif'),
(27, ':hunf:', '<img src="#CONTEXT#/images/smilies/0320a00cb4bb5629ab9fc2bc1fcc4e9e.gif" />', '0320a00cb4bb5629ab9fc2bc1fcc4e9e.gif'),
(28, ':-(', '<img src="#CONTEXT#/images/smilies/9d71f0541cff0a302a0309c5079e8dee.gif"  />', '9d71f0541cff0a302a0309c5079e8dee.gif'),
(29, ':XD:', '<img src="#CONTEXT#/images/smilies/49869fe8223507d7223db3451e5321aa.gif" />', '49869fe8223507d7223db3451e5321aa.gif'),
(30, ':thumbup:', '<img src="#CONTEXT#/images/smilies/e8a506dc4ad763aca51bec4ca7dc8560.gif" />', 'e8a506dc4ad763aca51bec4ca7dc8560.gif'),
(31, ':thumbdown:', '<img src="#CONTEXT#/images/smilies/e78feac27fa924c4d0ad6cf5819f3554.gif" />', 'e78feac27fa924c4d0ad6cf5819f3554.gif'),
(32, ':|', '<img src="#CONTEXT#/images/smilies/1cfd6e2a9a2c0cf8e74b49b35e2e46c7.gif" />', '1cfd6e2a9a2c0cf8e74b49b35e2e46c7.gif');

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_themes`
--

DROP TABLE IF EXISTS `jforum_themes`;
CREATE TABLE IF NOT EXISTS `jforum_themes` (
  `themes_id` int(11) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(30) NOT NULL DEFAULT '',
  `style_name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`themes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_themes`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_topics`
--

DROP TABLE IF EXISTS `jforum_topics`;
CREATE TABLE IF NOT EXISTS `jforum_topics` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(11) NOT NULL DEFAULT '0',
  `topic_title` varchar(100) NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `topic_time` datetime DEFAULT NULL,
  `topic_views` int(11) DEFAULT '1',
  `topic_replies` int(11) DEFAULT '0',
  `topic_status` tinyint(3) DEFAULT '0',
  `topic_vote_id` int(11) NOT NULL DEFAULT '0',
  `topic_type` tinyint(3) DEFAULT '0',
  `topic_first_post_id` int(11) DEFAULT '0',
  `topic_last_post_id` int(11) NOT NULL DEFAULT '0',
  `topic_moved_id` int(11) DEFAULT '0',
  `moderated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`topic_id`),
  KEY `forum_id` (`forum_id`),
  KEY `user_id` (`user_id`),
  KEY `topic_first_post_id` (`topic_first_post_id`),
  KEY `topic_last_post_id` (`topic_last_post_id`),
  KEY `topic_moved_id` (`topic_moved_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_topics`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_topics_watch`
--

DROP TABLE IF EXISTS `jforum_topics_watch`;
CREATE TABLE IF NOT EXISTS `jforum_topics_watch` (
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_read` tinyint(1) DEFAULT '1',
  KEY `idx_topic` (`topic_id`),
  KEY `idx_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_topics_watch`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_users`
--

DROP TABLE IF EXISTS `jforum_users`;
CREATE TABLE IF NOT EXISTS `jforum_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_active` tinyint(1) DEFAULT NULL,
  `username` varchar(50) NOT NULL DEFAULT '',
  `user_password` varchar(32) NOT NULL DEFAULT '',
  `user_session_time` bigint(20) DEFAULT '0',
  `user_session_page` int(11) NOT NULL DEFAULT '0',
  `user_lastvisit` datetime DEFAULT NULL,
  `user_regdate` datetime DEFAULT NULL,
  `user_level` tinyint(4) DEFAULT NULL,
  `user_posts` int(11) NOT NULL DEFAULT '0',
  `user_timezone` varchar(5) NOT NULL DEFAULT '',
  `user_style` tinyint(4) DEFAULT NULL,
  `user_lang` varchar(255) NOT NULL DEFAULT '',
  `user_dateformat` varchar(20) NOT NULL DEFAULT '%d/%M/%Y %H:%i',
  `user_new_privmsg` int(11) NOT NULL DEFAULT '0',
  `user_unread_privmsg` int(11) NOT NULL DEFAULT '0',
  `user_last_privmsg` datetime DEFAULT NULL,
  `user_emailtime` datetime DEFAULT NULL,
  `user_viewemail` tinyint(1) DEFAULT '0',
  `user_attachsig` tinyint(1) DEFAULT '1',
  `user_allowhtml` tinyint(1) DEFAULT '0',
  `user_allowbbcode` tinyint(1) DEFAULT '1',
  `user_allowsmilies` tinyint(1) DEFAULT '1',
  `user_allowavatar` tinyint(1) DEFAULT '1',
  `user_allow_pm` tinyint(1) DEFAULT '1',
  `user_allow_viewonline` tinyint(1) DEFAULT '1',
  `user_notify` tinyint(1) DEFAULT '1',
  `user_notify_always` tinyint(1) DEFAULT '0',
  `user_notify_text` tinyint(1) DEFAULT '0',
  `user_notify_pm` tinyint(1) DEFAULT '1',
  `user_popup_pm` tinyint(1) DEFAULT '1',
  `rank_id` int(11) DEFAULT '0',
  `user_avatar` varchar(100) DEFAULT NULL,
  `user_avatar_type` tinyint(4) NOT NULL DEFAULT '0',
  `user_email` varchar(255) NOT NULL DEFAULT '',
  `user_icq` varchar(15) DEFAULT NULL,
  `user_website` varchar(255) DEFAULT NULL,
  `user_from` varchar(100) DEFAULT NULL,
  `user_sig` text,
  `user_sig_bbcode_uid` varchar(10) DEFAULT NULL,
  `user_aim` varchar(255) DEFAULT NULL,
  `user_yim` varchar(255) DEFAULT NULL,
  `user_msnm` varchar(255) DEFAULT NULL,
  `user_occ` varchar(100) DEFAULT NULL,
  `user_interests` varchar(255) DEFAULT NULL,
  `user_biography` text,
  `user_actkey` varchar(32) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `themes_id` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `user_viewonline` tinyint(1) DEFAULT '1',
  `security_hash` varchar(32) DEFAULT NULL,
  `user_karma` double DEFAULT NULL,
  `user_authhash` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- テーブルのデータをダンプしています `jforum_users`
--

INSERT INTO `jforum_users` (`user_id`, `user_active`, `username`, `user_password`, `user_session_time`, `user_session_page`, `user_lastvisit`, `user_regdate`, `user_level`, `user_posts`, `user_timezone`, `user_style`, `user_lang`, `user_dateformat`, `user_new_privmsg`, `user_unread_privmsg`, `user_last_privmsg`, `user_emailtime`, `user_viewemail`, `user_attachsig`, `user_allowhtml`, `user_allowbbcode`, `user_allowsmilies`, `user_allowavatar`, `user_allow_pm`, `user_allow_viewonline`, `user_notify`, `user_notify_always`, `user_notify_text`, `user_notify_pm`, `user_popup_pm`, `rank_id`, `user_avatar`, `user_avatar_type`, `user_email`, `user_icq`, `user_website`, `user_from`, `user_sig`, `user_sig_bbcode_uid`, `user_aim`, `user_yim`, `user_msnm`, `user_occ`, `user_interests`, `user_biography`, `user_actkey`, `gender`, `themes_id`, `deleted`, `user_viewonline`, `security_hash`, `user_karma`, `user_authhash`) VALUES
(0, NULL, 'Anonymous', 'nopass', 0, 0, '2009-09-21 01:22:33', '2009-09-21 00:51:38', NULL, 0, '', NULL, 'zh_CN', '%d/%M/%Y %H:%i', 0, 0, NULL, NULL, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, -1, NULL, 0, '', '', '', '', '', NULL, '', '', '', '', '', '', NULL, NULL, 0, NULL, 1, NULL, NULL, NULL),
(1, NULL, 'Nologin', 'nopass', 0, 0, '2009-09-21 01:22:33', '2009-09-21 00:51:38', NULL, 0, '', NULL, 'zh_CN', '%d/%M/%Y %H:%i', 0, 0, NULL, NULL, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, -1, NULL, 0, '', '', '', '', '', NULL, '', '', '', '', '', '', NULL, NULL, 0, NULL, 1, NULL, NULL, NULL),
(2, NULL, 'Admin', '21232f297a57a5a743894a0e4a801fc3', 0, 0, '2009-09-21 01:22:47', '2009-09-21 00:51:38', NULL, 1, '', NULL, '', '%d/%M/%Y %H:%i', 0, 0, NULL, NULL, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, -1, NULL, 0, '', '', '', '', '', NULL, '', '', '', '', '', '', NULL, NULL, 0, NULL, 1, NULL, 3, NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_user_groups`
--

DROP TABLE IF EXISTS `jforum_user_groups`;
CREATE TABLE IF NOT EXISTS `jforum_user_groups` (
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `idx_group` (`group_id`),
  KEY `idx_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_user_groups`
--

INSERT INTO `jforum_user_groups` (`group_id`, `user_id`) VALUES
(3, 0),
(2, 2),
(3, 1);

-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_vote_desc`
--

DROP TABLE IF EXISTS `jforum_vote_desc`;
CREATE TABLE IF NOT EXISTS `jforum_vote_desc` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `vote_text` varchar(255) NOT NULL DEFAULT '',
  `vote_start` datetime NOT NULL,
  `vote_length` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vote_id`),
  KEY `topic_id` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_vote_desc`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_vote_results`
--

DROP TABLE IF EXISTS `jforum_vote_results`;
CREATE TABLE IF NOT EXISTS `jforum_vote_results` (
  `vote_id` int(11) NOT NULL DEFAULT '0',
  `vote_option_id` tinyint(4) NOT NULL DEFAULT '0',
  `vote_option_text` varchar(255) NOT NULL DEFAULT '',
  `vote_result` int(11) NOT NULL DEFAULT '0',
  KEY `vote_id` (`vote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_vote_results`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_vote_voters`
--

DROP TABLE IF EXISTS `jforum_vote_voters`;
CREATE TABLE IF NOT EXISTS `jforum_vote_voters` (
  `vote_id` int(11) NOT NULL DEFAULT '0',
  `vote_user_id` int(11) NOT NULL DEFAULT '0',
  `vote_user_ip` varchar(15) NOT NULL DEFAULT '',
  KEY `vote_id` (`vote_id`),
  KEY `vote_user_id` (`vote_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータをダンプしています `jforum_vote_voters`
--


-- --------------------------------------------------------

--
-- テーブルの構造 `jforum_words`
--

DROP TABLE IF EXISTS `jforum_words`;
CREATE TABLE IF NOT EXISTS `jforum_words` (
  `word_id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(100) NOT NULL DEFAULT '',
  `replacement` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`word_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- テーブルのデータをダンプしています `jforum_words`
--

