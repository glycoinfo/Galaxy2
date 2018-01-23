/*
SQLyog Community Edition- MySQL GUI v8.05 
MySQL - 5.1.61 : Database - galaxy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`galaxy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `galaxy`;

/*Table structure for table `analysis_log` */

DROP TABLE IF EXISTS `analysis_log`;

CREATE TABLE `analysis_log` (
  `analysis_id` bigint(20) NOT NULL DEFAULT '0',
  `analysis_user` varchar(15) DEFAULT NULL,
  `analysis_target` varchar(15) DEFAULT NULL,
  `analysis_enz` varchar(15) DEFAULT NULL,
  `analysis_flag` varchar(2) DEFAULT NULL,
  `analysis_date` date DEFAULT NULL,
  `analysis_time` time DEFAULT NULL,
  PRIMARY KEY (`analysis_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `login_id` bigint(20) NOT NULL DEFAULT '0',
  `login_name` varchar(25) DEFAULT NULL,
  `login_status` varchar(25) DEFAULT NULL,
  `login_date` date DEFAULT NULL,
  `login_time` time DEFAULT NULL,
  `agent` varchar(150) DEFAULT NULL,
  `ipaddress` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `marking_table` */

DROP TABLE IF EXISTS `marking_table`;

CREATE TABLE `marking_table` (
  `user_cd` int(11) NOT NULL DEFAULT '0',
  `mark1` text,
  `mark2` text,
  `mark3` text,
  PRIMARY KEY (`user_cd`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `oligo_table` */

DROP TABLE IF EXISTS `oligo_table`;

CREATE TABLE `oligo_table` (
  `oligo_id` int(11) NOT NULL AUTO_INCREMENT,
  `oligo_code` varchar(20) DEFAULT NULL,
  `oligo_structure` varchar(200) DEFAULT NULL,
  `oligo_ods` double DEFAULT NULL,
  `oligo_amide` double DEFAULT NULL,
  `oligo_mw` double DEFAULT NULL,
  `oligo_pref` varchar(50) DEFAULT NULL,
  `oligo_source` varchar(100) DEFAULT NULL,
  `oligo_info` text,
  `enz1` int(11) DEFAULT NULL,
  `enz2` int(11) DEFAULT NULL,
  `enz3` int(11) DEFAULT NULL,
  `enz4` int(11) DEFAULT NULL,
  `enz5` int(11) DEFAULT NULL,
  `enz6` int(11) DEFAULT NULL,
  `glycan` varchar(20) DEFAULT '-',
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`oligo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=471 DEFAULT CHARSET=utf8;

/*Table structure for table `oligo_table_admin` */

DROP TABLE IF EXISTS `oligo_table_admin`;

CREATE TABLE `oligo_table_admin` (
  `oligo_id` int(11) NOT NULL AUTO_INCREMENT,
  `oligo_code` varchar(20) DEFAULT NULL,
  `oligo_structure` varchar(200) DEFAULT NULL,
  `oligo_ods` double DEFAULT NULL,
  `oligo_amide` double DEFAULT NULL,
  `oligo_mw` double DEFAULT NULL,
  `oligo_pref` varchar(50) DEFAULT NULL,
  `oligo_source` varchar(100) DEFAULT NULL,
  `oligo_info` text,
  `enz1` int(11) DEFAULT NULL,
  `enz2` int(11) DEFAULT NULL,
  `enz3` int(11) DEFAULT NULL,
  `enz4` int(11) DEFAULT NULL,
  `enz5` int(11) DEFAULT NULL,
  `enz6` int(11) DEFAULT NULL,
  `glycan` varchar(20) DEFAULT '-',
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`oligo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=525 DEFAULT CHARSET=utf8;

/*Table structure for table `oligo_table_miti` */

DROP TABLE IF EXISTS `oligo_table_miti`;

CREATE TABLE `oligo_table_miti` (
  `oligo_id` int(11) NOT NULL AUTO_INCREMENT,
  `oligo_code` varchar(20) DEFAULT NULL,
  `oligo_structure` varchar(100) DEFAULT NULL,
  `oligo_ods` double DEFAULT NULL,
  `oligo_amide` double DEFAULT NULL,
  `oligo_mw` double DEFAULT NULL,
  `oligo_pref` varchar(50) DEFAULT NULL,
  `oligo_source` varchar(100) DEFAULT NULL,
  `oligo_info` text,
  `enz1` int(11) DEFAULT NULL,
  `enz2` int(11) DEFAULT NULL,
  `enz3` int(11) DEFAULT NULL,
  `enz4` int(11) DEFAULT NULL,
  `enz5` int(11) DEFAULT NULL,
  `enz6` int(11) DEFAULT NULL,
  `glycan` varchar(20) DEFAULT '-',
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`oligo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Table structure for table `oligo_table_miti_admin` */

DROP TABLE IF EXISTS `oligo_table_miti_admin`;

CREATE TABLE `oligo_table_miti_admin` (
  `oligo_id` int(11) NOT NULL AUTO_INCREMENT,
  `oligo_code` varchar(20) DEFAULT NULL,
  `oligo_structure` varchar(100) DEFAULT NULL,
  `oligo_ods` double DEFAULT NULL,
  `oligo_amide` double DEFAULT NULL,
  `oligo_mw` double DEFAULT NULL,
  `oligo_pref` varchar(50) DEFAULT NULL,
  `oligo_source` varchar(100) DEFAULT NULL,
  `oligo_info` text,
  `enz1` int(11) DEFAULT NULL,
  `enz2` int(11) DEFAULT NULL,
  `enz3` int(11) DEFAULT NULL,
  `enz4` int(11) DEFAULT NULL,
  `enz5` int(11) DEFAULT NULL,
  `enz6` int(11) DEFAULT NULL,
  `glycan` varchar(20) DEFAULT '-',
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`oligo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Table structure for table `regist_table` */

DROP TABLE IF EXISTS `regist_table`;

CREATE TABLE `regist_table` (
  `user_number` int(11) NOT NULL DEFAULT '0',
  `galaxy_id` varchar(100) DEFAULT NULL,
  `insert_date` date DEFAULT NULL,
  `user_first` varchar(100) DEFAULT NULL,
  `user_last` varchar(100) DEFAULT NULL,
  `user_country` varchar(5) DEFAULT NULL,
  `user_zip` varchar(8) DEFAULT NULL,
  `user_group` text,
  `user_sex` varchar(3) DEFAULT NULL,
  `user_mail` varchar(255) DEFAULT NULL,
  `user_mode` varchar(64) DEFAULT NULL,
  `user_pass` varchar(64) DEFAULT NULL,
  `galaxy_admin` char(1) DEFAULT NULL,
  `user_graph` varchar(5) DEFAULT NULL,
  `user_mark1_c` varchar(20) DEFAULT NULL,
  `user_mark1` varchar(255) DEFAULT NULL,
  `user_mark2_c` varchar(20) DEFAULT NULL,
  `user_mark2` varchar(255) DEFAULT NULL,
  `user_mark3_c` varchar(20) DEFAULT NULL,
  `user_mark3` varchar(255) DEFAULT NULL,
  `user_bg_c` varchar(20) DEFAULT NULL,
  `mark1` text,
  `mark2` text,
  `mark3` text,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
