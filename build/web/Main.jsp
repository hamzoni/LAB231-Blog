<%@page import="Utility.FileIO"%>
<%@page import="Utility.Tool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String subpage = (String) request.getAttribute("page");
    if (subpage == null) subpage = "404";
    if (subpage != null) {
        if (subpage.length() == 0) {
            subpage = "404";
        }
    }
    boolean isAbout = subpage.equals("About");
    
    String fn = "pagecounter.txt";
    int n = Tool.toInt(FileIO.read(fn) + "");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <section class="container">
            <header class="header">
                <div class="header-content">
                    <h1 class="mainheader">Blogging About My Life</h1>
                    <h4 class="subheader">Welcome to my blog</h4>
                </div>
                <nav class="navbar">
                    <a class="<% if (!isAbout) { %>active<% }; %>" href="home">My Blog</a>
                    <a class="<% if (isAbout) { %>active<% }; %>" href="about">About Me</a>
                </nav>
            </header>
            <!-- end of header -->
            <section class="wrapper">
                <div class="wrapper-left">
                    <jsp:include page="<%="pages/"+ subpage +".jsp"%>"/>
                </div>
                <div class="wrapper-right">
                    <div class="sidebar-wrapper">
                        <h4 class="sidebar-title">Share this page</h4>
                        <ul>
                            <li><a href="#">Share on Facebook</a></li>
                            <li><a href="#">Share on Twitter</a></li>
                            <li><a href="#">Share on Google+</a></li>
                        </ul>
                    </div>
                    <div class="sidebar-wrapper">
                        <div class="blankspace"></div>
                    </div>
                </div>
                
                <footer class="footer">
                    <div class="view-counter"><%=n + ""%></div>
                </footer>
            </section>
            <!-- end of wrapper -->
        </section>
        
    </body>
</html>
