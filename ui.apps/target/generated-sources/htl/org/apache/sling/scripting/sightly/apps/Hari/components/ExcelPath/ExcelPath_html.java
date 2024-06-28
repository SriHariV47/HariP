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
package org.apache.sling.scripting.sightly.apps.Hari.components.ExcelPath;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class ExcelPath_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<html>\n<body>\n <h1>File Upload Excel</h1>\n <h2>Select File</h2>\n <form id=\"uploadForm\" enctype=\"multipart/form-data\">\n <input type=\"file\" id=\"file\" name=\"selectedfile\" multiple/><br/><br/>\n <input type=\"button\" value=\"Upload\" onclick=\"uploadFile()\"/>\n </form>\n <div id=\"response\"></div>\n\n    <script>\n        function uploadFile() {\n            var form = document.getElementById('uploadForm');\n            var formData = new FormData(form);\n\n            var xhr = new XMLHttpRequest();\n            xhr.open('POST', '/bin/zip/excelzipfile', true);\n            xhr.responseType = 'blob'; // Set response type to blob\n            xhr.onload = function() {\n                if (xhr.status === 200) {\n                    var blob = xhr.response;\n                    var link = document.createElement('a');\n                    link.href = window.URL.createObjectURL(blob);\n                    link.download = 'my-package- + vesrsion +.zip'; // Set the name of the downloaded file\n                    link.click();\n                }\n            };\n            xhr.send(formData);\n        }\n    </script>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

