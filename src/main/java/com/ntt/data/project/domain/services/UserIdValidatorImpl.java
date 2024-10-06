package com.ntt.data.project.domain.services;

import com.ntt.data.project.domain.exceptions.InvalidUserException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserIdValidatorImpl implements UserIdValidator {

    @Override
    public void validate(String userId) {
        Pattern pattern = Pattern.compile("^[0-9]{8}[A-Za-z]$");
        if (userId == null || !pattern.matcher(userId).matches()) {
            throw new InvalidUserException("userId must have correct format (8 digits plus 1 letter)");
        }
    }

}
