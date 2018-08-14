<%--
    Navbar html
--%>
<nav class="navbar navbar-expand-lg fixed-top">

    <div class="collapse navbar-collapse flex-column" id="navbar">
        <ul class="navbar-nav nav w-100">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Rankings</a>
            </li>
        </ul>

        <ul class="navbar-nav nav w-100">
            <div class="search-container-navbar">
                <form action="/summoner" id="navSearch">
                    <input type="text" placeholder="Summoner Name..." name="search" id="searchBox">
                    <button type="submit">Scout</button>
                </form>
            </div>
        </ul>
    </div>

</nav>
