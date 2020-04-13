/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mpalourdio.springboottemplate.mediatype;

import java.nio.charset.StandardCharsets;

public final class MediaType extends org.springframework.http.MediaType {

    public static final org.springframework.http.MediaType APPLICATION_VND_API_V1;
    public static final String APPLICATION_VND_API_V1_VALUE = "application/vnd.api.v1+json;charset=UTF-8";

    public static final org.springframework.http.MediaType APPLICATION_VND_API_V2;
    public static final String APPLICATION_VND_API_V2_VALUE = "application/vnd.api.v2+json;charset=UTF-8";

    private MediaType(String type) {
        super(type);
    }

    static {
        var applicationType = "application";
        APPLICATION_VND_API_V1 = new org.springframework.http.MediaType(applicationType, "vnd.api.v1+json", StandardCharsets.UTF_8);
        APPLICATION_VND_API_V2 = new org.springframework.http.MediaType(applicationType, "vnd.api.v2+json", StandardCharsets.UTF_8);
    }
}
