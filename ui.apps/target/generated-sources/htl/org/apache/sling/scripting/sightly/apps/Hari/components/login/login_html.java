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
package org.apache.sling.scripting.sightly.apps.Hari.components.login;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class login_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n    <title>Login Page</title>\n\n</head>\n<body>\n    <div class=\"login-container\">\n        <button class=\"login-button\" onclick=\"showAuthOptions()\">Login</button>\n        <div id=\"auth-options\" class=\"auth-options\" style=\"display: none;\">\n            <a href=\"#\" class=\"auth-option google\" onclick=\"loginWithGoogle()\">Continue with Google</a>\n        </div>\n    </div>\n\n    <script>");
{
    String var_0 = "\n        function showAuthOptions() {\n            document.getElementById('auth-options').style.display = 'block';\n        }\n\n        function loginWithGoogle() {\n            const clientId = 'YOUR_GOOGLE_CLIENT_ID';\n            const redirectUri = 'YOUR_REDIRECT_URI';\n            const scope = 'email profile';\n            const responseType = 'token';\n            const authUrl = https://accounts.google.com/o/oauth2/v2/auth?client_id=&redirect_uri=&scope=&response_type=;\n\n            window.location.href = authUrl;\n        }\n    ";
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</script>\n</body>\n</html>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

