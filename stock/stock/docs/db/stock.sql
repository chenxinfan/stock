SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `sku_order_01`;
CREATE TABLE `sku_order_01`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `order_id` int(21) NOT NULL,
                                 `sku_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE INDEX `uni_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `sku_stock_01`;
CREATE TABLE `sku_stock_01`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `sku_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                 `stock` int(11) NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE INDEX `uni_sku`(`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
