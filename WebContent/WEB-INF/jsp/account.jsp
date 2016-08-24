<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Tutorial - Free Pricing Table UI Element</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/cloudflare.js" async=""></script>
<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	//<![CDATA[
	try {
		if (!window.CloudFlare) {
			var CloudFlare = [ {
				verbose : 0,
				p : 0,
				byc : 0,
				owlid : "cf",
				bag2 : 1,
				mirage2 : 0,
				oracle : 0,
				paths : {
					cloudflare : "/cdn-cgi/nexp/dokv=88e434a982/"
				},
				atok : "7c523ad980dc3f17e972bb485300d7bc",
				petok : "1c0cb2dbb9bcb2ccb25fff2e6fc7e2e61e4c75ea-1409196074-1800",
				zone : "flashuser.net",
				rocket : "0",
				apps : 0
			} ];
			CloudFlare.push({
				"apps" : {
					"ape" : "0fa19ad3be701d80d91a635ffbf67efa"
				}
			});
			!function(a, b) {
						a = document.createElement("script"),
						b = document.getElementsByTagName("script")[0],
						a.async = !0,
						a.src = "//ajax.cloudflare.com/cdn-cgi/nexp/dokv=97fb4d042e/cloudflare.min.js",
						b.parentNode.insertBefore(a, b)
			}()
		}
	} catch (e) {
	};
	//]]>
	
	function dateInit() {
		var d = new Date()
		var vYear = d.getFullYear()
		var vMon = d.getMonth() + 1
		var vDay = d.getDate()
		var h = d.getHours(); 
		var m = d.getMinutes(); 
		var se = d.getSeconds(); 	
		s = vYear + '/' + (vMon < 10 ? "0" + vMon : vMon)
			+ '/' + (vDay < 10 ? "0" + vDay : vDay) + ' '
			+ (h < 10 ? "0" + h : h) + ':' + (m < 10 ? "0" + m : m)
			+ ':' + (se < 10 ? "0" + se : se);
		$('#time').html("截止当前时间：" + s);	
		$('#timeCZ').html("截止当前时间：" + s);	
		$('#timeTX').html("截止当前时间：" + s);	
	}
	
	jQuery(document).ready(function() {
		dateInit();
	});
</script>
<link type="text/css" href="css/account/styles.css" rel="stylesheet"
	media="all">
<link href="css/account/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
.cf-hidden {
	display: none;
}

.cf-invisible {
	visibility: hidden;
}
</style>
<link rel="stylesheet" type="text/css" href="css/account/injected.css">
</head>
<body>
	<div id="menu-holder">
		<div class="price_table">
			<div class="column_1" >
				<ul>
					<li class="header_row_1 align_center">
						<div class="pack-title">账户详细</div>
					</li>
					<li class="header_row_2 align_center">
						<div class="price">
							<span id="amount">￥${amount}</span>
						</div>
						<div class="time"><span id = "time"></span></div>
					</li>
					<li class="row_style_1 align_center"><span>Lorem ipsum
							dolor sit</span></li>
					<li class="row_style_1 align_center"><span>Praesent ac
							elit</span></li>
					<li class="row_style_1 align_center"><span>Duis quis
							risus enim</span></li>
					<li class="row_style_1 align_center no-option"><span>Suspendisse
							rutrum nulla</span></li>
					<li class="row_style_1 align_center no-option"><span>Quisque
							mauris urna feugiat</span></li>
					<li class="row_style_footer_1"><a href="#" class="buy_now">更改</a></li>
				</ul>
			</div>
			<div class="column_1">
				<ul>
					<li class="header_row_1 align_center">
						<div class="pack-title">今日充值</div>
					</li>
					<li class="header_row_2 align_center">
						<div class="price">
							<span>$69</span>
						</div>
						<div class="time"><span id = "timeCZ"></span></div>
					</li>
					<li class="row_style_2 align_center"><span>资金流动</span></li>
					<li class="row_style_2 align_center"><span>Praesent ac
							elit</span></li>
					<li class="row_style_2 align_center"><span>Duis quis
							risus enim</span></li>
					<li class="row_style_2 align_center"><span>Suspendisse
							rutrum nulla</span></li>
					<li class="row_style_2 align_center no-option"><span>Quisque
							mauris urna feugiat</span></li>
					<li class="row_style_footer_2">
					<a href="#" class="buy_now">充值</a></li>
				</ul>
			</div>
			<div class="column_1">
				<ul>
					<li class="header_row_1 align_center">
						<div class="pack-title">今日提现</div>
					</li>
					<li class="header_row_2 align_center">
						<div class="price">
							<span>$179</span>
						</div>
						<div class="time"><span id = "timeTX"></span></div>
					</li>
					
					<li class="row_style_1 align_center"><span>资金流动</span></li>
					<li class="row_style_1 align_center"><span>Praesent ac
							elit</span></li>
					<li class="row_style_1 align_center"><span>Duis quis
							risus enim</span></li>
					<li class="row_style_1 align_center"><span>Suspendisse
							rutrum nulla</span></li>
					<li class="row_style_1 align_center"><span>Quisque
							mauris urna feugiat</span></li>
					<li class="row_style_1 align_center"><span>Quisque
							mauris urna feugiat</span></li>
					<li class="row_style_1 align_center"><span>Quisque
							mauris urna feugiat</span></li>
					
					<li class="row_style_footer_1">
					
					<a href="#" class="buy_now">提现</a></li>
				</ul>
			</div>
		</div>
		<div class="column-clear"></div>
		<div class="content">
			<p>Tutorial - Free Pricing Table UI Element</p>
			<p id="home">
				<a class="go"
					href="http://www.flashuser.net/css3-pricing-table-ui-element"
					title="">Go to article page</a>
			</p>
		</div>
	</div>


</body>
</html>