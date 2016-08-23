<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>yanyj个人系统</title>
    <link href="css/model/index.css" rel="stylesheet" />
    <link href="css/model/themes/default/easyui.css" rel="stylesheet" />
    <link href="css/model/themes/icon.css" rel="stylesheet" />
    <link href="css/model/demo.css" rel="stylesheet" />
    <script src="js/model/jquery.min.js"></script>
    <script src="js/model/jquery.easyui.min.js"></script>
    <script>
        $(function () {
            bindEvent();
        });
        function bindEvent() {
            $(".btn_menu").click(function () {
                var title = $(this).text();
                var url = $(this).attr("url");
                var isSelect = $("#container").tabs('exists', title);
                if (isSelect) {
                    $("#container").tabs('select', title);
                    return;
                }
                $("#container").tabs('add', {
                    title: title,
                    content: CreateContent(url),
                    closable: true
                });
            });
        }

        function CreateContent(url) {
            var strHtml = '<iframe src="' + url + '" scrolling="no" frameborder="0" fit="true" style="height:110%;width:100%;min-height:600px;"></iframe>';
            return strHtml;
        }
    </script>    
</head>
<body>
    <div id="layout_div" class="easyui-layout">
        <div data-options="region:'north',border:false"  style="overflow:hidden; height:70px;background:url(images/title_logo.jpg) no-repeat 120px 0px;padding:10px;padding-left:30px;">
            <div style="float:left; height:70px;">
              <img src="images/logo.png"  style="margin-top:-10px;margin-left:-30px;" />
            </div>
            <div style="color:#fff  ;font-size:3em; float:left;margin-left:30px;">
                个人系统
            </div>
            <div style="float:right;height:70px; margin-right:50px;">
                <span>您好，admin！</span>
                <span><a href="Javascript:void(0)">注销</a></span>
            </div>
        </div>
        <div data-options="region:'west',split:false,title:'菜单',collapsible:false" style="width:170px;">
            <div id="menu" class="easyui-accordion" fit="true">
                <!-- a标签url属性中填写（/控制器名称/视图名称） -->
                <div title="ticket服务" data-options="iconCls:'icon-help'" style=" overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="link.action">新建注单</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="linkAccount.action">账户管理</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="Replace_list.html">代填记录</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="replace_apply.html">代填申请</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="Audit_list.html">申请审批</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="bill_list.html">账单记录</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="service_list.html">服务统计</a></li>
                    </ul>
                </div>
                <div title="发送快递" data-options="iconCls:'icon-redo'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="">填写单号</a></li>
                    </ul>
                </div>
                <div title="用户管理" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="user_list.html">账户管理</a></li>
                    </ul>
                </div>
                <div title="部门管理" data-options="iconCls:'icon-tip'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="group_list.html">部门管理</a></li>
                    </ul>
                </div>
                <div title="系统配置" data-options="iconCls:'icon-lock'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="">系统配置</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div data-options="region:'south',border:false" style="height:50px; font-size:15px; color:#fff; background:#338FCC;padding:10px; text-align:center">
            © 2016 - yanyj个人系统
        </div>
        <div data-options="region:'center'" style="overflow:hidden">
            <div class="easyui-tabs" fit="true" id="container">
                <div title="主页" style="padding:10px">
                    欢迎使用yyj个人务系统
                    <!--<iframe src="/list.html" scrolling="no" frameborder="0" height="1000" width="1100" style="overflow:hidden; margin-bottom:10px;"></iframe>-->
                </div>
            </div>

        </div>
    </div>
</body>

</html>
