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
package org.apache.sling.scripting.sightly.apps.Hari.components.media;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class media_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
out.write("<h2>Media</h2>\n\n\n<div class=\"media-component\">\n    <h2>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h2>\n    <p>");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "description"), "text");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\n    <div class=\"content\">\n        <div class=\"text\">\n            <p>");
{
    Object var_2 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "paragraph"), "text");
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\n            <cq:include");
{
    Object var_attrvalue3 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "image");
    {
        Object var_attrcontent4 = renderContext.call("xss", var_attrvalue3, "attribute");
        {
            Object var_shoulddisplayattr6 = ((renderContext.getObjectModel().toBoolean(var_attrcontent4) ? var_attrcontent4 : ("false".equals(var_attrvalue3))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr6)) {
                out.write(" path");
                {
                    boolean var_istrueattr5 = (var_attrvalue3.equals(true));
                    if (!var_istrueattr5) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent4));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" resourceType=\"foundation/components/image\"/>\n        </div>\n        <div class=\"button-cta\">\n            <cq:if");
{
    boolean var_attrvalue7 = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "isCTA")));
    {
        Object var_attrcontent8 = renderContext.call("xss", var_attrvalue7, "attribute");
        {
            Object var_shoulddisplayattr10 = ((renderContext.getObjectModel().toBoolean(var_attrcontent8) ? var_attrcontent8 : ("false".equals(var_attrvalue7))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr10)) {
                out.write(" condition");
                {
                    boolean var_istrueattr9 = (var_attrvalue7 == true);
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
out.write(">\n                <a");
{
    Object var_attrvalue11 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonUrl");
    {
        Object var_attrcontent12 = renderContext.call("xss", var_attrvalue11, "uri");
        {
            Object var_shoulddisplayattr14 = ((renderContext.getObjectModel().toBoolean(var_attrcontent12) ? var_attrcontent12 : ("false".equals(var_attrvalue11))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr14)) {
                out.write(" href");
                {
                    boolean var_istrueattr13 = (var_attrvalue11.equals(true));
                    if (!var_istrueattr13) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent12));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" class=\"button\">");
{
    Object var_15 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonText"), "text");
    out.write(renderContext.getObjectModel().toString(var_15));
}
out.write("</a>\n            </cq:if>\n            <cq:if");
{
    Object var_attrvalue16 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "isCTA");
    {
        Object var_attrcontent17 = renderContext.call("xss", var_attrvalue16, "attribute");
        {
            Object var_shoulddisplayattr19 = ((renderContext.getObjectModel().toBoolean(var_attrcontent17) ? var_attrcontent17 : ("false".equals(var_attrvalue16))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr19)) {
                out.write(" condition");
                {
                    boolean var_istrueattr18 = (var_attrvalue16.equals(true));
                    if (!var_istrueattr18) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent17));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\n                <a");
{
    Object var_attrvalue20 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ctaUrl");
    {
        Object var_attrcontent21 = renderContext.call("xss", var_attrvalue20, "uri");
        {
            Object var_shoulddisplayattr23 = ((renderContext.getObjectModel().toBoolean(var_attrcontent21) ? var_attrcontent21 : ("false".equals(var_attrvalue20))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr23)) {
                out.write(" href");
                {
                    boolean var_istrueattr22 = (var_attrvalue20.equals(true));
                    if (!var_istrueattr22) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent21));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" class=\"cta\">");
{
    Object var_24 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ctaText"), "text");
    out.write(renderContext.getObjectModel().toString(var_24));
}
out.write("</a>\n            </cq:if>\n        </div>\n    </div>\n</div>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

