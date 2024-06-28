(function($, window, document) {

    /* Adapting window object to foundation-registry */
    var registry = $(window).adaptTo("foundation-registry");

    /*Validator for TextField - Any Custom logic can go inside validate function - starts */
    registry.register("foundation.validation.validator", {

        selector: "[data-validation=txt-validate]",
        validate: function(el) {
            var element = $(el);
            var pattern = element.data('pattern');
            var value = element.val();
            if (value.length == 0) {
                return "Please enter text";
            } else {

                patterns = {

                    phone: /([\+][0-9]{1,3}([ \.\-])?)?([\(]{1}[0-9]{3}[\)])?([0-9A-Z \.\-]{1,32})((x|ext|extension)?[0-9]{1,4}?)/,

                    email: /^[\w.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/,

                    url: /(https?|ftp):\/\/(((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?/,

                    // number: /-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?/,
                    number: /^\s*(\+|-)?((\d+(\.\d+)?)|(\.\d+))\s*$/,

                    dateISO: /\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}/,

                    alpha: /[a-zA-Z]+/,
                    alphaNumeric: /\w+/,
                    integer: /-?\d+/,
                    systemKey: /^[-_a-z0-9]+$/i

                }

                /*
                 * Test pattern if set. Pattern can be a preset regex pattern name or
                 * a regular expression such as "^\\d+$".
                 */
                if (pattern) {
                    if (patterns[pattern]) {
                        error = !patterns[pattern].test(value);
                    } else {
                        error = !(new RegExp(pattern)).test(value);
                    }

                    if (error) {
                        return "The field must match the pattern: " + pattern;
                    }
                }   

            }

        }
    });
})
($, window, document);
