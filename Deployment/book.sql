/*
 Navicat Premium Data Transfer

 Source Server         : Local MySQL
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 08/01/2021 16:06:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者通用名称，有索引，可重名',
  `fullname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者全名',
  `country` char(2) CHARACTER SET ascii COLLATE ascii_general_ci NULL DEFAULT NULL COMMENT '作者国籍，使用\r\nISO 3166-1二位字母代码规范',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '作者简述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_author_name`(`name`) USING BTREE COMMENT '作者通用名称索引'
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '作者表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES (1, '莎士比亚', '威廉·莎士比亚', 'UK', '威廉·莎士比亚（英语：William Shakespeare），1564年4月26日（受洗日）－儒略历1616年4月23日；华人社会常尊称为莎翁，清末民初鲁迅在《摩罗诗力说》 （1908年2月）称莎翁为（“狭斯丕尔”）是英国文学史上最杰出的戏剧家，也是西方文艺史上最杰出的作家之一，全世界最卓越的文学家之一。[1]他流传下来的作品包括38部戏剧、154首十四行诗、两首长叙事诗和其他诗歌。他的戏剧有各种主要语言的译本，且表演次数远远超过其他戏剧家的作品。[2]\r\n\r\n莎士比亚在埃文河畔斯特拉特福出生长大，18岁时与安妮·哈瑟维结婚，两人共生育了三个孩子：苏珊娜、双胞胎哈姆内特和朱迪思。16世纪末到17世纪初的20多年期间莎士比亚在伦敦开始了成功的职业生涯，他不仅是演员、剧作家，还是宫内大臣剧团的合伙人之一，后来改名为国王剧团。1613年左右，莎士比亚退休回到雅芳河畔斯特拉特福，3年后逝世。有关莎士比亚私人生活的记录流传下来很少，关于他的性取向、宗教信仰、以及他的著作是否出自他人之手都依然是谜。[3]\r\n\r\n1590年到1613年是莎士比亚的创作的黄金时代。他的早期剧本主要是喜剧和历史剧，在16世纪末期达到了深度和艺术性的高峰。接下来到1608年他主要创作悲剧，莎士比亚崇尚高尚情操，常常描写牺牲与复仇，被认为属于英语最佳范例。在他人生最后阶段，他开始创作悲喜剧，又称为传奇剧，并与其他剧作家合作。在他有生之年，他的很多作品就以多种版本出版，水准和准确性参差不齐。1623年，他所在剧团两位同事出版了《第一对开本》，除两部作品外，目前已经被认可的莎士比亚作品均收录其中。\r\n\r\n莎士比亚在世时被尊为诗人和剧作家，但直到19世纪他的声望才达到今日的高度。并在20世纪盛名传至亚、非、拉丁美洲三大地区，使更多人了解其盛名。浪漫主义时期赞颂莎士比亚的才华，维多利亚时代像英雄一样地尊敬他，被萧伯纳称为莎士比亚崇拜。20世纪，他的作品常常被新学术运动改编并重新发现价值。他的作品直至今日依旧广受欢迎，在全球以不同文化和政治形式演出和诠释。');
INSERT INTO `author` VALUES (2, '毛泽东', '毛泽东', 'CN', '毛泽东（1893年12月26日-1976年9月9日），字润之（原作咏芝，后改润芝），笔名子任。湖南湘潭人。中国人民的领袖，伟大的马克思主义者，无产阶级革命家、战略家和理论家，中国共产党、中国人民解放军和中华人民共和国的主要缔造者和领导人，政治家 [1]  ，军事家 [2]  ，诗人，书法家。 [3] \r\n1949至1976年，毛泽东担任中华人民共和国最高领导人。他对马克思列宁主义的发展、军事理论的贡献以及对共产党的理论贡献被称为毛泽东思想。因毛泽东担任过的主要职务几乎全部称为主席，所以也被人们尊称为“毛主席”。\r\n毛泽东被视为现代世界历史中最重要的人物之一，《时代》杂志也将他评为20世纪最具影响100人之一。');
INSERT INTO `author` VALUES (3, '王珊', '王珊', 'CN', '王珊，女，1944，中国人民大学二级岗位教授 [1]  、博士生导师，国家有突出贡献的中青年专家，享受国务院政府特殊津贴。\r\n1962年考入北京大学物理系本科，1968年毕业。1981年获中国人民大学信息系计算机应用与技术工学硕士学位。1984至1986年应姚诗斌教授邀请赴美国马里兰大学合作研究，开发关系数据库管理系统XDB。中国人民大学信息学院教授、博士生导师。中国计算机学会副理事长，中国计算机学会数据库专委会主任，教育部第五届科学技术委员会委员，中国科学技术协会第六届全国委员会委员等。');
INSERT INTO `author` VALUES (4, '萨师煊', '萨师煊', 'CN', '萨师煊（1922年12月27日—2010年7月11日）计算机科学家。是中国人民大学经济信息管理系的创建人，是我国数据库学科的奠基人之一，数据库学术活动的积极倡导者和组织者。原中国计算机学会常务理事、软件专业委员会常务委员兼数据库学组组长，中国计算机学会数据库专业委员会名誉主任委员，原中国人民大学经济信息管理系主任、名誉系主任。因病医治无效，于2010年7月11日在北京逝世，享年88岁。');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '书本ID',
  `creator_uid` bigint NOT NULL COMMENT '条目创建者UID',
  `type_id` int NOT NULL DEFAULT 0 COMMENT '图书类型ID',
  `title` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '书籍标题',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍概述',
  `publisher_id` bigint NOT NULL COMMENT '出版社ID',
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '条目创建时间',
  `num_total` int NOT NULL DEFAULT 1 COMMENT '书籍总数',
  `num_available` int NOT NULL COMMENT '可用书籍数',
  `status` tinyint NOT NULL COMMENT '书籍状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_creator_uid`(`creator_uid`) USING BTREE,
  INDEX `fk_publisher_id`(`publisher_id`) USING BTREE,
  INDEX `fk_book_status`(`status`) USING BTREE,
  INDEX `fk_book_type_id`(`type_id`) USING BTREE,
  CONSTRAINT `fk_book_status` FOREIGN KEY (`status`) REFERENCES `book_status` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_book_type_id` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_creator_uid` FOREIGN KEY (`creator_uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_publisher_id` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '书籍表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 1, 4, '仲夏夜之梦', '《仲夏夜之夢》，是威廉·莎士比亞在約1590年－1596年間創作的浪漫喜劇。它描繪了以雅典大公忒修斯和希波呂忒婚禮為中心的一系列故事。包括四名​​雅典戀人和六個業餘演員的冒險經歷，而森林裡的仙子們則在背後操作它們的命運。本戲劇是莎士比亞最流行的劇本之一，在全世界都有上演。', 1, '2021-01-03 16:12:55', 100, 100, 5);
INSERT INTO `book` VALUES (2, 1, 5, '毛泽东选集', '《毛泽东选集》是1951年人民出版社出版的图书，作者是毛泽东。该书是毛泽东思想的重要载体，是毛泽东思想的集中展现，亦是对20世纪的中国影响最大的书籍之一。\r\n建国后出版的两个版本均由人民出版社负责。该书在建国前即有大量出版，1944年于邯郸创建的晋察冀日报社出版首版《毛泽东选集》。建国后共出版了五卷，编入的是毛泽东同志在新民主主义革命时期、社会主义革命和社会主义建设时期的主要著作。1991年7月1日，《毛泽东选集》一至四卷第二版出版发行。', 2, '2021-01-04 16:13:59', 20, 20, 5);
INSERT INTO `book` VALUES (3, 1, 4, '哈姆雷特', '《哈姆雷特（Hamlet）》是由英国剧作家威廉·莎士比亚创作于1599年至1602年间的一部悲剧作品。戏剧讲述了叔叔克劳狄斯谋害了哈姆雷特的父亲，篡取了王位，并娶了国王的遗孀乔特鲁德；哈姆雷特王子因此为父王向叔叔复仇。\r\n《哈姆雷特》是莎士比亚所有戏剧中篇幅最长的一部， [1]  也是莎士比亚最负盛名的剧本，具有深刻的悲剧意义。复杂的人物性格以及丰富完美的悲剧艺术手法，代表着整个西方文艺复兴时期文学的最高成就。同《麦克白》、《李尔王》和《奥赛罗》一起组成莎士比亚“四大悲剧”。', 1, '2021-01-04 16:15:26', 1, 1, 4);
INSERT INTO `book` VALUES (4, 1, 6, '数据库系统概论（第5版', '《数据库系统概论（第5版）“十二五”普通高等教育本科国家级规划教材》第1版于1983年出版，至今已修订至第5版。第5版被列入“十二五”普通高等教育本科国家级规划教材。相应课程于2004年被评为北京市精品课程，2005年被评为国家精品课程，2014年被批准为国家级精品资源共享课。\r\n\r\n《数据库系统概论（第5版）“十二五”普通高等教育本科国家级规划教材》系统全面地阐述了数据库系统的基础理论、基本技术和基本方法。全书分为4篇16章。第一篇基础篇，包括绪论、关系数据库、关系数据库标准语言SQL、数据库安全性和数据库完整性，共5章；第二篇设计与应用开发篇，包括关系数据理论、数据库设计和数据库编程，共3章；第三篇系统篇，包括关系查询处理和查询优化、数据库恢复技术、并发控制和数据库管理系统，共4章', 3, '2021-01-04 16:22:13', 50, 50, 5);

-- ----------------------------
-- Table structure for book_author_map
-- ----------------------------
DROP TABLE IF EXISTS `book_author_map`;
CREATE TABLE `book_author_map`  (
  `book_id` bigint NOT NULL COMMENT '书籍ID',
  `author_id` bigint NOT NULL COMMENT '作者ID',
  PRIMARY KEY (`book_id`, `author_id`) USING BTREE,
  INDEX `fk_book_author_map_author_id`(`author_id`) USING BTREE,
  CONSTRAINT `fk_book_author_map_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_book_author_map_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '书籍-作者关系映射表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_author_map
-- ----------------------------
INSERT INTO `book_author_map` VALUES (1, 1);
INSERT INTO `book_author_map` VALUES (2, 2);
INSERT INTO `book_author_map` VALUES (3, 3);
INSERT INTO `book_author_map` VALUES (3, 4);

-- ----------------------------
-- Table structure for book_borrow
-- ----------------------------
DROP TABLE IF EXISTS `book_borrow`;
CREATE TABLE `book_borrow`  (
  `id` bigint NOT NULL,
  `book_id` bigint NOT NULL COMMENT '书籍ID',
  `borrower_uid` bigint NOT NULL COMMENT '借书人UID',
  `borrowed_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '借书日期',
  `expected_returned_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '期望的还书日期',
  `actual_returned_at` timestamp NULL DEFAULT NULL COMMENT '实际还书日期，NULL为没还',
  `renew_num` smallint NOT NULL DEFAULT 0 COMMENT '续借次数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_borrower_uid`(`borrower_uid`) USING BTREE,
  INDEX `fk_book_id`(`book_id`) USING BTREE,
  CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_borrower_uid` FOREIGN KEY (`borrower_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '借书表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book_borrow
-- ----------------------------

-- ----------------------------
-- Table structure for book_status
-- ----------------------------
DROP TABLE IF EXISTS `book_status`;
CREATE TABLE `book_status`  (
  `id` tinyint NOT NULL,
  `description` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '书籍状态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_status
-- ----------------------------
INSERT INTO `book_status` VALUES (0, '未知异常状态');
INSERT INTO `book_status` VALUES (1, '未公开（隐藏）');
INSERT INTO `book_status` VALUES (2, '已全部损坏');
INSERT INTO `book_status` VALUES (3, '已全部过期');
INSERT INTO `book_status` VALUES (4, '已公开，不可借阅');
INSERT INTO `book_status` VALUES (5, '已公开，可借阅');

-- ----------------------------
-- Table structure for book_type
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图书类目ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类目名称',
  `parent_id` int NOT NULL DEFAULT 0 COMMENT '父级图书类目ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_book_type_parent_id`(`parent_id`) USING BTREE,
  CONSTRAINT `fk_book_type_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `book_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图书类目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES (0, '无类别', 0);
INSERT INTO `book_type` VALUES (1, '人文', 0);
INSERT INTO `book_type` VALUES (3, '工学', 0);
INSERT INTO `book_type` VALUES (4, '戏剧', 1);
INSERT INTO `book_type` VALUES (5, '政治', 1);
INSERT INTO `book_type` VALUES (6, '计算机科学', 3);

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单名称',
  `type` smallint NOT NULL COMMENT '订单类型',
  `owner_uid` bigint NOT NULL COMMENT '付款人UID',
  `should_pay` int NOT NULL COMMENT '应付金额',
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `status` tinyint NOT NULL COMMENT '订单状态',
  `expire_at` timestamp NOT NULL DEFAULT '2038-01-19 00:00:00' COMMENT '订单过期时间',
  `paid_at` timestamp NULL DEFAULT NULL COMMENT '订单支付时间,NULL为没付',
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '订单备注',
  `extra_data` json NULL COMMENT '保留备用。特定订单驱动可读的数据信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_owner_uid`(`owner_uid`) USING BTREE,
  INDEX `fk_type`(`type`) USING BTREE,
  INDEX `fk_invocie_status`(`status`) USING BTREE,
  CONSTRAINT `fk_invocie_status` FOREIGN KEY (`status`) REFERENCES `invoice_status` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_owner_uid` FOREIGN KEY (`owner_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_type` FOREIGN KEY (`type`) REFERENCES `invoice_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '账单，包括罚款' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invoice
-- ----------------------------

-- ----------------------------
-- Table structure for invoice_penalty
-- ----------------------------
DROP TABLE IF EXISTS `invoice_penalty`;
CREATE TABLE `invoice_penalty`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `invoice_id` bigint NOT NULL COMMENT '订单ID',
  `book_id` bigint NOT NULL COMMENT '书籍ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_book_id_invoice_penalty`(`book_id`) USING BTREE,
  INDEX `fk_invoice_id_invoice_penalty`(`invoice_id`) USING BTREE,
  CONSTRAINT `fk_book_id_invoice_penalty` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_invoice_id_invoice_penalty` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '罚款型订单扩展信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invoice_penalty
-- ----------------------------

-- ----------------------------
-- Table structure for invoice_status
-- ----------------------------
DROP TABLE IF EXISTS `invoice_status`;
CREATE TABLE `invoice_status`  (
  `id` tinyint NOT NULL,
  `description` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invoice_status
-- ----------------------------
INSERT INTO `invoice_status` VALUES (0, '未知异常');
INSERT INTO `invoice_status` VALUES (1, '已取消');
INSERT INTO `invoice_status` VALUES (2, '未支付');
INSERT INTO `invoice_status` VALUES (3, '已支付');

-- ----------------------------
-- Table structure for invoice_type
-- ----------------------------
DROP TABLE IF EXISTS `invoice_type`;
CREATE TABLE `invoice_type`  (
  `id` smallint NOT NULL,
  `description` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `driver` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invoice_type
-- ----------------------------
INSERT INTO `invoice_type` VALUES (0, '未知类型', '');
INSERT INTO `invoice_type` VALUES (1, '借书超期罚款', 'asshole');

-- ----------------------------
-- Table structure for log_card_access
-- ----------------------------
DROP TABLE IF EXISTS `log_card_access`;
CREATE TABLE `log_card_access`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `serial_id` bigint NOT NULL COMMENT '卡序列号',
  `is_success` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否刷卡成功',
  `time` timestamp NOT NULL COMMENT '刷卡时间',
  `machine_id` int NOT NULL DEFAULT 0 COMMENT '刷卡机器编号',
  PRIMARY KEY (`id`) USING SE_SPECIFIC
) ENGINE = ARCHIVE CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '刷卡日志（不可修改和删除）' ROW_FORMAT = Compressed;

-- ----------------------------
-- Records of log_card_access
-- ----------------------------

-- ----------------------------
-- Table structure for log_system
-- ----------------------------
DROP TABLE IF EXISTS `log_system`;
CREATE TABLE `log_system`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志来源',
  `level` enum('unknown','trace','debug','info','warn','error','fatal') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志级别',
  `time` timestamp NOT NULL COMMENT '发生事件',
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息',
  `exception` varchar(20) CHARACTER SET ascii COLLATE ascii_general_ci NULL DEFAULT NULL COMMENT '日志异常类型（简化名）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_log_system_type`(`exception`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of log_system
-- ----------------------------
INSERT INTO `log_system` VALUES (1, 'Main', 'info', '2021-01-04 22:21:11', 'System start', NULL);

-- ----------------------------
-- Table structure for log_user_login
-- ----------------------------
DROP TABLE IF EXISTS `log_user_login`;
CREATE TABLE `log_user_login`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint NOT NULL COMMENT '用户UID',
  `time` timestamp NOT NULL COMMENT '登录时间',
  `ip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录IP',
  `useragent` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户代理',
  PRIMARY KEY (`id`) USING SE_SPECIFIC
) ENGINE = ARCHIVE CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户登录日志（不可修改和删除）' ROW_FORMAT = Compressed;

-- ----------------------------
-- Records of log_user_login
-- ----------------------------

-- ----------------------------
-- Table structure for publisher
-- ----------------------------
DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '出版社ID',
  `name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '出版社名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '出版社简介',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出版社' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publisher
-- ----------------------------
INSERT INTO `publisher` VALUES (1, '测试出版社', 'None');
INSERT INTO `publisher` VALUES (2, '人民出版社', '人民出版社是中华人民共和国的一家综合出版社，主要出版哲学和社会科学的书籍，并且是中国共产党和中国政府政治、意识形态书籍的官方出版社。ISBN代码为978-7-01。 人民出版社成立于1950年12月1日，社名为中国共产党中央委员会主席毛泽东亲笔题写。');
INSERT INTO `publisher` VALUES (3, '高等教育出版社', '高等教育出版社，简称高教社，是一家直属于中华人民共和国教育部的专业教育出版机构，成立于1954年5月，主要出版高等教育、职业教育、成人及社会教育等教育类、专业类、科技类出版物。ISBN代码为978-7-04。');

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting`  (
  `key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setting
-- ----------------------------
INSERT INTO `setting` VALUES ('book_borrow_max_borrow_num', '10', '最多允许同时借书数');
INSERT INTO `setting` VALUES ('book_borrow_max_renew_num', '7', '借书最大续期次数');
INSERT INTO `setting` VALUES ('book_borrow_period_millis', '2592000000', '每次借书/续期时长（毫秒）');
INSERT INTO `setting` VALUES ('book_expire_penalty_cents_a_day', '15', '超期罚款（每天，罚款单位为分）');
INSERT INTO `setting` VALUES ('site_name', '高级图书文献管理系统', '站点名称');

-- ----------------------------
-- Table structure for task_queue
-- ----------------------------
DROP TABLE IF EXISTS `task_queue`;
CREATE TABLE `task_queue`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL,
  `finished_at` timestamp NULL DEFAULT NULL,
  `is_finished` bit(1) NOT NULL DEFAULT b'0',
  `is_success` bit(1) NOT NULL DEFAULT b'0',
  `is_doing` bit(1) NOT NULL,
  `type` smallint NOT NULL DEFAULT 0,
  `content` json NULL COMMENT '任务正文（程序可读）',
  `result` json NULL COMMENT '任务结果（程序可读）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_task`(`is_finished`, `is_success`, `is_doing`, `type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务队列（程序可读）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_queue
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint NOT NULL AUTO_INCREMENT COMMENT '用户UID',
  `serial_id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '工号/序列号',
  `email` varchar(60) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `real_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `password` char(64) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '' COMMENT 'Bcrypt密码哈希值',
  `access_level` tinyint NOT NULL DEFAULT 1 COMMENT '访问级别',
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `ip_creation` varchar(45) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '' COMMENT '创建时IP',
  `ip_login` varchar(45) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '' COMMENT '上次登录IP',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `unique_email`(`email`) USING BTREE,
  UNIQUE INDEX `unique_serial_id`(`serial_id`) USING BTREE,
  INDEX `fk_access_level`(`access_level`) USING BTREE,
  CONSTRAINT `fk_access_level` FOREIGN KEY (`access_level`) REFERENCES `user_access_level` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, '0', 'example@example.com', '[系统]', '', 0, '0000-00-00 00:00:00', 'localhost', 'localhost');
INSERT INTO `user` VALUES (1, '114514', 'kenvix@qq.com', 'Kenvix', '-', 127, '2021-01-02 12:04:44', 'localhost', 'localhost');

-- ----------------------------
-- Table structure for user_access_level
-- ----------------------------
DROP TABLE IF EXISTS `user_access_level`;
CREATE TABLE `user_access_level`  (
  `id` tinyint NOT NULL,
  `description` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户访问级别定义' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_access_level
-- ----------------------------
INSERT INTO `user_access_level` VALUES (0, '被封号');
INSERT INTO `user_access_level` VALUES (10, '普通用户');
INSERT INTO `user_access_level` VALUES (20, 'VIP用户');
INSERT INTO `user_access_level` VALUES (100, '普通管理员');
INSERT INTO `user_access_level` VALUES (127, '最高系统管理员');

-- ----------------------------
-- Table structure for user_extra
-- ----------------------------
DROP TABLE IF EXISTS `user_extra`;
CREATE TABLE `user_extra`  (
  `uid` bigint NOT NULL,
  `phone` bigint NULL DEFAULT NULL COMMENT '电话号',
  `money` int NOT NULL DEFAULT 0 COMMENT '可用钱数（单位为分）',
  `card_serial_id` bigint NULL DEFAULT NULL COMMENT '卡片序列号',
  `start_year` smallint NULL DEFAULT NULL COMMENT '入学(职)年份',
  `department` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在部门',
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注',
  PRIMARY KEY (`uid`) USING BTREE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户扩展信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_extra
-- ----------------------------
INSERT INTO `user_extra` VALUES (1, 10086, 114514, 11515, 2018, '测试学院', '好');

-- ----------------------------
-- View structure for book_author
-- ----------------------------
DROP VIEW IF EXISTS `book_author`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `book_author` AS select `book_author_map`.`book_id` AS `book_id`,`book_author_map`.`author_id` AS `author_id`,`author`.`name` AS `author_name`,`author`.`fullname` AS `author_fullname`,`author`.`country` AS `author_country`,`author`.`description` AS `author_description` from ((`book` join `book_author_map` on((`book`.`id` = `book_author_map`.`book_id`))) join `author` on((`book_author_map`.`author_id` = `author`.`id`)));

-- ----------------------------
-- View structure for book_borrow_expired
-- ----------------------------
DROP VIEW IF EXISTS `book_borrow_expired`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `book_borrow_expired` AS select `book_borrow`.`book_id` AS `book_id`,`book_borrow`.`borrower_uid` AS `borrower_uid`,`book_borrow`.`borrowed_at` AS `borrowed_at`,`book_borrow`.`expected_returned_at` AS `expected_returned_at`,`book`.`title` AS `book_title`,`user`.`email` AS `borrower_email`,`user`.`real_name` AS `borrower_real_name`,`user`.`serial_id` AS `borrower_serial_id` from ((`book_borrow` join `book` on((`book_borrow`.`book_id` = `book`.`id`))) join `user` on((`book_borrow`.`borrower_uid` = `user`.`uid`))) where ((`book_borrow`.`actual_returned_at` is null) and (`book_borrow`.`expected_returned_at` >= now()));

-- ----------------------------
-- View structure for book_borrow_for_admin
-- ----------------------------
DROP VIEW IF EXISTS `book_borrow_for_admin`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `book_borrow_for_admin` AS select `book_borrow`.`book_id` AS `book_id`,`book`.`title` AS `book_title`,`book_borrow`.`borrower_uid` AS `borrower_uid`,`book_borrow`.`borrowed_at` AS `borrowed_at`,`book_borrow`.`expected_returned_at` AS `expected_returned_at`,`book_borrow`.`actual_returned_at` AS `actual_returned_at`,`user`.`real_name` AS `borrower_real_name`,`user`.`serial_id` AS `borrower_serial_id`,`book_borrow`.`renew_num` AS `renew_num` from ((`book` join `book_borrow` on((`book`.`id` = `book_borrow`.`book_id`))) join `user` on((`book_borrow`.`borrower_uid` = `user`.`uid`)));

-- ----------------------------
-- View structure for book_for_user
-- ----------------------------
DROP VIEW IF EXISTS `book_for_user`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `book_for_user` AS select `book`.`id` AS `id`,`book`.`title` AS `title`,`book`.`description` AS `description`,`book`.`publisher_id` AS `publisher_id`,`book`.`created_at` AS `created_at`,`book`.`num_total` AS `num_total`,`book`.`num_available` AS `num_available`,`book`.`status` AS `status`,`publisher`.`name` AS `publisher_name`,`book_author_map`.`author_id` AS `author_id`,group_concat(`author`.`name` separator ', ') AS `author_name`,group_concat(`author`.`fullname` separator ', ') AS `author_fullname`,group_concat(`author`.`country` separator ', ') AS `author_country`,`book`.`creator_uid` AS `creator_uid`,`book`.`type_id` AS `type_id`,`book_type`.`name` AS `type_name` from ((((`book` join `publisher` on((`book`.`publisher_id` = `publisher`.`id`))) left join `book_author_map` on((`book_author_map`.`book_id` = `book`.`id`))) join `author` on((`book_author_map`.`author_id` = `author`.`id`))) join `book_type` on((`book`.`type_id` = `book_type`.`id`))) where (`book`.`status` >= 4) group by `book`.`id`;

-- ----------------------------
-- View structure for invoice_for_user
-- ----------------------------
DROP VIEW IF EXISTS `invoice_for_user`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `invoice_for_user` AS select `invoice`.`id` AS `id`,`invoice`.`name` AS `name`,`invoice`.`type` AS `type`,`invoice`.`owner_uid` AS `owner_uid`,`invoice`.`should_pay` AS `should_pay`,`invoice`.`created_at` AS `created_at`,`invoice`.`status` AS `status`,`invoice_status`.`description` AS `status_description`,`invoice`.`expire_at` AS `expire_at`,`invoice`.`paid_at` AS `paid_at`,`invoice`.`comment` AS `comment`,`invoice`.`extra_data` AS `extra_data`,`invoice_type`.`description` AS `type_description`,`invoice_type`.`driver` AS `type_driver` from ((`invoice` join `invoice_status` on((`invoice`.`status` = `invoice_status`.`id`))) join `invoice_type` on((`invoice`.`type` = `invoice_type`.`id`)));

-- ----------------------------
-- View structure for log_card_access_for_admin
-- ----------------------------
DROP VIEW IF EXISTS `log_card_access_for_admin`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `log_card_access_for_admin` AS select `log_card_access`.`serial_id` AS `serial_id`,`user_extra`.`card_serial_id` AS `card_serial_id`,`user`.`uid` AS `uid`,`log_card_access`.`time` AS `time`,`log_card_access`.`machine_id` AS `machine_id`,`user`.`email` AS `email`,`user`.`real_name` AS `real_name` from ((`log_card_access` join `user_extra` on((`log_card_access`.`serial_id` = `user_extra`.`card_serial_id`))) join `user` on(((`user_extra`.`uid` = `user`.`uid`) and (`user_extra`.`uid` = `user`.`uid`))));

-- ----------------------------
-- View structure for log_user_login_for_admin
-- ----------------------------
DROP VIEW IF EXISTS `log_user_login_for_admin`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `log_user_login_for_admin` AS select `user`.`created_at` AS `created_at`,`user`.`access_level` AS `access_level`,`user`.`real_name` AS `real_name`,`user`.`email` AS `email`,`user`.`serial_id` AS `serial_id`,`user`.`uid` AS `uid`,`log_user_login`.`ip` AS `ip`,`log_user_login`.`time` AS `time`,`log_user_login`.`useragent` AS `useragent` from (`log_user_login` join `user` on((`log_user_login`.`uid` = `user`.`uid`)));

-- ----------------------------
-- View structure for user_for_admin
-- ----------------------------
DROP VIEW IF EXISTS `user_for_admin`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_for_admin` AS select `user`.`uid` AS `uid`,`user`.`serial_id` AS `serial_id`,`user`.`email` AS `email`,`user`.`real_name` AS `real_name`,`user`.`password` AS `password`,`user`.`access_level` AS `access_level`,`user_access_level`.`description` AS `access_level_description`,`user`.`created_at` AS `created_at`,`user_extra`.`phone` AS `phone`,`user_extra`.`money` AS `money`,`user_extra`.`card_serial_id` AS `card_serial_id`,`user_extra`.`start_year` AS `start_year`,`user_extra`.`department` AS `department`,`user_extra`.`comment` AS `comment`,`user`.`ip_creation` AS `ip_creation`,`user`.`ip_login` AS `ip_login` from ((`user` left join `user_extra` on((`user`.`uid` = `user_extra`.`uid`))) join `user_access_level` on((`user`.`access_level` = `user_access_level`.`id`)));

-- ----------------------------
-- Procedure structure for book_borrow
-- ----------------------------
DROP PROCEDURE IF EXISTS `book_borrow`;
delimiter ;;
CREATE PROCEDURE `book_borrow`(IN book_id_v bigint, IN borrower_uid_v bigint,
                                                   IN expected_returned_at_v timestamp, OUT insert_id bigint)
BEGIN
    #Routine body goes here...
    DECLARE remain_book_num int;
    DECLARE book_status tinyint;
    DECLARE user_access_level tinyint;

    START TRANSACTION;
    SELECT user_access_level INTO user_access_level FROM `user` WHERE uid = borrower_uid_v LOCK IN SHARE MODE;
    IF (user_access_level IS NULL OR user_access_level <= 10) THEN
        CALL raise_error('Access denied', 403);
    END IF;

    SELECT num_available, `status` INTO remain_book_num, book_status FROM book WHERE book.id = book_id_v FOR UPDATE;
    IF (book_status <> 5 OR remain_book_num <= 0) THEN
        CALL raise_error('This book cannot be borrowed because there is no stock', 3001);
    END IF;

    INSERT INTO book_borrow(book_id, borrower_uid, borrowed_at, expected_returned_at) VALUES (borrower_uid_v, book_id_v, NOW(), expected_returned_at_v);
    SELECT LAST_INSERT_ID() INTO insert_id;
    SET remain_book_num = remain_book_num - 1;
    UPDATE book SET num_available = remain_book_num WHERE id = `book_id_v`;
    COMMIT WORK;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for book_borrower_has_expired
-- ----------------------------
DROP FUNCTION IF EXISTS `book_borrower_has_expired`;
delimiter ;;
CREATE FUNCTION `book_borrower_has_expired`(`user_uid` bigint)
 RETURNS bit(1)
  DETERMINISTIC
BEGIN
	#Routine body goes here...
	DECLARE result bit(1);
	SELECT EXISTS(SELECT * FROM book_borrow_expired WHERE book_borrow_expired.borrower_uid = user_uid) INTO result;
	RETURN result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for book_borrow_renew
-- ----------------------------
DROP PROCEDURE IF EXISTS `book_borrow_renew`;
delimiter ;;
CREATE PROCEDURE `book_borrow_renew`(IN borrow_id bigint, OUT next_expected_return timestamp)
BEGIN
	#Routine body goes here...
    DECLARE book_id bigint;
	DECLARE borrower_uid bigint;
	DECLARE expected_returned_at TIMESTAMP;
	DECLARE book_borrow_period_millis BIGINT;
	DECLARE renew_num SMALLINT;
	DECLARE max_renew_num SMALLINT;
	
	START TRANSACTION;
	
	SELECT book_borrow.borrower_uid, book_borrow.book_id, book_borrow.expected_returned_at, renew_num
	INTO borrower_uid, book_id, expected_returned_at, renew_num
	FROM book_borrow
	WHERE book_borrow.id = borrow_id AND book_borrow.actual_returned_at IS NULL AND book_borrow.expected_returned_at <= NOW()
	FOR UPDATE;
	
	IF (borrower_uid IS NULL OR (expected_borrower_uid IS NOT NULL AND borrower_uid != expected_borrower_uid) OR expected_returned_at IS NULL) THEN
		CALL raise_error('No such book found, or book has been expired or returned', 404);
	END IF;
	
	SELECT `value` INTO max_renew_num FROM setting WHERE `key` = 'book_borrow_max_renew_num';
	
	IF (renew_num >= max_renew_num) THEN
		CALL raise_error('You have reached max renew num.', 403);
	END IF;
	
	SELECT get_setting('book_borrow_period_millis') INTO book_borrow_period_millis;
	SELECT FROM_UNIXTIME(book_borrow_period_millis / 1000 + UNIX_TIMESTAMP()) INTO expected_returned_at;
	UPDATE book_borrow SET renew_num = renew_num + 1, expected_returned_at = expected_returned_at WHERE id = borrow_id;
	
	SELECT expected_returned_at INTO next_expected_return;
	COMMIT WORK;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for book_borrow_return
-- ----------------------------
DROP PROCEDURE IF EXISTS `book_borrow_return`;
delimiter ;;
CREATE PROCEDURE `book_borrow_return`(IN borrow_id bigint, IN required_money int)
BEGIN
    #Routine body goes here...
    declare user_money int;
    declare book_id bigint;
    declare borrower_uid bigint;
    declare now timestamp;

    start transaction;

    select borrower_uid, book_id into borrower_uid, book_id from book_borrow where book_borrow.id = borrow_id for update;
    select money into user_money from user_extra where user_extra.uid = borrower_uid for update;
    if user_money < required_money then
        call raise_error('Your money is not enough, please charge your account first.');
    end if;

    select NOW() into now;
    update book set num_available = num_available + 1 where book.id = book_id;
    update book_borrow set actual_returned_at = now where book_borrow.id = borrow_id;
    update user_extra set money = money - required_money where user_extra.uid = borrower_uid;

    insert into invoice(name, type, owner_uid, should_pay, created_at, status, expire_at, paid_at)
    values('Overdue penality', 1, borrower_uid, required_money, now, now + 1, now);

    insert into invoice_penalty(invoice_id, book_id)
    values(get_last_insert_id(), book_id);

    commit work;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for book_borrow_unreturned_num
-- ----------------------------
DROP FUNCTION IF EXISTS `book_borrow_unreturned_num`;
delimiter ;;
CREATE FUNCTION `book_borrow_unreturned_num`(`borrower_uid` bigint)
 RETURNS int
  DETERMINISTIC
BEGIN
	#Routine body goes here...
	DECLARE result INT;
	SELECT COUNT(*) INTO result FROM book_borrow WHERE book_borrow.borrower_uid = borrower_uid AND book_borrow.actual_returned_at IS NULL;
	RETURN result;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for get_last_insert_id
-- ----------------------------
DROP FUNCTION IF EXISTS `get_last_insert_id`;
delimiter ;;
CREATE FUNCTION `get_last_insert_id`()
 RETURNS bigint
  DETERMINISTIC
BEGIN
    #Routine body goes here...
    DECLARE result BIGINT;
    SELECT LAST_INSERT_ID() INTO result;
    RETURN result;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for get_setting
-- ----------------------------
DROP FUNCTION IF EXISTS `get_setting`;
delimiter ;;
CREATE FUNCTION `get_setting`(`key_v` varchar(30))
 RETURNS text CHARSET utf8mb4
  DETERMINISTIC
BEGIN
	#Routine body goes here...
	DECLARE res TEXT;
	SELECT `value` INTO res FROM setting WHERE `key` = `key_v`;
	RETURN res;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for raise_error
-- ----------------------------
DROP PROCEDURE IF EXISTS `raise_error`;
delimiter ;;
CREATE PROCEDURE `raise_error`(IN error_message varchar(255), IN error_id smallint)
BEGIN
	#Routine body goes here...
	SIGNAL SQLSTATE '45233' SET MESSAGE_TEXT = `error_message`, MYSQL_ERRNO = error_id;
	ROLLBACK WORK;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for test
-- ----------------------------
DROP PROCEDURE IF EXISTS `test`;
delimiter ;;
CREATE PROCEDURE `test`(OUT max_renew_num smallint)
BEGIN
	#Routine body goes here...
	SELECT `value` INTO max_renew_num FROM setting WHERE `key` = 'book_borrow_max_renew_num';
	
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for user_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `user_add`;
delimiter ;;
CREATE PROCEDURE `user_add`(IN v_serial_id VARCHAR(80),
    IN v_email VARCHAR(80),
    IN v_real_name VARCHAR(80),
    IN v_password CHAR(64),
    IN v_access_level TINYINT,
    IN v_ip_creation  VARCHAR(45),
		OUT insert_id BIGINT)
BEGIN
    START TRANSACTION;
    INSERT INTO book.user(serial_id, email, real_name, password, access_level, created_at, ip_creation, ip_login)
    VALUES (v_serial_id, v_email, v_real_name, v_password, v_access_level, NOW(),v_ip_creation, v_ip_creation);
		SELECT LAST_INSERT_ID() INTO insert_id;
    COMMIT WORK;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for user_delete
-- ----------------------------
DROP PROCEDURE IF EXISTS `user_delete`;
delimiter ;;
CREATE PROCEDURE `user_delete`(IN uid_v bigint)
BEGIN
	#Routine body goes here...
    DECLARE user_role TINYINT;
	START TRANSACTION;
    SELECT access_level INTO user_role WHERE uid = uid_v FOR UPDATE;
	IF user_role >= 100 THEN
        CALL raise_error('Cannot delete administrator directly.', 403);
    END IF;

	DELETE FROM `user` WHERE uid = `uid_v`;
    COMMIT WORK;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
