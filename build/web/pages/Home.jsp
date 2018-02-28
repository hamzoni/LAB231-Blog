<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Post"%>
<%
  ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
%>

<% for (Post post : posts) { %>
    <% request.setAttribute("post", post); %>
    <jsp:include page="../views/Post.jsp"/>
<% } %>