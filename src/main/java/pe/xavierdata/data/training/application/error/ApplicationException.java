package pe.xavierdata.data.training.application.error;

import java.io.Serializable;

public class ApplicationException extends RuntimeException implements Serializable
{
    private static final long serialVersionUID = 1L;
    private ErrorCategory articleTypeExists;
    private String code;
    private String descriptionError;

    public ApplicationException() {
        super();
    }
    public ApplicationException(String code,String descriptionError) {
        super();
        this.code = code;
        this.descriptionError = descriptionError;
    }
    public ApplicationException(String msg)   {
        super(msg);
    }
    public ApplicationException(String msg, Exception e)  {
        super(msg, e);
    }

    public ApplicationException(ErrorCategory articleTypeExists) {
        this.articleTypeExists=articleTypeExists;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public ErrorCategory getArticleTypeExists() {
        return articleTypeExists;
    }

    public void setArticleTypeExists(ErrorCategory articleTypeExists) {
        this.articleTypeExists = articleTypeExists;
    }
}