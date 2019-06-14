<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Phone" %><%--
  Created by IntelliJ IDEA.
  User: Bad Boy
  Date: 6/14/2019
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Phone phone = (Phone) request.getAttribute("phone");

    if (phone == null) {
        phone = new Phone();
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddPhone</title>
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
        <div class="col-md-6">
            <h3>Add Phone</h3>
            <form action="/phone" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name phone" name="name">
                    <% if (errors.containsKey("name")) {%>
                    <p class="text-danger"><%= errors.get("name")%>
                    </p>
                    <%}%>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
                    <% if (errors.containsKey("price")) {%>
                    <p class="text-danger"><%= errors.get("price")%>
                    </p>
                    <%}%>
                </div>

                <%--<div class="form-group">--%>
                    <%--<label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">brand</label>--%>
                    <%--<select class="custom-select mr-sm-2" id="inlineFormCustomSelect">--%>
                        <%--<option value="nokia">Nokia</option>--%>
                        <%--<option value="apple">Apple</option>--%>
                        <%--<option value="samsung">Samsung</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label for="brand">Brand:</label>
                    <input type="text" class="form-control" id="brand" placeholder="Enter brand"
                           name="brand">
                    <%--<% if (errors.containsKey("description")) {%>--%>
                    <%--<p class="text-danger"><%= errors.get("description")%>--%>
                    <%--</p>--%>
                    <%--<%}%>--%>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" placeholder="Enter description"
                           name="password">
                    <% if (errors.containsKey("description")) {%>
                    <p class="text-danger"><%= errors.get("description")%>
                    </p>
                    <%}%>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
