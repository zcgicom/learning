-- 消息表
-- 存储用户发送的内容，图片存地址
CREATE TABLE `t_moments_timeline` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT,
  `uid` bigint(15) DEFAULT NULL COMMENT '用户id',
  `fmid` bigint(15) DEFAULT NULL COMMENT '朋友圈信息id',
  `is_own` int(1) DEFAULT '0' COMMENT '是否是自己的',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
)

-- 时间轴表
-- 时间轴表在朋友圈中是最关键的，存储着所有用的时间轴信息，因为当用户去拉取好友圈的时候，查询的就是本表.
-- is_own字段用来区分当前数据是自己的发布还是好友发布的消息
CREATE TABLE `t_moments_timeline` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT,
  `uid` bigint(15) DEFAULT NULL COMMENT '用户id',
  `fmid` bigint(15) DEFAULT NULL COMMENT '朋友圈信息id',
  `is_own` int(1) DEFAULT '0' COMMENT '是否是自己的',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
)


-- 评论表
-- 记录评论和点赞数
CREATE TABLE `t_moments_comment` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT,
  `fmid` bigint(15) DEFAULT NULL COMMENT '朋友圈信息id',
  `uid` bigint(15) DEFAULT NULL COMMENT '用户id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `like_count` int(10) DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`id`)
)

-- 当用户发布一条朋友圈消息的时候，后端逻辑的处理（A和B已经是好友关系）：
-- 1.用户A在朋友圈中发布一条消息，消息表t_moments_message写入一条数据
-- 2.时间轴表t_moments_timeline中增加一条数据，uid设置A，is_own设置为1，表示在A的时间轴中增加一条自己发布的消息
-- 3.查询用户A的好友，查到用户B（如果还有其他好友D、E等,采取同样处理）
-- 4.时间轴表t_moments_timeline中增加一条数据，uid设置B，is_own设置为0，表示在B的时间轴中增加一条好友发布的消息

-- 若用户A与用户C进行好友添加操作：
  INSERT INTO t_moments_timeline (uid,fmid,is_own,create_time)
            SELECT #{uid},`id`,0,create_time FROM t_moments_message WHERE uid = #{fid};
-- 把消息表t_moments_message中好友C发布的消息添加到自己的时间轴中
-- 再把消息表t_moments_message中自己发布的消息添加到好友C的时间轴中
-- 使用好is_own字段，因为都是互相添加好友的消息到自己的时间轴中，所以都应该为0

