<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入</title>
<link href="css/base/base_button.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="js/colorbox/jquery.colorbox.js"></script>
<script type="text/javascript">

	//更改账户余额
		function alter() {
		
		var amount = $("#amount").val();
		$.ajax({
			url : "alterAmount.action",
			data : {
				amount : amount
			},  
			type: "post",
			async: true,
			success: function(json) {
				if (json == "true") {
					parent.$.fn.colorbox.close();
					location.reload();
				} else {
					alter('失败');
				}
			},
			error: function(json) {
				
			}
		});
	}
</script>
</head>
<body background="images/moneybackground.jpg">
<table width="100%">
	<tr>
		<th width="100px" >金额：</th>
		<td><input class="mytxt" id="amount" type="text" style="width:150px;height:20px" /></td>
		<td align="right"><a href="#" onclick="alter();" class="button orange bigrounded ">提交</a>
		</td>
	</tr>

</table>
</body>
</html>