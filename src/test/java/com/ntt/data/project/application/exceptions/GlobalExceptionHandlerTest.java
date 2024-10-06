package com.ntt.data.project.application.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ntt.data.project.domain.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @Test
    void testHandleValidationExceptions() {
        ResponseEntity<String> response = new GlobalExceptionHandler().handleValidationExceptions(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Validation error: Unexpected error", response.getBody());
    }

    @Test
    void testHandleInvalidUserIdException() {
        InvalidUserException exception = new InvalidUserException("Invalid user ID");

        ResponseEntity<String> response = new GlobalExceptionHandler().handleInvalidUserIdException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Validation error: Invalid user ID", response.getBody());
    }

    @Test
    void testHandleDatabaseException() {
        DatabaseException exception = new DatabaseException("Database error occurred");

        ResponseEntity<String> response = new GlobalExceptionHandler().handleDatabaseException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal error: Database error occurred", response.getBody());
    }

}
