# player-match-backend 球员匹配系统
🏀篮球球员简易匹配系统 👭组队功能

## 项目简介
基于 SpringBoot + Vue + redis 的移动端网站，实现了按标签检索球员、匹配打法相似球员、组队等功能。

主页：

![](https://github.com/ketion18/player-match-backend/blob/main/doc/index.png?raw=true)

匹配打法相似球员：

![](https://github.com/ketion18/player-match-backend/blob/main/doc/index_match.png?raw=true)

按标签搜索球员：

![](https://github.com/ketion18/player-match-backend/blob/main/doc/search.png?raw=true)
搜索结果:
![](https://github.com/ketion18/player-match-backend/blob/main/doc/search_player.png?raw=true)

公开球队：

![](https://github.com/ketion18/player-match-backend/blob/main/doc/publicteam.png?raw=true)

创建球队:

![](https://github.com/ketion18/player-match-backend/blob/main/doc/create_team.png?raw=true)

## 主要工作
1.使用 Redis 实现分布式 Session，解决集群间登录态同步问题；
2.通过自定义线程池 + CompletableFuture 并发编程提高批量导入数据库的性能。实测导入 100 万行的时间从 10 秒缩短至 3 秒。
3.使用 Redis 缓存首页高频访问的用户信息列表 ,为解决首次访问系统的用户主页加载过慢的问题，使用 Spring Scheduler 定时任务来实现缓存预热，并通过分布式锁保证多机部署时定时任务不会重复执行。
4.为解决同一用户重复加入队伍、入队人数超限的问题，使用 Redisson 分布式锁来实现操作互斥，保证了接口幂等性。
5.使用编辑距离算法实现了根据标签匹配最相似用户的功能。
6.自主编写 Dockerfile，并通过第三方容器托管平台实现自动化镜像构建及容器部署，提高部署上线效率。
7.使用 Knife4j + Swagger 自动生成后端接口文档，并通过编写 ApiOperation 等注解补充接口注释，避免了人工编写维护文档的麻烦。