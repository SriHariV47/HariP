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
package org.apache.sling.scripting.sightly.apps.Hari.components.mixed;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class mixed_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_model = null;
out.write("\n");
_global_model = renderContext.call("use", "Hari.adobe.aem.guides.core.models.Mixed", obj());
out.write("\n    <!-- Display Experience Fragment -->\n    ");
{
    Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_global_model, "experienceFragmentHtml");
    if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
        {
            String var_1 = (("\n        " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "experienceFragmentHtml"), "html"))) + "\n    ");
            out.write(renderContext.getObjectModel().toString(var_1));
        }
    }
}
out.write("\n\n    <!-- Display Content Fragment -->\n    ");
{
    Object var_testvariable2 = renderContext.getObjectModel().resolveProperty(_global_model, "contentFragmentContent");
    if (renderContext.getObjectModel().toBoolean(var_testvariable2)) {
        {
            String var_3 = (("\n        " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "contentFragmentContent"), "html"))) + "\n    ");
            out.write(renderContext.getObjectModel().toString(var_3));
        }
    }
}
out.write("\na");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

