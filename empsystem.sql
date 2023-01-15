-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.28 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 empsystem 的数据库结构
CREATE DATABASE IF NOT EXISTS `empsystem` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empsystem`;

-- 导出  表 empsystem.tbl_dept 结构
CREATE TABLE IF NOT EXISTS `tbl_dept` (
  `dept_id` int NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `status` int DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `create_by` varchar(30) DEFAULT NULL COMMENT '创建者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- 正在导出表  empsystem.tbl_dept 的数据：~8 rows (大约)
INSERT INTO `tbl_dept` (`dept_id`, `dept_name`, `status`, `create_by`, `create_time`) VALUES
	(13, '科研部', 0, '张三', '2022-11-03 05:57:33'),
	(14, '财务部', 0, '张三', '2022-09-01 10:16:32'),
	(15, '销售部', 0, '张三', '2022-09-02 00:14:24'),
	(16, '人事部', 1, '张三', '2022-09-02 03:12:57'),
	(17, '保安部', 0, '张三', '2022-09-05 00:28:29'),
	(18, '测试部', 0, '张三', '2022-09-05 07:49:55'),
	(19, '运维部', 0, '张三', '2022-09-05 09:46:55'),
	(20, '综合管理部', 0, '张三', '2022-11-02 05:57:38'),
	(29, '新部门111', 1, '张三', '2022-12-28 16:08:09');

-- 导出  表 empsystem.tbl_menu 结构
CREATE TABLE IF NOT EXISTS `tbl_menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

-- 正在导出表  empsystem.tbl_menu 的数据：~8 rows (大约)
INSERT INTO `tbl_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`) VALUES
	(1, '人事管理', 0, 0, '#'),
	(2, '员工信息', 1, 0, 'emp.html'),
	(3, '部门信息', 1, 0, 'dept.html'),
	(4, '角色信息', 1, 0, 'role.html'),
	(5, '商品管理', 0, 0, '#'),
	(6, '商品信息', 5, 0, 's.jsp'),
	(7, '统计管理', 0, 0, '#'),
	(8, '统计信息', 7, 0, 't.jsp');

-- 导出  表 empsystem.tbl_role 结构
CREATE TABLE IF NOT EXISTS `tbl_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='角色信息表';

-- 正在导出表  empsystem.tbl_role 的数据：~6 rows (大约)
INSERT INTO `tbl_role` (`role_id`, `role_name`, `role_key`, `status`, `create_by`, `create_time`) VALUES
	(1, '管理员', '超级管理者', '0', '张三', '2022-11-03 08:15:04'),
	(2, '员工', '普通员工', '0', '张三', '2022-09-06 10:36:51'),
	(3, '经理', '部门管理者', '0', '张三', '2022-09-06 10:37:50'),
	(4, '采购经理', '负责采购管理', '0', '张三', '2022-09-09 09:14:47'),
	(5, '人事经理', '人事管理', '0', '张三', '2022-09-09 09:15:13'),
	(6, '测试数据', '测试数据', '1', '张三', '2022-09-09 09:15:31');

-- 导出  表 empsystem.tbl_role_menu 结构
CREATE TABLE IF NOT EXISTS `tbl_role_menu` (
  `role_id` int NOT NULL COMMENT '角色ID',
  `menu_id` int NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='角色和菜单关联表';

-- 正在导出表  empsystem.tbl_role_menu 的数据：~18 rows (大约)
INSERT INTO `tbl_role_menu` (`role_id`, `menu_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8),
	(3, 1),
	(3, 4),
	(4, 5),
	(4, 6),
	(4, 7),
	(4, 8),
	(5, 1),
	(5, 2),
	(5, 3),
	(5, 4);

-- 导出  表 empsystem.tbl_user 结构
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` int DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `status` int DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `hiredate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

-- 正在导出表  empsystem.tbl_user 的数据：~9 rows (大约)
INSERT INTO `tbl_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `email`, `phonenumber`, `sex`, `password`, `status`, `hiredate`) VALUES
	(2, 20, 'user000', '张三', 'xxx@qq.com', '110', 0, '123456', 0, '2022-12-06 07:05:56'),
	(3, 16, 'user001', '李四', '1373737@163.com', '1373737', 0, '123456', 1, '2022-12-06 07:06:37'),
	(4, 15, 'user002', '王五', '138234@qq,com', '138234', 1, '123', 0, '2002-11-04 07:31:55'),
	(7, 19, 'user003', '马六', '232@qq.com', '21324', 1, '123456', 0, '2012-11-02 09:32:36'),
	(11, 16, 'bbb', 'bbb', '23', '34343', 1, '123', 0, '2010-11-04 07:31:56'),
	(12, 17, 'user004', '赵大', 'qwewqe@qq.com', '21324', 1, '123', 0, '2013-11-04 07:31:57'),
	(13, 17, 'xd', '熊大', '12345@qq.com', '1234567', 1, '', 0, '2016-11-04 12:23:46'),
	(16, 15, '3', '31', '31@qq.com', '31', 1, '3', 1, '2022-12-04 18:21:04'),
	(20, 16, '1234512345', '王小明111', '111@henu.edu.cn', '13811111111', 0, 'password123', 1, '2022-12-28 11:36:14');

-- 导出  表 empsystem.tbl_user_role 结构
CREATE TABLE IF NOT EXISTS `tbl_user_role` (
  `user_id` int NOT NULL COMMENT '用户ID',
  `role_id` int NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户和角色关联表';

-- 正在导出表  empsystem.tbl_user_role 的数据：~11 rows (大约)
INSERT INTO `tbl_user_role` (`user_id`, `role_id`) VALUES
	(2, 1),
	(3, 5),
	(4, 1),
	(7, 3),
	(11, 2),
	(12, 3),
	(13, 3),
	(16, 1),
	(17, 3),
	(18, 6),
	(19, 2),
	(20, 6);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
