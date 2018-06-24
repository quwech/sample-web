<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.1.4.js"></script>
    <title>陌集网</title>
    <script>
        $(function () {
            $("#btnGet").click(function () {
                $.ajax({
                    type: 'GET',
                    url: 'client/陌集网', //通过url传递name参数
                    dataType: 'json',
                    data: {
                        title: "你好"
                    }, //通过data传递title参数
                    success: function (data) {
                        alert(data.data);
                    },
                    error: function (data) {
                        alert(data.responseText);
                    }
                });
            });
        });
    </script>
</head>
<body>
${hello.username}
<br/>
<input id="btnGet" type="button" value="获取客户端数据"/>
</body>
</html>
