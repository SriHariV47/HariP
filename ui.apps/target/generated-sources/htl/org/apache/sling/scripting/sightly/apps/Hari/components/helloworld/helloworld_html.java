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
package org.apache.sling.scripting.sightly.apps.Hari.components.helloworld;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class helloworld_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_obj = null;
Object _dynamic_properties = bindings.get("properties");
out.write("\n<h1>Hello world</h1>\n\n");
_global_obj = renderContext.call("use", "Hari.adobe.aem.guides.core.models.HelloworldSlingmodelEx", obj());
out.write("<div>\n\n<div>");
{
    String var_0 = (" Age:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "age"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n<div>");
{
    String var_1 = (" DOB:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "dob"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</div>\n<div>");
{
    String var_2 = ("Email:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "email"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</div>\n<div>");
{
    String var_3 = ("Text:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "text"), "text")));
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</div>\n\n<div>");
{
    String var_4 = ("Password:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "password"), "text")));
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</div>\n</div>\n\n\n<div>\n\n<img");
{
    Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "fileupload");
    {
        Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "uri");
        {
            Object var_shoulddisplayattr8 = ((renderContext.getObjectModel().toBoolean(var_attrcontent6) ? var_attrcontent6 : ("false".equals(var_attrvalue5))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr8)) {
                out.write(" src");
                {
                    boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                    if (!var_istrueattr7) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/> </div>\n\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

