<%@page import="Utility.Tool"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Post"%>
<%
    ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
    ArrayList<String> years = new ArrayList<String>();
    ArrayList<String> months = new ArrayList<String>();
%>

<h2 class="ov-header">Overview - My Blog</h2>

<% for (int i = 0; i < posts.size(); i++) { 
    Post post = posts.get(i);
%>
<% if (!years.contains(post.getYear())) { 
    months = new ArrayList<String>();
%>
<h3 class="ov-year-sort"><%=post.getYear()%></h3>
<% years.add(post.getYear()); } %>


<% if (!months.contains(post.getMonth())) { %>
<table class="ov-list">
    <tr class="tr-header">
        <td class="uppercase"><%=post.getMonth()%></td>
        <td class="align-right">Date</td>
    </tr>
<% months.add(post.getMonth()); } %>

<tr>
    <td>
        <a href="detail?id=<%=post.getId()%>"><%=post.getName()%></a>
    </td>
    <td class="align-right"><%= post.getDisplayDate() %></td>
</tr>

<% if (!months.contains(post.getMonth()) || i == posts.size() - 1) { %>
</table>
<% } %>

<% } %>

<jsp:include page="../views/Paginator.jsp"/>