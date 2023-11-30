package logixtek.moitech.malib.controllers;

import jakarta.validation.constraints.NotEmpty;
import logixtek.moitech.malib.entities.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @GetMapping(value = "/{readerId}", produces = {"application/vnd.logix.itm.api-v1.0+json"})
    public ResponseEntity<?> getReaderV1(@PathVariable @NotEmpty String readerId) {
        Reader reader = new Reader();
        reader.setId(1);
        reader.setFirstName("V1");
        reader.setLastName(readerId);
        return ResponseEntity.ok(reader);
    }

    @GetMapping(value = "/{readerId}", produces = {"application/vnd.logix.itm.api-v2.0+json"})
    public ResponseEntity<?> getReaderV2(@PathVariable @NotEmpty String readerId) {
        Reader reader = new Reader();
        reader.setId(2);
        reader.setFirstName("V2");
        reader.setLastName(readerId);
        return ResponseEntity.ok(reader);
    }
}
