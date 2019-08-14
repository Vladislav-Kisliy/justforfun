package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public interface Handler<S> {
    void handle(S s) throws IOException;
}
