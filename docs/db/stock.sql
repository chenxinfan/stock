CREATE TABLE `sku_stock_01`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `sku_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                 `stock` int(11) NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE INDEX `uni_sku`(`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `transaction_code_01`  (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `transaction_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                        `sku_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                        PRIMARY KEY (`id`) USING BTREE,
                                        UNIQUE INDEX `uni_transaction_code`(`transaction_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `sku_stock_02`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `sku_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                 `stock` int(11) NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE INDEX `uni_sku`(`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `transaction_code_02`  (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `transaction_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                        `sku_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                        PRIMARY KEY (`id`) USING BTREE,
                                        UNIQUE INDEX `uni_transaction_code`(`transaction_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;