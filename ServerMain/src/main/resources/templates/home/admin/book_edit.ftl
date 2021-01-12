<#import "../../common/layout.ftl" as layout />
<@layout.layout title="添加图书">
    <!-- Begin Page code -->
    <!-- Notice: This front-end view is combined Add and Edit books        by:Kenvix -->
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
                <#if book??>
                    <!-- Edit Mode For book #${book.getId()} -->
                    <input type="hidden" name="is_edit" value="1" />
                </#if>

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
                    <select class="form-control" name="status" id="book-status" required="required">
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
                    <input type="hidden" name="use_author_name_text_list" value="1">
                    <textarea name="authors_text" style="height: 6em;" class="form-control" id="book-authors_text" placeholder="每行一个作者名称。拖动文本框右下角可改变大小"><#if book??><#list authors as author>${author.getAuthorName()}
</#list></#if></textarea>
                </div>

                <div class="form-group">
                    <label for="book-created_at">入馆时间</label>
                    <input type="datetime-local" class="form-control" name="created_at" id="book-created_at" value="${book_created_at!""}" placeholder="默认为当前时间" title="入馆时间，默认为当前时间">
                </div>

                <div class="form-group">
                    <label for="book-num_total">馆藏数目</label>
                    <input type="number" class="form-control" name="num_total" min="0" id="book-num_total" value="<#if book??>${book.getNumTotal()?long?c}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="book-num_available">可供读者借阅数</label>
                    <input type="number" class="form-control" name="num_available" min="0" id="book-num_available" value="<#if book??>${book.getNumAvailable()?long?c}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <div class="custom-control custom-checkbox">
                        <input class="custom-control-input" type="checkbox" name="auto_create_author" id="book-auto_create_author" value="1">
                        <label class="custom-control-label" for="book-auto_create_author">自动创建尚不存在的作者</label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="custom-control custom-checkbox">
                        <input class="custom-control-input" type="checkbox" name="auto_create_publisher" id="book-auto_create_publisher" value="1">
                        <label class="custom-control-label" for="book-auto_create_publisher">自动创建尚不存在的出版社</label>
                    </div>
                </div>

                <button type="submit" class="btn btn-success">提交图书修改</button>
            </form>
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            相关操作
        </div>

        <div class="card-body" id="loginData">
            <form action="/admin/book/stat/borrow" enctype="application/x-www-form-urlencoded" method="get">
                <button type="submit" class="btn btn-primary">查询借书情况</button>
            </form>
        </div>
    </div>

    <#if book??>
        <div class="card">
            <div class="card-header">
                危险操作
            </div>

            <div class="card-body" id="loginData">
                <form action="/admin/book/delete" enctype="application/x-www-form-urlencoded" method="post" onsubmit="return confirm('是否确实要删除此图书？此操作不可逆，并且系统将不再追踪借书情况。通常情况下您可以将图书设为隐藏');">
                    <input type="hidden" name="book_id" value="${book.getId()}">
                    <button type="submit" class="btn btn-danger">删除图书</button>
                </form>
            </div>
        </div>
    </#if>
    <!-- End of page code -->
</@layout.layout>