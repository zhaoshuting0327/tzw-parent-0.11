<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/e3.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">


</script>
<body>
<table border="1">

    <td>
        <tr>

            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品库存</td>
            <td>商品状态</td>
            <td>商品描述</td>
            <td>购买人数</td>
            <td>操作</td>

        </tr>

        <c:forEach items="${itemList}" var="s">

            <tr>
                <td>${s.tzw_item_name}</td>
                <td>${s.tzw_item_price}</td>
                <td>${s.tzw_item_num}</td>
                <td>${s.tzw_item_status}</td>

                <td>${s.tzw_item_desc}</td>
                <td>${s.peopleNum}</td>

                <td><input type="button" name="update" id="update" value="编辑">
                    <input type="button" name="delete" id="delete" value="删除"></td>


            </tr>

        </c:forEach>
    </td>

</table>
</body>
</html>
