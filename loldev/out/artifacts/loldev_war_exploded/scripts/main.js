/*  ************************************
 *  ************************************
 *  All client sided javascript ********
 *  ************************************
 *  ************************************
 */

function selectedFilter(filter) {
    $('.sfilter').each( function() {
        if ($(this).data("selected") == true) {
            $(this).data("selected", false);
            $(this).css('color', '#ffffff');
        }
    });
    $('#' + filter).data("selected", true);
    $('#' + filter).css('color', '#f2f070');
}

/**
 * Ajax Call to get Summoner
 */
function searchUp() {
    var summonerName = $('#search').val();
    $.ajax({
        type:'GET',
        data: {
            summonerName : summonerName
        },
        async: false,
        cache: false,
        timeout: 30000,
        url: 'AjaxDealer',
        success: function(result){
            $('.profile').html(result);
        },
        error: function() {
            alert("Could not retrieve data!");
        }
});
}
