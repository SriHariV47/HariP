/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.Hari.components.pdfcomponent;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class pdfcomponent_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<!DOCTYPE html>\n<html>\n<head>\n    <title>Download and Send PDF</title>\n    <style>\n        body {\n            background-color: lightgray; /* A light background for contrast */\n        }\n        #content {\n            padding: 20px;\n            margin: 20px;\n            border-radius: 10px;\n            position: relative;\n            text-align: left;\n        }\n        .content-text {\n            display: flex;\n            align-items: center;\n            justify-content: left;\n        }\n        #dynamicName {\n            display: inline-block;\n            background-color: #050C9C; /* The desired background color for the text field */\n            color: white; /* Ensure text is readable */\n            padding: 10px;\n            border-radius: 5px;\n            margin: 0;\n        }\n        .content-image {\n            width: 25px; /* Set a suitable width for the image */\n            height: auto; /* Maintain aspect ratio */\n            margin-left: 10px;\n        }\n    </style>\n    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js\"></script>\n</head>\n<body>\n    <div id=\"content\">\n        <div class=\"content-text\" id=\"dynamicContent\">\n            <p id=\"dynamicName\">SRIHARI VARAKALA NARASIMHA RAO VARAKALA</p>\n            <img src=\"https://static.vecteezy.com/system/resources/previews/000/338/538/original/vector-printer-icon.jpg\" class=\"content-image\" alt=\"Printer Icon\"/>\n        </div>\n    </div>\n    <button id=\"downloadButton\" onclick=\"downloadAndSendPDF()\">Download PDF</button>\n\n    <script>\n        document.addEventListener('DOMContentLoaded', (event) => {\n            // Get the dynamic content element\n            var dynamicContent = document.getElementById('dynamicContent');\n\n            // Add a click event listener to the dynamic content\n            dynamicContent.addEventListener('click', function() {\n                // Call the downloadAndSendPDF() function when the dynamic content is clicked\n                downloadAndSendPDF();\n            });\n        });\n\n        function downloadAndSendPDF() {\n            var button = document.getElementById('downloadButton');\n            button.style.visibility = 'hidden';\n\n            // Generate PDF from the content\n            var element = document.getElementById('content');\n            html2pdf().from(element).set({\n                margin: 1,\n                filename: 'generated.pdf',\n                html2canvas: { scale: 2 },\n                jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }\n            }).toPdf().output('blob').then(function (pdfBlob) {\n                // Create a link element\n                var url = window.URL.createObjectURL(pdfBlob);\n                var a = document.createElement('a');\n                a.style.display = 'none';\n                a.href = url;\n                a.download = 'generated.pdf';\n\n                // Append the link to the body\n                document.body.appendChild(a);\n                a.click();\n\n                // Remove the link\n                window.URL.revokeObjectURL(url);\n                document.body.removeChild(a);\n\n                button.style.visibility = 'visible';\n            });\n        }\n    </script>\n</body>\n</html>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

