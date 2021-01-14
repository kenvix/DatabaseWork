<#import "../../common/layout.ftl" as layout />
<@layout.layout title="个性化页面">
    <!-- Begin Page code -->
    <div class="card">
        <div class="card-header">个性化设置</div>
        <div class="card-body" id="aboutInfo">
            你可以在此处修改你在本系统中的视图，修改仅对本浏览器生效。
        </div>
    </div>

    <div class="card">
        <div class="card-header">分页设置</div>
        <div class="card-body" id="custom-page-limit-panel">
            <p>设置每页条目超过多少项时分页</p>
            <form id="custom-page-limit" action="javascript:;"
                  onsubmit="document.cookie = 'paginate='+$('#page-limit').val()+';expires= Sun, 29 Apr 2037 08:00:00 GMT;path=/'">
                <div class="form-group">
                    <input type="number" min="1" class="form-control" id="page-limit" required="" maxlength="20"
                           placeholder="分页数量限制，默认为 50">
                </div>
                <input type="submit" class="btn btn-primary" value="应用更改">
            </form>
        </div>
    </div>

    <div class="card">
        <div class="card-header">自定义CSS</div>
        <div class="card-body" id="custom-css-panel">
            <p>自定义本系统的 CSS</p>
            <form id="custom-css" action="javascript:;"
                  onsubmit="localStorage.setItem('usercss', $('#custom-css-file').val());">
                <div class="form-group">
                    <textarea class="form-control text-monospace" id="custom-css-file" rows="8"></textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="提交更改">
            </form>
        </div>
    </div>

    <div class="card">
        <div class="card-header">自定义脚本(Javascript)</div>
        <div class="card-body" id="custom-js-panel">
            <p>在本系统执行自定义 JavaScript</p>
            <form id="custom-js" action="javascript:;"
                  onsubmit="localStorage.setItem('userjs', $('#custom-js-file').val());">
                <div class="form-group">
                    <textarea class="form-control text-monospace" id="custom-js-file" rows="8"></textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="提交更改">
            </form>
        </div>
    </div>

    <script type="text/javascript">
        function getCookie(name) {
            var cookies = document.cookie;
            var list = cookies.split("; ");      // 解析出名/值对列表

            for (var i = 0; i < list.length; i++) {
                var arr = list[i].split("=");      // 解析出名和值
                if (arr[0] === name)
                    return decodeURIComponent(arr[1]); // 对cookie值解码
            }
            return null;
        }

        if (localStorage.getItem("userjs") != null)
            $('#custom-js-file').val(localStorage.getItem("userjs"));
        if (localStorage.getItem("usercss") != null)
            $('#custom-css-file').val(localStorage.getItem("usercss"));
        if (getCookie('paginate') != null)
            $('#page-limit').val(getCookie("paginate"));
    </script>

    <!-- End of page code -->
</@layout.layout>