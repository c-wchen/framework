package com.wchen.pojo;

import com.wchen.enums.AcceptType;
import lombok.Data;

@Data
public class Accept {
    AcceptType type;
    Object data;
}
