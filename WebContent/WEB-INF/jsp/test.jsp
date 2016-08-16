<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="js/jquery.dataTables.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#example").dataTable({
//        "bPaginate": true, //开关，是否显示分页器
//        "bInfo": true, //开关，是否显示表格的一些信息
//        "bFilter": true, //开关，是否启用客户端过滤器
//        "sDom": "<>lfrtip<>",
//        "bAutoWith": false,
//        "bDeferRender": false,
//        "bJQueryUI": false, //开关，是否启用JQueryUI风格
//        "bLengthChange": true, //开关，是否显示每页大小的下拉框
//        "bProcessing": true,
//        "bScrollInfinite": false,
//        "sScrollY": "800px", //是否开启垂直滚动，以及指定滚动区域大小,可设值：'disabled','2000px'
//        "bSort": true, //开关，是否启用各列具有按列排序的功能
//        "bSortClasses": true,
//        "bStateSave": false, //开关，是否打开客户端状态记录功能。这个数据是记录在cookies中的，			打开了这个记录后，即使刷新一次页面，或重新打开浏览器，之前的状态都是保存下来的-			------当值为true时aoColumnDefs不能隐藏列
//        "sScrollX": "50%", //是否开启水平滚动，以及指定滚动区域大小,可设值：'disabled','2000%'
//        "aaSorting": [[0, "asc"]],

//        "aoColumnDefs": [{ "bVisible": false, "aTargets": [0]}]//隐藏列
//        "sDom": '<"H"if>t<"F"if>',
        "bAutoWidth": false, //自适应宽度
        "aaSorting": [[1, "asc"]],
        "sPaginationType": "full_numbers",
        "oLanguage": {
            "sProcessing": "正在加载中......",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "对不起，查询不到相关数据！",
            "sEmptyTable": "表中无数据存在！",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
            "sSearch": "搜索",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            }
        } //多语言配置



    });
});
</script>
</head>

<body>
	<table cellpadding="1" cellspacing="0" border="0" class="display"
		id="example">
		<thead>
			<tr>
				<th>Rendering engine</th>
				<th>Browser</th>
				<th>Platform(s)</th>
				<th>Engine version</th>
				<th>CSS grade</th>
			</tr>
		</thead>
		<tbody>
			<tr class="odd gradeX">
				<td>Trident</td>
				<td>Internet</td>
				<td>Win 95+</td>
				<td class="center">4</td>
				<td class="center">X</td>
			</tr>
			</tbody>
			</table>
</body>
</html>