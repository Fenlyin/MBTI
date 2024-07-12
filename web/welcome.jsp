<%@ page pageEncoding="UTF-8"%>
<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/table.css" />--%>
<%--</head>--%>
<%--<body>--%>
<%--	<img src="res/images/PuFu.jpg" style="width: 100%; height: 100%; object-fit: cover">--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>MBTI职业性格测试</title>
	<style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(to right, #49dff3, #a2c1e2);
            animation: bg-animation 10s ease-in-out infinite alternate;
        }

        .text {
            font-size: 48px;
            font-family: 'Arial Black', sans-serif;
            color: white;
            text-align: center;
            text-shadow: 0 0 10px #000, 0 0 20px #000, 0 0 30px #000, 0 0 40px #007bff, 0 0 70px #007bff, 0 0 80px #007bff, 0 0 100px #007bff;
            animation: text-animation 3s infinite;
        }

        @keyframes bg-animation {
            from {
                background-position: 0 0;
            }
            to {
                background-position: 100% 0;
            }
        }

        @keyframes text-animation {
            0%, 100% {
                transform: scale(1);
                text-shadow: 0 0 10px #000, 0 0 20px #000, 0 0 30px #000, 0 0 40px #007bff, 0 0 70px #007bff, 0 0 80px #007bff, 0 0 100px #007bff;
            }
            50% {
                transform: scale(1.1);
                text-shadow: 0 0 20px #000, 0 0 30px #000, 0 0 40px #000, 0 0 50px #007bff, 0 0 80px #007bff, 0 0 90px #007bff, 0 0 110px #007bff;
            }
        }
	</style>
</head>
<body>
<div class="text">MBTI职业性格测试</div>
</body>
</html>