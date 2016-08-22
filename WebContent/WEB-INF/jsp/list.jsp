<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>列表</title>
<link href="css/ui-lightness/jquery-ui-1.8.12.custom.css"
	rel="stylesheet" type="text/css" />
<link href="css/ui.jqgrid.css" rel="stylesheet" type="text/css" />
<link href="css/base/base_button.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.8.12.custom.min.js" type="text/javascript"></script>
<script src="js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min-3.8.js" type="text/javascript"></script>
<script type="text/javascript">
	var colNames = [ '序号', '彩票ID', '彩票种类', '彩票类型', '购彩时间', '购买种类', '队伍信息',
			'即时比分', '购买比率', '赔率', '购买金额', '比赛结果', '盈利', '状态' ];
	var colModel = [ {
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
		width : 55,
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
	}, {
		name : 'stake',
		index : 'stake',
		width : 15,
		align : "center",
		sortable : false
	}, {
		name : 'endScore',
		index : 'endScore',
		width : 15,
		align : "center",
		sortable : false,
		editable : true,
		formatter : endFmatter
	}, {
		name : 'profit',
		index : 'profit',
		width : 10,
		align : "center",
		sortable : false,
		formatter : profitFmatter,
		cellattr : addCellAttr
	}, {
		name : 'status',
		index : 'status',
		width : 10,
		align : "center",
		sortable : false,
		formatter : statusFmatter
	} ];

	jQuery(document).ready(function() {
		var param = {
			colNames : colNames,
			colModel : colModel,
			url : 'list.action'
		};
		createGrid(param);
		if (showProfit() == true) {
			showprofitBy();
		}
	});

	function createGrid(param) {
		jQuery("#gridTable").jqGrid(
				{
					datatype : "json", //将这里改为使用JSON数据    
					mtype : 'POST',
					height : 250,
					width : $(window).width() - 10,

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
						ID = rowData.ID;
						jQuery('#gridTable').jqGrid('restoreRow', id);
						jQuery('#gridTable').jqGrid('editRow', id, true, null,
								load, "update.action", {
									ID : ID
								}, null, null, null);
					},
					jsonReader : {
						root : "rows",
						page : "page",
						total : "total",
						records : "records",
						repeatitems : false,
						id : "id"
					}
				//cell中不需要各列的name，但是需要与colModel一一对应
				});
		jQuery("#gridTable").jqGrid('navGrid', '#pager2', {
			edit : true,
			add : true,
			del : true
		});
	}

	function addCellAttr(rowId, val, rawObject, cm, rdata) {
		if (rawObject.profit > 0) {
			return "style='color:red'";
		} else if (val < 0) {
			return "style='color:blue'";
		}
	}

	//加载数据
	var load = function loadData() {
		jQuery("#gridTable").jqGrid('setGridParam', {
			url : "list.action",
			datatype : 'json'

		}).trigger('reloadGrid');//重新载入
		showprofitBy();
	}

	function endFmatter(cellvalue, options, rowObject) {
		if (cellvalue == null || cellvalue == 'null') {
			return " ";
		}
		return cellvalue;
	}

	function statusFmatter(cellvalue, options, rowObject) {
		return cellvalue == '0' ? "<font color='#FF0000'>" + '未结算' + "</font> "
				: '已结算';
	}

	function profitFmatter(cellvalue, options, rowObject) {

		if (cellvalue > 0) {
			return "<font color='#FF0000'>" + '&#65509;' + cellvalue
					+ "</font> ";
		} else if (cellvalue < 0) {
			return "<font color='#0000FF'>" + '&#65509;' + cellvalue
					+ "</font> ";
		}
		return "<font>" + '&#65509;' + cellvalue + "</font> ";
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
			"errorfunc" : null,
			"afterrestorefunc" : null,
			"restoreAfterError" : true,
			"mtype" : "POST"
		}
		alert(rowData.gmbl);
		$('#gridTable').jqGrid('editRow', id, editparameters);
		showprofitBy();
	}

	function save() {
		var ticketInfo = $('#ticketInfo').val();
		if (jQuery("#gridTable").jqGrid('setGridParam', {
			url : "save.action?ticketInfo=" + ticketInfo,
			datatype : 'json'

		}).trigger('reloadGrid') != null ){
		showprofitBy();
			
		}//重新载入
		
	}

	function showprofitBy() {
		$.ajax({
			type : "POST", //提交方式
			dataType : "json", //类型
			url : "getProfitInfo.action", //提交的页面，方法名
			data : "json", //参数，如果没有，可以为null
			success : function(data) { //如果执行成功，那么执行此方法
				var profit = eval(data);
				$('#date').html("日期：" + profit.date);
				$('#balance').html("账户余额：" + '&#65509;' + profit.balance);
				$('#amount').html("下注金额：" + '&#65509;' + profit.bet_amount);
				if (profit.bet_profit > 0) {
					$('#profit').html(
							"收益：" + "<font color='#FF0000'>"
							 + '&#65509;' + profit.bet_profit + "</font>");
				} else {
					$('#profit').html(
							"收益：" + "<font color='#0000FF'>"
							 + '&#65509;' + profit.bet_profit + "</font>");
				}
			},
			error : function(err) { //如果执行不成功，那么执行此方法
				alert("err:" + err);
			}
		});

	}

	function showProfit() {
		var date = '${profit.date}';
		var balance = '${profit.balance}';
		var bet_amount = '${profit.bet_amount}';
		var bet_profit = '${profit.bet_profit}';

		var div = "";
		div += "<table width='100%'>";
		div += "<tr>";
		div += "<td id='date' width='25%'>日期：" + date + "</td>";
		div += "<td id='balance' width='25%'>账户余额：" + '&#65509;' + balance
				+ "</td>";
		div += "<td id='amount' width='25%'>下注金额：" + '&#65509;' + bet_amount
				+ "</td>";
		if (bet_profit >= 0) {
			div += "<td id='profit' width='25%'>收益：<font color='#FF0000'>"
					+ '&#65509;' + bet_profit + "</font></td>";
		} else {
			div += "<td id='profit' width='25%'>收益：<font color='#0000FF'>"
					+ '&#65509;' + bet_profit + "</font></td>";
		}
		div += "</tr>";
		div += "</table>";
		$('#append').append(div);
		return true;
	}
</script>
</head>
<body>

	<input class="mytxt" id="ticketInfo" type="text" width="80%"
		height="10px">
	<a href="#" onclick="save();" class="button orange bigrounded ">整理并保存到数据库</a>
	<br>
	<div id="append"></div>
	<table id="gridTable" width="100%" align="center"></table>
	<div id="pager2"></div>
</body>
</html>
