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
package org.apache.sling.scripting.sightly.apps.Hari.components.child;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class child_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
Object _global_model = null;
Collection var_collectionvar1_list_coerced$ = null;
out.write("<h2>Child pages</h2>\n\n\n<div>");
{
    String var_0 = ("Page Path: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "parentPagePath"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n\n");
_global_model = renderContext.call("use", "Hari.adobe.aem.guides.core.models.ChildPagesModel", obj());
out.write("\n    <div>\n        <ul>\n            ");
{
    Object var_collectionvar1 = renderContext.getObjectModel().resolveProperty(_global_model, "childPages");
    {
        long var_size2 = ((var_collectionvar1_list_coerced$ == null ? (var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1)) : var_collectionvar1_list_coerced$).size());
        {
            boolean var_notempty3 = (var_size2 > 0);
            if (var_notempty3) {
                {
                    long var_end6 = var_size2;
                    {
                        boolean var_validstartstepend7 = (((0 < var_size2) && true) && (var_end6 > 0));
                        if (var_validstartstepend7) {
                            if (var_collectionvar1_list_coerced$ == null) {
                                var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1);
                            }
                            long var_index8 = 0;
                            for (Object child : var_collectionvar1_list_coerced$) {
                                {
                                    boolean var_traversal10 = (((var_index8 >= 0) && (var_index8 <= var_end6)) && true);
                                    if (var_traversal10) {
                                        out.write("\n                <li>\n                    <a");
                                        {
                                            Object var_attrvalue11 = renderContext.getObjectModel().resolveProperty(child, "path");
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
                                        out.write(">");
                                        {
                                            Object var_15 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(child, "title"), "text");
                                            out.write(renderContext.getObjectModel().toString(var_15));
                                        }
                                        out.write("</a>\n                </li>\n            ");
                                    }
                                }
                                var_index8++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar1_list_coerced$ = null;
}
out.write("\n        </ul>\n    </div>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

