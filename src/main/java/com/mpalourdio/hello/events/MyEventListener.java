/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mpalourdio.hello.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    private MyEvent myEvent;

    @EventListener
    public AnotherEvent publishMyEvent(final MyEvent myEvent) {
        this.myEvent = myEvent;
        myEvent.setMessage(myEvent.getMessage() + " -> now I have been published");

        return new AnotherEvent();
    }

    @EventListener
    public void publishAnotherEvent(final AnotherEvent myOtherEvent) {
        myEvent.setMessage(myEvent.getMessage() + "\n" + myOtherEvent.publishMeToo());
    }
}