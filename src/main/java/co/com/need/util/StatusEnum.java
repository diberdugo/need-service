package co.com.need.util;

public enum StatusEnum {
    
    CODE_SUCCESS("0"),
    DESC_SUCCESS("Correcto"),
    CODE_EXPIRED_TOKEN("97"),
    DESC_EXPIRED_TOKEN("Token expirado"),
    CODE_INVALID_TOKEN("98"),
    DESC_INVALID_TOKEN("Token inválido"),
    CODE_ERROR("99"),
    DESC_ERROR("Error");
    
    private String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String get() {
        return status;
    }
}
