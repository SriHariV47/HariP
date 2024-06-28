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
package org.apache.sling.scripting.sightly.apps.Hari.components.title3;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class title3_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("\n\nTitle3\n<form action=\"/bin/generatepdf\" method=\"get\">\n\n    <button type=\"submit\">Submit</button>\n</form>\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n    <title>Generate PDF</title>\n</head>\n<body>\n    <div>\n        <label for=\"component1\">Component 1:</label>\n        <input type=\"text\" id=\"component1\"/>\n    </div>\n    <div>\n        <label for=\"component2\">Component 2:</label>\n        <input type=\"text\" id=\"component2\"/>\n    </div>\n    <div>\n        <label for=\"component3\">Component 3:</label>\n        <input type=\"text\" id=\"component3\"/>\n    </div>\n    <button onclick=\"generatePDF()\">Generate PDF</button>\n\n    <script>\n        function generatePDF() {\n            const component1 = document.getElementById('component1').value;\n            const component2 = document.getElementById('component2').value;\n            const component3 = document.getElementById('component3').value;\n\n            fetch('/generate-pdf', {\n                method: 'POST',\n                headers: {\n                    'Content-Type': 'application/json'\n                },\n                body: JSON.stringify({ component1, component2, component3 })\n            })\n            .then(response => {\n                if (!response.ok) {\n                    throw new Error('Failed to generate PDF');\n                }\n                return response.blob();\n            })\n            .then(blob => {\n                const url = window.URL.createObjectURL(blob);\n                const a = document.createElement('a');\n                a.href = url;\n                a.download = 'generated.pdf';\n                document.body.appendChild(a);\n                a.click();\n                window.URL.revokeObjectURL(url);\n            })\n            .catch(error => {\n                console.error('Error generating PDF:', error);\n            });\n        }\n    </script>\n</body>\n</html>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

