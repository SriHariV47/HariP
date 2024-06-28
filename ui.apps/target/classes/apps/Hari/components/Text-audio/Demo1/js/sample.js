(function(document, $) {
    'use strict';

    $(document).on('dialog-ready', function() {
        var dialog = $(this);

        dialog.find('form').on('submit', function(e) {
            e.preventDefault();

            var text = dialog.find("[name='./text']").val();

            $.ajax({
                url: '/bin/textToSpeech',
                type: 'POST',
                data: JSON.stringify({ text: text }),
                contentType: 'application/json',
                success: function(response) {
                    var jsonResponse = JSON.parse(response);
                    alert("Audio URL: " + jsonResponse.audioUrl);
                },
                error: function(xhr, status, error) {
                    alert("An error occurred: " + error);
                }
            });
        });
    });
})(document, Granite.$);
