/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

    var itemsAdded = 0;

    // Registering click event for multifield add button
    $(document).on("click", ".coral-Multifield-add", function() {
        itemsAdded++; // Increment the counter when the add button is clicked
        if (itemsAdded === 6) {
            window.alert("You have added six items. You cannot add more."); // Show alert after the sixth click
        }
    });

})(jQuery, Coral);
/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

    var registry = $(window).adaptTo("foundation-registry");

    // Counter to keep track of the number of items added
    var itemsAdded = 0;


    registry.register("foundation.validation.validator", {
        selector: "[data-validation=geeks-multifield]",
        validate: function(element) {
            var el = $(element);
            let max = el.data("max-items");
            let items = el.children("coral-multifield-item").length;
            let domitems = el.children("coral-multifield-item");
            console.log("{} : {} :{} ", max,items);
            if (items > max) {
                /* Use below line if you don't want to add item in multifield more than max limit */
                // domitems.last().remove();
                window.alert("You can add maximum " + max + " books. You are trying to add " + items + "th book.");
                return false; // returning false to prevent addition of new item
            }
        }
    });

    // Registering click event for multifield add button
    $(document).on("click", ".coral-Multifield-add", function() {
        itemsAdded++; // Increment the counter when the add button is clicked
        if (itemsAdded >= 5) {
            window.alert("You have added six items. You cannot add more."); // Show alert after the sixth click
            itemsAdded = 0; // Resetting the counter
        }
    });

    // Validation before form submission
    $(document).on("click", ".cq-dialog-submit", function(event) {
        // Perform validation before submitting the form
        var form = $(this).closest("form");
        var valid = true;
        form.find("[data-validation=geeks-multifield]").each(function() {
            if (!registry.get("foundation.validation.validator", $(this)).validate()) {
                valid = false;
            }
        });
        if (!valid) {
            event.preventDefault(); // Prevent form submission if validation fails
        }
    });

})(jQuery, Coral);
