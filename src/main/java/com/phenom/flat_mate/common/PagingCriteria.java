package com.phenom.flat_mate.common;

import lombok.Data;

import java.util.List;

@Data
public class PagingCriteria {

    private Integer pageNo;
    private Integer pageSize;
    private String sortKey;
    private String sortDirection;
    private List<String> sortDirs;
    private List<String> sortParams;
}
