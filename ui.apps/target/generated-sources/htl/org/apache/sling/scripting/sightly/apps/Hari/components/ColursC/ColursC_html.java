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
package org.apache.sling.scripting.sightly.apps.Hari.components.ColursC;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class ColursC_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
out.write("Colourcompo\n\n<div class=\"your-component\">\n\n    <h2>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h2>\n\n    <p>");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "pathfield"), "text");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\n\n    <p>");
{
    Object var_2 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text1"), "text");
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\n    <p>");
{
    Object var_3 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text2"), "text");
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</p>\n    <p>");
{
    Object var_4 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text3"), "text");
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</p>\n    <p>");
{
    Object var_5 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text4"), "text");
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</p>\n    <p>");
{
    Object var_6 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text5"), "text");
    out.write(renderContext.getObjectModel().toString(var_6));
}
out.write("</p>\n\n    <div class=\"dropdown-color\"");
{
    Object var_attrvalue7 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dropdown");
    {
        Object var_attrcontent8 = renderContext.call("xss", var_attrvalue7, "attribute");
        {
            Object var_shoulddisplayattr10 = ((renderContext.getObjectModel().toBoolean(var_attrcontent8) ? var_attrcontent8 : ("false".equals(var_attrvalue7))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr10)) {
                out.write(" data-color");
                {
                    boolean var_istrueattr9 = (var_attrvalue7.equals(true));
                    if (!var_istrueattr9) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent8));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\n        <p>");
{
    String var_11 = ("Selected Color: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dropdown"), "text")));
    out.write(renderContext.getObjectModel().toString(var_11));
}
out.write("</p>\n    </div>\n</div>\n\n<script>\n    (function(document, $) {\n        \"use strict\";\n        $(document).ready(function() {\n            var $dropdown = $(\"[name='./dropdown']\");\n            var $checkbox = $(\"[name='./checkbox']\");\n\n            function toggleCheckbox() {\n                if ($dropdown.val() === 'red') {\n                    $checkbox.prop('disabled', false);\n                } else {\n                    $checkbox.prop('disabled', true);\n                }\n            }\n\n            $dropdown.on('change', toggleCheckbox);\n\n            // Initial call to set the correct state\n            toggleCheckbox();\n        });\n    })(document, Granite.$);\n</script>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

