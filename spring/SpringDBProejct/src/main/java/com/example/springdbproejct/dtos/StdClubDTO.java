package com.example.springdbproejct.dtos;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
public class StdClubDTO {
    private StdDTO stdDTO;
    private ClubDTO clubDTO;
}
