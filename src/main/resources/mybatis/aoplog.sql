/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.59 : Database - demo_aoplog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo_aoplog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo_aoplog`;

/*Table structure for table `log_operation` */

DROP TABLE IF EXISTS `log_operation`;

CREATE TABLE `log_operation` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `login_username` varchar(50) NOT NULL COMMENT '谁动手的',
  `log_optType` varchar(10) NOT NULL COMMENT '操作的行为',
  `describe` varchar(100) NOT NULL COMMENT '干了什么事',
  `log_importance` varchar(10) NOT NULL COMMENT '行为的重要程度',
  `req_parameter` varchar(100) DEFAULT NULL COMMENT '操作的参数',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `log_operation` */

insert  into `log_operation`(`id`,`login_username`,`log_optType`,`describe`,`log_importance`,`req_parameter`,`createtime`) values (5,'Tom','SELECT','查询是否存在这个用户','LEVEL_B','[1]','2018-01-26 16:28:25');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `username` varchar(50) CHARACTER SET latin1 NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET latin1 NOT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET latin1 NOT NULL COMMENT '登录者用户名',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `login` */

insert  into `login`(`username`,`password`,`name`) values ('admin','123456','Tom'),('lisi','123','Zhe'),('zhangsan','123','Cat');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `age` int(4) NOT NULL,
  `birthday` date NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`age`,`birthday`,`createTime`) values (1,'zhel',12,'2018-01-10','2018-01-26 16:07:51'),(2,'zhea',12,'2018-01-10','2018-01-26 16:07:51');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
