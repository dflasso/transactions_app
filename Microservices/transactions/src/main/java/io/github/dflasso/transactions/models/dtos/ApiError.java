package io.github.dflasso.transactions.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import io.github.dflasso.transactions.models.constants.AppErrorsCodesAndMessages;
import io.github.dflasso.transactions.util.LowerCaseClassNameResolver;
import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
@JsonTypeIdResolver(LowerCaseClassNameResolver.class)
public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String code;
    private List<ApiSubError> subErrors;

    public ApiError(HttpStatus _status, AppErrorsCodesAndMessages  error) {
        this.status = _status;
        timestamp = LocalDateTime.now();
        this.message = error.getMessage();
        this.code = error.getCode();
        subErrors = new ArrayList<ApiSubError>();
    }

    public ApiError(HttpStatus _status, String _message) {
        this.status = _status;
        timestamp = LocalDateTime.now();
        this.message = _message;
        subErrors = new ArrayList<ApiSubError>();
    }

    public ApiError(HttpStatus _status) {
        this.status = _status;
        timestamp = LocalDateTime.now();
        subErrors = new ArrayList<ApiSubError>();
    }

    public void addSubError(ApiSubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<ApiSubError>();
        }
        subErrors.add(subError);
    }

    public void addSubErrors(ApiSubError ...subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<ApiSubError>();
        }
        subErrors.addAll(subErrors);
    }

    public void addSubErrors( List<ApiSubError> subErrors) {
        if (subErrors == null) {
            subErrors = new ArrayList<ApiSubError>();
        }
        subErrors.addAll(subErrors);
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message, AppErrorsCodesAndMessages.FIELD_VALIDATION.getCode()));
    }


    private void addValidationError(FieldError fieldError) {
        this.addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    private void addValidationError(String object, String message) {
        addSubError(new ApiValidationError(object, message));
    }


    private void addValidationError(ObjectError objectError) {
        this.addValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
    }

    public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }

}
