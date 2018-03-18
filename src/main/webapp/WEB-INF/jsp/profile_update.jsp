<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>完善资料|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">资料完善</div>
    <form class="weui-cells weui-cells_form" action="profile_update" name ="profile_form" id="profile_form" method="post">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">昵称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="nickName" name ="nickName" type="text" placeholder="请输入你的昵称">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">姓名</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="userName" name ="userName" placeholder="请输入你的姓名">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">性别</label>
            </div>
            <div class="weui-cell__bd">
                <select class="weui-select" name="sex" id="sex" >
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">年龄</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number"  id="age" name ="age" pattern="[0-9]*" placeholder="请输入你的年龄">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">邮箱</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="email"  id="email" name ="email"  placeholder="请输入你的邮箱">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">电话</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number"  id="tele" name ="tele" pattern="[0-9]*" placeholder="请输入你的电话">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">宣言</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="moto" name ="moto" placeholder="请输入你的宣言">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">恋爱状况</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="aboutLove" name ="aboutLove" placeholder="请输入你的恋爱状况">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">故乡</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="homeTown" name ="homeTown" placeholder="请输入你的故乡">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">现居地</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="nowLiveAt" name ="nowLiveAt" placeholder="请输入你的安居地">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">职业</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="profession" name ="profession" placeholder="请输入你的职业">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">生肖</label>
            </div>
            <div class="weui-cell__bd">
                <select class="weui-select" name="zodiacSign" id="zodiacSign">
                    <option value="1">鼠</option>
                    <option value="2">牛</option>
                    <option value="3">虎</option>
                    <option value="4">兔</option>
                    <option value="5">龙</option>
                    <option value="6">蛇</option>
                    <option value="7">马</option>
                    <option value="8">羊</option>
                    <option value="9">猴</option>
                    <option value="10">鸡</option>
                    <option value="11">狗</option>
                    <option value="12">猪</option>
                </select>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">公司</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="company" name ="company" placeholder="请输入你的公司">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">星座</label>
            </div>
            <div class="weui-cell__bd">
                <select class="weui-select" name="constellation" id="constellation">
                    <option value="1">白羊座</option>
                    <option value="2">金牛座</option>
                    <option value="3">双子座</option>
                    <option value="4">巨蟹座</option>
                    <option value="5">狮子座</option>
                    <option value="6">处女座</option>
                    <option value="7">天秤座</option>
                    <option value="8">天蝎座</option>
                    <option value="9">射手座</option>
                    <option value="10">摩羯座</option>
                    <option value="11">水瓶座</option>
                    <option value="12">双鱼座</option>
                </select>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">生日</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="date"  id="birthday" name ="birthday" value>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">血型</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="bloodCate" name ="bloodCate" placeholder="请输入你的血型">
            </div>
        </div>
    </form>
    <div class="weui-cells__tips"></div>
    <input  type="submit" value="保存" form ="profile_form" />
    <div class="weui-cells__tips"></div>
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