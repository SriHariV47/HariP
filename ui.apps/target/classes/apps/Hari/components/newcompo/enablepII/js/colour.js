// /apps/your-app/components/your-component/clientlibs/site/js/color-changer.js
console.log(hello)
(function(document, $) {
    "use strict";

    $(document).on("dialog-ready", function() {
        var $colorSelect = $("coral-select[name='./color']");
        $colorSelect.on("change", function() {
            var selectedColor = $(this).val();
            // Assuming there's an element to show the color
            $('.color-display').css('background-color', selectedColor);
        });
    });
})(document, Granite.$);
