package utils;

import com.github.javafaker.Faker;

public class FieldGenerator {

    private static final Faker faker = new Faker();

    public static String getTaskName(){
        return faker.lorem().sentence(3);
    }

    public static String getTaskDescription(){
        return faker.lorem().paragraph(2);
    }
}

