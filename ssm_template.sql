CREATE DATABASE `ssm_template_db` if not exists
use `ssm_template_db`

CREATE TABLE `t_goods` (
   `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `created_at` timestamp NULL DEFAULT NULL COMMENT '列创建时间',
   `updated_at` timestamp NULL DEFAULT NULL COMMENT '列更新时间',
   `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
   `good_type` varchar(100) DEFAULT NULL COMMENT '商品类型',
   `price` int DEFAULT NULL COMMENT '商品价格',
   `manufacturing` timestamp NULL DEFAULT NULL COMMENT '生产日期',
   PRIMARY KEY (`id`)
) COMMENT='商品表'