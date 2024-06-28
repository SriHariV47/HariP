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
package org.apache.sling.scripting.sightly.apps.Hari.components.HeaderComponentIMPL;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class HeaderComponentIMPL_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_headermodel = null;
Collection var_collectionvar3_list_coerced$ = null;
out.write("<div class=\"header-component\">\n    <h1>Author Bio</h1>\n    \n    <!-- Inject the HeaderSlingmodelEx model -->\n    ");
_global_headermodel = renderContext.call("use", "Hari.adobe.aem.guides.core.models.HeaderSlingmodelExIn", obj());
out.write("\n    \n    <!-- Display the properties -->\n    <h2>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_headermodel, "text"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h2>\n    <p>");
{
    String var_1 = ("Checkbox: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_headermodel, "checkbox"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\n    <p>");
{
    String var_2 = ("Pathfield: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_headermodel, "pathfield"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\n    \n    <!-- Display the details multifield -->\n    <div class=\"multifield-items\">\n        <h3>Details:</h3>\n        <ul>\n            ");
{
    Object var_collectionvar3 = renderContext.getObjectModel().resolveProperty(_global_headermodel, "details");
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
                            if (var_collectionvar3_list_coerced$ == null) {
                                var_collectionvar3_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar3);
                            }
                            long var_index10 = 0;
                            for (Object item : var_collectionvar3_list_coerced$) {
                                {
                                    boolean var_traversal12 = (((var_index10 >= 0) && (var_index10 <= var_end8)) && true);
                                    if (var_traversal12) {
                                        out.write("\n                <li>\n                    <p>");
                                        {
                                            String var_13 = ("First Name: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "firstname"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_13));
                                        }
                                        out.write("</p>\n                    <p>");
                                        {
                                            String var_14 = ("DOB: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "dob"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_14));
                                        }
                                        out.write("</p>\n                </li>\n            ");
                                    }
                                }
                                var_index10++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar3_list_coerced$ = null;
}
out.write("\n        </ul>\n    </div>\n</div>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

