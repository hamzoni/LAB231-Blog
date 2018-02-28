<%@page import="Entities.Post"%>
<% 
    Post post = (Post) request.getAttribute("post");
    if (post == null) return;
    
    String postType = "";
    String postImage = "";
    switch (post.getType()) {
        case Post.TEXT: postType = "Post1"; postImage = "KM8J9y"; break;
        case Post.POEM: postType = "Post2"; postImage = "eyjL8P"; break;
        case Post.ALBUM: postType = "Post3"; postImage = "moUPha"; break;
        default: postType = "Post1"; postImage = "KM8J9y"; break;
    }
    String postUrl = String.format("../views/%s.jsp", postType);
    
    String subpage = (String) request.getAttribute("page");
    String url = "";
    if (subpage.equals("Home")) url = "href=\"detail?id=" + post.getId() + "\"";
%>

<div class="p-wrapper">
    <div class="p-left">
        <image class="p-left-deco" src="https://goo.gl/<%=postImage%>"/>
    </div>
    <div class="p-right">
        <div class="p-header">
            <h2>
                <a <%=url%>>
                    <%=post.getName()%>
                </a>
            </h2>
            <p class="p-date"><%=post.getDisplayDate()%></p>
        </div>
        <article class="p-article">
            <jsp:include page="<%=postUrl%>"/>
        </article>
    </div>
</div>
