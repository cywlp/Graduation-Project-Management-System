/*
Navicat MySQL Data Transfer

Source Server         : 课设
Source Server Version : 50651
Source Host           : 39.99.120.216:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50651
File Encoding         : 65001

Date: 2022-06-16 21:13:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Administrator`
-- ----------------------------
DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (
  `a_id` int(11) NOT NULL,
  `a_number` char(10) DEFAULT NULL,
  `a_pwd` char(16) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Administrator
-- ----------------------------
INSERT INTO `Administrator` VALUES ('1', '2019900444', '123456');
INSERT INTO `Administrator` VALUES ('2', '2019900555', '123456');
INSERT INTO `Administrator` VALUES ('3', '2019900666', '123456');
INSERT INTO `Administrator` VALUES ('4', '2019900777', '123456');
INSERT INTO `Administrator` VALUES ('5', 'atest', '123');

-- ----------------------------
-- Table structure for `DefenseGrades`
-- ----------------------------
DROP TABLE IF EXISTS `DefenseGrades`;
CREATE TABLE `DefenseGrades` (
  `dg_id` int(11) NOT NULL,
  `dg_innovation` float DEFAULT NULL,
  `dg_quality` float DEFAULT NULL,
  `dg_difficulty` float DEFAULT NULL,
  `dg_verbal` float DEFAULT NULL,
  `dg_defense` float DEFAULT NULL,
  `dg_comment` text,
  `dg_date` date DEFAULT NULL,
  `dg_person` varchar(20) DEFAULT NULL,
  `dg_sum` float(255,0) DEFAULT NULL,
  PRIMARY KEY (`dg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of DefenseGrades
-- ----------------------------
INSERT INTO `DefenseGrades` VALUES ('0', '99', '90', '99', '90', null, null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('1', '75', '85', '85', '85', '85', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('2', '65', '85', '80', '75', '75', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('3', '100', '85', '80', '90', '85', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('4', '56', '11', '22', '11', '11', '6666', null, 'undefined', '111');
INSERT INTO `DefenseGrades` VALUES ('5', '75', '75', '75', '75', '75', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('6', '85', '100', '95', '85', '90', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('7', '80', '65', '65', '75', '80', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('8', '95', '95', '90', '85', '100', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('9', '95', '90', '90', '65', '90', null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('10', null, null, null, null, null, 'sss', null, null, null);
INSERT INTO `DefenseGrades` VALUES ('11', '56', '11', '22', '11', '11', 'hhh', null, 'undefined', '111');
INSERT INTO `DefenseGrades` VALUES ('12', '12', '1', null, null, null, null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('13', null, null, null, null, null, null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('14', null, null, null, null, null, null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('15', '5', '5', '5', '30', '30', 'ss', '2022-06-09', '小明', '75');
INSERT INTO `DefenseGrades` VALUES ('16', null, null, null, null, null, null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('17', null, null, null, null, null, null, null, null, null);
INSERT INTO `DefenseGrades` VALUES ('18', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `Instruction`
-- ----------------------------
DROP TABLE IF EXISTS `Instruction`;
CREATE TABLE `Instruction` (
  `is_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  `content` text,
  `time` date DEFAULT NULL,
  `is_finished` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`is_id`),
  KEY `FK_Reference_8` (`s_id`),
  KEY `FK_Reference_9` (`t_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`s_id`) REFERENCES `Student` (`s_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`t_id`) REFERENCES `Teacher` (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Instruction
-- ----------------------------
INSERT INTO `Instruction` VALUES ('1', '99', '1', '超级超级数学', '2022-06-15', '127');
INSERT INTO `Instruction` VALUES ('2', '2', '3', null, '2022-05-03', '1');
INSERT INTO `Instruction` VALUES ('3', '3', '9', null, '2022-05-03', '1');
INSERT INTO `Instruction` VALUES ('4', '6', '1', null, '2022-06-08', '0');
INSERT INTO `Instruction` VALUES ('5', '7', '9', null, '2022-05-03', '0');
INSERT INTO `Instruction` VALUES ('6', '8', '1', null, '2022-06-07', '1');
INSERT INTO `Instruction` VALUES ('7', '24', '2', null, '2022-06-01', '1');
INSERT INTO `Instruction` VALUES ('8', '25', '4', null, '2022-05-02', '1');
INSERT INTO `Instruction` VALUES ('9', '26', '10', null, '2022-05-30', '1');
INSERT INTO `Instruction` VALUES ('10', '29', '7', null, '2022-05-31', '1');
INSERT INTO `Instruction` VALUES ('99', '99', null, '书法家口', null, '0');
INSERT INTO `Instruction` VALUES ('101', '99', '2', '社区内', null, '1');
INSERT INTO `Instruction` VALUES ('102', '99', '2', 'zegbfdxdxbf', null, '1');
INSERT INTO `Instruction` VALUES ('104', '99', '2', '还真的', null, '1');
INSERT INTO `Instruction` VALUES ('105', '99', '2', 'zbsz', '2022-06-09', '1');
INSERT INTO `Instruction` VALUES ('106', '99', '2', '找不到房', '2022-06-09', '1');
INSERT INTO `Instruction` VALUES ('107', '99', '2', '西哈莫尼在北方', '2022-06-01', '0');

-- ----------------------------
-- Table structure for `InstructorGrades`
-- ----------------------------
DROP TABLE IF EXISTS `InstructorGrades`;
CREATE TABLE `InstructorGrades` (
  `ig_id` int(11) NOT NULL,
  `ig_design` float DEFAULT NULL,
  `ig_innovation` float DEFAULT NULL,
  `ig_workload` float DEFAULT NULL,
  `ig_investigate` float DEFAULT NULL,
  `ig_information` float DEFAULT NULL,
  `ig_comprehension` float DEFAULT NULL,
  `ig_comment` text,
  `ig_date` date DEFAULT NULL,
  `ig_sum` float(255,0) DEFAULT NULL,
  `ig_agree` char(255) DEFAULT NULL,
  `ig_person` char(255) DEFAULT NULL,
  PRIMARY KEY (`ig_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of InstructorGrades
-- ----------------------------
INSERT INTO `InstructorGrades` VALUES ('1', '80', '75', '90', '90', '75', '80', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('2', '85', '85', '85', '85', '85', '85', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('3', '75', '65', '70', '70', '80', '80', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('4', '90', '90', '95', '90', '85', '80', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('5', '85', '70', '71', '75', '75', '80', '你很好', null, '456', 'yes', '张三');
INSERT INTO `InstructorGrades` VALUES ('6', '100', '100', '95', '95', '90', '100', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('7', '65', '70', '70', '85', '75', '70', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('8', '70', '75', '80', '85', '80', '75', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('9', '80', '80', '80', '80', '80', '90', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('10', '65', '85', '95', '90', '65', '85', null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('11', null, null, null, null, null, null, '12548', null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('12', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('13', null, null, '3', null, '5', null, null, null, null, null, null);
INSERT INTO `InstructorGrades` VALUES ('14', '13', '4', '14', '9', '5', '4', 'fdxbx', null, '49', 'yes', '张三');
INSERT INTO `InstructorGrades` VALUES ('15', '20', '20', '20', '20', '20', '20', '做的好', null, '120', 'null', '张三');
INSERT INTO `InstructorGrades` VALUES ('16', '15', '5', '20', '10', '5', '45', 'hao', null, '100', 'null', 'null');
INSERT INTO `InstructorGrades` VALUES ('17', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `Pre_select`
-- ----------------------------
DROP TABLE IF EXISTS `Pre_select`;
CREATE TABLE `Pre_select` (
  `pre_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `pre_pri` int(11) DEFAULT NULL,
  `pre_success` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`pre_id`),
  KEY `FK_Reference_10` (`s_id`),
  KEY `FK_Reference_11` (`p_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`s_id`) REFERENCES `Student` (`s_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`p_id`) REFERENCES `Project` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Pre_select
-- ----------------------------
INSERT INTO `Pre_select` VALUES ('1', '1', '2', '1', '1');
INSERT INTO `Pre_select` VALUES ('2', '1', '1', '2', '-1');
INSERT INTO `Pre_select` VALUES ('3', '1', '13', '3', '3');
INSERT INTO `Pre_select` VALUES ('4', '2', '2', '1', '-1');
INSERT INTO `Pre_select` VALUES ('5', '2', '1', '2', '-1');
INSERT INTO `Pre_select` VALUES ('6', '2', '12', '3', '0');
INSERT INTO `Pre_select` VALUES ('7', '3', '13', '1', '-1');
INSERT INTO `Pre_select` VALUES ('8', '3', '13', '2', '-1');
INSERT INTO `Pre_select` VALUES ('9', '4', '1', '1', '-1');
INSERT INTO `Pre_select` VALUES ('10', '5', '1', '1', '-1');
INSERT INTO `Pre_select` VALUES ('11', '5', '2', '2', '-1');
INSERT INTO `Pre_select` VALUES ('12', '6', '1', '1', '-1');
INSERT INTO `Pre_select` VALUES ('13', '6', '2', '2', '-1');
INSERT INTO `Pre_select` VALUES ('14', '6', '3', '3', '0');
INSERT INTO `Pre_select` VALUES ('15', '7', '13', '1', '1');
INSERT INTO `Pre_select` VALUES ('16', '7', '12', '2', '3');
INSERT INTO `Pre_select` VALUES ('17', '7', '1', '3', '-1');
INSERT INTO `Pre_select` VALUES ('18', '8', '13', '1', '-1');
INSERT INTO `Pre_select` VALUES ('19', '8', '1', '2', '-1');
INSERT INTO `Pre_select` VALUES ('20', '8', '2', '3', '-1');
INSERT INTO `Pre_select` VALUES ('21', '9', '13', '1', '3');
INSERT INTO `Pre_select` VALUES ('22', '9', '2', '2', '3');
INSERT INTO `Pre_select` VALUES ('23', '9', '1', '3', '1');
INSERT INTO `Pre_select` VALUES ('24', '10', '2', '1', '-1');
INSERT INTO `Pre_select` VALUES ('25', '10', '12', '2', '0');
INSERT INTO `Pre_select` VALUES ('26', '10', '13', '3', '-1');
INSERT INTO `Pre_select` VALUES ('38', '11', '13', null, '-1');
INSERT INTO `Pre_select` VALUES ('51', '99', '21', null, '3');
INSERT INTO `Pre_select` VALUES ('52', '99', '22', null, '1');
INSERT INTO `Pre_select` VALUES ('54', '99', '2', null, '0');
INSERT INTO `Pre_select` VALUES ('56', '100', '30', null, '1');
INSERT INTO `Pre_select` VALUES ('57', '100', '1', null, '-1');
INSERT INTO `Pre_select` VALUES ('58', '101', '31', null, '0');
INSERT INTO `Pre_select` VALUES ('59', '101', '24', null, '0');
INSERT INTO `Pre_select` VALUES ('60', '101', '28', null, '0');

-- ----------------------------
-- Table structure for `Project`
-- ----------------------------
DROP TABLE IF EXISTS `Project`;
CREATE TABLE `Project` (
  `p_id` int(11) NOT NULL,
  `p_name` char(10) DEFAULT NULL,
  `p_origin` char(40) DEFAULT NULL,
  `p_type` char(40) DEFAULT NULL,
  `p_content` text,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Project
-- ----------------------------
INSERT INTO `Project` VALUES ('0', '计算机系统', '自选项目', '论文', '能够发挥');
INSERT INTO `Project` VALUES ('1', '数字图像识别', '自选项目', '论文', '百分点');
INSERT INTO `Project` VALUES ('2', '人工智能', '国家重点项目', '论文', '标识符');
INSERT INTO `Project` VALUES ('3', '道路桥梁设计', '自选项目', '设计图', 'BF不断发展');
INSERT INTO `Project` VALUES ('4', '英文对话', '自选项目', '口语表达', '不涨反跌');
INSERT INTO `Project` VALUES ('5', '土木建筑设计', '自选项目', '设计图', '本课题来自国家项目。具体内容请问本专业出题老师。');
INSERT INTO `Project` VALUES ('6', '体育运动培养', '自选项目', '论文', '找不到');
INSERT INTO `Project` VALUES ('7', '公司收支分析', '自选项目', '图表', '在打不过你');
INSERT INTO `Project` VALUES ('8', '碳纤维研发', '国家重点项目', '论文', '知道不');
INSERT INTO `Project` VALUES ('9', '车辆实时检测', '国家重点项目', '论文', '洗衣机你好');
INSERT INTO `Project` VALUES ('10', '快递运输信息跟踪', '国家重点项目', '图表', '总不能跟踪');
INSERT INTO `Project` VALUES ('11', '身体健康训练', '自选项目', '论文', '找不到');
INSERT INTO `Project` VALUES ('12', '信息安全', '自选项目', '论文', '座谈会你打不过');
INSERT INTO `Project` VALUES ('13', 'web开发', '自选项目', '论文', '非标定制');
INSERT INTO `Project` VALUES ('14', 'linux开发', '自选项目', '论文', '你这个');
INSERT INTO `Project` VALUES ('15', '数学分析5', '自选项目', '设计', '着日本豆腐');
INSERT INTO `Project` VALUES ('16', '室内自动消毒系统', '省级重点项目', '论文', '你先跟大不大方');
INSERT INTO `Project` VALUES ('17', '土力学', '自选项目', '论文', '完成论文');
INSERT INTO `Project` VALUES ('18', '方土学', '自选项目', '实践', '完成课题实践');
INSERT INTO `Project` VALUES ('19', '地质', '自选项目', '论文', '完成论文');
INSERT INTO `Project` VALUES ('20', '地质信息', '省级重点项目', '论文', '红烧猪蹄');
INSERT INTO `Project` VALUES ('21', '室内消毒系统', '省级课题', '实践', '完成系统测试');
INSERT INTO `Project` VALUES ('22', '实践实践', '省级课题', '论文', '完成论文');
INSERT INTO `Project` VALUES ('23', '实践实践', '自选项目', '论文', '完成论文');
INSERT INTO `Project` VALUES ('24', '人脸识别系统', '国家级项目', '实践', '完成系统设计');
INSERT INTO `Project` VALUES ('25', '数据库', '自选项目', '论文', 'www');
INSERT INTO `Project` VALUES ('26', '数据', '自选项目', '论文', '吴');
INSERT INTO `Project` VALUES ('27', '王佳宝人脸识别', '国家级项目', '论文', '完成论文');
INSERT INTO `Project` VALUES ('28', '土木', '自选项目', '论文', '无');
INSERT INTO `Project` VALUES ('29', '基于人脸识别的课题', '省级课题', '论文', '完成论文');
INSERT INTO `Project` VALUES ('30', '人脸识别', '省级课题', '论文', '完成论文');
INSERT INTO `Project` VALUES ('31', '疫情防控', '省级课题', '论文', '完成论文');

-- ----------------------------
-- Table structure for `ReviewerGrades`
-- ----------------------------
DROP TABLE IF EXISTS `ReviewerGrades`;
CREATE TABLE `ReviewerGrades` (
  `rg_id` int(11) NOT NULL,
  `rg_investigate` float DEFAULT NULL,
  `rg_completion` float DEFAULT NULL,
  `rg_translation` float DEFAULT NULL,
  `rg_comprehension` float DEFAULT NULL,
  `rg_innovation` float DEFAULT NULL,
  `rg_design` float DEFAULT NULL,
  `rg_comment` text,
  `rg_date` date DEFAULT NULL,
  `rg_sum` float(255,0) DEFAULT NULL,
  `rg_person` char(255) DEFAULT NULL,
  PRIMARY KEY (`rg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ReviewerGrades
-- ----------------------------
INSERT INTO `ReviewerGrades` VALUES ('1', '70', '80', '80', '85', '75', '90', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('2', '65', '90', '90', '90', '80', '95', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('3', '90', '80', '70', '70', '70', '85', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('4', '85', '85', '85', '65', '85', '75', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('5', '100', '95', '95', '95', '95', '95', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('6', '85', '74', '65', '85', '85', '90', '你和那后', null, '484', 'undefined');
INSERT INTO `ReviewerGrades` VALUES ('7', '90', '90', '75', '100', '65', '95', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('8', '85', '80', '80', '90', '85', '75', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('9', '95', '85', '80', '85', '85', '90', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('10', '85', '80', '70', '75', '75', '80', null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('11', '11', null, null, null, null, null, '5555', null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('12', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('13', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('14', '9', '10', '3', '4', '5', '6', 'sadas', null, '37', 'undefined');
INSERT INTO `ReviewerGrades` VALUES ('15', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('16', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ReviewerGrades` VALUES ('17', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `Student`
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `s_id` int(11) NOT NULL,
  `s_number` char(10) DEFAULT NULL,
  `s_pwd` char(16) DEFAULT NULL,
  `s_name` char(10) DEFAULT NULL,
  `s_photo` char(30) DEFAULT NULL,
  `s_major` char(10) DEFAULT NULL,
  `s_telephone` char(11) DEFAULT NULL,
  `s_grade` char(40) DEFAULT NULL,
  `s_class` char(40) DEFAULT NULL,
  `s_nation` char(20) DEFAULT NULL,
  `s_sex` char(4) DEFAULT NULL,
  `s_email` char(20) DEFAULT NULL,
  `s_origin` char(20) DEFAULT NULL,
  `s_academy` char(20) DEFAULT NULL,
  `s_status` int(10) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO `Student` VALUES ('0', '20251111', '1234567', '哈哈哈', null, '关注', '自动', '142', 'null', 'null', '男', 'null', 'null', 'null', '1');
INSERT INTO `Student` VALUES ('1', '20261111', '1234567', '哈哈哈哈哈', null, '找不到房', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', '1');
INSERT INTO `Student` VALUES ('2', '2019900221', '123456', '李四', null, '计科', '13157686254', '2019', '二班', '汉族', '男', '2445896321@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('3', '2019900220', '123456', '王五', null, '物联网', '13557685412', '2019', '九班', '汉族', '男', '2749625784@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('4', '2019900119', '123456', '李莉', null, '软件工程', '13157686259', '2019', '六班', '汉族', '女', '2748452392@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('5', '2019900118', '123456', '叶军', null, '软件工程', '13157686255', '2019', '七班', '汉族', '男', '2748450399@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('6', '2019900117', '123456', '李依琳', null, '软件工程', '13568945124', '2019', '七班', '汉族', '女', '1542369874@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('7', '2019900116', '123456', '王家宝', null, '软件工程', '13875692147', '2019', '七班', '汉族', '男', '1456238798@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('8', '2019900115', '123456', '赵小龙', null, '软件工程', '13456895123', '2019', '七班', '汉族', '男', '1060772971@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('9', '2019900114', '123456', '李季伟', null, '计科', '13984562145', '2019', '一班', '汉族', '男', '1067589654@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('10', '2019900113', '123456', '齐永', null, '物联网', '13576852145', '2019', '九班', '汉族', '男', '2145698745@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('11', '2019900112', '123456', '王新宇', null, '物联网', '13357686252', '2019', '九班', '汉族', '男', '2748452356@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('12', '2019900111', '123456', '辛羊羊', null, '计科', '13547896523', '2019', '三班', '汉族', '男', '1123654789@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('13', '2019900110', '123456', '赵小弟', null, '软件工程', '13157686252', '2019', '八班', '汉族', '男', '1132547896@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('14', '2019900099', '123456', '李依霖', null, '软件工程', '13157686254', '2019', '六班', '汉族', '男', '1145698745@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('15', '2099000098', '123456', '王小宝', null, '计科', '15547896522', '2019', '一班', '汉族', '男', '1452365872@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('16', '2019900097', '123456', '叶俊军', null, '计科', '15125478965', '2019', '二班', '汉族', '男', '1236548789@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('17', '2019900096', '123456', '赵晓晓', null, '物联网', '15123654789', '2019', '九班', '汉族', '男', '1254789652@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('18', '2199000095', '123456', '赵小小', null, '物联网', '15423685698', '2019', '九班', '汉族', '男', '1521563254@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('19', '2019900120', '123456', '赵龙', null, '计科', '15623578965', '2019', '一班', '汉族', '男', '1532547896@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('20', '2019900121', '123456', '叶叶俊', null, '计科', '13545698521', '2019', '二班', '汉族', '男', '1524869875@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('21', '2018900444', '123456', '邓雨雨', null, '软件工程', '15545625855', '2018', '六班', '汉族', '男', '1524589655@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('22', '2018900445', '123456', '邓彤彤', null, '计科', '15246852365', '2018', '二班', '汉族', '女', '1111111111@qq.com', '中国', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('23', '2019907777', '123456', '灰天', null, '体育训练', '11111111111', '2019', '八班', '印度族', '男', '1254786985@qq.com', '孟加拉国', '体育学院', '1');
INSERT INTO `Student` VALUES ('24', '2019555443', '123456', '代呆呆', null, '道桥', '12354854523', '2019', '七班', '壮族', '男', '54515644561@qq.com', '日本', '道桥学院', '1');
INSERT INTO `Student` VALUES ('25', '2018754896', '123456', '小三', null, '土木', '54513545451', '2018', '四班', '朝鲜族', '女', '15415156@qq.com', '美国', '土木学院', '1');
INSERT INTO `Student` VALUES ('26', '2020548774', '123456', '牛仔', null, '车辆', '89841515648', '2020', '三班', '保安族', '女', '662789488@qq.com', '韩国', '车辆学院', '1');
INSERT INTO `Student` VALUES ('27', '2016978451', '123456', '兰博', null, '材料', '48116489788', '2016', '十一班', '苗族', '女', '5451654561@qq.com', '德国', '材料学院', '1');
INSERT INTO `Student` VALUES ('29', '2018456417', '123456', '内内', null, '英语', '45154879811', '2018', '二班', '汉族', '男', '4841879848@qq.com', '比利时', '外语学院', '1');
INSERT INTO `Student` VALUES ('30', '2019909999', null, 'wangjiab', null, null, null, '2019', null, null, null, null, null, '信息工程学院', null);
INSERT INTO `Student` VALUES ('99', 'test', '123', 'test', null, '软件工程', null, '2019', '七班', null, null, null, null, '信息工程学院', null);
INSERT INTO `Student` VALUES ('100', '2019903879', '123456', '王佳宝', null, '软件工程', '111', '2019', '222', '汉族', '男', '11', '河南', '信息工程学院', '1');
INSERT INTO `Student` VALUES ('101', '2019903333', '123456', '张晓明', null, '软件工程', '18237579818', '2019', '2019240207', '汉族', '男', '13078@qq.com', '河南', '信息工程学院', '1');

-- ----------------------------
-- Table structure for `Student_Project`
-- ----------------------------
DROP TABLE IF EXISTS `Student_Project`;
CREATE TABLE `Student_Project` (
  `sp_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `rg_id` int(11) DEFAULT NULL,
  `ig_id` int(11) DEFAULT NULL,
  `dg_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sp_id`),
  KEY `FK_Reference_3` (`s_id`),
  KEY `FK_Reference_4` (`p_id`),
  KEY `FK_Reference_5` (`rg_id`),
  KEY `FK_Reference_6` (`ig_id`),
  KEY `FK_Reference_7` (`dg_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`s_id`) REFERENCES `Student` (`s_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`p_id`) REFERENCES `Project` (`p_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`rg_id`) REFERENCES `ReviewerGrades` (`rg_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`ig_id`) REFERENCES `InstructorGrades` (`ig_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`dg_id`) REFERENCES `DefenseGrades` (`dg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Student_Project
-- ----------------------------
INSERT INTO `Student_Project` VALUES ('4', '3', '3', '3', '3', '3');
INSERT INTO `Student_Project` VALUES ('5', '25', '5', '6', '5', '4');
INSERT INTO `Student_Project` VALUES ('6', '11', '1', '7', '6', '6');
INSERT INTO `Student_Project` VALUES ('7', '9', '1', '5', '8', '8');
INSERT INTO `Student_Project` VALUES ('8', '2', '3', '2', '5', '3');
INSERT INTO `Student_Project` VALUES ('9', '30', '27', null, null, null);
INSERT INTO `Student_Project` VALUES ('14', '7', '13', '11', '11', '11');
INSERT INTO `Student_Project` VALUES ('18', '99', '22', '14', '14', '15');
INSERT INTO `Student_Project` VALUES ('20', '100', '30', '16', '16', '17');
INSERT INTO `Student_Project` VALUES ('21', '9', '1', '17', '17', '18');

-- ----------------------------
-- Table structure for `Teacher`
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `t_id` int(11) NOT NULL,
  `t_number` char(10) DEFAULT NULL,
  `t_pwd` char(16) DEFAULT NULL,
  `t_name` char(10) DEFAULT NULL,
  `t_photo` char(30) DEFAULT NULL,
  `t_telephone` char(11) DEFAULT NULL,
  `t_nation` char(20) DEFAULT NULL,
  `t_sex` char(4) DEFAULT NULL,
  `t_email` char(20) DEFAULT NULL,
  `t_origin` char(20) DEFAULT NULL,
  `t_academy` char(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES ('1', '01', '12133', '小明', null, '18237579818', '汉', '男', '2107854753@qq.com', '陕西', '电控学院');
INSERT INTO `Teacher` VALUES ('2', '11', '456', '鲍勃', null, '123788', '维吾尔族', '45', '51516556@qq,com', '荷兰', '土木学院');
INSERT INTO `Teacher` VALUES ('3', '25', '551', '杰瑞', null, '15478', '汉族', '26', 'dsdsffr@148.com', '日本', '信息工程学院');
INSERT INTO `Teacher` VALUES ('4', '44', '2554', '唐家', null, '4842331', '汉族', '46', '121314@qq.com', '中国', '道桥学院');
INSERT INTO `Teacher` VALUES ('5', '41', '515', '靓仔', null, '21154', '壮族', '32', '121241412@qq.com', '韩国', '经管学院');
INSERT INTO `Teacher` VALUES ('6', '08', '7878', '叶子', null, '1548', '汉族', '29', 'daahdh@qq.com', '瑞典', '体育学院');
INSERT INTO `Teacher` VALUES ('7', '16', '464', '唐迟', null, '8112', '汉族', '46', 'sajda@123.com', '中国', '外语学院');
INSERT INTO `Teacher` VALUES ('8', '67', '1546', '永乐', null, '1547', '汉族', '58', 'qweqsa@134.com', '中国', '数学学院');
INSERT INTO `Teacher` VALUES ('9', '54', '15484', '晓阳', null, '7871', '汉族', '31', 'jjaskdji@176.com', '中国', '信息工程学院');
INSERT INTO `Teacher` VALUES ('10', '13', '8549', '薛镇', null, '2045', '汉族', '40', '264154@qq.com', '中国', '车辆学院');
INSERT INTO `Teacher` VALUES ('11', '09', '451', '周鹏', null, '155', '汉族', '28', 'jjkjsj@19.com', '中国', '体育学院');
INSERT INTO `Teacher` VALUES ('12', '02', '593', '李建', null, '017', '壮族', '44', '145165@qq.com', '中国', '材料学院');
INSERT INTO `Teacher` VALUES ('13', '89', '151', '陆运', null, '8451', '壮族', '57', 'dhasdasjqeq@123.com', '韩国', '运输学院');
INSERT INTO `Teacher` VALUES ('15', '67', '123', '李依琳', null, '12234343434', '汉', '女', 'bedfgs@134.com', '陕西西安', '信息学院');
INSERT INTO `Teacher` VALUES ('21', '3423', '123', '地方', null, '132134', '上风向标', '', '', '', '');

-- ----------------------------
-- Table structure for `Teacher_Project`
-- ----------------------------
DROP TABLE IF EXISTS `Teacher_Project`;
CREATE TABLE `Teacher_Project` (
  `tp_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `grade` char(20) DEFAULT NULL,
  `scale` char(20) DEFAULT NULL,
  PRIMARY KEY (`tp_id`),
  KEY `FK_Reference_1` (`t_id`),
  KEY `FK_Reference_2` (`p_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`t_id`) REFERENCES `Teacher` (`t_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`p_id`) REFERENCES `Project` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Teacher_Project
-- ----------------------------
INSERT INTO `Teacher_Project` VALUES ('1', '1', '1', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('2', '2', '5', '2020', '土木学院');
INSERT INTO `Teacher_Project` VALUES ('3', '9', '2', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('4', '4', '3', '2019', '道桥学院');
INSERT INTO `Teacher_Project` VALUES ('5', '6', '11', '2019', '体育学院');
INSERT INTO `Teacher_Project` VALUES ('6', '7', '4', '2019', '外语学院');
INSERT INTO `Teacher_Project` VALUES ('7', '5', '7', '2016', '经管学院');
INSERT INTO `Teacher_Project` VALUES ('8', '10', '9', '2020', '车辆学院');
INSERT INTO `Teacher_Project` VALUES ('10', '12', '8', '2016', '材料学院');
INSERT INTO `Teacher_Project` VALUES ('11', '13', '10', '2019', '运输学院');
INSERT INTO `Teacher_Project` VALUES ('12', '1', '14', '2018', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('13', '3', '15', '2019', '数学学院');
INSERT INTO `Teacher_Project` VALUES ('14', '3', '12', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('16', '6', '16', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('17', '2', '17', '2018', '土木学院');
INSERT INTO `Teacher_Project` VALUES ('18', '2', '18', '2020', '土木学院');
INSERT INTO `Teacher_Project` VALUES ('19', '2', '19', '2019', '地测学院');
INSERT INTO `Teacher_Project` VALUES ('20', '2', '20', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('25', '2', '13', null, null);
INSERT INTO `Teacher_Project` VALUES ('26', '2', '21', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('27', '2', '22', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('28', '2', '23', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('37', '2', '24', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('38', '2', '25', '2021', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('39', '2', '26', '2020', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('40', '2', '27', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('41', '2', '28', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('42', '2', '29', '2019', '信息学院');
INSERT INTO `Teacher_Project` VALUES ('43', '2', '30', '2019', '信息工程学院');
INSERT INTO `Teacher_Project` VALUES ('44', '2', '31', '2019', '信息工程学院');

-- ----------------------------
-- View structure for `AdminProject`
-- ----------------------------
DROP VIEW IF EXISTS `AdminProject`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `AdminProject` AS select `Project`.`p_id` AS `id`,`Project`.`p_name` AS `name`,`Project`.`p_origin` AS `origin`,`Project`.`p_type` AS `type`,`Teacher`.`t_name` AS `teacherName`,`Teacher_Project`.`grade` AS `grade`,`Teacher_Project`.`scale` AS `scale` from ((`Project` join `Teacher`) join `Teacher_Project`) where ((`Project`.`p_id` = `Teacher_Project`.`p_id`) and (`Teacher_Project`.`t_id` = `Teacher`.`t_id`)) WITH CASCADED CHECK OPTION ;

-- ----------------------------
-- View structure for `AdminStudent`
-- ----------------------------
DROP VIEW IF EXISTS `AdminStudent`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `AdminStudent` AS (select `Student`.`s_id` AS `id`,`Student`.`s_number` AS `number`,`Student`.`s_name` AS `name`,`Student`.`s_email` AS `email`,`Student`.`s_pwd` AS `pwd`,`Student`.`s_major` AS `major`,`Student`.`s_telephone` AS `telephone`,`Student`.`s_grade` AS `grade`,`Student`.`s_class` AS `a_class`,`Student`.`s_nation` AS `nation`,`Student`.`s_sex` AS `sex`,`Student`.`s_origin` AS `origin`,`Student`.`s_academy` AS `academy`,`Student`.`s_status` AS `status` from `Student`) ;

-- ----------------------------
-- View structure for `AdminTeacher`
-- ----------------------------
DROP VIEW IF EXISTS `AdminTeacher`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `AdminTeacher` AS (select `Teacher`.`t_id` AS `id`,`Teacher`.`t_number` AS `number`,`Teacher`.`t_pwd` AS `pwd`,`Teacher`.`t_name` AS `name`,`Teacher`.`t_telephone` AS `telephone`,`Teacher`.`t_nation` AS `nation`,`Teacher`.`t_sex` AS `sex`,`Teacher`.`t_email` AS `email`,`Teacher`.`t_origin` AS `origin`,`Teacher`.`t_academy` AS `academy` from `Teacher`) ;

-- ----------------------------
-- View structure for `demo`
-- ----------------------------
DROP VIEW IF EXISTS `demo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `demo` AS select distinct `Student`.`s_number` AS `number`,`Project`.`p_id` AS `id`,`Project`.`p_name` AS `name`,`Project`.`p_origin` AS `origin`,`Project`.`p_type` AS `type`,`Teacher`.`t_name` AS `teacherName`,`Teacher_Project`.`grade` AS `grade`,`Teacher_Project`.`scale` AS `scale` from ((((`Student` join `Teacher_Project`) join `Project`) join `Teacher`) join `Pre_select`) where ((`Student`.`s_academy` = `Teacher_Project`.`scale`) and (`Student`.`s_grade` = `Teacher_Project`.`grade`) and (`Project`.`p_id` = `Teacher_Project`.`p_id`) and (`Teacher`.`t_id` = `Teacher_Project`.`t_id`) and (`Student`.`s_id` <> `Pre_select`.`s_id`) and (`Project`.`p_id` <> `Pre_select`.`p_id`)) ;

-- ----------------------------
-- View structure for `FinalStudentProject`
-- ----------------------------
DROP VIEW IF EXISTS `FinalStudentProject`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `FinalStudentProject` AS (select `Teacher`.`t_id` AS `t_id`,`Teacher`.`t_number` AS `t_number`,`Student`.`s_id` AS `id`,`Student`.`s_number` AS `number`,`Student`.`s_name` AS `NAME`,`Student`.`s_major` AS `major`,`Project`.`p_id` AS `projectId`,`Project`.`p_name` AS `projectName`,`Student_Project`.`rg_id` AS `rg_id`,`Student_Project`.`ig_id` AS `ig_id`,`Student_Project`.`dg_id` AS `dg_id` from ((((`Teacher` join `Student`) join `Project`) join `Student_Project`) join `Teacher_Project`) where ((`Student`.`s_id` = `Student_Project`.`s_id`) and (`Project`.`p_id` = `Student_Project`.`p_id`) and (`Teacher`.`t_id` = `Teacher_Project`.`t_id`) and (`Teacher_Project`.`p_id` = `Project`.`p_id`))) ;

-- ----------------------------
-- View structure for `Instruction_Student`
-- ----------------------------
DROP VIEW IF EXISTS `Instruction_Student`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `Instruction_Student` AS (select `Student`.`s_number` AS `Sid`,`Instruction`.`content` AS `content`,`Instruction`.`time` AS `time` from (`Instruction` join `Student`) where (`Student`.`s_id` = `Instruction`.`s_id`)) ;

-- ----------------------------
-- View structure for `InstructionTwo`
-- ----------------------------
DROP VIEW IF EXISTS `InstructionTwo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `InstructionTwo` AS select distinct `Instruction`.`is_id` AS `isid`,`Instruction`.`s_id` AS `sid`,`Student`.`s_number` AS `snumber`,`Instruction`.`t_id` AS `tid`,`Teacher`.`t_number` AS `tnumber`,`Instruction`.`content` AS `content`,`Instruction`.`time` AS `time`,`Instruction`.`is_finished` AS `isFinished` from ((`Teacher` join `Student`) join `Instruction`) where ((`Teacher`.`t_id` = `Instruction`.`t_id`) and (`Student`.`s_id` = `Instruction`.`s_id`)) ;

-- ----------------------------
-- View structure for `Student_Select`
-- ----------------------------
DROP VIEW IF EXISTS `Student_Select`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `Student_Select` AS select `Student`.`s_number` AS `number`,`Project`.`p_id` AS `id`,`Project`.`p_name` AS `name`,`Project`.`p_origin` AS `origin`,`Project`.`p_type` AS `type`,`Teacher`.`t_name` AS `teacherName`,`Teacher_Project`.`grade` AS `grade`,`Teacher_Project`.`scale` AS `scale` from (((`Student` join `Project`) join `Teacher_Project`) join `Teacher`) where ((`Student`.`s_academy` = `Teacher_Project`.`scale`) and (`Student`.`s_grade` = `Teacher_Project`.`grade`) and (`Project`.`p_id` = `Teacher_Project`.`p_id`) and (`Teacher`.`t_id` = `Teacher_Project`.`t_id`)) ;

-- ----------------------------
-- View structure for `StudentApplication`
-- ----------------------------
DROP VIEW IF EXISTS `StudentApplication`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `StudentApplication` AS select `Student`.`s_number` AS `number`,`Pre_select`.`p_id` AS `projectId`,`Project`.`p_name` AS `projectName`,`Pre_select`.`pre_success` AS `status` from ((`Student` join `Pre_select`) join `Project`) where ((`Student`.`s_id` = `Pre_select`.`s_id`) and (`Pre_select`.`p_id` = `Project`.`p_id`)) ;

-- ----------------------------
-- View structure for `StudentInstruction`
-- ----------------------------
DROP VIEW IF EXISTS `StudentInstruction`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `StudentInstruction` AS (select `Student`.`s_number` AS `number`,`Student`.`s_name` AS `name`,`Instruction`.`content` AS `content`,`Instruction`.`time` AS `time` from (`Instruction` join `Student`) where (`Student`.`s_id` = `Instruction`.`s_id`)) ;

-- ----------------------------
-- View structure for `StudentView`
-- ----------------------------
DROP VIEW IF EXISTS `StudentView`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `StudentView` AS (select `Student_Project`.`s_id` AS `s_id`,`Student`.`s_number` AS `s_number`,`Student`.`s_name` AS `s_name`,`Student`.`s_major` AS `s_major`,`Student`.`s_class` AS `s_class`,`Teacher_Project`.`t_id` AS `t_id`,`Teacher`.`t_number` AS `t_number`,`Student_Project`.`p_id` AS `p_id`,`Project`.`p_name` AS `p_name` from ((((`Student` join `Teacher`) join `Project`) join `Student_Project`) join `Teacher_Project`) where ((`Student`.`s_id` = `Student_Project`.`s_id`) and (`Teacher`.`t_id` = `Teacher_Project`.`t_id`) and (`Student_Project`.`p_id` = `Project`.`p_id`) and (`Teacher_Project`.`p_id` = `Student_Project`.`p_id`))) ;

-- ----------------------------
-- View structure for `TeacherApplication`
-- ----------------------------
DROP VIEW IF EXISTS `TeacherApplication`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `TeacherApplication` AS select distinct `Teacher`.`t_id` AS `t_id`,`Teacher`.`t_number` AS `t_number`,`Student`.`s_id` AS `id`,`Student`.`s_number` AS `number`,`Student`.`s_name` AS `name`,`Student`.`s_major` AS `major`,`Project`.`p_id` AS `projectId`,`Project`.`p_name` AS `projectName`,`Pre_select`.`pre_success` AS `status` from ((((`Teacher` join `Student`) join `Pre_select`) join `Project`) join `Teacher_Project`) where ((`Student`.`s_id` = `Pre_select`.`s_id`) and (`Project`.`p_id` = `Pre_select`.`p_id`) and (`Teacher_Project`.`t_id` = `Teacher`.`t_id`) and (`Teacher_Project`.`p_id` = `Project`.`p_id`)) ;

-- ----------------------------
-- View structure for `TeacherHistorySelect`
-- ----------------------------
DROP VIEW IF EXISTS `TeacherHistorySelect`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin2`@`%` SQL SECURITY DEFINER VIEW `TeacherHistorySelect` AS select `Teacher`.`t_id` AS `id`,`Teacher`.`t_number` AS `number`,`Project`.`p_id` AS `p_id`,`Project`.`p_name` AS `name`,`Project`.`p_origin` AS `origin`,`Project`.`p_type` AS `type`,`Project`.`p_content` AS `content`,`Teacher_Project`.`grade` AS `grade`,`Teacher_Project`.`scale` AS `scale` from ((`Project` join `Teacher_Project`) join `Teacher`) where ((`Teacher`.`t_id` = `Teacher_Project`.`t_id`) and (`Teacher_Project`.`p_id` = `Project`.`p_id`)) ;

-- ----------------------------
-- View structure for `TeacherProject`
-- ----------------------------
DROP VIEW IF EXISTS `TeacherProject`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `TeacherProject` AS (select `Project`.`p_name` AS `name`,`Project`.`p_type` AS `type`,`Project`.`p_content` AS `content`,`Teacher_Project`.`grade` AS `grade`,`Teacher_Project`.`scale` AS `scale` from (`Teacher_Project` join `Project`) where (`Teacher_Project`.`p_id` = `Project`.`p_id`)) ;

-- ----------------------------
-- View structure for `User_Admin`
-- ----------------------------
DROP VIEW IF EXISTS `User_Admin`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `User_Admin` AS (select `Administrator`.`a_id` AS `id`,`Administrator`.`a_number` AS `number`,`Administrator`.`a_pwd` AS `pwd` from `Administrator`) ;

-- ----------------------------
-- View structure for `User_Student`
-- ----------------------------
DROP VIEW IF EXISTS `User_Student`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `User_Student` AS (select `Student`.`s_id` AS `id`,`Student`.`s_number` AS `number`,`Student`.`s_pwd` AS `pwd` from `Student`) ;

-- ----------------------------
-- View structure for `User_Teacher`
-- ----------------------------
DROP VIEW IF EXISTS `User_Teacher`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `User_Teacher` AS (select `Teacher`.`t_id` AS `id`,`Teacher`.`t_number` AS `number`,`Teacher`.`t_pwd` AS `pwd` from `Teacher`) ;
DROP TRIGGER IF EXISTS `Preselect`;
DELIMITER ;;
CREATE TRIGGER `Preselect` BEFORE INSERT ON `Pre_select` FOR EACH ROW BEGIN
	IF NEW.pre_success is null THEN 
		set NEW.pre_success=0;
	END IF;
	
    END
;;
DELIMITER ;
