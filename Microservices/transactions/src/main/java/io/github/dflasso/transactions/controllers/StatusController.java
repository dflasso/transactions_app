package io.github.dflasso.transactions.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Status of Server", description = "Services to determinate if server is enable")
@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public String getStatus() {
        return "ok";
    }
}
