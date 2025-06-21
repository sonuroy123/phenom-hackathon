package com.phenom.flat_mate.common;

import lombok.Data;

@Data
public class HouseSearchCriteria {
    private String location;
    private String status;
    private String rtype;
    private Boolean furnished;
    private Integer ownerId;
}
