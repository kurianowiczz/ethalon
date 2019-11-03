package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Journal;
import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Journal> getJournal() {
        return journalService.getAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Journal> getJournalByUserId(@PathVariable(name = "userId") Long userId){
        Optional<Journal> journal = journalService.getByUserId(userId);
        if(journal.isPresent()){
            return ResponseEntity.ok(journal.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Journal deleteJournal (@PathVariable(name = "id") Long id) {
        return journalService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Journal updateMovie(@RequestBody Journal journal) {
        return journalService.update(journal);
    }

}
