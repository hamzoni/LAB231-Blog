<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
%>

<p class="p-poem">
    <%=post.getContent()%>
</p>