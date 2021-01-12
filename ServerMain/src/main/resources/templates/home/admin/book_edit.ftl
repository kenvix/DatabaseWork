<#import "../../common/layout.ftl" as layout />
<@layout.layout title="添加或编辑图书">
    <!-- Begin Page code -->
    <!-- Notice: This front-end view is combined Add and Edit books        by:Kenvix -->
    <div class="container container-main flex-grow-1">
    <div class="row">
    <!-- 侧边导航，宽屏设备可见 -->
    <div class="col-lg-3">
        <div class="card hidden-print d-none d-lg-block nav-side" role="complementary" >
            <ul class="nav flex-column">
                <li class="nav-item"><a class="nav-link" href="https://www.moecraft.net" target="_blank">主页</a></li>
                <li class="nav-item"><a class="nav-link" href="/user/login"> 登录</a></li>
                <li class="nav-item"><a class="nav-link" href="/user/register"> 注册</a></li>
                <li class="nav-item"><a class="nav-link" href="/Home/Apply/applyInviteCode"> 申请邀请码</a></li>
                <li class="nav-item"><a class="nav-link" href="/user/password_reset"> 忘记密码</a></li>
                <li class="nav-item"><a class="nav-link" href="/Doc/Public/duoshuo">评论</a></li>
                <li class="nav-item"><a class="nav-link" href="/Doc/Public/status">实时服务器状态</a></li>
                <li class="nav-item"><a class="nav-link" href="/Doc/Public/play">了解 library</a></li>
                <!--<li class="nav-item"><a class="nav-link" href="/Home/Mc/about">关于</a></li>-->    </ul>
        </div>
        <script type="text/javascript">
            $(".nav-link[href$='/Home/User/login']").addClass('active');
        </script>
    </div>
    <div class="col-lg main" role="main" >
        <div class="card">
            <div class="card-header">
                <#if book??>
                    编辑图书 #${book.getId()}
                    <#else>
                    添加新图书
                </#if>
            </div>

            <div class="card-body" id="loginData">
                <form action="" method="post" enctype="application/x-www-form-urlencoded">
                    <div class="form-group">
                        <label for="book-title">书名</label>
                        <input type="text" class="form-control" name="title" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                    </div>

                    <div class="form-group">
                        <label for="book-type_id">图书类目</label>
                        <select class="form-control" name="type_id" id="book-type_id" required="required">
                            <#list bookTypeMap as topId, topBookType>
                                <optgroup label="${topBookType.getName()}">
                                    <option value="${topId}" <#if (book?? && book.getTypeId() == topId)>selected</#if>>(直接使用) ${topBookType.getName()}</option>
                                    <#list topBookType.getChildMap() as secondId, secondBookType>
                                        <option value="${secondId}" <#if (book?? && book.getTypeId() == secondId)>selected</#if>>${secondBookType.getName()}</option>
                                    </#list>
                                </optgroup>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="book-status">图书状态</label>
                        <select class="form-control" name="num_total" id="book-status" required="required">
                            <#list bookStatusMap as id, description>
                                <option value="${id}" <#if (book?? && book.getStatus() == id)>selected</#if>>${description}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="book-publisher_id">出版社</label>
                        <select class="form-control" name="publisher_id" id="book-publisher_id" required="required">
                            <#list publisherMap as id, publisher>
                                <option value="${id}" <#if (book?? && book.getPublisherId() == id)>selected</#if>>${publisher.getName()}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="book-description">图书简述</label>
                        <textarea name="description" style="height: 10em;" class="form-control" id="book-description" placeholder="拖动文本框右下角可改变大小"><#if book??>${book.getDescription()}</#if></textarea>
                    </div>

                    <div class="form-group">
                        <label for="book-authors_text">作者（每行一个）</label>
                        <textarea name="authors_text" style="height: 6em;" class="form-control" id="book-authors_text" placeholder="每行一个作者名称。拖动文本框右下角可改变大小"><#if book??><#list authors as author>${author.getAuthorName()}
</#list></#if></textarea>
                    </div>

                    <div class="form-group">
                        <label for="book-created_at">入馆时间</label>
                        <input type="datetime-local" class="form-control" name="created_at" id="book-created_at" value="${book_created_at!""}" placeholder="默认为当前时间" title="入馆时间，默认为当前时间">
                    </div>

                    <div class="form-group">
                        <label for="book-num_total">馆藏数目</label>
                        <input type="number" class="form-control" name="num_total" min="0" id="book-num_total" value="<#if book??>${book.getNumTotal()}</#if>" placeholder="必填" required="required">
                    </div>

                    <div class="form-group">
                        <label for="book-num_available">可供读者借阅数</label>
                        <input type="number" class="form-control" name="num_available" min="0" id="book-num_available" value="<#if book??>${book.getNumAvailable()}</#if>" placeholder="必填" required="required">
                    </div>

                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" name="remember" id="rem" value="1">
                            <label class="custom-control-label" for="rem">自动创建尚不存在的作者</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" name="remember" id="rem" value="1">
                            <label class="custom-control-label" for="rem">自动创建尚不存在的出版社</label>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-success">提交图书</button>
                </form>
            </div>
        </div>
    </div>
    </div>
    </div>

    <!-- End of page code -->
</@layout.layout>