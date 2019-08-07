package cn.chenzw.springboot.validation;

import cn.chenzw.toolkit.http.HttpRequestWrapper;

import java.util.List;

public interface ConstraintViolationExceptionWrapper {

    List<InvalidField> getInvalidFields();

    String getMethodName();

    Class<?> getBeanClass();

    HttpRequestWrapper getHttpRequestWrapper();

    class InvalidField {
        private String fieldName;
        private String message;
        private Object invalidValue;
        private String messageTemplate;

        public InvalidField(String fieldName, String message, Object invalidValue, String messageTemplate) {
            this.fieldName = fieldName;
            this.message = message;
            this.invalidValue = invalidValue;
            this.messageTemplate = messageTemplate;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessageTemplate() {
            return messageTemplate;
        }

        public void setMessageTemplate(String messageTemplate) {
            this.messageTemplate = messageTemplate;
        }

        public Object getInvalidValue() {
            return invalidValue;
        }

        public void setInvalidValue(Object invalidValue) {
            this.invalidValue = invalidValue;
        }

        @Override
        public String toString() {
            return "InvalidField{" +
                    "fieldName='" + fieldName + '\'' +
                    ", message='" + message + '\'' +
                    ", invalidValue=" + invalidValue +
                    ", messageTemplate='" + messageTemplate + '\'' +
                    '}';
        }
    }
}
