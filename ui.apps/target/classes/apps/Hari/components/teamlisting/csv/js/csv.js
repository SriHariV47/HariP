<!-- mycomponent.js -->
(function() {
  function addCsvToAssetRenditions(renditionNodePath, csv) {
    console.log('ASDF');
    $.ajax({
      url: '/bin/add-csv-to-asset-renditions',
      type: "POST",
      data: { paramName1: renditionNodePath, paramName2: csv },
      success: function(response) {
        console.log("CSV file added successfully");
      },
      error: function(xhr, status, error) {
        console.error("Error adding CSV file: " + error); // Concatenate the error message with the string
        console.log("Error details:", {
          status: status,
          error: error,
          responseText: xhr.responseText
        });
      }
    });
  }

  $(document).ready(function() {
    $('#triggerButton').click(function() {
      var csvData = 'your-csv-data'; // Replace with actual CSV data
      var renditionNodePath = '/content/dam/Hari/PORTAL_SCHEMA2.xlsx/jcr:content/renditions'; // Replace with actual rendition node path
      addCsvToAssetRenditions(renditionNodePath, csvData);
    });
  });
})();
