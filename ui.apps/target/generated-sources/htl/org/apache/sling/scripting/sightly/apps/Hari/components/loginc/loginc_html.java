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
package org.apache.sling.scripting.sightly.apps.Hari.components.loginc;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class loginc_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<h1> Login</h1>\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n    <title>Login</title>\n</head>\n<body>\n\n<h1>Login</h1>\n<div class=\"login-form\">\n    <form id=\"loginForm\" method=\"post\" action=\"submit.php\">\n        <div class=\"form-group\">\n            <label for=\"email\">Email address</label>\n            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" required/>\n        </div>\n        <div class=\"form-group\">\n            <label for=\"password\">Password</label>\n            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required/>\n            <small id=\"passwordHelp\" class=\"form-text text-muted\">Password must contain at least one capital letter, one number, and one special character.</small>\n        </div>\n        <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n    </form>\n</div>\n\n</body>\n</html>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

