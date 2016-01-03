<!DOCTYPE html>
<html>
<head>
	<title>PhantomJS Rendering Page</title>
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<style type="text/css">
		body {
			background: #ffffff url("/image/bg.png") no-repeat;
		}

		#name {
			width: 350px;
			text-align: center;
			margin-top: 195px;
		}

		#price {
			width: 350px;
			text-align: center;
			margin-top: 10px;
			font-size: 45px;
			color: red;
		}

		#qrCode {
			margin-left: 75px;
			width: 200px;
			height: 200px;
		}

		#barcode {
			width: 350px;
			height: 100px;
		}
	</style>
</head>
<body>
	<div id="name">
		${name}님! 크리스마스 쿠폰이 도착했습니다! <br/><br/>
		<p style="font-size:11px;">현장에서 QR코드 혹은 바코드를 보여주시면 할인됩니다!</p>
	</div>

	<div id="price">
		${price}원
	</div>

	<img id="qrCode" alt="QRCode" src="data:image/png;base64,${qrCode}"/> <br/>
	<img id="barcode" alt="Barcode" src="data:image/png;base64,${barcode}"/>
</body>
</html>
