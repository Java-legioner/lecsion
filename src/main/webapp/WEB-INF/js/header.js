$( document ).ready(function() {
    $('.leftmenutrigger').on('click', function(e) {
        $('.side-nav').toggleClass("open");
        e.preventDefault();
    });
});

$("button.header-logout").click(function() {


    $.get("logout", function(data) {
        if(data != ''){
            let customUrl = '';
            let urlContent = window.location.href.split('/');
            for (let i = 0; i < urlContent.length - 1; i++) {
                customUrl += urlContent[i] + '/'
            }
            customUrl += data;
            window.location = customUrl;
        }

        // $("form")[1].reset();
    });

});

$(document).ready(function () {
    $.get('user-role', function (data) {
        if(data !== ''){
            userRole = data;
        }
    }).done(function () {
        if(userRole === 'ADMIN'){
            $('li.user-bucket-option').hide();
        }
    })

});