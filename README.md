# online-education
在线教育平台后端
## 目录结构
api层
bus层
common层
biz层



- biz
- 多模块
  service
  dao
  mapper
- bus

api -> bus -> biz (模块内部使用entity，返回给bus，用其他dto)