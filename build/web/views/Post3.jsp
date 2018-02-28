<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
    if (post == null) return;
%>

<image class="p-image" src="<%=post.getImage(request)%>"/>