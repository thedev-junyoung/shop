package com.example.runshop.exception.global;

import com.example.runshop.exception.Inventory.InventoryNotFoundException;
import com.example.runshop.exception.cart.CartItemAlreadyExistsException;
import com.example.runshop.exception.cart.CartItemNotFoundException;
import com.example.runshop.exception.order.OrderAlreadyBeenCancelledException;
import com.example.runshop.exception.order.OrderNotFoundException;
import com.example.runshop.exception.product.CharactersArrangeDescriptionException;
import com.example.runshop.exception.product.CharactersArrangeException;
import com.example.runshop.exception.product.PriceNegativeException;
import com.example.runshop.exception.product.ProductNotFoundException;
import com.example.runshop.exception.user.*;
import com.example.runshop.model.dto.response.SuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CharactersArrangeDescriptionException.class)
    public ResponseEntity<SuccessResponse<Void>> handleCharactersArrangeDescriptionException(CharactersArrangeDescriptionException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(PriceNegativeException.class)
    public ResponseEntity<SuccessResponse<Void>> handlePriceNegativeException(PriceNegativeException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(CharactersArrangeException.class)
    public ResponseEntity<SuccessResponse<Void>> handleCharactersArrangeException(CharactersArrangeException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<SuccessResponse<Void>> handleInvalidEmailException(InvalidEmailException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<SuccessResponse<Void>> handleInventoryNotFoundException(InventoryNotFoundException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(OrderAlreadyBeenCancelledException.class)
    public ResponseEntity<SuccessResponse<Void>> handleOrderAlreadyBeenCancelled(OrderAlreadyBeenCancelledException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<SuccessResponse<Void>> handleOrderNotFoundException(OrderNotFoundException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<SuccessResponse<Void>> handleProductNotFoundException(ProductNotFoundException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<SuccessResponse<Void>> handleCartItemNotFoundException(CartItemNotFoundException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(CartItemAlreadyExistsException.class)
    public ResponseEntity<SuccessResponse<Void>> handleCartItemAlreadyExistsException(CartItemAlreadyExistsException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<SuccessResponse<Void>> handleSecurityException(SecurityException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.FORBIDDEN, ex.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<SuccessResponse<Void>> handleValidationExceptions(ConstraintViolationException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());

    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<SuccessResponse<Void>> handleUserAlreadyExistsException(UserAlreadyExistsException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<SuccessResponse<Void>> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<SuccessResponse<Void>> handleIncorrectPasswordException(IncorrectPasswordException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.UNAUTHORIZED, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<SuccessResponse<Void>> handleDuplicateEmailException(DuplicateEmailException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<SuccessResponse<Void>> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.UNAUTHORIZED, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SuccessResponse<Void>> handleGeneralException(HttpServletRequest request) {
        return SuccessResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다.", request.getRequestURI());
    }
}
