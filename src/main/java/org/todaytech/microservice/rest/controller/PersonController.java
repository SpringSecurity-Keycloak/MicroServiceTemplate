package org.todaytech.microservice.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.todaytech.microservice.rest.model.Person;

@RestController
@Validated
public class PersonController {
    private Random ran = new Random();

    @Operation(summary = "Get person", description = "", tags={ "Person" })
    @RequestMapping(path = "/person", method = RequestMethod.POST)
    @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, content = @Content(examples = {
            @ExampleObject(value = INVALID_REQUEST, name = "invalidRequest", description = "Invalid Request"),
            @ExampleObject(value = VALID_REQUEST, name = "validRequest", description = "Valid Request") }))

    public Person person(@Valid @RequestBody Person person) {

        int nxt = ran.nextInt(10);
        if(nxt>=5)
        {
            throw new RuntimeException("Breaking logic");
        }
        return person;
    }

    @Operation(summary = "Get person by last name", description = "", tags={ "Person" })
    @RequestMapping(path = "/personByLastName", method = RequestMethod.GET)
    public List<Person> findByLastName(@RequestParam(name = "lastName", required = true)@NotNull
                                       @NotBlank
                                       @Size(max = 10)String lastName){
        List<Person> hardCoded= new ArrayList<>();
        Person person= new Person();
        person.setAge(20);
        person.setAge(20);
        person.setEmail("abc@abc.com");
        person.setEmail1("abc1@abc.com");
        person.setFirstName("Somefirstname");
        person.setLastName(lastName);
        person.setId(1);
        hardCoded.add(person);
        return hardCoded;

    }

    private static final String VALID_REQUEST = """
			{
			  "id": 0,
			  "firstName": "string",
			  "lastName": "string",
			  "email": "abc@abc.com",
			  "email1": "abc@abc.com",
			  "age": 20,
			  "creditCardNumber": "4111111111111111"
			}""";

    private static final String INVALID_REQUEST = """
			{
			  "id": 0,
			  "firstName": "string",
			  "lastName": "string",
			  "email": "abcabc.com",
			  "email1": "abcabc.com",
			  "age": 17,
			  "creditCardNumber": "411111111111111"
			}""";
}
