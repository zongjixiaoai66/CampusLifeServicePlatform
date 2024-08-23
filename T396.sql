/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `t396`;
CREATE DATABASE IF NOT EXISTS `t396` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `t396`;

DROP TABLE IF EXISTS `beiwanglu`;
CREATE TABLE IF NOT EXISTS `beiwanglu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `beiwanglu_name` varchar(200) DEFAULT NULL COMMENT '备忘录名称  Search111 ',
  `beiwanglu_uuid_number` varchar(200) DEFAULT NULL COMMENT '备忘录编号',
  `beiwanglu_content` longtext COMMENT '备忘录内容 ',
  `beiwanglu_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='备忘录';

DELETE FROM `beiwanglu`;
INSERT INTO `beiwanglu` (`id`, `beiwanglu_name`, `beiwanglu_uuid_number`, `beiwanglu_content`, `beiwanglu_delete`, `insert_time`, `create_time`) VALUES
	(1, '备忘录名称1', '1679880698589', '备忘录内容1', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(2, '备忘录名称2', '1679880698567', '备忘录内容2', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(3, '备忘录名称3', '1679880698636', '备忘录内容3', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(4, '备忘录名称4', '1679880698643', '备忘录内容4', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(5, '备忘录名称5', '1679880698589', '备忘录内容5', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(6, '备忘录名称6', '1679880698577', '备忘录内容6', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(7, '备忘录名称7', '1679880698606', '备忘录内容7', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(8, '备忘录名称8', '1679880698555', '备忘录内容8', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(9, '备忘录名称9', '1679880698591', '备忘录内容9', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(10, '备忘录名称10', '1679880698580', '备忘录内容10', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(11, '备忘录名称11', '1679880698627', '备忘录内容11', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(12, '备忘录名称12', '1679880698588', '备忘录内容12', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(13, '备忘录名称13', '1679880698593', '备忘录内容13', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(14, '备忘录名称14', '1679880698641', '备忘录内容14', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(15, '6636', '1679883304111', '今天怎么怎么呀 那个', 1, '2023-03-27 02:15:15', '2023-03-27 02:15:15'),
	(16, '6', '1679883389225', '2sa3d撒', 2, '2023-03-27 02:16:33', '2023-03-27 02:16:33');

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';

DELETE FROM `config`;
INSERT INTO `config` (`id`, `name`, `value`) VALUES
	(1, '轮播图1', 'upload/config1.jpg'),
	(2, '轮播图2', 'upload/config2.jpg'),
	(3, '轮播图3', 'upload/config3.jpg');

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COMMENT='字典';

DELETE FROM `dictionary`;
INSERT INTO `dictionary` (`id`, `dic_code`, `dic_name`, `code_index`, `index_name`, `super_id`, `beizhu`, `create_time`) VALUES
	(1, 'sex_types', '性别类型', 1, '男', NULL, NULL, '2023-03-27 01:31:16'),
	(2, 'sex_types', '性别类型', 2, '女', NULL, NULL, '2023-03-27 01:31:16'),
	(3, 'gonggao_types', '公告类型', 1, '公告类型1', NULL, NULL, '2023-03-27 01:31:16'),
	(4, 'gonggao_types', '公告类型', 2, '公告类型2', NULL, NULL, '2023-03-27 01:31:16'),
	(5, 'forum_state_types', '帖子状态', 1, '发帖', NULL, NULL, '2023-03-27 01:31:16'),
	(6, 'forum_state_types', '帖子状态', 2, '回帖', NULL, NULL, '2023-03-27 01:31:16'),
	(7, 'shangxia_types', '上下架', 1, '发布', NULL, NULL, '2023-03-27 01:31:16'),
	(8, 'shangxia_types', '上下架', 2, '完成', NULL, NULL, '2023-03-27 01:31:16'),
	(9, 'paotui_types', '跑腿类型', 1, '跑腿类型1', NULL, NULL, '2023-03-27 01:31:16'),
	(10, 'paotui_types', '跑腿类型', 2, '跑腿类型2', NULL, NULL, '2023-03-27 01:31:16'),
	(11, 'paotui_types', '跑腿类型', 3, '跑腿类型3', NULL, NULL, '2023-03-27 01:31:16'),
	(12, 'paotui_types', '跑腿类型', 4, '跑腿类型4', NULL, NULL, '2023-03-27 01:31:16'),
	(13, 'paotui_order_types', '接单类型', 101, '已接单', NULL, NULL, '2023-03-27 01:31:16'),
	(14, 'paotui_order_types', '接单类型', 102, '已取消接单', NULL, NULL, '2023-03-27 01:31:16'),
	(15, 'paotui_order_types', '接单类型', 103, '已取走', NULL, NULL, '2023-03-27 01:31:16'),
	(16, 'paotui_order_types', '接单类型', 104, '已送达', NULL, NULL, '2023-03-27 01:31:16'),
	(17, 'huodong_yuyue_yesno_types', '报名状态', 1, '待审核', NULL, NULL, '2023-03-27 01:31:16'),
	(18, 'huodong_yuyue_yesno_types', '报名状态', 2, '同意', NULL, NULL, '2023-03-27 01:31:16'),
	(19, 'huodong_yuyue_yesno_types', '报名状态', 3, '拒绝', NULL, NULL, '2023-03-27 01:31:16'),
	(20, 'wenyu_types', '活动类型', 1, '活动类型1', NULL, NULL, '2023-03-27 01:31:17'),
	(21, 'wenyu_types', '活动类型', 2, '活动类型2', NULL, NULL, '2023-03-27 01:31:17'),
	(22, 'wenyu_types', '活动类型', 3, '活动类型3', NULL, NULL, '2023-03-27 01:31:17'),
	(23, 'wenyu_types', '活动类型', 4, '活动类型4', NULL, NULL, '2023-03-27 01:31:17'),
	(24, 'wenyu_order_types', '订单类型', 101, '已报名', NULL, NULL, '2023-03-27 01:31:17'),
	(25, 'wenyu_order_types', '订单类型', 102, '已取消报名', NULL, NULL, '2023-03-27 01:31:17');

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(200) DEFAULT NULL COMMENT '帖子标题  Search111 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `users_id` int DEFAULT NULL COMMENT '管理员',
  `forum_content` longtext COMMENT '发布内容',
  `super_ids` int DEFAULT NULL COMMENT '父id',
  `forum_state_types` int DEFAULT NULL COMMENT '帖子状态',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '发帖时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COMMENT='分享大厅';

DELETE FROM `forum`;
INSERT INTO `forum` (`id`, `forum_name`, `yonghu_id`, `users_id`, `forum_content`, `super_ids`, `forum_state_types`, `insert_time`, `update_time`, `create_time`) VALUES
	(1, '帖子标题1', 2, NULL, '发布内容1', 490, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(2, '帖子标题2', 1, NULL, '发布内容2', 6, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(3, '帖子标题3', 2, NULL, '发布内容3', 497, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(4, '帖子标题4', 1, NULL, '发布内容4', 394, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(5, '帖子标题5', 1, NULL, '发布内容5', 453, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(6, '帖子标题6', 3, NULL, '发布内容6', 376, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(7, '帖子标题7', 3, NULL, '发布内容7', 80, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(8, '帖子标题8', 3, NULL, '发布内容8', 388, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(9, '帖子标题9', 1, NULL, '发布内容9', 411, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(10, '帖子标题10', 3, NULL, '发布内容10', 382, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(11, '帖子标题11', 3, NULL, '发布内容11', 174, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(12, '帖子标题12', 3, NULL, '发布内容12', 362, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(13, '帖子标题13', 3, NULL, '发布内容13', 245, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(14, '帖子标题14', 1, NULL, '发布内容14', 189, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(15, '帖子', 1, NULL, '<p>帖子</p>', NULL, 1, '2023-03-27 01:53:13', NULL, '2023-03-27 01:53:13'),
	(16, NULL, NULL, 1, '2626', 15, 2, '2023-03-27 02:18:03', NULL, '2023-03-27 02:18:03'),
	(17, NULL, 1, NULL, '5666', 15, 2, '2024-08-13 07:40:06', NULL, '2024-08-13 07:40:06');

DROP TABLE IF EXISTS `gonggao`;
CREATE TABLE IF NOT EXISTS `gonggao` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `gonggao_name` varchar(200) DEFAULT NULL COMMENT '公告名称 Search111  ',
  `gonggao_photo` varchar(200) DEFAULT NULL COMMENT '公告图片 ',
  `gonggao_types` int NOT NULL COMMENT '公告类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '公告发布时间 ',
  `gonggao_content` longtext COMMENT '公告详情 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='公告';

DELETE FROM `gonggao`;
INSERT INTO `gonggao` (`id`, `gonggao_name`, `gonggao_photo`, `gonggao_types`, `insert_time`, `gonggao_content`, `create_time`) VALUES
	(1, '公告名称1', 'upload/gonggao1.jpg', 2, '2023-03-27 01:31:38', '公告详情1', '2023-03-27 01:31:38'),
	(2, '公告名称2', 'upload/gonggao2.jpg', 1, '2023-03-27 01:31:38', '公告详情2', '2023-03-27 01:31:38'),
	(3, '公告名称3', 'upload/gonggao3.jpg', 1, '2023-03-27 01:31:38', '公告详情3', '2023-03-27 01:31:38'),
	(4, '公告名称4', 'upload/gonggao4.jpg', 2, '2023-03-27 01:31:38', '公告详情4', '2023-03-27 01:31:38'),
	(5, '公告名称5', 'upload/gonggao5.jpg', 2, '2023-03-27 01:31:38', '公告详情5', '2023-03-27 01:31:38'),
	(6, '公告名称6', 'upload/gonggao6.jpg', 2, '2023-03-27 01:31:38', '公告详情6', '2023-03-27 01:31:38'),
	(7, '公告名称7', 'upload/gonggao7.jpg', 1, '2023-03-27 01:31:38', '公告详情7', '2023-03-27 01:31:38'),
	(8, '公告名称8', 'upload/gonggao8.jpg', 2, '2023-03-27 01:31:38', '公告详情8', '2023-03-27 01:31:38'),
	(9, '公告名称9', 'upload/gonggao9.jpg', 1, '2023-03-27 01:31:38', '公告详情9', '2023-03-27 01:31:38'),
	(10, '公告名称10', 'upload/gonggao10.jpg', 2, '2023-03-27 01:31:38', '公告详情10', '2023-03-27 01:31:38'),
	(11, '公告名称11', 'upload/gonggao11.jpg', 2, '2023-03-27 01:31:38', '公告详情11', '2023-03-27 01:31:38'),
	(12, '公告名称12', 'upload/gonggao12.jpg', 1, '2023-03-27 01:31:38', '公告详情12', '2023-03-27 01:31:38'),
	(13, '公告名称13', 'upload/gonggao13.jpg', 2, '2023-03-27 01:31:38', '公告详情13', '2023-03-27 01:31:38'),
	(14, '公告名称14', 'upload/gonggao14.jpg', 1, '2023-03-27 01:31:38', '公告详情14', '2023-03-27 01:31:38');

DROP TABLE IF EXISTS `huodong_yuyue`;
CREATE TABLE IF NOT EXISTS `huodong_yuyue` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `huodong_yuyue_uuid_number` varchar(200) DEFAULT NULL COMMENT '报名编号 Search111 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `huodong_yuyue_text` longtext COMMENT '报名理由',
  `huodong_yuyue_yesno_types` int DEFAULT NULL COMMENT '报名状态 Search111 ',
  `huodong_yuyue_yesno_text` longtext COMMENT '审核回复',
  `huodong_yuyue_shenhe_time` timestamp NULL DEFAULT NULL COMMENT '审核时间',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '活动报名时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='活动申请';

DELETE FROM `huodong_yuyue`;
INSERT INTO `huodong_yuyue` (`id`, `huodong_yuyue_uuid_number`, `yonghu_id`, `huodong_yuyue_text`, `huodong_yuyue_yesno_types`, `huodong_yuyue_yesno_text`, `huodong_yuyue_shenhe_time`, `insert_time`, `create_time`) VALUES
	(1, '1679880698590', 3, '报名理由1', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(2, '1679880698637', 2, '报名理由2', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(3, '1679880698644', 3, '报名理由3', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(4, '1679880698636', 2, '报名理由4', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(5, '1679880698651', 2, '报名理由5', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(6, '1679880698641', 2, '报名理由6', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(7, '1679880698581', 2, '报名理由7', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(8, '1679880698612', 2, '报名理由8', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(9, '1679880698654', 2, '报名理由9', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(10, '1679880698598', 2, '报名理由10', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(11, '1679880698586', 2, '报名理由11', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(12, '1679880698606', 1, '报名理由12', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(13, '1679880698657', 2, '报名理由13', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(14, '1679880698613', 1, '报名理由14', 1, NULL, NULL, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(15, '1679881355750', 1, '丫丫', 2, '好的', '2023-03-27 01:42:53', '2023-03-27 01:42:40', '2023-03-27 01:42:40'),
	(16, '1679882106242', 1, '我要发布活动\n', 2, '同意之后可以添加文娱活动', '2023-03-27 02:17:33', '2023-03-27 01:55:13', '2023-03-27 01:55:13');

DROP TABLE IF EXISTS `paotui`;
CREATE TABLE IF NOT EXISTS `paotui` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `paotui_name` varchar(200) DEFAULT NULL COMMENT '跑腿名称  Search111 ',
  `paotui_uuid_number` varchar(200) DEFAULT NULL COMMENT '跑腿编号',
  `paotui_photo` varchar(200) DEFAULT NULL COMMENT '跑腿照片',
  `paotui_address` varchar(200) DEFAULT NULL COMMENT '跑腿地点',
  `paotui_types` int DEFAULT NULL COMMENT '跑腿类型 Search111',
  `paotui_new_money` decimal(10,2) DEFAULT NULL COMMENT '现价/积分 ',
  `paotui_content` longtext COMMENT '跑腿介绍 ',
  `shangxia_types` int DEFAULT NULL COMMENT '是否上架 ',
  `paotui_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COMMENT='跑腿';

DELETE FROM `paotui`;
INSERT INTO `paotui` (`id`, `yonghu_id`, `paotui_name`, `paotui_uuid_number`, `paotui_photo`, `paotui_address`, `paotui_types`, `paotui_new_money`, `paotui_content`, `shangxia_types`, `paotui_delete`, `insert_time`, `create_time`) VALUES
	(1, 2, '跑腿名称1', '1679880698573', 'upload/paotui1.jpg', '跑腿地点1', 3, 212.46, '跑腿介绍1', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(2, 2, '跑腿名称2', '1679880698649', 'upload/paotui2.jpg', '跑腿地点2', 2, 349.56, '跑腿介绍2', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(3, 2, '跑腿名称3', '1679880698594', 'upload/paotui3.jpg', '跑腿地点3', 4, 137.98, '跑腿介绍3', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(4, 1, '跑腿名称4', '1679880698653', 'upload/paotui4.jpg', '跑腿地点4', 2, 285.39, '跑腿介绍4', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(5, 2, '跑腿名称5', '1679880698630', 'upload/paotui5.jpg', '跑腿地点5', 2, 493.21, '跑腿介绍5', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(6, 2, '跑腿名称6', '1679880698635', 'upload/paotui6.jpg', '跑腿地点6', 4, 151.12, '跑腿介绍6', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(7, 1, '跑腿名称7', '1679880698601', 'upload/paotui7.jpg', '跑腿地点7', 2, 258.72, '跑腿介绍7', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(8, 1, '跑腿名称8', '1679880698657', 'upload/paotui8.jpg', '跑腿地点8', 3, 294.27, '跑腿介绍8', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(9, 3, '跑腿名称9', '1679880698646', 'upload/paotui9.jpg', '跑腿地点9', 2, 114.73, '跑腿介绍9', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(10, 2, '跑腿名称10', '1679880698596', 'upload/paotui10.jpg', '跑腿地点10', 1, 32.60, '跑腿介绍10', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(11, 2, '跑腿名称11', '1679880698589', 'upload/paotui11.jpg', '跑腿地点11', 4, 256.85, '跑腿介绍11', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(12, 3, '跑腿名称12', '1679880698620', 'upload/paotui12.jpg', '跑腿地点12', 2, 69.88, '跑腿介绍12', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(13, 1, '跑腿名称13', '1679880698584', 'upload/paotui13.jpg', '跑腿地点13', 2, 115.06, '跑腿介绍13', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(14, 2, '跑腿名称14', '1679880698575', 'upload/paotui14.jpg', '跑腿地点14', 2, 291.95, '跑腿介绍14', 1, 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(15, 1, '222', '1679882218922', 'upload/1679882224197.jpg', '222', 2, NULL, '1546', NULL, 2, '2023-03-27 01:57:15', '2023-03-27 01:57:15'),
	(16, 1, '22', '1679883018954', 'upload/1679883027973.jpg', '22', 4, 50.00, '123', NULL, 2, '2023-03-27 02:10:38', '2023-03-27 02:10:38'),
	(17, 1, '22', '1679883261482', 'upload/1679883265657.jpg', '654', 3, 21.00, '546', 1, 1, '2023-03-27 02:14:33', '2023-03-27 02:14:33');

DROP TABLE IF EXISTS `paotui_order`;
CREATE TABLE IF NOT EXISTS `paotui_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `paotui_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '接单编号 Search111 ',
  `paotui_id` int DEFAULT NULL COMMENT '跑腿',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `paotui_order_true_price` decimal(10,2) DEFAULT NULL COMMENT '实付价格',
  `paotui_order_types` int DEFAULT NULL COMMENT '接单类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '接单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='跑腿接单';

DELETE FROM `paotui_order`;
INSERT INTO `paotui_order` (`id`, `paotui_order_uuid_number`, `paotui_id`, `yonghu_id`, `paotui_order_true_price`, `paotui_order_types`, `insert_time`, `create_time`) VALUES
	(1, '1679882050978', 14, 1, 291.95, 104, '2023-03-27 01:54:11', '2023-03-27 01:54:11');

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '儿童id',
  `username` varchar(100) NOT NULL COMMENT '儿童名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='token表';

DELETE FROM `token`;
INSERT INTO `token` (`id`, `userid`, `username`, `tablename`, `role`, `token`, `addtime`, `expiratedtime`) VALUES
	(1, 1, 'admin', 'users', '管理员', '0867noiakexpkcvng6xxtkh1inbbx9he', '2023-03-27 01:34:33', '2024-08-13 08:38:31'),
	(2, 1, 'a1', 'yonghu', '用户', 'tgwstspdk3gwkq8st7t1wsz854fajq6u', '2023-03-27 01:34:54', '2024-08-13 08:39:54'),
	(3, 2, 'a2', 'yonghu', '用户', 'celczsg11n7va9ooh1ywwr6irnhmquws', '2023-03-27 01:55:24', '2023-03-27 02:55:24');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '儿童名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='管理员';

DELETE FROM `users`;
INSERT INTO `users` (`id`, `username`, `password`, `role`, `addtime`) VALUES
	(1, 'admin', '123456', '管理员', '2023-03-27 01:31:16');

DROP TABLE IF EXISTS `wenyu`;
CREATE TABLE IF NOT EXISTS `wenyu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `wenyu_name` varchar(200) DEFAULT NULL COMMENT '活动名称  Search111 ',
  `wenyu_uuid_number` varchar(200) DEFAULT NULL COMMENT '活动编号',
  `wenyu_photo` varchar(200) DEFAULT NULL COMMENT '活动照片',
  `wenyu_address` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `wenyu_types` int DEFAULT NULL COMMENT '活动类型 Search111',
  `wenyu_kucun_number` int DEFAULT NULL COMMENT '活动人数',
  `wenyu_content` longtext COMMENT '活动介绍 ',
  `wenyu_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='文娱活动';

DELETE FROM `wenyu`;
INSERT INTO `wenyu` (`id`, `yonghu_id`, `wenyu_name`, `wenyu_uuid_number`, `wenyu_photo`, `wenyu_address`, `wenyu_types`, `wenyu_kucun_number`, `wenyu_content`, `wenyu_delete`, `insert_time`, `create_time`) VALUES
	(1, 2, '活动名称1', '1679880698665', 'upload/wenyu1.jpg', '活动地点1', 4, 101, '活动介绍1', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(2, 1, '活动名称2', '1679880698590', 'upload/wenyu2.jpg', '活动地点2', 2, 102, '活动介绍2', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(3, 3, '活动名称3', '1679880698651', 'upload/wenyu3.jpg', '活动地点3', 1, 103, '活动介绍3', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(4, 1, '活动名称4', '1679880698655', 'upload/wenyu4.jpg', '活动地点4', 1, 104, '活动介绍4', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(5, 2, '活动名称5', '1679880698593', 'upload/wenyu5.jpg', '活动地点5', 1, 105, '活动介绍5', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(6, 2, '活动名称6', '1679880698651', 'upload/wenyu6.jpg', '活动地点6', 3, 106, '活动介绍6', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(7, 1, '活动名称7', '1679880698620', 'upload/wenyu7.jpg', '活动地点7', 2, 107, '活动介绍7', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(8, 1, '活动名称8', '1679880698582', 'upload/wenyu8.jpg', '活动地点8', 4, 108, '活动介绍8', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(9, 1, '活动名称9', '1679880698626', 'upload/wenyu9.jpg', '活动地点9', 1, 109, '活动介绍9', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(10, 1, '活动名称10', '1679880698610', 'upload/wenyu10.jpg', '活动地点10', 2, 1010, '活动介绍10', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(11, 2, '活动名称11', '1679880698658', 'upload/wenyu11.jpg', '活动地点11', 1, 1011, '活动介绍11', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(12, 3, '活动名称12', '1679880698638', 'upload/wenyu12.jpg', '活动地点12', 3, 1012, '活动介绍12', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(13, 2, '活动名称13', '1679880698596', 'upload/wenyu13.jpg', '活动地点13', 3, 1013, '活动介绍13', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(14, 2, '活动名称14', '1679880698610', 'upload/wenyu14.jpg', '活动地点14', 2, 1013, '活动介绍14', 1, '2023-03-27 01:31:38', '2023-03-27 01:31:38'),
	(15, 1, '111', '1679881379959', 'upload/1679881387693.jpg', '12651', 2, 10, '55555', 1, '2023-03-27 01:43:19', '2023-03-27 01:43:19');

DROP TABLE IF EXISTS `wenyu_order`;
CREATE TABLE IF NOT EXISTS `wenyu_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `wenyu_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '订单编号 Search111 ',
  `wenyu_id` int DEFAULT NULL COMMENT '文娱活动',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `buy_number` int DEFAULT NULL COMMENT '购买数量',
  `wenyu_order_types` int DEFAULT NULL COMMENT '订单类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='文娱活动报名';

DELETE FROM `wenyu_order`;
INSERT INTO `wenyu_order` (`id`, `wenyu_order_uuid_number`, `wenyu_id`, `yonghu_id`, `buy_number`, `wenyu_order_types`, `insert_time`, `create_time`) VALUES
	(1, '1679881964498', 14, 1, 1, 102, '2023-03-27 01:52:44', '2023-03-27 01:52:44'),
	(2, '1723534826967', 14, 1, 1, 101, '2024-08-13 07:40:27', '2024-08-13 07:40:27');

DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE IF NOT EXISTS `yonghu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex_types` int DEFAULT NULL COMMENT '性别',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '用户邮箱',
  `new_money` decimal(10,2) DEFAULT NULL COMMENT '余额 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

DELETE FROM `yonghu`;
INSERT INTO `yonghu` (`id`, `username`, `password`, `yonghu_name`, `yonghu_phone`, `yonghu_id_number`, `yonghu_photo`, `sex_types`, `yonghu_email`, `new_money`, `create_time`) VALUES
	(1, '用户1', '123456', '用户姓名1', '17703786901', '410224199010102001', 'upload/yonghu1.jpg', 1, '1@qq.com', 468.54, '2023-03-27 01:31:38'),
	(2, '用户2', '123456', '用户姓名2', '17703786902', '410224199010102002', 'upload/yonghu2.jpg', 2, '2@qq.com', 624.22, '2023-03-27 01:31:38'),
	(3, '用户3', '123456', '用户姓名3', '17703786903', '410224199010102003', 'upload/yonghu3.jpg', 2, '3@qq.com', 656.09, '2023-03-27 01:31:38');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
