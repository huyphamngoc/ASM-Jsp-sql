<%@ page import="entity.Phone" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Bad Boy
  Date: 6/14/2019
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList<Phone> feedbacks = (ArrayList<Phone>) request.getAttribute("listPhone");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Phone</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>List Phone</h3>
        </div>
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Brand</th>
                </tr>
                </thead>
                <tbody>

                <%
                    Iterator it = feedbacks.iterator();
                    while (it.hasNext()) {
                        Phone b = (Phone) it.next();
                %>
                <tr>
                    <td><%=b.getName()%>
                    </td>
                    <td><%=b.getPrice()%>
                    </td>
                    <td><%=b.getBrand()%>
                    </td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
