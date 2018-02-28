
<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
%>

<% if (post == null) { %>
    <jsp:include page="<%="Empty.jsp"%>"/>
<% return; } %>

<% if (post.getType() == Post.TEXT) { %>
<jsp:include page="<%="../views/Post1.jsp"%>"/>
<% } else if (post.getType() == Post.POEM) { %>
<jsp:include page="<%="../views/Post2.jsp"%>"/>
<% } else if (post.getType() == Post.ALBUM) { %>
<jsp:include page="<%="../views/Post3.jsp"%>"/>
<% } %>
<div class="p-wrapper">
    <div class="p-left">
    </div>
    <div class="p-right">
        <hr>
        <div class="p-footer">
            <a class="p-overview" href="#">Overview</a>
        </div>
    </div>
</div>

