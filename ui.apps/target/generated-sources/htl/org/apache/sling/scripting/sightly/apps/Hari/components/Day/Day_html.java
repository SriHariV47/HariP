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
package org.apache.sling.scripting.sightly.apps.Hari.components.Day;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class Day_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_obj = null;
Collection var_collectionvar3_list_coerced$ = null;
out.write("<h1>Day component component</h1>\n");
_global_obj = renderContext.call("use", "Hari.adobe.aem.guides.core.models.DaySlingModel", obj());
out.write("<div></div>\n <div>");
{
    String var_0 = ("Text:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "text"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n<div>");
{
    String var_1 = ("path=" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "getPathField"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</div>\n    <p>");
{
    String var_2 = ("Check: " + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_obj, "checkbox")) ? "Yes" : "No"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\n \n    ");
{
    Object var_collectionvar3 = renderContext.getObjectModel().resolveProperty(_global_obj, "details");
    {
        long var_size4 = ((var_collectionvar3_list_coerced$ == null ? (var_collectionvar3_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar3)) : var_collectionvar3_list_coerced$).size());
        {
            boolean var_notempty5 = (var_size4 > 0);
            if (var_notempty5) {
                {
                    long var_end8 = var_size4;
                    {
                        boolean var_validstartstepend9 = (((0 < var_size4) && true) && (var_end8 > 0));
                        if (var_validstartstepend9) {
                            out.write("<div>");
                            if (var_collectionvar3_list_coerced$ == null) {
                                var_collectionvar3_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar3);
                            }
                            long var_index10 = 0;
                            for (Object multi : var_collectionvar3_list_coerced$) {
                                {
                                    boolean var_traversal12 = (((var_index10 >= 0) && (var_index10 <= var_end8)) && true);
                                    if (var_traversal12) {
                                        out.write("\n      <div>");
                                        {
                                            String var_13 = (("firstName :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(multi, "firstname"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_13));
                                        }
                                        out.write("</div>\n       <div>");
                                        {
                                            String var_14 = ("Date Of Birth: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(multi, "getDOB"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_14));
                                        }
                                        out.write("</div>\n   ");
                                    }
                                }
                                var_index10++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar3_list_coerced$ = null;
}
out.write("\n\n\n\n\n\n\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

