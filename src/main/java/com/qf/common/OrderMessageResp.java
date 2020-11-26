package com.qf.common;

import lombok.Data;

@Data
public class OrderMessageResp {

    private Integer oid;
    private String cname;
    private String getcity;
    private String backcity;
    private Double oprice;
    private String ostatus;

}
