<#import "../../common/layout.ftl" as layout />
<@layout.layout title="添加或编辑图书">
    <!-- Begin Page code -->
    <!-- Notice: This front-end view is combined Add and Edit books ——Kenvix -->

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
                <form action="" onsubmit="return checkPwdOnSubmit();" method="post">
                    <div class="form-group">
                        <label for="book-title">书名</label>
                        <input type="text" class="form-control" name="title" id="book-title" value="" placeholder="必填" required="required">
                    </div>

                    <div class="form-group">
                        <label for="book-description">图书简述</label>
                        <textarea name="description" class="form-control" id="book-description" placeholder="拖动文本框右下角可改变大小"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="book-description">图书类目</label>

                    </div>

                    <div class="form-group">
                        <label for="book-status">图书状态</label>
                        <select class="form-control" name="num_total" id="book-status" required="required">
                            <#list bookStatusMap as id, description>
                                <option value="${id}">${description}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="book-publisher_id">出版社</label>
                        <select class="form-control" name="publisher_id" id="book-publisher_id" required="required">
                            <#list publisherMap as id, publisher>
                                <option value="${id}">${publisher.getName()}</option>
                            </#list>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="book-created_at">入馆时间</label>
                        <input type="datetime-local" class="form-control" name="created_at" id="book-created_at" value="" placeholder="默认为当前时间" title="入馆时间，默认为当前时间">
                    </div>

                    <div class="form-group">
                        <label for="book-num_total">馆藏数目</label>
                        <input type="number" class="form-control" name="num_total" min="0" id="book-num_total" value="" placeholder="必填" required="required">
                    </div>

                    <div class="form-group">
                        <label for="book-num_available">可供读者借阅数</label>
                        <input type="number" class="form-control" name="num_available" min="0" id="book-num_available" value="" placeholder="必填" required="required">
                    </div>

                    <button type="submit" class="btn btn-success">提交图书</button>
                </form>
            </div>
        </div>
    </div>

    <!-- End of page code -->
</@layout.layout>