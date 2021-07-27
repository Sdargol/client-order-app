package com.sdargol.dto.msg;

public class ContentMessageDTO<T> extends BaseMessageDTO{
    private T content;

    public ContentMessageDTO() {
    }

    public ContentMessageDTO(String msg, T content) {
        super(msg);
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
