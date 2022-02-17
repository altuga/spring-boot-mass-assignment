package jug.istanbul.demo.controller;

import jug.istanbul.demo.model.User;
import jug.istanbul.demo.utility.CheckInputUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
import java.util.zip.CheckedInputStream;

@RestController
public class HelloController {

	@GetMapping("/")
	public String getIndex() {
		return "Greetings from Spring Boot!";
	}

    @PostMapping("/post")
    public ResponseEntity<String> setIndex(@RequestBody User user) {

        Logger.getGlobal().info("information" + user);

        return new ResponseEntity<String>(String.valueOf(user), HttpStatus.CREATED);
    }

}