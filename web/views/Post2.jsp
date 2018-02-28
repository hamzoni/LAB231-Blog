<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
    if (post == null) return;
%>

<div class="p-wrapper">
    <div class="p-left">
        <image class="p-left-deco" src="https://goo.gl/eyjL8P"/>
    </div>
    <div class="p-right">
        <div class="p-header">
            <h2>
                <a><%=post.getName()%></a>
            </h2>
            <p class="p-date"><%=post.getDisplayDate()%></p>
        </div>
        <article class="p-article">
            <p class="p-poem">
                <%=post.getContent()%>
            </p>
        </article>
    </div>
</div>

