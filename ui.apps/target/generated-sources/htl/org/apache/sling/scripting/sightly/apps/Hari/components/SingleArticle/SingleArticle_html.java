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
package org.apache.sling.scripting.sightly.apps.Hari.components.SingleArticle;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class SingleArticle_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
Object _global_cssclass = null;
out.write("<h1>Hello Article</h1>\n\n<div>");
{
    String var_0 = ((" Enable PII: " + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "checkbox")) ? "checked" : "unchecked"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n");
_global_cssclass = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "checkbox");
if (renderContext.getObjectModel().toBoolean(_global_cssclass)) {
    out.write("<div>\n    ");
    {
        Object var_testvariable1 = _global_cssclass;
        if (renderContext.getObjectModel().toBoolean(var_testvariable1)) {
            out.write("<p>");
            {
                String var_2 = ("Css Class : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "cssclass"), "text")));
                out.write(renderContext.getObjectModel().toString(var_2));
            }
            out.write("</p>");
        }
    }
    out.write("\n</div>");
}
out.write("\n\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

