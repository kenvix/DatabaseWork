<#import "../../common/layout.ftl" as layout />
<@layout.layout title="管理图书">
    <!-- Begin Page code -->
    <style>
        td {
            text-indent: 5px;
        }
        .detail-text {
            overflow: hidden;
            text-overflow: ellipsis;
            -webkit-line-clamp: 2;
            display: -webkit-box;
            -webkit-box-orient: vertical;
        }
    </style>

    <div class="card">
        <div class="card-header">图书管理</div>
        <td class="panel panel-primary">
            <p style="margin-top: 20px;margin-left: 20px;">当前共有图书  本</p>
            <div class="panel-body">
                <div>
                    <table id="Table1" class="admintable03 table table-condensed table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th width="1%">#</th>
                            <th width="20%">书目</th>
                            <th width="35%">详情</th>
                            <th width="10%">出版社</th>
                            <th>到馆时间/数目</th>
                            <th class="text-center" width="1%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td style="margin-left: 100px;">1</td>
                            <td>
                                <a href="#">
                                    <span class="detail-text">

                                    </span>
                                </a>
                            </td>
                            <td>
                                <span class="detail-text">

                                </span>
                            </td>
                            <td>
                                <span class="detail-text">

                                </span>
                            </td>
                            <td>

                            </td>
                            <td class="text-center">
                                <button class="btn btn-outline-success btn-xs">借</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                    <nav aria-label="Page navigation" class="text-center"></nav>
                </div>
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group" style="margin-left:300px">
                        <button type="button" class="btn btn-default">1</button>
                        <button type="button" class="btn btn-default">2</button>
                        <button type="button" class="btn btn-default">3</button>
                        <button type="button" class="btn btn-default">4</button>
                        <button type="button" class="btn btn-default">5</button>
                        <button type="button" class="btn btn-default">6</button>
                        <button type="button" class="btn btn-default">7</button>
                        <button type="button" class="btn btn-default">8</button>
                        <button type="button" class="btn btn-default">9</button>
                    </div>
                </div>
            </div>
            <!-- End of page code -->
        </td>
    </div>
</@layout.layout>