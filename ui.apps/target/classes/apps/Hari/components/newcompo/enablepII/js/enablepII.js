(function (document, $) {
    "use strict";

    $(document).on("foundation-contentloaded", function () {
        function showHide(component, element) {
            var target = $(element).data("cqDialogShowhideTarget");
            var $target = $(target);

            if (target) {
                if (component.checked) {
                    $target.find('input, select, textarea, button').prop('disabled', false);
                } else {
                    $target.find('input, select, textarea, button').prop('disabled', true);
                    if ($target.find('input, select, textarea, button').prop('type') !== 'checkbox') {
                        $target.find('input, select, textarea, button').val('');
                    }
                }
            }
        }

        function checkboxShowHideHandler(el) {
            el.each(function (i, element) {
                if ($(element).is("coral-checkbox")) {
                    Coral.commons.ready(element, function (component) {
                        showHide(component, element);
                        component.on("change", function () {
                            showHide(component, element);
                        });
                    });
                } else {
                    var component = $(element).data("checkbox");
                    if (component) {
                        showHide(component, element);
                    }
                }
            });
        }

        $(document).on("foundation-contentloaded", function (e) {
            checkboxShowHideHandler($(".cq-dialog-showhide", e.target));
        });

        $(document).on("change", ".cq-dialog-showhide", function (e) {
            checkboxShowHideHandler($(this));
        });
    });

})(document, Granite.$);
