<%@page import="Utility.Tool"%>
<%
    int i = Tool.toInt(request.getParameter("page") + "");
    int c = (Integer) request.getAttribute("count");
    if (c == -1) return;
    if (i == -1) i = 1;
%>


<nav class="pag-nav">
    <% for (int j = 1; j <= c; j++) { %>
    <a 
        <% if (j == i) { %>
            class="active"
        <% } else { %>
            href="?page=<%=j%>"
        <% } %>
    >
        <%=j%>
    </a>
    <% } %>
</nav>