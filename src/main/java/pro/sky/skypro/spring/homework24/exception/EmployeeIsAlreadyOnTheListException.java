package pro.sky.skypro.spring.homework24.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class EmployeeIsAlreadyOnTheListException extends RuntimeException {
}
