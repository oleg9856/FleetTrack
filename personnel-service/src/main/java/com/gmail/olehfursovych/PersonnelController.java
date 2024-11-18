package com.gmail.olehfursovych;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/personnel")
public record PersonnelController(PersonnelService personnelService) {

    @PostMapping()
    public void registerPersonnel(@RequestBody PersonnelRegistrationRequest personnelRequest) {
        log.info("new person registration: {}", personnelRequest);
        personnelService.registerPersonnel(personnelRequest);
    }
}
