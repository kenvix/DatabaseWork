<#import "../../common/layout.ftl" as layout />
<@layout.layout title="图书列表">
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
        <div class="card-header">
            <#if isAdminBorrowExpired??>
                管理超期图书
                <#elseif isAdminAllBorrow??>
                管理借书
                <#else>
                我的借书列表
            </#if>
        </div>
        <td class="panel panel-primary">

            <div style="margin-top: 20px;margin-left: 20px;margin-right: 20px;">
                <#if isAdmin??>
                    <p>管理借书。</p>
                    <#else>
                        <p>您正在查看您的借书列表。目前您总共借过 ${booksCount} 本书，您最多可以同时借 ${maxBorrowCount} 本书，续借 ${maxRenewCount} 次。</p>
                        <#if !isOnlineReturnAllowed??>
                            <p>系统管理员不允许您直接还书，请联系图书管理员进行还书。</p>
                        </#if>
                </#if>
                <p>
                    <#if bookExpirePenalty gt 0>
                    超期罚款 ${bookExpirePenaltyString} / 天，
                    </#if>
                    每次续期时间<b>不会</b>累积（始终以当前时间起算），请您在图书到期前续期。</p>
            </div>
            <div class="panel-body">
                <div>
                    <table id="Table1" class="admintable03 table table-condensed table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th width="1%">#</th>
                            <th width="15%">书目</th>
                            <th width="10%">作者</th>
                            <th width="10%">出版社</th>
                            <th width="15%">借书时间</th>
                            <th width="15%">限还时间</th>
                            <th width="15%">状态</th>
                            <th class="text-center" width="8%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list books as book>
                            <tr>
                                <td>${book.getBorrowId()!0?long?c}</td>
                                <td>
                                    <a href="/reader/book/${book.getBookId()?long?c}">
                                    <span class="detail-text">
                                       《${book.getBookTitle()!"无"}》
                                    </span>
                                    </a>
                                    ${book.getBookTypeName()!"无"}
                                </td>
                                <td>
                                <span class="detail-text">
                                     ${book.getBookAuthorName()!"（不详）"}
                                </span>
                                </td>
                                <td>
                                <span class="detail-text">
                                    ${book.getBookPublisherName()!"（未知）"}
                                </span>
                                </td>
                                <td>
                                    ${book.getBorrowedAt()}
                                    <br/>已续借 ${book.getRenewNum()} 次
                                </td>
                                <td>
                                    ${book.getExpectedReturnedAt()}
                                </td>
                                <td>
                                    <#if book.getActualReturnedAt()??>
                                        已还书，还书时间为：${book.getActualReturnedAt()}
                                    <#else >
                                        未还
                                        <#if .now gte book.getExpectedReturnedAt()>
                                            ，<span style="color: red; font-weight: bold">已超期</span>
                                        </#if>
                                    </#if>
                                </td>
                                <td class="text-center">
                                    <#if book.getActualReturnedAt()??>
                                        无
                                    <#else>
                                        <form action="/reader/book/borrow/renew" method="post">
                                            <#if isAdmin??>
                                                <input type="hidden" name="is_admin" value="1">
                                            </#if>
                                            <input type="hidden" name="borrow_id" value="${book.getBorrowId()!0?long?c}">
                                            <p><button type="submit"  <#if book.getRenewNum() gte maxRenewCount>disabled</#if> class="btn btn-outline-info btn-xs">续</button></p>
                                        </form>

                                        <#if isOnlineReturnAllowed??>
                                            <form action="/reader/book/borrow/return" method="post">
                                                <#if isAdmin??>
                                                    <input type="hidden" name="is_admin" value="1">
                                                </#if>
                                                <input type="hidden" name="borrow_id" value="${book.getBorrowId()!0?long?c}">
                                                <p><button type="submit"  class="btn btn-outline-success btn-xs">还</button></p>
                                            </form>
                                        </#if>
                                    </#if>
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
    </div>
</@layout.layout>