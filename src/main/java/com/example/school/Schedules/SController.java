package com.example.school.Schedules;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SController {
    public final SService service;

    @GetMapping("/timetable")
    public Object timetable(Authentication auth) {
        if (auth == null) {
            return new RedirectView("/register");
        }
        return service.findTitle();
    }

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable Long id, Authentication auth) {
        if (auth == null) {
            return new RedirectView("/register");
        }
        Optional<Schedule> result = service.detailOne(id);
        return result.orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @PostMapping("/add")
    String add(String title, String description) {
        service.saveMemo(title, description);
        return "redirect:/timetable";
    }

    @PostMapping("/edit")
    String edit(Long id, String title, String description) {
        service.updateMemo(id, title, description);
        return "redirect:/timetable";
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam Long id) {
        service.deleteMemo(id);
        return "redirect:/timetable";
    }
}