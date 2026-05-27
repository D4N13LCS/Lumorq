package com.lumorq.entities.enums;

public enum EnrollmentStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private EnrollmentStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static EnrollmentStatus valueOf(int code){
        for(EnrollmentStatus value : EnrollmentStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid EnrollmentStatus code: " + code);
    }
}