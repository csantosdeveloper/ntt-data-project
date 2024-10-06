package com.ntt.data.project.domain.services;

import com.ntt.data.project.domain.exceptions.InvalidUserException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Log4j2
@Service
public class UserIdValidatorImpl implements UserIdValidator {

    @Override
    public void validate(String userId) {
        Pattern pattern = Pattern.compile("^[0-9]{8}[A-Za-z]$");
        if (userId == null || !pattern.matcher(userId).matches()) {
            log.error("Invalid userId: {}", userId);
            throw new InvalidUserException("userId must have correct format (8 digits plus 1 letter)");
        }
    }

}
