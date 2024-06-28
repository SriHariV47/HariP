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
package org.apache.sling.scripting.sightly.apps.Hari.components.software;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class software_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_obj = null;
Collection var_collectionvar0_list_coerced$ = null;
Collection var_collectionvar14_list_coerced$ = null;
Object _dynamic_item = bindings.get("item");
Collection var_collectionvar37_list_coerced$ = null;
Collection var_collectionvar48_list_coerced$ = null;
Collection var_collectionvar59_list_coerced$ = null;
out.write("<h1>Software component</h1>\n\n");
_global_obj = renderContext.call("use", "Hari.adobe.aem.guides.core.models.Softwareslimgmodel", obj());
out.write("<div>\n\n<h2>Header Links M1 </h2>\n");
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_obj, "headerLinks");
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
                                            String var_10 = ("Name:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "name"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_10));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_11 = (("URL:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "url"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_11));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_12 = (("Icon:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "icon"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_12));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_13 = (("HideInMobileMenu:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "hideInMobileMenu"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_13));
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
out.write("\n\n\n<h2>Seidebar M2 </h2>\n");
{
    Object var_collectionvar14 = renderContext.getObjectModel().resolveProperty(_global_obj, "sidebar");
    {
        long var_size15 = ((var_collectionvar14_list_coerced$ == null ? (var_collectionvar14_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar14)) : var_collectionvar14_list_coerced$).size());
        {
            boolean var_notempty16 = (var_size15 > 0);
            if (var_notempty16) {
                {
                    long var_end19 = var_size15;
                    {
                        boolean var_validstartstepend20 = (((0 < var_size15) && true) && (var_end19 > 0));
                        if (var_validstartstepend20) {
                            out.write("<div>");
                            if (var_collectionvar14_list_coerced$ == null) {
                                var_collectionvar14_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar14);
                            }
                            long var_index21 = 0;
                            for (Object item : var_collectionvar14_list_coerced$) {
                                {
                                    boolean var_traversal23 = (((var_index21 >= 0) && (var_index21 <= var_end19)) && true);
                                    if (var_traversal23) {
                                        out.write("\n<div>");
                                        {
                                            String var_24 = ("Name:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "name"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_24));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_25 = (("SecondLevelEnabled:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "secondLevelEnabled"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_25));
                                        }
                                        out.write("</div>\n<div>SelectedIcon:<img");
                                        {
                                            Object var_attrvalue26 = renderContext.getObjectModel().resolveProperty(item, "selectedIcon");
                                            {
                                                Object var_attrcontent27 = renderContext.call("xss", var_attrvalue26, "uri");
                                                {
                                                    Object var_shoulddisplayattr29 = ((renderContext.getObjectModel().toBoolean(var_attrcontent27) ? var_attrcontent27 : ("false".equals(var_attrvalue26))));
                                                    if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr29)) {
                                                        out.write(" src");
                                                        {
                                                            boolean var_istrueattr28 = (var_attrvalue26.equals(true));
                                                            if (!var_istrueattr28) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent27));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write("/> </div>\n<div>");
                                        {
                                            String var_30 = ("MainAnchorDisabled:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "mainAnchorDisabled"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_30));
                                        }
                                        out.write("</div>\n<div>");
                                        {
                                            String var_31 = ("Target:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "target"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_31));
                                        }
                                        out.write("</div>\n<div>Icon:<img");
                                        {
                                            Object var_attrvalue32 = renderContext.getObjectModel().resolveProperty(item, "icon");
                                            {
                                                Object var_attrcontent33 = renderContext.call("xss", var_attrvalue32, "uri");
                                                {
                                                    Object var_shoulddisplayattr35 = ((renderContext.getObjectModel().toBoolean(var_attrcontent33) ? var_attrcontent33 : ("false".equals(var_attrvalue32))));
                                                    if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr35)) {
                                                        out.write(" src");
                                                        {
                                                            boolean var_istrueattr34 = (var_attrvalue32.equals(true));
                                                            if (!var_istrueattr34) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent33));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write("/> </div>\n<div>");
                                        {
                                            String var_36 = (("Path:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "path"), "text"))) + " ");
                                            out.write(renderContext.getObjectModel().toString(var_36));
                                        }
                                        out.write("</div>\n");
                                    }
                                }
                                var_index21++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar14_list_coerced$ = null;
}
out.write("\n\n");
{
    Object var_collectionvar37 = renderContext.getObjectModel().resolveProperty(_dynamic_item, "secondlevelsidebarmanual");
    {
        long var_size38 = ((var_collectionvar37_list_coerced$ == null ? (var_collectionvar37_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar37)) : var_collectionvar37_list_coerced$).size());
        {
            boolean var_notempty39 = (var_size38 > 0);
            if (var_notempty39) {
                {
                    long var_end42 = var_size38;
                    {
                        boolean var_validstartstepend43 = (((0 < var_size38) && true) && (var_end42 > 0));
                        if (var_validstartstepend43) {
                            out.write("<div>");
                            if (var_collectionvar37_list_coerced$ == null) {
                                var_collectionvar37_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar37);
                            }
                            long var_index44 = 0;
                            for (Object nesteditem : var_collectionvar37_list_coerced$) {
                                {
                                    boolean var_traversal46 = (((var_index44 >= 0) && (var_index44 <= var_end42)) && true);
                                    if (var_traversal46) {
                                        out.write("\n<div>");
                                        {
                                            String var_47 = ("Sidebar Path :" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(nesteditem, "sidebarpath"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_47));
                                        }
                                        out.write("</div>\n");
                                    }
                                }
                                var_index44++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar37_list_coerced$ = null;
}
out.write("\n\n\n\n<h2>Business M3 </h2>\n");
{
    Object var_collectionvar48 = renderContext.getObjectModel().resolveProperty(_global_obj, "businesses");
    {
        long var_size49 = ((var_collectionvar48_list_coerced$ == null ? (var_collectionvar48_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar48)) : var_collectionvar48_list_coerced$).size());
        {
            boolean var_notempty50 = (var_size49 > 0);
            if (var_notempty50) {
                {
                    long var_end53 = var_size49;
                    {
                        boolean var_validstartstepend54 = (((0 < var_size49) && true) && (var_end53 > 0));
                        if (var_validstartstepend54) {
                            out.write("<div>");
                            if (var_collectionvar48_list_coerced$ == null) {
                                var_collectionvar48_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar48);
                            }
                            long var_index55 = 0;
                            for (Object item : var_collectionvar48_list_coerced$) {
                                {
                                    boolean var_traversal57 = (((var_index55 >= 0) && (var_index55 <= var_end53)) && true);
                                    if (var_traversal57) {
                                        out.write("\n<div>");
                                        {
                                            String var_58 = ("Section Name:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "sectionName"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_58));
                                        }
                                        out.write("</div>\n\n");
                                        {
                                            Object var_collectionvar59 = renderContext.getObjectModel().resolveProperty(item, "items");
                                            {
                                                long var_size60 = ((var_collectionvar59_list_coerced$ == null ? (var_collectionvar59_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar59)) : var_collectionvar59_list_coerced$).size());
                                                {
                                                    boolean var_notempty61 = (var_size60 > 0);
                                                    if (var_notempty61) {
                                                        {
                                                            long var_end64 = var_size60;
                                                            {
                                                                boolean var_validstartstepend65 = (((0 < var_size60) && true) && (var_end64 > 0));
                                                                if (var_validstartstepend65) {
                                                                    out.write("<div>");
                                                                    if (var_collectionvar59_list_coerced$ == null) {
                                                                        var_collectionvar59_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar59);
                                                                    }
                                                                    long var_index66 = 0;
                                                                    for (Object nesteditem : var_collectionvar59_list_coerced$) {
                                                                        {
                                                                            boolean var_traversal68 = (((var_index66 >= 0) && (var_index66 <= var_end64)) && true);
                                                                            if (var_traversal68) {
                                                                                out.write("\n<div>Link :<a");
                                                                                {
                                                                                    String var_attrcontent69 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(nesteditem, "link"), "uri")) + ".html");
                                                                                    {
                                                                                        Object var_shoulddisplayattr70 = ((renderContext.getObjectModel().toBoolean(var_attrcontent69) ? var_attrcontent69 : ("false".equals(var_attrcontent69))));
                                                                                        if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr70)) {
                                                                                            out.write(" href=\"");
                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent69));
                                                                                            out.write("\"");
                                                                                        }
                                                                                    }
                                                                                }
                                                                                out.write("> Nested </a></div>\n<div>");
                                                                                {
                                                                                    String var_71 = ("Name:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(nesteditem, "name"), "text")));
                                                                                    out.write(renderContext.getObjectModel().toString(var_71));
                                                                                }
                                                                                out.write("</div>\n\n");
                                                                            }
                                                                        }
                                                                        var_index66++;
                                                                    }
                                                                    out.write("</div>");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            var_collectionvar59_list_coerced$ = null;
                                        }
                                        out.write("\n\n");
                                    }
                                }
                                var_index55++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar48_list_coerced$ = null;
}
out.write("\n\n</div>\n\n\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

