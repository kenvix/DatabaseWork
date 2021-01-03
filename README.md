# API Paths

## 会话

* 登录 POST /api/session
* 注销 DELETE /api/session

## 用户

* 注册 POST /api/user
* 获取当前用户信息 GET /api/user
* 获取指定用户信息 GET /api/user/{userId}
* 更新指定用户信息 PUT /api/user/{userId}
* 删除指定用户信息 DELETE /api/user/{userId}

## 学生端

* 获取当前所有考试 GET /api/exam/student/examine
* 获取指定考试信息。学生端对于进行中的考试，此接口会产生副作用（视为学生参与考试并开始倒计时） GET /api/exam/student/examine/{id}
* 交卷 PUT /api/exam/student/examine/{id}
* 记录日志、自动保存答案、随机拍照 WebSocket\<ProtoBuf\> /api/exam/student/log

## 教师端

* 获取当前所有考试 GET /api/exam/teacher/examine
* 获取指定考试信息。教师端不会产生副作用。 GET /api/exam/student/teacher/examine/{id}
* 编辑考试完整信息（例如考试内容） PUT /api/exam/student/teacher/examine/{id}
* 编辑考试某些信息（例如提前终止考试） PATCH /api/exam/student/teacher/examine/{id}
* 删除考试 PUT /api/exam/student/teacher/examine/{id}
* 新建考试 POST /api/exam/student/teacher/examine

### WebSocket ProtoBuf (简称 WS PB)
