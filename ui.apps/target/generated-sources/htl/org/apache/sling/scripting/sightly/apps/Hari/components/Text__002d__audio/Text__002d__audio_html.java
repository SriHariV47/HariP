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
package org.apache.sling.scripting.sightly.apps.Hari.components.Text__002d__audio;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class Text__002d__audio_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
out.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n    <title>Text to Audio</title>\n</head>\n<body>\n\n<h1>Text to Audio Example</h1>\n\n<!-- Text input and Speak button -->\n<div>\n    <textarea id=\"textInput\" rows=\"4\" cols=\"50\">");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</textarea>\n    <button type=\"button\" onclick=\"speak()\">Speak</button>\n</div>\n\n<!-- Form for text submission -->\n<form id=\"textForm\" action=\"/bin/yourServlet\" method=\"POST\">\n    <div>\n        <label for=\"textField\">Enter Text:</label>\n        <input type=\"text\" id=\"textField\" name=\"textField\"");
{
    Object var_attrvalue1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "unsafe");
    {
        Object var_shoulddisplayattr4 = ((renderContext.getObjectModel().toBoolean(var_attrvalue1) ? var_attrvalue1 : ("false".equals(var_attrvalue1))));
        if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr4)) {
            out.write(" value");
            {
                boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                if (!var_istrueattr3) {
                    out.write("=\"");
                    out.write(renderContext.getObjectModel().toString(var_attrvalue1));
                    out.write("\"");
                }
            }
        }
    }
}
out.write("/>\n    </div>\n    <button type=\"submit\">Submit</button>\n</form>\n\n<!-- Audio player for playing audio response -->\n<audio id=\"audioPlayer\" controls style=\"display:none;\">\n    <source id=\"audioSource\" type=\"audio/mpeg\"/>\n    Your browser does not support the audio element.\n</audio>\n\n<script>\n    function speak() {\n        var textInput = document.getElementById('textInput').value;\n        var utterance = new SpeechSynthesisUtterance(textInput);\n        window.speechSynthesis.speak(utterance);\n    }\n\n    document.getElementById('textForm').onsubmit = function(event) {\n        event.preventDefault();\n        var form = event.target;\n\n        // Update text field value from textarea\n        document.getElementById('textField').value = document.getElementById('textInput').value;\n\n        // Call the speak function to read the text aloud\n        speak();\n\n        fetch(form.action, {\n            method: form.method,\n            body: new URLSearchParams(new FormData(form))\n        })\n        .then(response => {\n            console.log('Response received:', response);\n            return response.blob();\n        })\n        .then(blob => {\n            console.log('Blob received:', blob);\n            var url = URL.createObjectURL(blob);\n            console.log('Blob URL:', url);\n            var audioPlayer = document.getElementById('audioPlayer');\n            var audioSource = document.getElementById('audioSource');\n            audioSource.src = url;\n            audioPlayer.style.display = 'block';\n            audioPlayer.load();\n            audioPlayer.play().then(() => {\n                console.log('Audio is playing');\n            }).catch(error => {\n                console.error('Error playing audio:', error);\n            });\n        })\n        .catch(error => console.error('Error:', error));\n    };\n</script>\n\n</body>\n</html>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

