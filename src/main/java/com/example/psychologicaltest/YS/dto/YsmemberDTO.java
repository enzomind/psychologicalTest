package com.example.psychologicaltest.YS.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YsmemberDTO {

    private Long mid;
    private String mname;
    private String mgender;
    private int mage;
    private String mresult;

}
