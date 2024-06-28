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
package org.apache.sling.scripting.sightly.apps.Hari.components.jsondata;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class jsondata_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<h1>\tJson data submit button Component</h1>\n\n<!DOCTYPE html>\n<html>\n<head>\n    <title>Submit Button Example</title>\n    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n    <script>\n        $(document).ready(function(){\n            $(\"#submitButton\").click(function(){\n                $.ajax({\n                    type: \"GET\",\n                    url: \"/bin/er/edf\",\n                    success: function(data){\n                        // Check if data is JSON\n                        if (typeof data === 'object') {\n                            // Convert JSON object to string\n                            data = JSON.stringify(data);\n                        }\n                        // Update a specific HTML element with the received data\n                        $(\"#responseData\").text(data);\n                    },\n                    error: function(xhr, status, error) {\n                        console.error(\"Error occurred:\", error);\n                    }\n                });\n            });\n        });\n    </script>\n</head>\n<body>\n\n    <button id=\"submitButton\">Submit</button>\n\n    <!-- This is the element where the received data will be displayed -->\n    <div id=\"responseData\"></div>\n\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

