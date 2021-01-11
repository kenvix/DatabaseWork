<#import "../../common/layout.ftl" as layout />
<@layout.layout title="标题">
    <!-- Begin Page code -->

        <div class="col-lg main" role="main" >
            <div class="card">
                <div class="card-header">图书展示${siteName}</div>
                <div class="panel panel-primary">
                    <p style="margin-top: 20px;margin-left: 20px;">[ 借阅查询 ] 您的账目当前余额为15元</p>
                    <div class="panel-body">
                        <div class="col-lg-9">
                            <div class="input-group" style="margin-left:0px ;margin-bottom: 20px;">
                                <input type="text" class="form-control" placeholder="高等数学">
                                <span class="input-group-btn">
                                    <button class="btn btn-outline-success" type="button">Go!</button>
                                </span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                        <div>
                            <table cellspacing="0" cellpadding="0" id="Table1" style="table-layout:fixed" class="admintable03 table table-condensed table-bordered table-hover table-striped" onmouseover="overShow(this,event)" onmouseout="outHide()">




                                <thead>
                                <tr>
                                    <style>
                                        table{
                                            width:120px;
                                            table-layout:fixed;/* 只有定义了表格的布局算法为fixed，下面td的定义才能起作用。 */
                                        }



                                        th {
                                            text-indent: 5px;
                                        }
                                    </style>
                                    <th width="8%" >序号</th>
                                    <th width="20%">书目</th>
                                    <th width="30%">详情</th>
                                    <th width="10%">出版社</th>
                                    <th>到馆时间</th>
                                    <th width="10%">数目</th>
                                    <th class="text-center"width="10%" >操作</th>
                                </tr>
                                <style>
                                    td {
                                        text-indent: 5px;
                                    }
                                </style>
                                </thead>
                                <tbody>

                                <tr>

                                    <td style="margin-left: 100px;">1</td>
                                    <td><a href="#">《仲夏夜之梦》</a></td></a>
                                    <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">《仲夏夜之夢》，是威廉·莎士比亞在約1590年－1596年間創作的浪漫喜劇。它描繪了以雅典大公忒修斯和希波呂忒婚禮為中心的一系列故事。包括四名​​雅典戀人和六個業餘演員的冒險經歷，而森林裡的仙子們則在背後操作它們的命運。本戲劇是莎士比亞最流行的劇本之一，在全世界都有上演。</td>
                                    <td>1</td>
                                    <td>2021-01-03</td>
                                    <td>100/100</div>
                        <td class="text-center">
                            <button class="btn btn-outline-success btn-xs">详情</button>
                        </td>
                        </tr>
                        <tr>
                            <td style="margin-left: 100px;">2</td>
                            <td><a href="#">《毛泽东思想概论》</a></td></a>
                            <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">《毛泽东选集》是1951年人民出版社出版的图书，作者是毛泽东。该书是毛泽东思想的重要载体，是毛泽东思想的集中展现，亦是对20世纪的中国影响最大的书籍之一。
                                建国后出版的两个版本均由人民出版社负责。该书在建国前即有大量出版，1944年于邯郸创建的晋察冀日报社出版首版《毛泽东选集》。建国后共出版了五卷，编入的是毛泽东同志在新民主主义革命时期、社会主义革命和社会主义建设时期的主要著作。1991年7月1日，《毛泽东选集》一至四卷第二版出版发行。</td>
                            <td>2</td>
                            <td>2021-01-04</td>
                            <td>20/20</div>
                    <td class="text-center">
                        <button class="btn btn-outline-success btn-xs">详情</button>
                    </td>
                    </tr>
                    <tr>
                        <td style="margin-left: 100px;">3</td>
                        <td><a href="#">《哈姆雷特》</a></td></a>
                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">《哈姆雷特（Hamlet）》是由英国剧作家威廉·莎士比亚创作于1599年至1602年间的一部悲剧作品。戏剧讲述了叔叔克劳狄斯谋害了哈姆雷特的父亲，篡取了王位，并娶了国王的遗孀乔特鲁德；哈姆雷特王子因此为父王向叔叔复仇。
                            《哈姆雷特》是莎士比亚所有戏剧中篇幅最长的一部， [1]  也是莎士比亚最负盛名的剧本，具有深刻的悲剧意义。复杂的人物性格以及丰富完美的悲剧艺术手法，代表着整个西方文艺复兴时期文学的最高成就。同《麦克白》、《李尔王》和《奥赛罗》一起组成莎士比亚“四大悲剧”。</td>
                        <td>1</td>
                        <td>2021-01-04 </td>
                        <td>1/1</div>
                <td class="text-center">
                    <button class="btn btn-outline-success btn-xs">详情</button>
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
    </div>
</div>
</div><!-- .main -->
</div><!-- .row -->
</div >




    <!-- End of page code -->
</@layout.layout>