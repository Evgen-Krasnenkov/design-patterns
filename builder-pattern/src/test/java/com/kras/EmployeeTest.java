package com.kras;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeeTest {
    private static Employee.EmployeeBuilder builder;
    @BeforeAll
    static void setUp(){
        builder = Employee.builder();
    }

    @Test
    void givenEmployeeBuilder_whenDifferentNumberOfFields_thenBuilderWorks() {

        Employee employeeTwoFields = builder.setCarNumber("1234")
                .setEmail("test@test.com")
                .build();
        Employee employeeThreeFields = builder.setName("Nike")
                .setPosition("NoPosition")
                .setLastName("Family")
                .build();

        Employee employee = builder.setPhone("555-1234")
                .setLastName("Dow")
                .build();
        Assertions.assertEquals(Employee.class, employee.getClass());
        Assertions.assertEquals(Employee.class, employeeTwoFields.getClass());
        Assertions.assertEquals(Employee.class, employeeThreeFields.getClass());
    }

}