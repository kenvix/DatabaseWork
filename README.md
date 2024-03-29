<p style="text-align: center; font-weight:bold; font-size:2.3em;">
高级图书管理系统
详细设计说明书
</p>

**用词说明**：以下说明文档中的 *输入*，对于 Web后端模块，均指通过 [URL Query String](https://en.wikipedia.org/wiki/Query_string) 、[Cookie](https://en.wikipedia.org/wiki/HTTP_cookie) 或以 HTML `application/x-www-form-urlencoded` 或 `multipart/form-data` 形式提交的表单；对于 API，则指通过 API 请求，配合所需 HTTP 谓词提交的 `application/x-www-form-urlencoded` 或 `multipart/form-data`  [表单](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form) 。以下说明文档中的 *输出*，对于Web后端模块，均指通过模板变量向前端传送的对象；对于 API，则指 [JSON](https://en.wikipedia.org/wiki/JSON) 对象。

以上说明中的名词均是链接，可点击查看详细。[URI](https://en.wikipedia.org/wiki/Uniform_Resource_Identifier)

# Web 后端模块

## 本模块全局模板变量

**说明**：以下所有变量表中，类型后面带有问号 `?` 表示这个变量的值可能为 `null`，不带有问号表示不可能为 `null`。`Any` 类型表示可以为任何值，但是不可为 `null`，`Any?` 类型表示可以为任何值，也可为 `null`。输入变量表的类型有问号还意味着这个输入是可选的。

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| public | String | 公共静态资源文件所在路径，值一般为 /public |
| siteName | String | 站点名称，取决于数据库中 Setting 表同名项的值 |
| user | User? | 当用户登录后，此变量指向包含当前用户所有基本信息的对象。若未登录则为 `null`。完整名称为 `com.kenvix.bookmgr.orm.tables.pojos.User` |
| msg | String? | 原样包含用户通过 URL Query String 传入的 msg 变量（ i.e. `/user/login?msg=密码错误`）。一般用于展示某个信息，例如登录页面上通知用户密码错误。此字段已经经过编码确保不会发生 XSS。此处展示的信息应简洁易懂，只允许纯文本，不允许超过 256 个字。 |
| page | Int? | 原样包含用户通过 URL Query String 传入的 page 变量，表示当前页码 ( i.e. /book?page=3 )。一般在包含多页的信息时出现，例如展示图书列表时 |

**备注**：包 `com.kenvix.bookmgr.orm.tables.pojos` 下的所有类的均为对数据库对象的直接映射，命名和数据类型均和数据库对应，只是将 小写和下划线 的命名替换为 驼峰命名（表为大驼峰，字段为小驼峰）。此外，所有 POJO 和数据对象的访问都应该通过 `getXXX()`, `setXXX(value)` 进行

**命名风格**：本模块中，URI 以 `/action` 结尾的一般表示对应功能的动作部分；不带 `/action` 的则为展示部分，用于展示前端页面。为防止用户重复执行操作，以 `/action` 结尾的动作部分没有前端页面，也不会停留，始终会通过跳转或JSON的形式转到展示部分。

## 用户部分

### 登录

**登录页面 URI**：`/user/login` 

**页面模板路径**：`home/user/login.ftl`

**登录过程 URI**：`/user/login/action`

**输入方式**：HTTP POST `/user/login/action` (MIME `application/x-www-form-urlencoded`)

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| username | String | 学号或邮箱 |
| password | String | 密码 |
| remember | Any? | 是否保持登录 30 天，这个字段非 Null 则视为保持登录 |

**输出行为**：当登录失败时，跳转回 *登录页面*，并附加 `msg` 参数告知原因；当登录成功时，将会命令浏览器设置一个名为 `Token` 的 Cookie，并直接跳转到首页

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ---------- | ---------- | ---------------------- |
| msg | URL Query String | String | 用户登录失败说明 | 
| Token | Cookie | String | 当用户登录成功时由服务器命令客户端设置。用户登录凭证，由后端签名颁发。凭此凭证可以证明用户已经登录 |

### 登出

**登出过程 URI**：`/user/logout/action`

**输入方式**：HTTP POST `/user/logout/action` 

**输入变量表**：无

**输出行为**：当登出成功时，转 *登录页面* 并带有 `msg` 提示登出成功

### 注册

**注册页面 URI**：`/user/register`

**页面模板路径**：`home/user/register.ftl`

**注册过程 URI**：`/user/register/action`

**输入方式**：HTTP POST `/user/register/action` (MIME `application/x-www-form-urlencoded`)

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| username | String | 学号 |
| realName | String | 真实姓名 |
| email | String | 邮箱地址 |
| password | String | 密码 |

**输出行为**：当注册失败时，跳转回 *注册页面*，并附加 `msg` 参数告知原因；当注册成功时，转 *登录页面*，并附加 `msg` 参数告知注册成功

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ---------- | ---------- | ---------------------- |
| msg | URL Query String | String | 用户注册结果说明 | 

### 忘记密码(密码重置)

### 个人资料修改

**资料页面 URI**：`/user/profile`

**页面模板路径**：`home/user/profile.ftl`

**资料修改过程 URI**：`/user/profile/action`

**输入方式**：HTTP POST `/user/profile/action` (MIME `application/x-www-form-urlencoded`)

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| email | String | 新邮箱地址 |
| password | String | 新密码 |

**输出行为**：始终跳转到 *资料页面*，并附加 `msg` 参数告知结果

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ---------- | ---------- | ---------------------- |
| msg | URL Query String | String | 用户操作结果说明 | 

### 个性化设置

**个性化页面 URI**：`/user/personalize`

**页面模板路径**：`home/user/personalize.ftl`

此功能没有 `/action` 动作后端

## 读者图书借阅

以下功能都需要登录使用。因此对未登录用户完全隐藏

### 列出所有图书（用户视角）

**页面 URI**：`/reader/book`

**页面模板路径**：`home/reader/book_list.ftl`

**输入方式**： URL Query String

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| filter_title | String? | 按标题过滤图书 |
| filter_publisher | String? 或 Long? | 按出版社名称或者出版社ID过滤图书 |
| filter_description | String? | 按图书描述过滤图书 |
| filter_available | Any? | 按图书是否可以借阅过滤图书，非 Null 表示只显示可借阅图书 |
| filter_type | String? | 按图书类型名过滤图书 |
| filter_author | String? 或 Long? | 按作者名或作者ID过滤图书 |
| page | Int? | 图书列表页码 |

**输出变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| books | List\<BookForUser\> | 符合条件的图书列表。完整名称为 `com.kenvix.bookmgr.orm.tables.pojos.BookForUser` |

### 搜索图书页面

**页面 URI**：`/reader/book/search`

**页面模板路径**：`home/reader/book_search.ftl`

无输入

**说明**：这个页面应提供搜索表单，其表单动作目标就是 *列出所有图书（用户视角）*，动作方式为 GET

### 查看图书详情

**页面 URI**：`/reader/book/{bookId}` （**注：** `{bookId}` 表示此处为变量 bookId）

**页面模板路径**：`home/reader/book_detail.ftl`

**输入方式**：URL Path

**输入变量表**

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ----- | ---------- | ---------------------- |
| bookId | URL Path | Long | 图书 ID |

**输出变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| book | BookForUserAndAuthors | 图书和作者信息，完整名称为 `com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors` |

**数据对象 BookForUserAndAuthors**

| 字段 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| book | BookForUser | 图书信息，完整名称为 `com.kenvix.bookmgr.orm.tables.pojos.BookForUser` |
| authors | List\<BookAuthor\> | 所有作者信息，完整名称为 `com.kenvix.bookmgr.orm.tables.pojos.generic.BookAuthor` |

### 列出已借图书

> 前端实现注意：此功能可以和读者图书借阅的列出所有图书共享同一套前端模板

**页面 URI**：`/reader/book/borrow`

无输入

**输出变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| books | List\<BookBorrowForAdmin\> | 符合条件的图书列表，包含借书信息。完整名称为 `com.kenvix.bookmgr.orm.tables.pojos.BookBorrowForAdmin` |

### 借书

**URI**：`/reader/book/borrow/borrow`

**输入方式**：HTTP POST /user/book/borrow/borrow (MIME application/x-www-form-urlencoded)

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| borrow_id | Long | 借书 ID |

**输出行为**：始终跳转到 *列出已借图书*，并附加 `msg` 参数告知结果

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ---------- | ---------- | ---------------------- |
| msg | URL Query String | String | 用户操作结果说明 | 


### 还书

**URI**：`/reader/book/borrow/return`

**输入方式**：HTTP POST /user/book/borrow/return (MIME application/x-www-form-urlencoded)

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| borrow_id | Long | 借书 ID |

**输出行为**：始终跳转到 *列出已借图书*，并附加 `msg` 参数告知结果

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ---------- | ---------- | ---------------------- |
| msg | URL Query String | String | 用户操作结果说明 | 

### 图书续期

**URI**：`/reader/book/borrow/renew`

**输入方式**：HTTP POST /user/book/borrow/renew (MIME application/x-www-form-urlencoded)

**输入变量表**

| 变量名 | 类型 | 说明 |
| ---- | ---------- | ---------------------- |
| borrow_id | Long | 借书 ID |

**输出行为**：始终跳转到 *列出已借图书*，并附加 `msg` 参数告知结果

| 变量名 | 形式 | 类型 | 说明 |
| ---- | ---------- | ---------- | ---------------------- |
| msg | URL Query String | String | 用户操作结果说明 | 

### 查看作者信息

### 查看出版社信息

## 图书管理

以下功能都需要登录且必须具有管理权限 (`user.getAccessLevel() >= 100`) 使用。因此应对未登录用户和权限不足的用户完全隐藏

列出所有作者、列出所有出版社功能和上节一致，管理模块只是提供增删改功能。

### 列出所有图书（管理员视角）

> 前端实现注意：此功能可以和读者图书借阅的列出所有图书共享同一套前端模板

**页面 URI**：`/admin/book`

输入、输出变量表同读者图书借阅的 *列出所有图书*

### 增加图书



### 编辑图书

### 删除图书

# API 模块

API 模块用于系统和其他第三方程序交互