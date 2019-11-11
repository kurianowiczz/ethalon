package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Journal;

import java.util.List;
import java.util.Optional;

public interface JournalService {
    List<Journal> getAll();
    Journal update(Journal journal);
    void delete(Long id);
    Journal getByUserId(Long userId);
    Journal getById(Long id);

}
