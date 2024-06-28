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

public final class title_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_title = getProperty("title");
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
addSubTemplate("title", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _dynamic_teaser = arguments.get("teaser");
Object _global_title = null;
out.write("\n    ");
_global_title = renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "title");
if (renderContext.getObjectModel().toBoolean(_global_title)) {
    {
        Object var_tagvar0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "titleType"), "elementName");
        if (renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("<");
            out.write(renderContext.getObjectModel().toString(var_tagvar0));
        }
        if (!renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("<h2");
        }
        out.write(" class=\"cmp-teaser__title\">\n        ");
        {
            Object var_unwrapcondition1 = (((!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "linkURL"))) ? (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "linkURL"))) : renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "titleLinkHidden")));
            if (!renderContext.getObjectModel().toBoolean(var_unwrapcondition1)) {
                out.write("<a class=\"cmp-teaser__title-link\"");
                {
                    Object var_attrvalue2 = renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "linkURL");
                    {
                        Object var_attrcontent3 = renderContext.call("xss", var_attrvalue2, "uri");
                        {
                            Object var_shoulddisplayattr5 = ((renderContext.getObjectModel().toBoolean(var_attrcontent3) ? var_attrcontent3 : ("false".equals(var_attrvalue2))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr5)) {
                                out.write(" href");
                                {
                                    boolean var_istrueattr4 = (var_attrvalue2.equals(true));
                                    if (!var_istrueattr4) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent3));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    boolean var_attrvalue6 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "data")) ? true : false);
                    {
                        Object var_attrcontent7 = renderContext.call("xss", var_attrvalue6, "attribute");
                        {
                            Object var_shoulddisplayattr9 = ((renderContext.getObjectModel().toBoolean(var_attrcontent7) ? var_attrcontent7 : ("false".equals(var_attrvalue6))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr9)) {
                                out.write(" data-cmp-clickable");
                                {
                                    boolean var_istrueattr8 = (var_attrvalue6 == true);
                                    if (!var_istrueattr8) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent7));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write(">");
            }
            {
                Object var_10 = renderContext.call("xss", _global_title, "text");
                out.write(renderContext.getObjectModel().toString(var_10));
            }
            if (!renderContext.getObjectModel().toBoolean(var_unwrapcondition1)) {
                out.write("</a>");
            }
        }
        out.write("\n    ");
        if (renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("</");
            out.write(renderContext.getObjectModel().toString(var_tagvar0));
            out.write(">");
        }
        if (!renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("</h2>");
        }
    }
}
out.write("\n");


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

