package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Journal;
import com.netcracker.edu.backend.repository.JournalRepository;
import com.netcracker.edu.backend.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Override
    public List<Journal> getAll() {
        return (List<Journal>) journalRepository.findAll();
    }

    @Override
    public Journal update(Journal journal) {
        journalRepository.save(journal);
        return journal;

    }

    @Override
    public Journal delete(Long id) {

        journalRepository.deleteById(id);
        return null;
    }

    @Override
    public Optional<Journal> getByUserId(Long userId) {
        return journalRepository.findById(userId);
    }
}
