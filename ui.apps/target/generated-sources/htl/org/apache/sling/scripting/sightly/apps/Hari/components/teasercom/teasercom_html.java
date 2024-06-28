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

public final class teasercom_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_teaser = null;
Object _global_component = null;
Object _global_templates = null;
Object _global_imagetemplate = null;
Object _global_pretitletemplate = null;
Object _global_titletemplate = null;
Object _global_descriptiontemplate = null;
Object _global_actionstemplate = null;
Object _global_hascontent = null;
Object _dynamic_wcmmode = bindings.get("wcmmode");
out.write("Hello\n\n");
_global_teaser = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Teaser.class.getName(), obj());
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_imagetemplate = renderContext.call("use", "image.html", obj());
_global_pretitletemplate = renderContext.call("use", "pretitle.html", obj());
_global_titletemplate = renderContext.call("use", "title.html", obj());
_global_descriptiontemplate = renderContext.call("use", "description.html", obj());
_global_actionstemplate = renderContext.call("use", "actions.html", obj());
_global_hascontent = ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title")))) ? ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "description")))) ? ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title")))) ? ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "description"))) : (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_teaser, "actions"), "size"), 0)))));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    out.write("<div");
    {
        Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
        {
            Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
            {
                Object var_shoulddisplayattr3 = ((renderContext.getObjectModel().toBoolean(var_attrcontent1) ? var_attrcontent1 : ("false".equals(var_attrvalue0))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr3)) {
                    out.write(" id");
                    {
                        boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                        if (!var_istrueattr2) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    {
        String var_attrcontent4 = ("cmp-teaser" + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean((((!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "disabled"))) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "disabled")))))) ? " cq-dd-image" : ""), "attribute")));
        {
            Object var_shoulddisplayattr5 = ((renderContext.getObjectModel().toBoolean(var_attrcontent4) ? var_attrcontent4 : ("false".equals(var_attrcontent4))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr5)) {
                out.write(" class=\"");
                out.write(renderContext.getObjectModel().toString(var_attrcontent4));
                out.write("\"");
            }
        }
    }
    {
        Object var_attrvalue6 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_teaser, "data"), "json");
        {
            Object var_attrcontent7 = renderContext.call("xss", var_attrvalue6, "attribute");
            {
                Object var_shoulddisplayattr9 = ((renderContext.getObjectModel().toBoolean(var_attrcontent7) ? var_attrcontent7 : ("false".equals(var_attrvalue6))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr9)) {
                    out.write(" data-cmp-data-layer");
                    {
                        boolean var_istrueattr8 = (var_attrvalue6.equals(true));
                        if (!var_istrueattr8) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent7));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write(">\n    ");
    {
        Object var_templatevar10 = renderContext.getObjectModel().resolveProperty(_global_imagetemplate, "image");
        {
            Object var_templateoptions11_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions11 = obj().with("teaser", var_templateoptions11_field$_teaser);
                callUnit(out, renderContext, var_templatevar10, var_templateoptions11);
            }
        }
    }
    out.write("\n    <div class=\"cmp-teaser__content\">\n        ");
    {
        Object var_templatevar12 = renderContext.getObjectModel().resolveProperty(_global_pretitletemplate, "pretitle");
        {
            Object var_templateoptions13_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions13 = obj().with("teaser", var_templateoptions13_field$_teaser);
                callUnit(out, renderContext, var_templatevar12, var_templateoptions13);
            }
        }
    }
    out.write("\n        ");
    {
        Object var_templatevar14 = renderContext.getObjectModel().resolveProperty(_global_titletemplate, "title");
        {
            Object var_templateoptions15_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions15 = obj().with("teaser", var_templateoptions15_field$_teaser);
                callUnit(out, renderContext, var_templatevar14, var_templateoptions15);
            }
        }
    }
    out.write("\n        ");
    {
        Object var_templatevar16 = renderContext.getObjectModel().resolveProperty(_global_descriptiontemplate, "description");
        {
            Object var_templateoptions17_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions17 = obj().with("teaser", var_templateoptions17_field$_teaser);
                callUnit(out, renderContext, var_templatevar16, var_templateoptions17);
            }
        }
    }
    out.write("\n        ");
    {
        Object var_templatevar18 = renderContext.getObjectModel().resolveProperty(_global_actionstemplate, "actions");
        {
            Object var_templateoptions19_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions19 = obj().with("teaser", var_templateoptions19_field$_teaser);
                callUnit(out, renderContext, var_templatevar18, var_templateoptions19);
            }
        }
    }
    out.write("\n    </div>\n</div>");
}
out.write("\n");
{
    Object var_templatevar20 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions21_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            String var_templateoptions21_field$_classappend = "cmp-teaser";
            {
                java.util.Map var_templateoptions21 = obj().with("isEmpty", var_templateoptions21_field$_isempty).with("classAppend", var_templateoptions21_field$_classappend);
                callUnit(out, renderContext, var_templatevar20, var_templateoptions21);
            }
        }
    }
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

