<#import "../../common/layout.ftl" as layout />
<@layout.layout title="图书详细信息">
    <!-- Begin Page code -->
    <div class="card">
        <div class="card-header">#${book.getId()?long?c} : ${book.getTitle()}</div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <b>书名</b>：
                ${book.getTitle()}
            </li>
            <li class="list-group-item">
                <b>ISBN</b>：
                ${book.getIsbn()}
            </li>
            <li class="list-group-item">
                <b>图书类目</b>：${book.getTypeName()!"无"}
            </li>
            <li class="list-group-item">
                <b>作者</b>：
                <#if authors??>
                    <#list authors as item>
                        <#if item.getAuthorCountry()??>[${item.getAuthorCountry()}]</#if>
                        ${item.getAuthorName()}
                        <#if item.getAuthorFullname()?? && item.getAuthorFullname() != item.getAuthorName() >
                            (${item.getAuthorFullname()})
                        </#if> ,
                    </#list>
                <#else>
                    （不详）
                </#if>
            </li>
            <li class="list-group-item">
                <b>出版社</b>：
                ${book.getPublisherName()}
            </li>
            <li class="list-group-item">
                <b>库存数/总数</b>：
                ${book.getNumAvailable()?int?c}/${book.getNumTotal()?int?c}
            </li>
            <li class="list-group-item">
                <b>入库时间</b>：
                ${book.getCreatedAt()?string["yyyy-dd-MM HH:mm"]}
            </li>
            <li class="list-group-item">
                <b>库存状态</b>：
                ${book.getStatusDescription()}
            </li>
            <li class="list-group-item">
                <b>了解更多</b>：
                <a href="https://zh.wikipedia.org/wiki/${bookAndAuthorNameEncoded}" target="_blank">维基百科</a> |
                <a href="https://www.bing.com/search?q=${bookAndAuthorNameEncoded}" target="_blank">必应</a> |
                <a href="https://www.google.com/search?q=${bookAndAuthorNameEncoded}" target="_blank">谷歌</a> |
                <a href="https://www.baidu.com/search?q=${bookAndAuthorNameEncoded}" target="_blank">百度</a> |
                <a href="https://s.taobao.com/search?q=${bookAndAuthorNameEncoded}" target="_blank">淘宝</a> |
                <a href="https://search.jd.com/Search?keyword=${bookAndAuthorNameEncoded}" target="_blank">京东</a> |
                <a href="http://search.dangdang.com/?key=${bookAndAuthorNameEncoded}" target="_blank">当当网</a>
            </li>
        </ul>
    </div>

    <div class="card">
        <div class="card-header">图书简述</div>
        <div class="card-body">
            ${book.getDescription()}
        </div>
    </div>

    <div class="card">
        <div class="card-header">操作</div>
        <div class="card-body">
            <form action="/reader/book/borrow/borrow" method="post">
                <input type="hidden" name="book_id" value="${book.getId()?long?c}">
                <p>
                    <button type="submit" class="btn btn-outline-info btn-xs">借书</button>
                    <#if user.getAccessLevel() gte 100>
                        <button type="button" onclick="window.location='/admin/book/edit/${book.getId()?long?c}'" class="btn btn-outline-primary btn-xs">编辑</button>
                    </#if>
                </p>
            </form>
        </div>
    </div>
    <!-- End of page code -->
</@layout.layout>