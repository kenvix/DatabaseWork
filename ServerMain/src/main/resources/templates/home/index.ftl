<#import "../common/layout.ftl" as layout />
<@layout.layout title="首页">
    <!-- Begin Page code -->

    <div class="col-lg main" role="main">
        <div class="card">
            <div class="card-body" id="aboutInfo">
                <img title="你的 Gravatar 头像" src="img/usericon.png" width="100" height="100"
                     class="img-thumbnail mb-3 ml-3 float-right d-none d-md-block">

                <h3 class="mb-3">首页</h3>
                <p>请务必加入图书资源讨论群(Telegram或QQ)，以便在发生重大事件时能及时通知你。</p>
                <p>Telegram: @library [ <a href="#" target="_blank">点击加入</a> ]
                </p>
                <p>QQ 群: xxxxxxxx [ <a href="#" target="_blank">点击加入</a> ]
                </p>
                <p>注意：主要内容由QQ群推送公告，加入library请务必入群</p>
            </div>
        </div>



        <div class="alert alert-warning" role="alert" onclick="location = '/Home/Mc/view'">
            <p><span class="glyphicon glyphicon-warning-sign"></span> <b>尚未创建图书资源账号</b></p>
            您还没有创建 library 账号，<b>不能进入系统</b>。请点击右侧的“账户资料”或此处以创建 libary 账号
        </div>
        <div class="card">
            <div class="card-header">用户中心账户资料</div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <b>用户名：</b>
                    admin
                </li>
                <li class="list-group-item">
                    <b>注册时间：</b>
                    2021-01-06 14:46:51
                </li>
                <li class="list-group-item">
                    <b>注册邮箱：</b>
                    846963318@qq.com
                </li>
                <li class="list-group-item">
                    <b>上次登录：</b>
                    1970-01-01 08:00:00
                </li>
            </ul>
        </div>


        <div class="card">
            <div class="card-header">导读园地</div>
            <div class="card-body" id="donateInfo">
                <div class="main1_r_l" style="margin-left: 0px;">
                    <p>&nbsp;<a href="#" target="_blank">[1]5本书讲透中华上下五千年文化精髓</a> </p>
                    <div class="main1_r_nr" style="min-height:72px;">
                        故宫文具，敦煌眼影......最近的一批国潮品牌火了，大家发现，我们的传统文化原来这么有趣，迷人。其实，远远不止这些呢！今天推荐的这5本书，将带领大家好好认识、了解、进而爱上我们的传统文化！
                    </div>
                </div>
                <div class="clear"></div>

                <div class="main1_r_l" style="margin-left: 0px;">
                    <p>&nbsp;<a href="#" target="_blank">[2]二战中被遗忘的普通人，这5本书都记下来了</a> </p>
                    <div class="main1_r_nr" style="min-height:72px;">
                        “二战”对于很多人来说，可能只是个历史名词,但对于普通士兵来说，却是永远都无法消弭的伤痛。</div>
                </div>
                <div class="clear"></div>

                <div class="main1_r_l" style="margin-left: 0px;">
                    <p>&nbsp;<a href="#" target="_blank">[3]让人生逆风翻盘的5个故事</a> </p>
                    <div class="main1_r_nr" style="min-height:72px;">
                        人都免不了有沮丧的时刻，也会忍不住陷入怀疑，面对生活的“拳拳重击”，我们真的有还击之力吗？努力了真的有用吗？这个问题，
                        今天这5本书的主角，每一个都比我们普通人要惨得多，他们会用亲身经历，给你最好的解答！</div>
                </div>
                <div class="clear"></div>

                <div class="main1_r_l" style="margin-left: 0px;">
                    <p>&nbsp;<a href="#" target="_blank">[4]庆祝建党100周年系列丛书展</a> </p>
                    <div class="main1_r_nr" style="min-height:72px;">
                        在纪念建党100周年即将来临之际，图书馆举办建党100周年系列丛书展，目的是让中北学子更好地了解党史、学习党史，发扬革命精神，继承革命志向。</div>
                </div>
                <div class="clear"></div>
            </div>
        </div>




        <div class="card">
            <div class="card-header">高校学报</div>

            <div>
                <table class="table table-striped table-hover">
                    <thead>

                    </thead>
                    <tbody>
                    <tr>
                        <td><a href="http://tsinghua.cuepa.cn/index.php" target="_blank">清华大学报</a></td>
                        <td><a href="http://pku.cuepa.cn/index.php" target="_blank">北京大学报</a></td>
                        <td><a href="http://buaa.cuepa.cn/" target="_blank">北京航空航天大学报</a></td>
                        <td><a href="http://bit.cuepa.cn/" target="_blank">北京理工大学报</a></td>
                        <td><a href="http://ruc.cuepa.cn/" target="_blank">中国人民大学报</a></td>
                    </tr>
                    <tr>
                        <td><a href="http://sjtu.cuepa.cn/" target="_blank">上海交通大学报</a></td>
                        <td><a href="https://journals.nwpu.edu.cn/xbgydxxb/" target="_blank">西北工业大学报</a></td>
                        <td><a href="http://hit.cuepa.cn/" target="_blank">哈尔滨工业大学报</a></td>
                        <td><a href="http://www.xb.uestc.edu.cn/" target="_blank">电子科技大学报</a></td>
                        <td><a href="http://sn.cuepa.cn/" target="_blank">西安交通大学报</a></td>
                    </tr>
                    <tr>
                        <td><a href="http://jdb.cuepa.cn/" target="_blank">吉林大学报</a></td>
                        <td><a href="http://cqu.cuepa.cn/" target="_blank">重庆大学报</a></td>
                        <td><a href="http://tju.cuepa.cn/" target="_blank">天津大学报</a></td>
                        <td><a href="http://nkweekly.cuepa.cn/" target="_blank">南开大学报</a></td>
                        <td><a href="http://seu.cuepa.cn/" target="_blank">东南大学学报</a></td>
                    </tr>
                    <tr>
                        <td><a href="http://sdu.cuepa.cn/" target="_blank">山东大学报</a></td>
                        <td><a href="http://ouceducnxiaobao.cuepa.cn/" target="_blank">中国海洋大学报</a></td>
                        <td><a href="http://sxdr.chinajournal.net.cn/WKD/WebPublication/index.aspx?mid=sxdr" target="_blank">山西大学报</a></td>
                        <td><a href="http://www.tylgdxxb.cn/" target="_blank">太原理工大学学报</a></td>
                        <td><a href="http://www.cuepa.cn/" target="_blank">中国高校校报展示平台</a></td>
                    </tr>
                    </tbody>
                </table>
                <nav aria-label="Page navigation" class="text-center">
            </div>








            <div class="card">
                <div class="card-header">下载/安装 library</div>
                <div class="card-body" id="downloadUpdater">
                    <p>更新器在群文件，请使用更新器来完成安装和更新。更新器也提供一些实用工具，例如MOD管理器和低配补丁</p>
                    <p>QQ 群: xxxxxxxx [ <a href="#" target="_blank">点击加入</a> ]</p>
                    <!--        <p><a href="/Doc/Protected/updaterfaq">更新器及系统问题常见问题解答</a></p>-->
                    <!--        <a class="btn btn-info" href="/Doc/Protected/download" target="_blank">下载压缩包</a>-->
                </div>
            </div>
        </div><!-- .main -->
    </div><!-- .row -->
    </div><!-- .container-main -->

    <!-- End of page code -->
</@layout.layout>