package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Journal;

import java.util.List;
import java.util.Optional;

public interface JournalService {
    List<Journal> getAll();
    Journal update(Journal journal);
    Journal delete(Long id);
    Optional<Journal> getByUserId(Long userId);

}
