package dec.cloudility.springwebsockets.authorizedqueue;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Profile("authorized-queue")
@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebSocketBean {

    private final AtomicLong msgsCount = new AtomicLong();

    void increment() {
        msgsCount.incrementAndGet();
    }

    public AtomicLong getMsgsCount() {
        return msgsCount;
    }

}
