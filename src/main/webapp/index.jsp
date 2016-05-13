<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 5/13/16
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script language="javascript" type="text/javascript">
        function clickGirl(girlId) {
            var http;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                http = new XMLHttpRequest();
            }
            else {// code for IE6, IE5
                http = new ActiveXObject("Microsoft.XMLHTTP");
            }

            http.onreadystatechange = function () {
                if (http.status == 202)
                    window.location.reload();
            };
            http.open("PUT", "girl/" + girlId);
            http.send();
        }
    </script>
</head>
<body>
<%
    System.out.println("JSP is processing");
%>

<h1>All Girls</h1>
<ul>
    <c:forEach var="i" items="${girls}">
        <li onclick="clickGirl(${i.id})">${i}</li>
    </c:forEach>
</ul>


<br/>
<br/>
<br/>
<form method="post" action="girl">
    <input type="submit" value="add new girl"/>
</form>

</body>
</html>
