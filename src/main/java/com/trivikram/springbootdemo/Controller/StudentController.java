package com.trivikram.springbootdemo.Controller;


import com.trivikram.springbootdemo.dto.StudentRequestDTO;
import com.trivikram.springbootdemo.dto.StudentResponseDTO;
import com.trivikram.springbootdemo.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto){
        return service.createStudent(dto);
    }

    @GetMapping
    public StudentResponseDTO getOne(@PathVariable Long id){
        return service.getStudent(id);
    }

    @PutMapping
    public StudentResponseDTO update(@PathVariable Long id, @RequestBody StudentRequestDTO dto){
        return service.updateStudent(id,dto);
    }


}
