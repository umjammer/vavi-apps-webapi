<?xml version="1.0" encoding="Windows-31J"?>
<jsp:root
    xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:x="http://java.sun.com/jsp/jstl/xml"
    xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    version="2.1">
  <jsp:directive.page
       language="java"
       contentType="text/html; charset=Windows-31J"
       pageEncoding="Windows-31J" />
  <jsp:directive.page import="vavi.apps.umjammer00.jaxb1.*"/>
  <jsp:directive.page import="vavi.apps.umjammer00.*" />
  <jsp:directive.page import="org.restlet.*" />
  <jsp:directive.page import="org.restlet.data.*" />
  <jsp:directive.page import="org.restlet.resource.*" />
<html>
<body>

<jsp:scriptlet>
    if ("POST".equals(request.getMethod()) &amp;&amp;
        "make".equals(request.getParameter("mode"))) {

        System.setProperty("sen.home", "c:/tmp/000/sen-1.2.2.1");
        System.setProperty("yjws.appid", "umjammer_00");

        String name = request.getParameter("name");

        Test6 test6 = new Test6();

        String url = test6.query(test6.x(name));
        if (url == null) {
            url = test6.query(test6.x(name).split(" ")[0]);
        }

        request.setAttribute("name", name);
        request.setAttribute("url", url);
</jsp:scriptlet>
        ���O�F ${name}<br/>
        ���N�����F bbbb �N c �� d ��
        <div style="">
        <img src="${url}" style="width:120;height:160" /><br/>
        </div>
        <hr/>
<jsp:scriptlet>
        Test5 test5 = new Test5();

        String target = "���w�Z";
        ResultSet result1 = test5.query1(name + " " + target);
        String result2 = test5.query2(result1, "����-�ŗL����-�n��", "����");
        String result3 = test5.query2(result1, "����-�ŗL����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        xxxx �N 3 �� ${result2}${result3} ${target} ���� <br/>
        <hr />
<jsp:scriptlet>
        target = "���w�Z";
        result1 = test5.query1(name + " " + target);
        result2 = test5.query2(result1, "����-�ŗL����-�n��", "����");
        result3 = test5.query2(result1, "����-�ŗL����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        yyyy �N 3 �� ${result2}${result3} ${target} ���� <br/>
        <hr />
<jsp:scriptlet>
        target = "�����w�Z";
        result1 = test5.query1(name + " " + target);
        result2 = test5.query2(result1, "����-�ŗL����-�n��", "����");
        result3 = test5.query2(result1, "����-�ŗL����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        zzzz �N 3 �� ${result2}${result3} ${target} ���� <br/>
        <hr />
<jsp:scriptlet>
        target = test5.random.nextInt(2) == 1 ? "��w" : "���w�Z";
        result1 = test5.query1(test5.x(name) + " " + target);
        result2 = test5.query2(result1, "����-�ŗL����-�n��", "����");
        result3 = test5.query2(result1, "����-�ŗL����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        aaaa �N 3 �� ${result2}${result3} ${target} ���� <br/>
        <hr />
<jsp:scriptlet>
        target = "�";
        result1 = test5.query1(test5.x(name) + " " + target);
        result2 = test5.query2(result1, "����-���", "����");
        result3 = test5.query2(result1, "����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        ${target}�F ${result2}��${result3}���� <br/>
        <hr />
<jsp:scriptlet>
        target = "���i";
        result1 = test5.query1(test5.x(name) + " " + target);
        result2 = test5.query2(result1, "����-���", "����");
        result3 = test5.query2(result1, "����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        ${target}�F ${result2}��${result3}���� <br/>
        <hr />
<jsp:scriptlet>
        target = "�u�]���@";
        result1 = test5.query1(test5.x(name) + " " + target);
        result2 = test5.query2(result1, "����-���", "����");
        result3 = test5.query2(result1, "����", "����");
        request.setAttribute("target", target);
        request.setAttribute("result2", result2);
        request.setAttribute("result3", result3);
</jsp:scriptlet>
        ${target}�F ��Ђ�${result2}�ɐS��${result3}���� <br/>
        <hr />
        <a href="index.jsp">������x��蒼��</a><br/>
        <a href="mailto:recruit@klab.org">KLab ������Ђɂ��̗������ŉ��傷��</a>
<jsp:scriptlet>
    } else { 
</jsp:scriptlet>

<h2>��ꂫ����߁[���[</h2>

<form action="index.jsp" method="post">
 ���Ȃ��̂����O<br/>
 <input type="text" name="name" value="" />
 <input type="submit" value="��������" />
 <input type="hidden" name="mode" value="make" />
</form>

<jsp:scriptlet>
    } 
</jsp:scriptlet>

</body>

</html>

</jsp:root>
