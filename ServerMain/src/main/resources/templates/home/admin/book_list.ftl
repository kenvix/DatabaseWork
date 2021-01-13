<#import "../../common/layout.ftl" as layout />
<@layout.layout title="管理图书">
    <!-- Begin Page code -->
    <style>
        .detail-text {
            overflow: hidden;
            text-overflow: ellipsis;
            -webkit-line-clamp: 4;
            display: -webkit-box;
            -webkit-box-orient: vertical;
        }
    </style>

    <div class="card">
        <div class="card-header">图书管理</div>
        <td class="panel panel-primary">

            <p style="margin-top: 20px;margin-left: 20px;margin-right: 20px;">
                <button onclick="window.location = '/admin/book/add'" style="float: right" class="btn btn-outline-success btn-xs">+ 添加图书</button>
                <button onclick="window.location = '/admin/book/search'" style="float: right; margin: 0 1em 0 1em;" class="btn btn-outline-primary btn-xs">检索图书</button>
                当前共有图书 ${bookTotalCount} 本
            </p>
            <div class="panel-body">
                <div>
                    <table id="Table1" class="admintable03 table table-condensed table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th width="1%">#</th>
                            <th width="20%">书目</th>
                            <th width="35%">详情</th>
                            <th width="10%">作者</th>
                            <th width="10%">出版社</th>
                            <th width="15%">到馆时间/数目</th>
                            <th class="text-center" width="8%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list books as book>
                            <tr>
                                <td style="margin-left: 100px;">${book.getId()?long?c}</td>
                                <td>
                                    <a href="/reader/book/${book.getId()?long?c}">
                                    <span class="detail-text">
                                       《${book.getTitle()!"无"}》
                                    </span>
                                    </a>
                                    ${book.getTypeName()!"无"}
                                </td>
                                <td>
                                <span class="detail-text">
                                     ${book.getDescription()!"无"}
                                </span>
                                </td>
                                <td>
                                <span class="detail-text">
                                     ${book.getAuthorName()!"（不详）"}
                                </span>
                                </td>
                                <td>
                                <span class="detail-text">
                                    ${book.getPublisherName()!"（未知）"}
                                </span>
                                </td>
                                <td>
                                    ${book.getCreatedAt()?string["yyyy-dd-MM HH:mm"]}
                                    <br/>
                                    ${book.getNumAvailable()?int?c}/${book.getNumTotal()?int?c}
                                    <br/>
                                    ${book.getStatusDescription()}
                                </td>
                                <td class="text-center">
                                    <p><button onclick="window.location = '/reader/book/${book.getId()?long?c}'" class="btn btn-outline-primary btn-xs">详</button></p>
                                    <p> <button onclick="window.location = '/admin/book/edit/${book.getId()?long?c}'" class="btn btn-outline-success btn-xs">改</button></p>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>

                </div>
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group" style="text-align:center">
                        <nav aria-label="Page navigation" class="text-center">
                            <button type="button" class="btn btn-default">1</button>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- End of page code -->
        </td>
    </div>
</@layout.layout>