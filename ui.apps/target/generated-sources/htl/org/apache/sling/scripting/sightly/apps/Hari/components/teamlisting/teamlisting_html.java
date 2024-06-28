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
package org.apache.sling.scripting.sightly.apps.Hari.components.teamlisting;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class teamlisting_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_team = null;
out.write("<div class=\"team-listing\">\n    <h2>Team Listing</h2>\n    ");
_global_team = renderContext.call("use", "Hari.adobe.aem.guides.core.models.TeamListingSlingModel", obj());
out.write("<div>\n        <p><strong>First Name:</strong>");
{
    String var_0 = (" " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_team, "text1"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</p>\n        <p><strong>Last Name:</strong>");
{
    String var_1 = (" " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_team, "text2"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\n        <p><strong>Text 3:</strong>");
{
    String var_2 = (" " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_team, "text3"), "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\n        <p><strong>Text 4:</strong>");
{
    String var_3 = (" " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_team, "text4"), "text")));
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</p>\n        <p><strong>Text 5:</strong>");
{
    String var_4 = (" " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_team, "text5"), "text")));
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</p>\n    </div>\n</div>\n\n<!-- mycomponent.html -->\n\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

