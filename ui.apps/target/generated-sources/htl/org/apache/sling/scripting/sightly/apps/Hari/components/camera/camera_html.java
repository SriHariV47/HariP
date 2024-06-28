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
package org.apache.sling.scripting.sightly.apps.Hari.components.camera;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class camera_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n    <title>WebRTC Test</title>\n    <style>\n        #video {\n            border: 1px solid black;\n        }\n        #canvas {\n            border: 1px solid black;\n            display: none;\n        }\n        #output-canvas {\n            border: 1px solid black;\n            display: none;\n        }\n    </style>\n    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n</head>\n<body>\n    <h1>WebRTC Test</h1>\n    <button id=\"start-camera\">Start Camera</button>\n    <video id=\"video\" width=\"300\" height=\"300\" autoplay style=\"display:none;\"></video>\n    <button id=\"snap\" style=\"display: none;\">Snap Photo</button>\n    <button id=\"recapture\" style=\"display: none;\">Recapture Photo</button>\n    <canvas id=\"canvas\" width=\"300\" height=\"300\"></canvas>\n    <canvas id=\"output-canvas\" width=\"300\" height=\"300\"></canvas>\n    <p id=\"location-info\" style=\"display:none;\">\n        Latitude: <span id=\"latitude\"></span><br/>\n        Longitude: <span id=\"longitude\"></span>\n    </p>\n    <button id=\"download\" style=\"display: none;\">Download Image</button>\n    <script>\n        (function () {\n            const startCameraButton = document.getElementById('start-camera');\n            const video = document.getElementById('video');\n            const canvas = document.getElementById('canvas');\n            const outputCanvas = document.getElementById('output-canvas');\n            const snap = document.getElementById('snap');\n            const recapture = document.getElementById('recapture');\n            const locationInfo = document.getElementById('location-info');\n            const latitudeSpan = document.getElementById('latitude');\n            const longitudeSpan = document.getElementById('longitude');\n            const downloadButton = document.getElementById('download');\n            const context = canvas.getContext('2d');\n            const outputContext = outputCanvas.getContext('2d');\n\n            let stream;\n\n            function startCamera() {\n                navigator.mediaDevices.getUserMedia({ video: true })\n                    .then(function (mediaStream) {\n                        stream = mediaStream;\n                        video.srcObject = stream;\n                        video.style.display = 'block';\n                        snap.style.display = 'inline';\n                        startCameraButton.style.display = 'none';\n                        console.log('WebRTC is supported!');\n                    })\n                    .catch(function (err) {\n                        console.log('WebRTC is not supported: ' + err);\n                    });\n            }\n\n            snap.addEventListener('click', function () {\n                navigator.geolocation.getCurrentPosition(function(position) {\n                    const latitude = position.coords.latitude;\n                    const longitude = position.coords.longitude;\n                    latitudeSpan.textContent = latitude;\n                    longitudeSpan.textContent = longitude;\n                    locationInfo.style.display = 'block';\n                }, function(error) {\n                    console.error('Error getting location: ', error);\n                });\n\n                context.drawImage(video, 0, 0, 300, 300);\n                canvas.toBlob(function(blob) {\n                    createCircularImage(blob);\n                }, 'image/png');\n                canvas.style.display = 'block';\n                recapture.style.display = 'inline';\n                downloadButton.style.display = 'inline';\n                snap.style.display = 'none';\n\n                if (stream) {\n                    stream.getTracks().forEach(track => track.stop());\n                }\n            });\n\n            function createCircularImage(blob) {\n                const img = new Image();\n                img.onload = function () {\n                    outputContext.clearRect(0, 0, outputCanvas.width, outputCanvas.height);\n                    outputContext.save();\n                    outputContext.beginPath();\n                    outputContext.arc(outputCanvas.width / 2, outputCanvas.height / 2, outputCanvas.width / 2, 0, Math.PI * 2, true);\n                    outputContext.closePath();\n                    outputContext.clip();\n                    outputContext.drawImage(img, 0, 0, outputCanvas.width, outputCanvas.height);\n                    outputContext.restore();\n                    outputCanvas.style.display = 'block';\n                    outputCanvas.toBlob(function(circularBlob) {\n                        sendImageToServer(circularBlob, window.location.href);\n                    }, 'image/png');\n                };\n                img.src = URL.createObjectURL(blob);\n            }\n\n            recapture.addEventListener('click', function () {\n                startCamera();\n                canvas.style.display = 'none';\n                outputCanvas.style.display = 'none';\n                recapture.style.display = 'none';\n                downloadButton.style.display = 'none';\n                locationInfo.style.display = 'none';\n            });\n\n            downloadButton.addEventListener('click', function () {\n                const dataURL = outputCanvas.toDataURL('image/png');\n                const link = document.createElement('a');\n                link.href = dataURL;\n                link.download = 'captured_image.png';\n                link.click();\n            });\n\n            function sendImageToServer(imageBlob, url) {\n                var xhr = new XMLHttpRequest();\n                xhr.open('POST', '/bin/mycamera', true); // Update with servlet path\n                xhr.setRequestHeader('Current-Page-URL', url); // Pass the URL in a custom header\n                xhr.onload = function() {\n                    if (xhr.status === 200) {\n                        console.log('Image and URL sent to servlet successfully.');\n                    } else {\n                        console.error('Failed to send image and URL to servlet.');\n                    }\n                };\n                xhr.send(imageBlob);\n            }\n\n            startCameraButton.addEventListener('click', startCamera);\n        })();\n    </script>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

