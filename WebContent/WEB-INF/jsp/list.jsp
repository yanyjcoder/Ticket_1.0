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
 var colNames = ['序号', '彩票ID', '彩票种类', '彩票类型', '购彩时间', '购买种类', '队伍信息','即时比分','购买比率','赔率','购买金额','比赛结果' ,'盈利','操作'];
 var colModel = [{
	name : 'id',
	index : 'id',
	align : "center",
	width : 10
}, {
	name : 'ID',
	index : 'ID',
	align : "center",
	width : 25
}, {
	name : 'class',
	index : 'class',
	align : "center",
	width : 20
}, {
	name : 'type',
	index : 'type',
	align : "center",
	width : 20
}, {
	name : 'date',
	index : 'date',
	width : 35,
	align : "center"
}, {
	name : 'betType',
	index : 'betType',
	width : 15,
	align : "center"
}, {
	name : 'team',
	index : 'team',
	width : 60,
	align : "center",
	sortable : false
}, {
	name : 'jsbf',
	index : 'jsbf',
	width : 20,
	align : "center",
	sortable : false
}, {
	name : 'gmbl',
	index : 'gmbl',
	width : 20,
	align : "center",
	sortable : false
}, {
	name : 'odds',
	index : 'odds',
	width : 20,
	align : "center",
	sortable : false
},{
	name : 'stake',
	index : 'stake',
	width : 10,
	align : "center",
	sortable : false
}, {
	name : 'endScore',
	index : 'endScore',
	width : 10,
	align : "center",
	sortable : false,
	editable: true, 
	formatter:endFmatter
}, {
	name : 'profit',
	index : 'profit',
	width : 10,
	align : "center",
	sortable : false,
	formatter:profitFmatter
}, {
	name : 'act',
	index : 'act',
	align : "center",
	width : 30,
	formatter : actfomatter
}];
	
	jQuery(document).ready(function() {
		var param = {
				colNames : colNames,
				colModel : colModel,
				url : 'list.action'
		};
		createGrid(param);
	});  

	function createGrid(param) {
		jQuery("#gridTable").jqGrid({
			datatype : "json", //将这里改为使用JSON数据    
			mtype : 'POST',
			height : 250,
			width : $(window).width()-10,

			url : param.url,
			datatype : "json",
			colNames : param.colNames,
			colModel : param.colModel,
			pager : '#pager2', //分页工具栏,指定了jqGrid页脚显示位置
			sortname : 'ID', //排序
			sortorder : "desc",//降序
			viewrecords : true,//是否在Pager Bar显示所有记录的总数
			rowNum : 10, //每页显示记录数               
			rowList : [ 10, 20, 30 ], //可调整每页显示的记录数   
			multiselect : true, //是否支持多选   
			caption : "信息显示",
			gridComplete : function() { 
				
			},
			onSelectRow : function(id) { 
				var rowData = $("#gridTable").jqGrid("getRowData", id);
				ID= rowData.ID;
				jQuery('#gridTable').jqGrid('restoreRow', id); 
				jQuery('#gridTable').jqGrid('editRow', id, true,null, null, "update.action" , {ID:ID}, null,null, null); 
			},
			jsonReader : {  
		        root:"rows",  
		        page: "page",  
		        total: "total",  
		        records: "records",  
		        repeatitems: false,  
		        id: "id"  
		    }
		//cell中不需要各列的name，但是需要与colModel一一对应
		});
		jQuery("#gridTable").jqGrid('navGrid', '#pager2', {
			edit : true,
			add : true,
			del : true
		});
	}
	
	
	//加载数据
	function loadData() {
		
	}
	function endFmatter (cellvalue, options, rowObject) { 
		if(cellvalue == null || cellvalue == 'null') {
			return " ";
		}
		return cellvalue;
	}
	function actfomatter (cellvalue, options, rowObject) { 
		var be = "<input style='height:22px;width:40px;' type='button' value='修改' onclick=\"save("+ rowObject['id']+","+rowObject['endScore']+");\" />"; 
		var ce = "<input style='height:22px;width:40px;' type='button' value='重置' onclick=\"jQuery('#gridTable').restoreRow('" + rowObject['id'] + "');\" />"; 
		return  be + ce ;
	}
	
	function profitFmatter (cellvalue, options, rowObject) { 
		var profit =  rowObject["odds"] * rowObject["stake"]; 
		if(rowObject["endScore"] == null || rowObject["endScore"] == 'null') {
			return '&#65509; 0.0';
		}
		return '&#65509; ' + profit;
	}
	
	//保存数据
	function save(id, endscore) {
		var rowData = $("#gridTable").jqGrid("getRowData", id);
		var editparameters = {
			    "keys" : false,
			    "oneditfunc" : null,
			    "successfunc" : null,
			    "url" : "update.action?ID=123123",
			        "extraparam" : {},
			    "aftersavefunc" : null,
			    "errorfunc": null,
			    "afterrestorefunc" : null,
			    "restoreAfterError" : true,
			    "mtype" : "POST"
			}
		alert(rowData.gmbl);
		$('#gridTable').jqGrid('editRow',id,editparameters);
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

	<table id="gridTable" width ="100%" align="center"></table>
	<div id="pager2"></div>
</body>
</html>
