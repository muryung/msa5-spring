package org.msa.msa5spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingController {

    @GetMapping("/users")
    public String index() {
        return "유저 조회";
    }

    @PostMapping("/users/1")
    public String store() {
        return "유저 생성";
    }
}
