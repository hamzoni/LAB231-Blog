
<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
%>

<% if (post == null) { %>
    <jsp:include page="<%="Empty.jsp"%>"/>
<% return; } %>

<jsp:include page="../views/Post.jsp"/>

<div class="p-wrapper">
    <div class="p-left">
    </div>
    <div class="p-right">
        <hr>
        <div class="p-footer">
            <a class="p-overview" href="overview">overview</a>
        </div>
    </div>
</div>
