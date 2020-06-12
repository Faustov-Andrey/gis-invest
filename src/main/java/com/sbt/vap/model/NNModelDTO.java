package com.sbt.vap.model;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class NNModelDTO {

    @NonNull
    String name;

    @NonNull
    String systemName;

    @NonNull
    Boolean activity;
}
