package com.sdargol.dto.msg;

public class BaseMessageDTO {
    private String msg;

    public BaseMessageDTO() {
    }

    public BaseMessageDTO(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
