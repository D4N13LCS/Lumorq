package com.lumorq.entities.enums;

public enum EnrollmentStatus {

    PENDING(1),
    ACTIVE(2),
    COMPLETED(3),
    CANCELED(4);

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