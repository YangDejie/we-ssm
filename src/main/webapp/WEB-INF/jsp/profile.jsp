<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>个人设置|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">

</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">个人资料</div>
    <div class="weui-flex">
        <div class="weui-flex__item">
            <div class="placeholder">用户名：<br />${user.userName}</div>
        </div>
        <div class="weui-flex__item" style="width: 50%">
            <img class="avatar" src="./icon/avatar.png"  id = "preview" alt="">
        </div>
    </div>
    <ul>
        <li class onclick="javascript:window.location.href='create_activity'">
            <div class="weui-flex ">
                <p  class="weui-flex_item">发布活动</p>
                <img class="li-img" src="./icon/icon_create_activity.png" alt="">
            </div>
        </li>
        <li class onclick="javascript:window.location.href='view_activity'">
            <div class="weui-flex ">
                <p  class="weui-flex_item">查看群活动</p>
                <img class="li-img" src="./icon/icon_view_activity.png" alt="">
            </div>
        </li>
        <li class onclick="javascript:window.location.href='find_user'">
            <div class="weui-flex ">
                <p  class="weui-flex_item">搜索群员</p>
                <img class="li-img" src="./icon/icon_find_user.png" alt="">
            </div>
        </li>
        <li class onclick="javascript:window.location.href='profile_update'">
            <div class="weui-flex ">
                <p  class="weui-flex_item">个人完善</p>
                <img class="li-img" src="./icon/icon_profile.png" alt="">
            </div>
        </li>
        <li class onclick="javascript:window.location.href='my_group'">
            <div class="weui-flex ">
                <p  class="weui-flex_item">我的群</p>
                <img class="li-img" src="./icon/icon_my_group.png" alt="">
            </div>
        </li>
        <li class onclick="javascript:window.location.href='join_group'">
            <div class="weui-flex ">
                <p  class="weui-flex_item">申请入群</p>
                <img class="li-img" src="./icon/icon_group.png" alt="">
            </div>
        </li>
    </ul>
    <div class="weui-footer">
        <p class="weui-footer__links">
            <a href="javascript:void(0);" class="weui-footer__link">六度空间</a>
            <a href="index.html" class="weui-footer__link">返回首页</a>
        </p>
        <p class="weui-footer__text">Copyright © Reserved </p>
    </div>
</div>
</body>
</html>