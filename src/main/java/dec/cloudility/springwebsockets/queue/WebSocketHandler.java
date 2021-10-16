package dec.cloudility.springwebsockets.queue;

import dec.cloudility.springwebsockets.model.Message;
import dec.cloudility.springwebsockets.model.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Profile("queue")
@Slf4j
public class WebSocketHandler {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/queue")
    @SendToUser("/queue/from-myself")
    public OutputMessage send(Message message, WebSocketBean bean, Principal principal) {
        log.info("Handling session with id {} receiving message {} from {}", principal.getName(), message.getText(), message.getFrom());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}
