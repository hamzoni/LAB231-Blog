<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Post"%>
<%
  ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
%>

<% for (Post post : posts) { %>
    <% request.setAttribute("post", post); %>
    <% if (post.getType() == Post.TEXT) { %>
    <jsp:include page="<%="../views/Post1.jsp"%>"/>
    <% } else if (post.getType() == Post.POEM) { %>
    <jsp:include page="<%="../views/Post2.jsp"%>"/>
    <% } else if (post.getType() == Post.ALBUM) { %>
    <jsp:include page="<%="../views/Post3.jsp"%>"/>
    <% } %>
<% } %>