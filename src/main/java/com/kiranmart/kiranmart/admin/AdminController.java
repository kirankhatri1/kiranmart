package com.kiranmart.kiranmart.admin;

import com.kiranmart.kiranmart.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("admin")
@Controller
public interface AdminController {

    @GetMapping(value = "find-all-by-status")
    ResponseEntity<Response> findAllByStatus();
}
