<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
%>

<image class="p-thumbnail" src="<%=post.getImage(request)%>"/>
            
<%=post.getContent()%>