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
package org.apache.sling.scripting.sightly.apps.Hari.components.product;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class product_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<h2>Product details</h2>\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\"/>\n    <title>Product Card</title>\n</head>\n<body>\n    <div class=\"product-card\">\n        <p><b>ID:</b> {{properties.id}}</p>\n        <p><b>Name:</b> {{properties.name}}</p>\n        <p><b>Description:</b> {{properties.description}}</p>\n        <p><b>Type:</b> {{properties.type}}</p>\n        <p><b>Price:</b> {{properties.price}}</p>\n        <form action=\"/path/to/cart/servlet\" method=\"post\">\n            <input type=\"hidden\" name=\"productId\" value=\"{{properties.id}}\"/>\n            <button type=\"submit\">{{#if osgiConfig.addButtonForType[properties.type]}}{{osgiConfig.addButtonForType[properties.type]}}{{#else}}Add to Cart{{/if}}</button>\n        </form>\n    </div>\n</body>\n</html>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

