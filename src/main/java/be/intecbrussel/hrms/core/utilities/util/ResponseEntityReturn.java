package be.intecbrussel.hrms.core.utilities.util;

import be.intecbrussel.hrms.core.utilities.results.Result;
import org.springframework.http.ResponseEntity;

public class ResponseEntityReturn {

    public static ResponseEntity<?> checkResult(Result operation) {
        Result result = operation;
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
