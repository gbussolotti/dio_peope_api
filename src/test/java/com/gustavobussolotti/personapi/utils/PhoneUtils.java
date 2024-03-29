package com.gustavobussolotti.personapi.utils;


import com.gustavobussolotti.personapi.dto.request.PhoneDTO;
import com.gustavobussolotti.personapi.entity.Phone;
import com.gustavobussolotti.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "3199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}