<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>申请邀请码|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
    <!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">获取邀请码</div>
    <form class="weui-cells weui-cells_form" action="invite_code" id="invite_code" method="post">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">群ID</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" id="GID" name ="GID" type="number" pattern="[0-9]*" placeholder="请输入你管理的群 ID">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label">邀请码</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text"  id="inviteCode" name ="inviteCode" placeholder="请设置邀请码">
                </div>
            </div>        
    </form>
        <div class="weui-cells__tips"></div>
        <input  type="submit" value="确认" form ="invite_code" />
        <div class="weui-cells__tips"></div>
    <div class="weui-footer">
            <p class="weui-footer__links">
                <a href="javascript:void(0);" class="weui-footer__link">六度空间</a>
                <a href="../../index.jsp" class="weui-footer__link">返回首页</a>
            </p>
            <p class="weui-footer__text">Copyright © Reserved </p>
    </div>
</div>
</body>
</html>