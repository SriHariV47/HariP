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
package org.apache.sling.scripting.sightly.apps.Hari.components.newcompo;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class newcompo_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
Object _global_colors = null;
out.write("<h2>hello</h2>\n\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n<title>Color Display</title>\n<script>\n    function changeColor() {\n        var color = document.getElementById(\"color-selectors\").getAttribute(\"colour\");\n        document.getElementById(\"color-display\").style.backgroundColor = color;\n    }\n</script>\n</head>\n<body>\n<div id=\"color-selectors\"");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "colors");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            Object var_shoulddisplayattr3 = ((renderContext.getObjectModel().toBoolean(var_attrcontent1) ? var_attrcontent1 : ("false".equals(var_attrvalue0))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr3)) {
                out.write(" colour");
                {
                    boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                    if (!var_istrueattr2) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" oninput=\"changeColor()\">\n    <!-- Your color selectors here -->\n</div>\n\n\n\n<div>");
{
    String var_4 = ((" Checkbox: " + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "checkbox")) ? "checked" : "unchecked"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</div>\n\n");
_global_colors = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "checkbox");
if (renderContext.getObjectModel().toBoolean(_global_colors)) {
    out.write("<div>\n\n<div id=\"color-display\" style=\"width: 100px; height: 50px;\">");
    {
        String var_5 = (("\n" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "colors"), "text"))) + "\n");
        out.write(renderContext.getObjectModel().toString(var_5));
    }
    out.write("</div>\n</div>");
}
out.write("\n\n\n<script>\n    // Initially call changeColor() to display the initial color\n    changeColor();\n\n    // Add an event listener to the color selector div to trigger changeColor() when the color changes\n    document.getElementById(\"color-selectors\").addEventListener(\"input\", function() {\n        changeColor();\n    });\n</script>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

