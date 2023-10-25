package logixtek.moitech.malib.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseMessage {
    String timestamp;

    HttpStatus status;

    String path;

    private String message;

    private Map<String, String> fieldErrors;

}
