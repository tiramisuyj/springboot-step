一 jdbc模块修改内容：
1.引入依赖：
mysql-connector-java:MySql连接Java的驱动程序
spring-boot-starter-jdbc:支持通过JDBC连接数据库
<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
2.配置信息：
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springbootstep?characterEncoding=utf-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yj123!@#
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
3.建表语句和sql：
-- ----------------------------
-- Table structure for ay_user
-- ----------------------------
DROP TABLE IF EXISTS `ay_user`;
CREATE TABLE `ay_user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ay_user
-- ----------------------------
INSERT INTO `ay_user` VALUES ('1', '阿毅', '123456');
INSERT INTO `ay_user` VALUES ('2', '阿兰', '123456');

