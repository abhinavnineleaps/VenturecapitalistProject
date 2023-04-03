package com.platform.VentureCapitalist.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ResponseDto {
    Object response;
    String message;
}
