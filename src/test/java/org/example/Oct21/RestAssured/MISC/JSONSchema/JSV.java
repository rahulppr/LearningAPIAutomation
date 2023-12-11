package org.example.Oct21.RestAssured.MISC.JSONSchema;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class JSV {
    //JSON Schema Validation

    @Test
    public void JSValidation(){

        RestAssured.given().baseUri("https://jsonplaceholder.typicode.com/posts/2").given().when().get()
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/org/example/RestAssured/MISC/JSONSchema/Schema.json")));

    }
}

