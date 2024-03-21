package com.D7.myPet.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pass implements Serializable {
    private long id;
    private long userID;
    private byte[] password;

}
