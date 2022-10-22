//package com.bridgelabz.addressbookspringapp.exception;
//
//import com.bridgelabz.addressbookspringapp.Dto.ResponseDto;
//import org.springframework.context.support.DefaultMessageSourceResolvable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@ControllerAdvice
//public class AddressBookExceptionHandler {
//    public static final String message = "Exception while processing REST Request";
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ResponseDto> handleMethodArgumentsNotValidException(MethodArgumentNotValidException exception) {
//        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
//        List<String> errorMessage = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
//        ResponseDto responseDto = new ResponseDto(message, errorMessage);
//        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(AddressBookException.class)
//    public ResponseEntity<ResponseDto>handleEmployeePayrollException(AddressBookException exception) {
//        ResponseDto responseDto = new ResponseDto(message,exception.getMessage());
//        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
//    }
//}
