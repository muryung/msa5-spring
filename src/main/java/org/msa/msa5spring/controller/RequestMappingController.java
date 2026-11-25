package org.msa.msa5spring.controller;

import org.msa.msa5spring.request.QueryRequestDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class RequestMappingController {
    @GetMapping
    public String index() {
        return "유저 조회";
    }

    @PostMapping
    public String store() {
        return "유저 생성";
    }

    @PutMapping
    public String update() {
        return "유저 수정";
    }

    @DeleteMapping
    public String destroy() {
        return "유저 삭제";
    }

    @GetMapping("/query")
    public String query(QueryRequestDTO queryRequestDTO) {
        return String.format("%d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    @GetMapping("/segment/{id}/{name}")
    public String segment(@ModelAttribute QueryRequestDTO queryRequestDTO) {
        return String.format("segment = %d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    @PostMapping("/form")
    public String form(@ModelAttribute MultipartFile file) {
        return String.format("%s : %s", file.getContentType(), file.getOriginalFilename());
    }

    @GetMapping("/json")
    public String json(@RequestBody QueryRequestDTO queryRequestDTO) {
        return String.format("json = %d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }
}

// Query Parameter 방식
// - 어노테이션 X, DTO 객체 생성

// Segment Parameter 방식
// - @PathVariable, 각 키에 맞는 파라미터를 별도로 맵핑 메소드의 파라미터로 생성
// - @ModelAttribute, DTO 객체 생성

// Form Data 방식
// - @ModelAttribute, DTO 객체 또는 맵핑 메소드의 파라미터

// JSON 방식
// - @RequestBody, DTO 객체