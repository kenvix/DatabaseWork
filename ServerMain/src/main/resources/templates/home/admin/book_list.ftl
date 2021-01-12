<#import "../../common/layout.ftl" as layout />
<@layout.layout title="搜索图书">
    <!-- Begin Page code -->
    <!-- Notice: This front-end view is combined Add and Edit books        by:Kenvix -->
    <div class="card">
        <div class="card-header">
            <#if book??>
                搜索图书 #${book.getId()}

            </#if>
        </div>

        <div class="card-body" id="loginData">
            <form action="" method="post" enctype="application/x-www-form-urlencoded">
                <#if book??>
                    <!-- Edit Mode For book #${book.getId()} -->
                    <input type="hidden" name="is_edit" value="1" />
                </#if>

                <div class="form-group">
                    <label for="filter_title">按标题过滤图书</label>
                    <input type="String?" class="form-control" name="filter_title" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="filter_publisher">按出版社名称或者出版社ID过滤图书</label>
                    <input type="String?" class="form-control" name="filter_publisher" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="filter_description">按图书描述过滤图书</label>
                    <input type="String?" class="form-control" name="filter_description" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="filter_available">按图书是否可以借阅过滤图书，非 Null 表示只显示可借阅图书</label>
                    <input type="String?" class="form-control" name="filter_available" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="filter_type">按图书类型名过滤图书</label>
                    <input type="String?" class="form-control" name="filter_type" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="filter_author">按作者名或作者ID过滤图书</label>
                    <input type="String?" class="form-control" name="filter_author" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>

                <div class="form-group">
                    <label for="page">按图书列表页码过滤图书</label>
                    <input type="Int?" class="form-control" name="page" id="book-title" value="<#if book??>${book.getTitle()}</#if>" placeholder="必填" required="required">
                </div>





            </form>
        </div>
    </div>


    <!-- End of page code -->
</@layout.layout>