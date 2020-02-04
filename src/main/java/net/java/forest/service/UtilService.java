package net.java.forest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Iterator;

@Slf4j
@Service
public class UtilService {
    @Autowired
    private  Validator validator;

    public  <T> String validation(T t) {
        log.info(t.toString());
        Iterator<ConstraintViolation<T>> it = validator.validate(t).iterator();
        String message = "";
        while (it.hasNext()) {
            ConstraintViolation<T> constraintViolation = it.next();
            log.info("Error message : {}", constraintViolation.getMessage());
            message += constraintViolation.getMessage() + "\n";
        }
        return message;
    }
}
