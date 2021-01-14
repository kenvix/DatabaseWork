<#import "../../common/layout.ftl" as layout />
<@layout.layout title="管理用户">
    <!-- Begin Page code -->
    <style>
        .detail-text {
            overflow: hidden;
            text-overflow: ellipsis;
            -webkit-line-clamp: 2;
            display: -webkit-box;
            -webkit-box-orient: vertical;
        }
    </style>

    <div class="card">
        <div class="card-header">用户管理</div>
        <td class="panel panel-primary">

            <p style="margin-top: 20px;margin-left: 20px;margin-right: 20px;">
                <button onclick="window.location = '/admin/user/add'" style="float: right" class="btn btn-outline-success btn-xs">+ 添加用户</button>
                当前共有用户 ${userTotalCount} 名 (粗略估计)
            </p>
            <div class="panel-body">
                <div>
                    <table id="Table1" class="admintable03 table table-condensed table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th width="1%">#</th>
                            <th width="15%">学号/姓名</th>
                            <th width="15%">邮箱/手机</th>
                            <th width="15%">年级/部门</th>
                            <th width="15%">注册时间/权限</th>
                            <th width="15%">备注</th>
                            <th class="text-center" width="1%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list users as item>
                            <tr>
                                <td style="margin-left: 100px;">${item.getUid()?long?c}</td>
                                <td>
                                    ${item.getSerialId()!"无"}
                                    <br/>
                                    ${item.getRealName()!"无"}
                                </td>
                                <td>
                                    ${item.getEmail()!"无"}
                                    <br/>
                                    <#if item.getPhone()??>${item.getPhone()?long?c}<#else>未知</#if>
                                </td>
                                <td>
                                    <#if item.getStartYear()??>${item.getStartYear()?short?c}<#else>未知</#if>
                                    <br/>
                                    ${item.getDepartment()!"无"}
                                </td>
                                <td>
                                    ${item.getCreatedAt()?string["yyyy-dd-MM HH:mm"]}
                                    <br/>
                                    ${item.getAccessLevelDescription()!"未知"}
                                </td>
                                <td>
                                    <span class="detail-text">
                                    ${item.getComment()!"无"}
                                    </span>
                                </td>
                                <td class="text-center">
                                    <p> <button onclick="window.location = '/admin/user/edit/${item.getUid()?long?c}'" class="btn btn-outline-success btn-xs">改</button></p>
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