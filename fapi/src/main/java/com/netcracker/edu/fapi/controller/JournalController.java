package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.Journal;
import com.netcracker.edu.fapi.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Journal> getAll() {
        return journalService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Journal updateJournal(@RequestBody Journal journal) {
        return journalService.update(journal);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteJournalById(@PathVariable(name = "id") long id) {
        journalService.delete(id);
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Journal> getByUserId(@PathVariable(name = "userId") long userId) {
        Journal journal = journalService.getByUserId(userId);
        return journal != null ? ResponseEntity.ok(journal) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Journal> getById(@PathVariable(name = "id") long id) {
        Journal journal = journalService.getById(id);
        return journal != null ? ResponseEntity.ok(journal) : ResponseEntity.notFound().build();
    }
}
