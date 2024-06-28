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
package org.apache.sling.scripting.sightly.apps.Hari.components.textfield;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class textfield_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("    <form id=\"emailForm\">\n        <label for=\"email\">Email:</label>\n        <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Enter your email address\" required/>\n        <span class=\"error-message\" id=\"emailError\"></span>\n        <br/>\n        <input type=\"button\" value=\"Submit\" onclick=\"validateAndSubmit()\"/>\n    </form>\n\n    <script>\n    document.getElementById('email').addEventListener('input', function() {\n        var emailField = this;\n        var emailValue = emailField.value;\n        var emailPattern = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/; // Improved email pattern\n        var emailError = document.getElementById('emailError');\n\n        if (emailValue.trim() === '') {\n            emailField.classList.remove('valid');\n            emailField.classList.add('error');\n            emailError.textContent = 'Please enter an email address.';\n        } else if (!emailPattern.test(emailValue)) {\n            emailField.classList.remove('valid');\n            emailField.classList.add('error');\n            emailError.textContent = 'Please enter a valid email address.';\n        } else {\n            emailField.classList.remove('error');\n            emailField.classList.add('valid');\n            emailError.textContent = ''; // Clear error message\n        }\n    });\n\n    function validateAndSubmit() {\n    var emailField = document.getElementById('email');\n    var emailError = document.getElementById('emailError');\n    if (emailField.value.trim() === '') {\n        emailError.textContent = 'Please enter an email address.';\n    } else if (!emailField.classList.contains('valid')) {\n        emailError.textContent = 'Please enter a valid email address.';\n    } else {\n        emailError.textContent = ''; // Clear error message if email is valid\n        var email = emailField.value; // Get the email address\n        // Handle the form submission here if the email is valid\n        // For example, send an AJAX request or update the page content\n        console.log('mail id is submitted correctly:', email);\n    }\n}\n\n    </script>\n\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

