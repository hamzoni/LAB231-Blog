<%@page import="Entities.About"%>
<% 
    About about = (About) request.getAttribute("about");
%>

<% if (about == null) { %>
    <jsp:include page="<%="Empty.jsp"%>"/>
<% return; } %>

<h2 class="ab-header">About Me</h2>

<div class="ab-wrapper">
    <article class="ab-article">
        <%=about.getContent()%>
    </article>
    <div class="ab-footer">
        <p class="ab-sub-sign">
            Kind regards
        </p>
        <p class="ab-sign">
            <%=about.getSignature()%>
        </p>
    </div>
</div>