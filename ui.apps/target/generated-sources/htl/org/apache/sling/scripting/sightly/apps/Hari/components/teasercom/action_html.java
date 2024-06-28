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
package org.apache.sling.scripting.sightly.apps.Hari.components.teasercom;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class action_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_action = getProperty("action");
out.write("\n");
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------

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
addSubTemplate("action", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _dynamic_action = arguments.get("action");
out.write("\n    <a class=\"cmp-teaser__action-link\"");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_dynamic_action, "URL");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "uri");
        {
            Object var_shoulddisplayattr3 = ((renderContext.getObjectModel().toBoolean(var_attrcontent1) ? var_attrcontent1 : ("false".equals(var_attrvalue0))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr3)) {
                out.write(" href");
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
{
    Object var_attrvalue4 = renderContext.getObjectModel().resolveProperty(_dynamic_action, "id");
    {
        Object var_attrcontent5 = renderContext.call("xss", var_attrvalue4, "attribute");
        {
            Object var_shoulddisplayattr7 = ((renderContext.getObjectModel().toBoolean(var_attrcontent5) ? var_attrcontent5 : ("false".equals(var_attrvalue4))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr7)) {
                out.write(" id");
                {
                    boolean var_istrueattr6 = (var_attrvalue4.equals(true));
                    if (!var_istrueattr6) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent5));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue8 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_dynamic_action, "data"), "json");
    {
        Object var_attrcontent9 = renderContext.call("xss", var_attrvalue8, "attribute");
        {
            Object var_shoulddisplayattr11 = ((renderContext.getObjectModel().toBoolean(var_attrcontent9) ? var_attrcontent9 : ("false".equals(var_attrvalue8))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr11)) {
                out.write(" data-cmp-data-layer");
                {
                    boolean var_istrueattr10 = (var_attrvalue8.equals(true));
                    if (!var_istrueattr10) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent9));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    boolean var_attrvalue12 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_action, "data")) ? true : false);
    {
        Object var_attrcontent13 = renderContext.call("xss", var_attrvalue12, "attribute");
        {
            Object var_shoulddisplayattr15 = ((renderContext.getObjectModel().toBoolean(var_attrcontent13) ? var_attrcontent13 : ("false".equals(var_attrvalue12))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr15)) {
                out.write(" data-cmp-clickable");
                {
                    boolean var_istrueattr14 = (var_attrvalue12 == true);
                    if (!var_istrueattr14) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent13));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">");
{
    Object var_16 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_action, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_16));
}
out.write("</a>\n");


// End Of Main Sub-Template Body ------------------------------------------------------------------
    }



    {
//Sub-Sub-Templates Initialization ----------------------------------------------------------------



//End of Sub-Sub-Templates Initialization ---------------------------------------------------------
    }
    
});


//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

