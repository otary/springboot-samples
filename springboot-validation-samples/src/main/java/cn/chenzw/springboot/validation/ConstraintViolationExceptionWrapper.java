package cn.chenzw.springboot.validation;

import java.util.List;

public interface ConstraintViolationExceptionWrapper {

    List<InvalidField> getInvalidFields();

    class InvalidField {
        private String fieldName;
        private String message;
        private Object value;
        private String messageTemplate;

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

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getMessageTemplate() {
            return messageTemplate;
        }

        public void setMessageTemplate(String messageTemplate) {
            this.messageTemplate = messageTemplate;
        }

        @Override
        public String toString() {
            return "InvalidField{" + "fieldName='" + fieldName + '\'' + ", message='" + message + '\'' + ", value="
                    + value + ", messageTemplate='" + messageTemplate + '\'' + '}';
        }
    }
}
