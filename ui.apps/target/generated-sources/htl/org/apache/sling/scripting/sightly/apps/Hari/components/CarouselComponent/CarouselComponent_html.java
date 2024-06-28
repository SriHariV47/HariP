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
package org.apache.sling.scripting.sightly.apps.Hari.components.CarouselComponent;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class CarouselComponent_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_obj = null;
Collection var_collectionvar0_list_coerced$ = null;
out.write("<h1>Carousel Component</h1>\n");
_global_obj = renderContext.call("use", "Hari.adobe.aem.guides.core.models.CorouselSlingmodelEx", obj());
out.write("<div>\n\n");
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_obj, "details");
    {
        long var_size1 = ((var_collectionvar0_list_coerced$ == null ? (var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0)) : var_collectionvar0_list_coerced$).size());
        {
            boolean var_notempty2 = (var_size1 > 0);
            if (var_notempty2) {
                {
                    long var_end5 = var_size1;
                    {
                        boolean var_validstartstepend6 = (((0 < var_size1) && true) && (var_end5 > 0));
                        if (var_validstartstepend6) {
                            out.write("<div>");
                            if (var_collectionvar0_list_coerced$ == null) {
                                var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                            }
                            long var_index7 = 0;
                            for (Object item : var_collectionvar0_list_coerced$) {
                                {
                                    boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                    if (var_traversal9) {
                                        out.write("\n<div>");
                                        {
                                            String var_10 = (("First Name :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "firstname"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_10));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_11 = (("Path Field :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "pathfield"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_11));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_12 = (("Address :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "address"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_12));
                                        }
                                        out.write("</div>\n");
                                    }
                                }
                                var_index7++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar0_list_coerced$ = null;
}
out.write("\n</div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

