<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
			width : $(window).width()-10,

			url : 'list.action',
			datatype : "json",
			colNames : [ '彩票ID', '彩票种类', '彩票类型', '购彩时间', '购买种类', '队伍信息','即时比分','购买比率','赔率','购买金额','比赛结果' ,'盈利'],
			colModel : [ {
				name : 'ID',
				index : 'ID',
				width : 50
			}, {
				name : 'class',
				index : 'class',
				width : 20
			}, {
				name : 'type',
				index : 'type',
				width : 30,
				align : "right"
			}, {
				name : 'date',
				index : 'date',
				width : 50,
				align : "right"
			}, {
				name : 'betType',
				index : 'betType',
				width : 50,
				align : "right"
			}, {
				name : 'team',
				index : 'team',
				width : 100,
				sortable : false
			}, {
				name : 'jsbf',
				index : 'jsbf',
				width : 20,
				sortable : false
			}, {
				name : 'gmbl',
				index : 'gmbl',
				width : 20,
				sortable : false
			}, {
				name : 'odds',
				index : 'odds',
				width : 20,
				sortable : false
			},{
				name : 'stake',
				index : 'stake',
				width : 20,
				sortable : false
			}, {
				name : 'endScore',
				index : 'endScore',
				width : 20,
				sortable : false,
				editable: true, 
				formatter:endFmatter
			}, {
				name : 'profit',
				index : 'profit',
				width : 20,
				sortable : false,
				formatter:profitFmatter
			}],

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
			add : true,
			del : true
		});
	});  
	function endFmatter (cellvalue, options, rowObject) { 
		if(cellvalue == null || cellvalue == 'null') {
			return " ";
		}
		return ;
	}
	function profitFmatter (cellvalue, options, rowObject) { 
		var profit =  rowObject["odds"] * rowObject["stake"]; 
		if(rowObject["endScore"] == null || rowObject["endScore"] == 'null') {
			return '&#65509; 0.0';
		}
		return '&#65509; ' + profit;
	}
	
	//计算盈利
	function calcuProfit(gmbl,odds,stake,jsbf,endScore){
		//当购买的比率以。5结尾
		//当购买的比率后面为。75
	}
</script>
</head>
<body>
	<s:textarea id="ticketInfo" cols="10" name="ticketInfo"></s:textarea>
	<input type="button" onclick="" value="确认" />

	<table id="list2" width ="100%"></table>
	<div id="pager2"></div>
</body>
</html>
