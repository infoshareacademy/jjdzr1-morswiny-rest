$(document).ready(function () {

    $("button.favourite-heart").click(function () {

        let $element = $(this).find('svg').toggleClass('fav-heart-unactive fav-heart-active');

        let active = $element.hasClass('fav-heart-active') ? 1 : 0;

        let idEvent = $(this).data('idevent');

        $.get( "/favourite", { idEvent: idEvent, active: active } )
            .done(function( data ) {
                console.log( "Data Loaded: " + data );
            }).fail(function () {
            // alert("error");
        })
            .always(function () {
                // alert("finished");
            });
    });

});