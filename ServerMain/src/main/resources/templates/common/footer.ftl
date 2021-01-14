<footer>
    <div class="footer bg-white">
        <div class="container">
            <p>
                ${.now}
                | <#if user??>Authorized<#else>Unauthorized</#if>
                <#if user?? && user.getAccessLevel() gte 100> | Administration Mode</#if>
            </p>
            <p>Copyright © 2021 Advanced Book Management System. All Rights Reserved.</p>
        </div>
    </div>
    <div class="modal fade" id="alert_modal" tabindex="-1" role="dialog" aria-labelledby="watitle" aria-hidden="true">
        <div id="alert_modal_dialog" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="modal-title" id="watitle"></span>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body" id="watext" style="word-wrap: break-word"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="waclose" data-dismiss="modal" style="width:100px;">关闭</button>
                </div>
            </div>
        </div>
    </div>
</footer>