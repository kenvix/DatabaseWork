<#import "../../common/layout.ftl" as layout />
<@layout.layout title="搜索图书">
    <!-- Begin Page code -->
    <!-- Notice: This front-end view is combined Add and Edit books        by:Kenvix -->
    <div class="card">
        <div class="card-header">
            按条件检索图书
        </div>

        <div class="card-body" id="loginData">
            <form action="/reader/book" method="get" enctype="application/x-www-form-urlencoded">
                <p>按以下条件检索图书：（“与” 关系）</p>

                <div class="form-group">
                    <label for="filter_title">按标题过滤图书</label>
                    <input type="text" class="form-control" name="filter_title">
                </div>

                <div class="form-group">
                    <label for="filter_publisher">按出版社名称或者出版社ID过滤图书</label>
                    <input type="text" class="form-control" name="filter_publisher">
                </div>

                <div class="form-group">
                    <label for="filter_description">按图书描述过滤图书</label>
                    <input type="text" class="form-control" name="filter_description">
                </div>

                <div class="form-group">
                    <div class="custom-control custom-checkbox">
                        <input class="custom-control-input" type="checkbox" name="filter_available" id="book-filter_available" value="1">
                        <label class="custom-control-label" for="book-filter_available">按图书是否可以借阅过滤图书</label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="filter_type">按图书类型名过滤图书</label>
                    <input type="text" class="form-control" name="filter_type">
                </div>

                <div class="form-group">
                    <label for="filter_author">按作者名或作者ID过滤图书</label>
                    <input type="text" class="form-control" name="filter_author">
                </div>

                <div class="form-group">
                    <label for="page">按图书列表页码过滤图书</label>
                    <input type="number" value="" class="form-control" name="page">
                </div>

                <button type="submit" class="btn btn-success">查询图书</button>
            </form>
        </div>
    </div>


    <!-- End of page code -->
</@layout.layout>