package com.ntt.data.project.domain.services;

import com.ntt.data.project.domain.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserValidatorImplTest {

    @InjectMocks
    private UserIdValidatorImpl userIdValidator;

    @Test
    void testValidate() {
        userIdValidator.validate("12345678A");
    }

    @Test
    void testValidateException() {
        InvalidUserException responseException = assertThrows(InvalidUserException.class, () -> userIdValidator.validate("1234AAAAA"));

        assertEquals("userId must have correct format (8 digits plus 1 letter)", responseException.getMessage());
    }

    @Test
    void testValidateExceptionNull() {
        InvalidUserException responseException = assertThrows(InvalidUserException.class, () -> userIdValidator.validate(null));

        assertEquals("userId must have correct format (8 digits plus 1 letter)", responseException.getMessage());
    }

}
