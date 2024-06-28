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
package org.apache.sling.scripting.sightly.apps.Hari.components.sidebar;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class sidebar_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_obj = null;
Collection var_collectionvar12_list_coerced$ = null;
Collection var_collectionvar27_list_coerced$ = null;
Collection var_collectionvar45_list_coerced$ = null;
out.write("<h1>Sidebar Component component.</h1>\n\n");
_global_obj = renderContext.call("use", "Hari.adobe.aem.guides.core.models.Sidebarslingmodel", obj());
out.write("<div>\n\n<h2>Header </h2>\n<div>");
{
    String var_0 = (("Logo Path :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "logopath"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n<div>LogoMobileimage :<img");
{
    Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_global_obj, "logomobileimage");
    {
        Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "uri");
        {
            Object var_shoulddisplayattr4 = ((renderContext.getObjectModel().toBoolean(var_attrcontent2) ? var_attrcontent2 : ("false".equals(var_attrvalue1))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr4)) {
                out.write(" src");
                {
                    boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                    if (!var_istrueattr3) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/> </div>\n<div>Logo Link :<a");
{
    Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(_global_obj, "logolink");
    {
        Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "uri");
        {
            Object var_shoulddisplayattr8 = ((renderContext.getObjectModel().toBoolean(var_attrcontent6) ? var_attrcontent6 : ("false".equals(var_attrvalue5))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr8)) {
                out.write(" href");
                {
                    boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                    if (!var_istrueattr7) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">");
{
    Object var_9 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "logolink"), "text");
    out.write(renderContext.getObjectModel().toString(var_9));
}
out.write("</a> </div>\n<div>");
{
    String var_10 = (("Switch:" + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_obj, "checkbox")) ? "on" : "off"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_10));
}
out.write("</div>\n\n<h2>Region </h2>\n<div>");
{
    String var_11 = ("Country:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_obj, "country"), "text")));
    out.write(renderContext.getObjectModel().toString(var_11));
}
out.write("</div>\n\n<h2>Header Links </h2>\n");
{
    Object var_collectionvar12 = renderContext.getObjectModel().resolveProperty(_global_obj, "Day1");
    {
        long var_size13 = ((var_collectionvar12_list_coerced$ == null ? (var_collectionvar12_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar12)) : var_collectionvar12_list_coerced$).size());
        {
            boolean var_notempty14 = (var_size13 > 0);
            if (var_notempty14) {
                {
                    long var_end17 = var_size13;
                    {
                        boolean var_validstartstepend18 = (((0 < var_size13) && true) && (var_end17 > 0));
                        if (var_validstartstepend18) {
                            out.write("<div>");
                            if (var_collectionvar12_list_coerced$ == null) {
                                var_collectionvar12_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar12);
                            }
                            long var_index19 = 0;
                            for (Object item : var_collectionvar12_list_coerced$) {
                                {
                                    boolean var_traversal21 = (((var_index19 >= 0) && (var_index19 <= var_end17)) && true);
                                    if (var_traversal21) {
                                        out.write("\n<div>");
                                        {
                                            String var_22 = (("Name :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "name"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_22));
                                        }
                                        out.write("</div>\n<div>Image:<img");
                                        {
                                            Object var_attrvalue23 = renderContext.getObjectModel().resolveProperty(item, "image");
                                            {
                                                Object var_attrcontent24 = renderContext.call("xss", var_attrvalue23, "uri");
                                                {
                                                    Object var_shoulddisplayattr26 = ((renderContext.getObjectModel().toBoolean(var_attrcontent24) ? var_attrcontent24 : ("false".equals(var_attrvalue23))));
                                                    if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr26)) {
                                                        out.write(" src");
                                                        {
                                                            boolean var_istrueattr25 = (var_attrvalue23.equals(true));
                                                            if (!var_istrueattr25) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent24));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write("/> </div>\n");
                                    }
                                }
                                var_index19++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar12_list_coerced$ = null;
}
out.write("\n\n\n<h2>Sidebar Navigation  </h2>\n");
{
    Object var_collectionvar27 = renderContext.getObjectModel().resolveProperty(_global_obj, "Day2");
    {
        long var_size28 = ((var_collectionvar27_list_coerced$ == null ? (var_collectionvar27_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar27)) : var_collectionvar27_list_coerced$).size());
        {
            boolean var_notempty29 = (var_size28 > 0);
            if (var_notempty29) {
                {
                    long var_end32 = var_size28;
                    {
                        boolean var_validstartstepend33 = (((0 < var_size28) && true) && (var_end32 > 0));
                        if (var_validstartstepend33) {
                            out.write("<div>");
                            if (var_collectionvar27_list_coerced$ == null) {
                                var_collectionvar27_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar27);
                            }
                            long var_index34 = 0;
                            for (Object item : var_collectionvar27_list_coerced$) {
                                {
                                    boolean var_traversal36 = (((var_index34 >= 0) && (var_index34 <= var_end32)) && true);
                                    if (var_traversal36) {
                                        out.write("\n<div>Desk top icon:<img");
                                        {
                                            Object var_attrvalue37 = renderContext.getObjectModel().resolveProperty(item, "getDesktopicon");
                                            {
                                                Object var_attrcontent38 = renderContext.call("xss", var_attrvalue37, "uri");
                                                {
                                                    Object var_shoulddisplayattr40 = ((renderContext.getObjectModel().toBoolean(var_attrcontent38) ? var_attrcontent38 : ("false".equals(var_attrvalue37))));
                                                    if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr40)) {
                                                        out.write(" src");
                                                        {
                                                            boolean var_istrueattr39 = (var_attrvalue37.equals(true));
                                                            if (!var_istrueattr39) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent38));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write("/> </div>\n<div>Mobile Icon:<img");
                                        {
                                            Object var_attrvalue41 = renderContext.getObjectModel().resolveProperty(item, "mobileicon");
                                            {
                                                Object var_attrcontent42 = renderContext.call("xss", var_attrvalue41, "uri");
                                                {
                                                    Object var_shoulddisplayattr44 = ((renderContext.getObjectModel().toBoolean(var_attrcontent42) ? var_attrcontent42 : ("false".equals(var_attrvalue41))));
                                                    if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr44)) {
                                                        out.write(" src");
                                                        {
                                                            boolean var_istrueattr43 = (var_attrvalue41.equals(true));
                                                            if (!var_istrueattr43) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent42));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write("/> </div>\n\n");
                                        {
                                            Object var_collectionvar45 = renderContext.getObjectModel().resolveProperty(item, "getNested");
                                            {
                                                long var_size46 = ((var_collectionvar45_list_coerced$ == null ? (var_collectionvar45_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar45)) : var_collectionvar45_list_coerced$).size());
                                                {
                                                    boolean var_notempty47 = (var_size46 > 0);
                                                    if (var_notempty47) {
                                                        {
                                                            long var_end50 = var_size46;
                                                            {
                                                                boolean var_validstartstepend51 = (((0 < var_size46) && true) && (var_end50 > 0));
                                                                if (var_validstartstepend51) {
                                                                    out.write("<div>");
                                                                    if (var_collectionvar45_list_coerced$ == null) {
                                                                        var_collectionvar45_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar45);
                                                                    }
                                                                    long var_index52 = 0;
                                                                    for (Object nesteditem : var_collectionvar45_list_coerced$) {
                                                                        {
                                                                            boolean var_traversal54 = (((var_index52 >= 0) && (var_index52 <= var_end50)) && true);
                                                                            if (var_traversal54) {
                                                                                out.write("\n<div>navigation URL :<a");
                                                                                {
                                                                                    String var_attrcontent55 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(nesteditem, "getNavigation"), "uri")) + ".html");
                                                                                    {
                                                                                        Object var_shoulddisplayattr56 = ((renderContext.getObjectModel().toBoolean(var_attrcontent55) ? var_attrcontent55 : ("false".equals(var_attrcontent55))));
                                                                                        if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr56)) {
                                                                                            out.write(" href=\"");
                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent55));
                                                                                            out.write("\"");
                                                                                        }
                                                                                    }
                                                                                }
                                                                                out.write("> Nested </a></div>\n\n");
                                                                            }
                                                                        }
                                                                        var_index52++;
                                                                    }
                                                                    out.write("</div>");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            var_collectionvar45_list_coerced$ = null;
                                        }
                                        out.write("\n");
                                    }
                                }
                                var_index34++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar27_list_coerced$ = null;
}
out.write("\n</div>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

