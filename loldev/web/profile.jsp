
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <jsp:include page="script_refs.jsp" />
    <title>Goose</title>

    <link rel="stylesheet" type="text/css" href="/css/profilecss.css">
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/css/circle.css">
</head>

<body>
    <jsp:include page="navbar_full.jsp" />
    <jsp:include page="sidebar.jsp" />

    <div class="col">
        <%= (String)request.getAttribute("ranked-container") %>
        <!--
            <div class="body-container">
                <div class="rank-icon-container">
                    <div id="soloQ">
                        <img src="/images/tier-icons/platinum_ii.png" height="150px" width="151px">
                    </div>
                    <div id="tier-info">
                        <ul class="tier-stats" style="list-style-type:none">
                            <li><a id="rank">Platinum II</a></li>
                            <li><a id="points">75 Points</a></li>
                            <li><a id="name">Cassiopeia's Inquisitors</a></li>
                        </ul>
                    </div>
                    <div id="win-rates">
                        <div class="c100 p52 dark center">
                            <span>52%</span>
                            <div class="slice"><div class="bar"></div><div class="fill"></div></div>
                        </div>
                    </div>
                    <div id="soloQLogo">
                        <a>SOLO</a>
                        <a id="rates">203 W / 192 L</a>
                    </div>
                </div>
            </div>
            -->
    </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>

</html>


