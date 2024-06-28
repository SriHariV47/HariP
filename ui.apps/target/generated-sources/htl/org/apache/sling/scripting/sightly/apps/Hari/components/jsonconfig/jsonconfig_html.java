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
package org.apache.sling.scripting.sightly.apps.Hari.components.jsonconfig;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class jsonconfig_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_model = null;
out.write("<!-- File: JsonDataSlingmodel.html -->\n\n");
_global_model = renderContext.call("use", "Hari.adobe.aem.guides.core.models.JsonDataSlingmodel", obj());
out.write("\n\n<h2>User Details:</h2>\n<ul>\n    <li>");
{
    String var_0 = ("ID: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "id"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</li>\n    <li>");
{
    String var_1 = ("Name: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "name"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</li>\n    <li>");
{
    String var_2 = ("Username: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "username"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</li>\n    <li>");
{
    String var_3 = ("Email: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "email"), "text")));
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</li>\n    <li>");
{
    String var_4 = ("Phone: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "phone"), "text")));
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</li>\n    <li>");
{
    String var_5 = ("Website: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "website"), "text")));
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</li>\n</ul>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

