package pe.xavierdata.data.training.application.error;

import javax.ws.rs.core.Response;

public enum ErrorCategory {

    DATA_EXISTS("AT001","Error information", Response.Status.BAD_REQUEST),
    RUC_PARENT_NOT_EXISTS("AT002","Error information", Response.Status.NOT_FOUND),
    COMPANY_NOT_EXISTS("AT003","Error information", Response.Status.NOT_FOUND),
    DATA_NOT_EXISTS("AT004","Error information", Response.Status.NOT_FOUND),
    LIMIT_EXCEEDED("AT005","Exceeded limit", Response.Status.PRECONDITION_FAILED),
    DATA_DELETED("AT006","Error data not exists", Response.Status.PRECONDITION_REQUIRED),
    CONSUMER_NOT_EXISTS("AT007","Error information", Response.Status.NOT_FOUND),
    ROLE_NOT_EXISTS("AT005","Error information", Response.Status.NOT_FOUND),
    ERROR_PERMISSION("AT006","Error information", Response.Status.FORBIDDEN),
    ERROR_GENERAL("AT100","Error", Response.Status.NOT_FOUND),
    ;

    private String code;
    private String message;
    private Response.Status httpStatus;

    ErrorCategory(String code, String message, Response.Status httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response.Status getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Response.Status httpStatus) {
        this.httpStatus = httpStatus;
    }
}
