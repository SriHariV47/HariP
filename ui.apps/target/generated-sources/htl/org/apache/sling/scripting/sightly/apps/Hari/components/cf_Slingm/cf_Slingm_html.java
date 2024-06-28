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
package org.apache.sling.scripting.sightly.apps.Hari.components.cf_Slingm;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class cf_Slingm_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_obj = null;
out.write("<h1> hello ..</h1>\n\n");
_global_obj = renderContext.call("use", "Hari.adobe.aem.guides.core.models.ContentFSlingModel", obj());
out.write("<div>\n<div>");
{
    String var_0 = ("summary:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "summary"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n<div>");
{
    String var_1 = ("Nid :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "nid"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</div>\n<div>");
{
    String var_2 = ("articleType:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "articleType"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</div>\n<div>");
{
    String var_3 = ("Body :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "body"), "text")));
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</div>\n<div>");
{
    String var_4 = ("audioAttachment:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "audioAttachment"), "text")));
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</div>\n<div>");
{
    String var_5 = ("headline:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "headline"), "text")));
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</div>\n\n</div>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

