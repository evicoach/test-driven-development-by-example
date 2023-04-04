package com.columnhack.module_two;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTypeTest {

    @ParameterizedTest(name = "{displayName} [{index}] - {arguments}")
    @EnumSource(OwnerType.class)
    void values(OwnerType ownerType) {
        System.out.println("The owner is " + ownerType);
    }
}