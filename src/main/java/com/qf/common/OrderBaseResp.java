package com.qf.common;

import lombok.Data;

import java.util.List;

@Data
public class OrderBaseResp {

    private Integer total;

    private List rows;
}
