package com.example.school.Schedules;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SService {
    public final ScheduleRepo scheduleRepo;

    public void saveMemo(String title, String description) {
        Schedule memo = new Schedule();
        memo.setTitle(title);
        memo.setDescription(description);
        scheduleRepo.save(memo);
    }

    public Optional<Schedule> detailOne(Long id) {
        return scheduleRepo.findById(id);
    }

    public void updateMemo(Long id, String title, String description) {
        Schedule memo = new Schedule();
        memo.setId(id);
        memo.setTitle(title);
        memo.setDescription(description);
        scheduleRepo.save(memo);
    }

    public void deleteMemo(Long id) {
        scheduleRepo.deleteById(id);
    }

    public List<String> findTitle() {
        return scheduleRepo.findAll().stream()
                .map(Schedule::getTitle)
                .collect(Collectors.toList());
    }
}
