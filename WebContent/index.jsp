<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/ui-lightness/jquery-ui-1.8.12.custom.css"
	rel="stylesheet" type="text/css" />
<link href="css/ui.jqgrid.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.8.12.custom.min.js" type="text/javascript"></script>
<script src="js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min-3.8.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery("#list2").jqGrid({
			datatype : "json", //将这里改为使用JSON数据    
			mtype : 'POST',
			height : 250,
			width : 1000,

			url : 'list.action',
			datatype : "json",
			colNames : [ 'ID', 'class', 'betType', 'gmbl', 'jsbf', 'odds' ],
			colModel : [ {
				name : 'ID',
				index : 'ID',
				width : 90
			}, {
				name : 'class',
				index : 'class',
				width : 100
			}, {
				name : 'betType',
				index : 'betType',
				width : 80,
				align : "right"
			}, {
				name : 'gmbl',
				index : 'gmbl',
				width : 80,
				align : "right"
			}, {
				name : 'jsbf',
				index : 'jsbf',
				width : 80,
				align : "right"
			}, {
				name : 'odds',
				index : 'odds',
				width : 150,
				sortable : false
			} ],

			pager : '#pager2', //分页工具栏,指定了jqGrid页脚显示位置
			sortname : 'ID', //排序
			sortorder : "desc",//降序
			viewrecords : true,//是否在Pager Bar显示所有记录的总数
			rowNum : 10, //每页显示记录数               
			rowList : [ 10, 20, 30 ], //可调整每页显示的记录数   
			multiselect : true, //是否支持多选   
			caption : "信息显示",
			jsonReader : {  
		        root:"rows",  
		        page: "page",  
		        total: "total",  
		        records: "records",  
		        repeatitems: false,  
		        id: "0"  
		    }
		//cell中不需要各列的name，但是需要与colModel一一对应
		});
		jQuery("#list2").jqGrid('navGrid', '#pager2', {
			edit : true,
			add : false,
			del : true
		});
	});  
</script>
</head>
<body>
	<s:textarea id="ticketInfo" cols="10" name="ticketInfo"></s:textarea>
	<input type="button" onclick="link.actio" value="确认" />
<a href="link!link.action">跳转</a>
	<table id="list2" width ="100%"></table>
	<div id="pager2"></div>
</body>
</html>
