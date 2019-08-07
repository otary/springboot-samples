package cn.chenzw.springboot.validation.exception.handler;

import com.google.common.collect.Lists;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ConstraintViolationExceptionHandler {


    /**
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        System.out.println("------------------handleMethodArgumentNotValidException:" + message);


        //  System.out.println(e.getBindingResult());
       /* MethodParameter parameter = e.getParameter();

        Member member = parameter.getMember();
        System.out.println(member);
        System.out.println("---------getDeclaringClass:" + member.getDeclaringClass());
        System.out.println("-------------------getName:" + member.getName());

        String parameterName = parameter.getParameterName();
        System.out.println("--------------parameterName:" + parameterName);


        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());

        System.out.println("----------------message:" + message);

         e.getBindingResult().getAllErrors().stream().map(()->{

        });

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();

        for (ObjectError allError : allErrors) {
            System.out.println(allError.getObjectName());
            System.out.println(allError.getCode());
            System.out.println(Arrays.toString(allError.getCodes()));
            System.out.println(Arrays.toString(allError.getArguments()));
        }*/


        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            System.out.println(fieldError.getField());
            System.out.println(fieldError.getDefaultMessage());
        }

        return null;
    }


    /**
     * qing
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Object handleConstraintViolationException(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining());

        System.out.println("-------------------handleConstraintViolationException:" + message);

        for (ConstraintViolation<?> cv : e.getConstraintViolations()) {

            String propertyPath = cv.getPropertyPath().toString();
            if (propertyPath.indexOf(".") != -1) {
                String[] propertyPathArr = propertyPath.split("\\.");

                System.out.println("-----------filedName: " + propertyPathArr[propertyPathArr.length - 1]);
            } else {
                System.out.println("-------------------fieldName22:" + propertyPath);
            }
            System.out.println("------------------message:" + cv.getMessage());
            System.out.println("---------------------getPropertyPath:" + cv.getPropertyPath());

            System.out.println("-------------------------------getInvalidValue:" + cv.getInvalidValue());

            System.out.println("--------------------------getMessageTemplate:" + cv.getMessageTemplate());
        }

        return null;
    }


    /**
     * GET请求参数异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object hanldeBindException(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        System.out.println("----------------hanldeBindException:" + message);


        return null;
    }


/*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Object handleConstraintViolationException(ConstraintViolationException e) {
        if (logger.isDebugEnabled()) {
            logger.debug("参数值校验不通过!", e);
        }
        StringBuilder msgBuilder = new StringBuilder();
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            msgBuilder.append(String.format("参数[ %s = %s ]校验不通过！详细:[%s]", constraintViolation.getPropertyPath(),
                    constraintViolation.getInvalidValue(), constraintViolation.getMessageTemplate()));
        }
        return new ErrorInfo(HttpStatus.BAD_REQUEST.value(), msgBuilder.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        if (logger.isDebugEnabled()) {
            logger.debug("参数值校验不通过!", e);
        }
        return new ErrorInfo(HttpStatus.BAD_REQUEST.value(), getErrorMsg(e.getBindingResult()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object hanldeBindException(BindException e) {
        if (logger.isDebugEnabled()) {
            logger.debug("参数值校验不通过!", e);
        }
        return new ErrorInfo(HttpStatus.BAD_REQUEST.value(), getErrorMsg(e.getBindingResult()));
    }


    private String getErrorMsg(BindingResult bindingResult) {
        StringBuilder msgBuilder = new StringBuilder();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                msgBuilder.append(String.format("参数[ %s = %s ]校验不通过！详细:[%s]; ", fieldError.getField(),
                        fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
            }
        }
        return msgBuilder.toString();
    }*/


}
