<%@page import="Utility.Tool"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Post"%>
<%
    HashMap<Integer, HashMap<Integer, ArrayList<Post>>> years = (HashMap<Integer, HashMap<Integer, ArrayList<Post>>>) request.getAttribute("posts");
%>

<h2 class="ov-header">Overview - My Blog</h2>

<%
    Iterator it = years.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        String year = pair.getKey()+ "";
        HashMap<Integer, ArrayList<Post>> months = (HashMap<Integer, ArrayList<Post>>) pair.getValue();
%>

<h3 class="ov-year-sort"><%=year%></h3>

<%
        Iterator it2 = months.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair2 = (Map.Entry)it2.next();
            String month = pair2.getKey()+ "";
            ArrayList<Post> posts = (ArrayList<Post>) pair2.getValue();

%>


<table class="ov-list">
    <tr>
        <td><%=month%></td>
        <td class="align-right">Date</td>
    </tr>
    
    <% for (Post post : posts) { %>
    <tr>
        <td>
            <a href="detail?id=<%=post.getId()%>"><%=post.getName()%></a>
        </td>
        <td class="align-right"><%= post.getDisplayDate() %></td>
    </tr>
    <% } %>
</table>


<%

            it2.remove();
        }
        
        it.remove();
    }
%>


