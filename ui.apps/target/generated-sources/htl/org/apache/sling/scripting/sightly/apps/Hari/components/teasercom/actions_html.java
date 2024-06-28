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

public final class actions_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_actions = getProperty("actions");
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
addSubTemplate("actions", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _dynamic_teaser = arguments.get("teaser");
Object _global_actiontemplate = null;
Collection var_collectionvar0_list_coerced$ = null;
out.write("\n    ");
{
    Object var_testvariable7 = renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "actionsEnabled");
    if (renderContext.getObjectModel().toBoolean(var_testvariable7)) {
_global_actiontemplate = renderContext.call("use", "action.html", obj());
        {
            Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_dynamic_teaser, "actions");
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
                                    out.write("<div class=\"cmp-teaser__action-container\">");
                                    if (var_collectionvar0_list_coerced$ == null) {
                                        var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                                    }
                                    long var_index8 = 0;
                                    for (Object item : var_collectionvar0_list_coerced$) {
                                        {
                                            boolean var_traversal10 = (((var_index8 >= 0) && (var_index8 <= var_end5)) && true);
                                            if (var_traversal10) {
                                                out.write("\n        ");
                                                {
                                                    Object var_templatevar11 = renderContext.getObjectModel().resolveProperty(_global_actiontemplate, "action");
                                                    {
                                                        Object var_templateoptions12_field$_action = item;
                                                        {
                                                            java.util.Map var_templateoptions12 = obj().with("action", var_templateoptions12_field$_action);
                                                            callUnit(out, renderContext, var_templatevar11, var_templateoptions12);
                                                        }
                                                    }
                                                }
                                                out.write("\n    ");
                                            }
                                        }
                                        var_index8++;
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

