<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="javascript"
	src="js/jqgrid/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript"
	src="js/jqgrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript">
	$(function() {
		pageInit();
	});
	function pageInit() {
		var t = $("#ticketInfo").val();
		jQuery("#list2").jqGrid(
				{
					url : 'test.action?ticketInfo=' + t,
					datatype : "json",
					colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
							'Total', 'Notes' ],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55
					}, {
						name : 'invdate',
						index : 'invdate',
						width : 90
					}, {
						name : 'name',
						index : 'name asc, invdate',
						width : 100
					}, {
						name : 'amount',
						index : 'amount',
						width : 80,
						align : "right"
					}, {
						name : 'tax',
						index : 'tax',
						width : 80,
						align : "right"
					}, {
						name : 'total',
						index : 'total',
						width : 80,
						align : "right"
					}, {
						name : 'note',
						index : 'note',
						width : 150,
						sortable : false
					} ],
					rowNum : 10,
					rowList : [ 10, 20, 30 ],
					pager : '#pager2',
					sortname : 'id',
					mtype : "post",
					viewrecords : true,
					sortorder : "desc",
					caption : "JSON 实例"
				});
		jQuery("#list2").jqGrid('navGrid', '#pager2', {
			edit : false,
			add : false,
			del : false
		});
	}
</script>
</head>
<body>
		<s:textarea id = "ticketInfo" cols="10" name="ticketInfo"></s:textarea>>
		<input type="button" onclick="pageInit();">

	<table id="list2"></table>
	<div id="pager2"></div>
</body>
</html>
