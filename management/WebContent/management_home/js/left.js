$(document).ready(function(){
    $(".div2").click(function(){
        $(this).next("div").slideToggle("slow")
            .siblings(".div3:visible").slideUp("slow");
    });
});