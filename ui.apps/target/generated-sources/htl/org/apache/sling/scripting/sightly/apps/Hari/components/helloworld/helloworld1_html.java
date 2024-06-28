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
package org.apache.sling.scripting.sightly.apps.Hari.components.helloworld;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class helloworld1_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_name = null;
Object _dynamic_properties = bindings.get("properties");
Collection var_collectionvar7_list_coerced$ = null;
Collection var_collectionvar18_list_coerced$ = null;
Collection var_collectionvar29_list_coerced$ = null;
Object _dynamic_writeinfo = getProperty("writeinfo");
Object _dynamic_writedemo = getProperty("writedemo");
Object _dynamic_currentpage = bindings.get("currentpage");
out.write("\n\n<h1>Hello World Component</h1>\n\n<h1>");
{
    Object var_includedresult0 = renderContext.call("include", "sample.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult0));
}
out.write("</h1>\n\n");
_global_name = "Suchi";
out.write("\n<p>");
{
    String var_2 = ("Name:" + renderContext.getObjectModel().toString(renderContext.call("xss", _global_name, "text")));
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</p>\n\n\n");
{
    Object var_testvariable3 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "age")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "age") : renderContext.getObjectModel().resolveProperty(_dynamic_properties, "email")));
    if (renderContext.getObjectModel().toBoolean(var_testvariable3)) {
        out.write("\n    <p>");
        {
            String var_4 = ("Age:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "age"), "text")));
            out.write(renderContext.getObjectModel().toString(var_4));
        }
        out.write("</p>\n    <p>");
        {
            String var_5 = ("Email:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "email"), "text")));
            out.write(renderContext.getObjectModel().toString(var_5));
        }
        out.write("</p>\n    <p>");
        {
            Object var_6 = renderContext.call("xss", renderContext.call("format", "yyyy-mm-dd", obj().with("format", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "jcr:lastModified"))), "text");
            out.write(renderContext.getObjectModel().toString(var_6));
        }
        out.write("</p>\n");
    }
}
out.write("\n\n");
{
    Object var_collectionvar7 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "subjects");
    {
        long var_size8 = ((var_collectionvar7_list_coerced$ == null ? (var_collectionvar7_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar7)) : var_collectionvar7_list_coerced$).size());
        {
            boolean var_notempty9 = (var_size8 > 0);
            if (var_notempty9) {
                {
                    long var_end12 = var_size8;
                    {
                        boolean var_validstartstepend13 = (((0 < var_size8) && true) && (var_end12 > 0));
                        if (var_validstartstepend13) {
                            out.write("<ul>");
                            if (var_collectionvar7_list_coerced$ == null) {
                                var_collectionvar7_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar7);
                            }
                            long var_index14 = 0;
                            for (Object item : var_collectionvar7_list_coerced$) {
                                {
                                    boolean var_traversal16 = (((var_index14 >= 0) && (var_index14 <= var_end12)) && true);
                                    if (var_traversal16) {
                                        out.write("\n    <li>");
                                        {
                                            Object var_17 = renderContext.call("xss", item, "text");
                                            out.write(renderContext.getObjectModel().toString(var_17));
                                        }
                                        out.write("</li>\n");
                                    }
                                }
                                var_index14++;
                            }
                            out.write("</ul>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar7_list_coerced$ = null;
}
out.write("\n\n\n");
{
    Object var_collectionvar18 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "subjects");
    {
        long var_size19 = ((var_collectionvar18_list_coerced$ == null ? (var_collectionvar18_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar18)) : var_collectionvar18_list_coerced$).size());
        {
            boolean var_notempty20 = (var_size19 > 0);
            if (var_notempty20) {
                {
                    long var_end23 = var_size19;
                    {
                        boolean var_validstartstepend24 = (((0 < var_size19) && true) && (var_end23 > 0));
                        if (var_validstartstepend24) {
                            out.write("<ul>");
                            if (var_collectionvar18_list_coerced$ == null) {
                                var_collectionvar18_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar18);
                            }
                            long var_index25 = 0;
                            for (Object variable : var_collectionvar18_list_coerced$) {
                                {
                                    boolean variablelist_field$_middle = (!((var_index25 == 0) || (var_index25 == (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.SUB.eval(var_size19, 1)).longValue()))));
                                    {
                                        boolean variablelist_field$_last = (var_index25 == (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.SUB.eval(var_size19, 1)).longValue()));
                                        {
                                            long variablelist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index25, 1)).longValue());
                                            {
                                                long variablelist_field$_index = var_index25;
                                                {
                                                    boolean variablelist_field$_first = (var_index25 == 0);
                                                    {
                                                        boolean var_traversal27 = (((var_index25 >= 0) && (var_index25 <= var_end23)) && true);
                                                        if (var_traversal27) {
                                                            out.write("\n    <li>");
                                                            {
                                                                String var_28 = ((((((((("Index:" + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_index, "text"))) + ":Count:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_count, "text"))) + ":First:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_first, "text"))) + ":middle:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_middle, "text"))) + ":Last:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_last, "text")));
                                                                out.write(renderContext.getObjectModel().toString(var_28));
                                                            }
                                                            out.write("</li>\n");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                var_index25++;
                            }
                            out.write("</ul>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar18_list_coerced$ = null;
}
out.write("\n\n");
{
    Object var_collectionvar29 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "subjects");
    {
        long var_size30 = ((var_collectionvar29_list_coerced$ == null ? (var_collectionvar29_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar29)) : var_collectionvar29_list_coerced$).size());
        {
            boolean var_notempty31 = (var_size30 > 0);
            if (var_notempty31) {
                {
                    long var_end34 = var_size30;
                    {
                        boolean var_validstartstepend35 = (((0 < var_size30) && true) && (var_end34 > 0));
                        if (var_validstartstepend35) {
                            if (var_collectionvar29_list_coerced$ == null) {
                                var_collectionvar29_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar29);
                            }
                            long var_index36 = 0;
                            for (Object variable : var_collectionvar29_list_coerced$) {
                                {
                                    boolean variablelist_field$_middle = (!((var_index36 == 0) || (var_index36 == (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.SUB.eval(var_size30, 1)).longValue()))));
                                    {
                                        boolean variablelist_field$_last = (var_index36 == (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.SUB.eval(var_size30, 1)).longValue()));
                                        {
                                            long variablelist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index36, 1)).longValue());
                                            {
                                                long variablelist_field$_index = var_index36;
                                                {
                                                    boolean variablelist_field$_first = (var_index36 == 0);
                                                    {
                                                        boolean var_traversal38 = (((var_index36 >= 0) && (var_index36 <= var_end34)) && true);
                                                        if (var_traversal38) {
                                                            out.write("<ul>\n    <li>");
                                                            {
                                                                String var_39 = ((((((((("Index:" + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_index, "text"))) + ":Count:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_count, "text"))) + ":First:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_first, "text"))) + ":middle:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_middle, "text"))) + ":Last:") + renderContext.getObjectModel().toString(renderContext.call("xss", variablelist_field$_last, "text")));
                                                                out.write(renderContext.getObjectModel().toString(var_39));
                                                            }
                                                            out.write("</li>\n</ul>\n");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                var_index36++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar29_list_coerced$ = null;
}
out.write("\n\n");
{
    Object var_tagvar40 = renderContext.call("xss", "h3", "elementName");
    if (renderContext.getObjectModel().toBoolean(var_tagvar40)) {
        out.write("<");
        out.write(renderContext.getObjectModel().toString(var_tagvar40));
    }
    if (!renderContext.getObjectModel().toBoolean(var_tagvar40)) {
        out.write("<h1");
    }
    out.write(">Text");
    if (renderContext.getObjectModel().toBoolean(var_tagvar40)) {
        out.write("</");
        out.write(renderContext.getObjectModel().toString(var_tagvar40));
        out.write(">");
    }
    if (!renderContext.getObjectModel().toBoolean(var_tagvar40)) {
        out.write("</h1>");
    }
}
out.write("\n\n");
out.write("\n<div>");
{
    Object var_templatevar43 = _dynamic_writeinfo;
    {
        java.util.Map var_templateoptions44 = obj();
        callUnit(out, renderContext, var_templatevar43, var_templateoptions44);
    }
}
out.write("</div>\n\n");
out.write("\n<div>");
{
    Object var_templatevar47 = _dynamic_writedemo;
    {
        String var_templateoptions48_field$_age = "10";
        {
            String var_templateoptions48_field$_text = "text";
            {
                java.util.Map var_templateoptions48 = obj().with("age", var_templateoptions48_field$_age).with("text", var_templateoptions48_field$_text);
                callUnit(out, renderContext, var_templatevar47, var_templateoptions48);
            }
        }
    }
}
out.write("</div>\n\n<div>");
{
    Object var_textcontent49 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_currentpage, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_textcontent49));
}
out.write("</div>\n<div>");
{
    Object var_resourcecontent50 = renderContext.call("includeResource", "textnode", obj().with("resourceType", "wknd/components/image"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent50));
}
out.write("</div>\n");


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
addSubTemplate("writeInfo", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
out.write("\n    <p>");
{
    String var_41 = ("Text:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "text")));
    out.write(renderContext.getObjectModel().toString(var_41));
}
out.write("</p>\n    <p>");
{
    String var_42 = ("Age:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "age"), "text")));
    out.write(renderContext.getObjectModel().toString(var_42));
}
out.write("</p>\n");


// End Of Main Sub-Template Body ------------------------------------------------------------------
    }



    {
//Sub-Sub-Templates Initialization ----------------------------------------------------------------



//End of Sub-Sub-Templates Initialization ---------------------------------------------------------
    }
    
});
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
addSubTemplate("writedemo", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _dynamic_text = arguments.get("text");
Object _dynamic_age = arguments.get("age");
out.write("\n    <p>");
{
    String var_45 = ("Text:" + renderContext.getObjectModel().toString(renderContext.call("xss", _dynamic_text, "text")));
    out.write(renderContext.getObjectModel().toString(var_45));
}
out.write("</p>\n    <p>");
{
    String var_46 = ("Age:" + renderContext.getObjectModel().toString(renderContext.call("xss", _dynamic_age, "text")));
    out.write(renderContext.getObjectModel().toString(var_46));
}
out.write("</p>\n");


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

