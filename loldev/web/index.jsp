
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <jsp:include page="script_refs.jsp" />
    <title>Goose</title>
  </head>
  <body>

  <jsp:include page="navbar.jsp" />

  <div class="body_wrapper">
      <div class="search-container">
        <img src="/images/blueward.png">
        <div class="search-area">
          <form action="/summoner">
            <input type="text" id="search" name="search" placeholder="Summoner Name...">
            <button type="submit" value="Submit" id="searchGo">
             Scout
           </button>
          </form>
        </div>
      </div>

    <div class="select_options">
      <button class="sfilter" id="rsb" data-selected="true" onclick="selectedFilter('rsb')">
        Ranked Stats
      </button>
      <button class="sfilter" id="mhb" data-selected="false" onclick="selectedFilter('mhb')">
        Match History
      </button>
      <button class="sfilter" id="bmb" data-selected="false" onclick="selectedFilter('bmb')">
        Game Assistant Beta
      </button>
    </div>

    <div class="profile"></div>

  </div>


  </body>

  <jsp:include page="footer.jsp" />

  <script>
      $(document).ready( function () {
          $('.sfilter').each( function() {
              if ($(this).data("selected") == true) {
                  $(this).css('color', '#f2f070');
              }
          });

          $('#search').keypress(function(e){
              if(e.keyCode==13)
                  $('#searchGo').click();
          });
      })
  </script>
</html>
