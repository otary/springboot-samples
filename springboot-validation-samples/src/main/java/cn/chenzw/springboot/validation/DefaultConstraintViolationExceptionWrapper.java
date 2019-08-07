package cn.chenzw.springboot.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;

public class DefaultConstraintViolationExceptionWrapper implements ConstraintViolationExceptionWrapper {

    private List<InvalidField> invalidFields;


    public DefaultConstraintViolationExceptionWrapper(ConstraintViolationException constraintViolationException) {

        /*StringBuilder msgBuilder = new StringBuilder();
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            msgBuilder.append(String.format("参数[ %s = %s ]校验不通过！详细:[%s]", constraintViolation.getPropertyPath(),
                    constraintViolation.getInvalidValue(), constraintViolation.getMessageTemplate()));
        }*/

        // constraintViolationException


        for (ConstraintViolation<?> cv : constraintViolationException.getConstraintViolations()) {

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


    }

    @Override
    public List<InvalidField> getInvalidFields() {
        return invalidFields;
    }
}
