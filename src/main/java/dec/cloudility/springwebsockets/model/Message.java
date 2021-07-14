package dec.cloudility.springwebsockets.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class Message {

    @JsonProperty("from")
    String from;
    @JsonProperty("text")
    String text;

}