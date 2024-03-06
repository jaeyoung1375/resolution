package com.jy.board.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MemberDto {
    private String id;
    private String password;
    private String name;
    private String mobile;
    private String lastLoginIp;
    private String memberLevel;
    private Date createDate;
    private Date lastLoginDate;
}
