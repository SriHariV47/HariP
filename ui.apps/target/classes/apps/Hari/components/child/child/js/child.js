console.log('child ');

(function(document, $) {
    "use strict";

    $(document).on("dialog-ready", function() {
        var parentPagePathField = $(".parent-page-path input"),
            childPageNamesField = $(".child-page-names input"),
            childPageNamesDisplayField = $(".child-page-names-display input");

        parentPagePathField.on("change", function() {
            var parentPagePath = $(this).val();
            if (parentPagePath) {
                Granite.$.ajax({
                    url: "/bin/childpages?parentPagePath=" + parentPagePath,
                    dataType: "json",
                    success: function(data) {
                        var childPageNames = data.map(function(page) { return page.title; }).join(", ");
                        childPageNamesField.val(childPageNames);
                        childPageNamesDisplayField.val(childPageNames);
                    },
                    error: function() {
                        console.error("Failed to fetch child pages.");
                    }
                });
            }
        });
    });
})(document, Granite.$);
