<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>用户详情|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>

<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">用户详情</div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">用户ID:${user.UID}</div>
        </div>
    </div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">昵称:${user.nickName}</div>
        </div>
    </div>

    <div>
        <div class="weui-flex__item">
            <div class="placeholder">年龄:${user.age}</div>
        </div>
    </div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">生日:${user.birthday}</div>
        </div>
    </div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">tele:${user.telephone}</div>
        </div>
    </div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">恋爱状况:${ui.aboutLove}</div>
        </div>
    </div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">现居地:${ui.nowLiveAt}</div>
        </div>
    </div>
    <div>
        <div class="weui-flex__item">
            <div class="placeholder">宣言:${ui.moto}</div>
        </div>
    </div>
    <br/>
    <div>
        <div class="weui-flex__item">
            <a href="mailto:${user.email}">打招呼</a>
        </div>
    </div>
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