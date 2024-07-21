package com.example.MyStickyNotes.controller;

import com.example.MyStickyNotes.model.StickyNote;
import com.example.MyStickyNotes.service.StickyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StickyNoteController {

    private StickyNoteService service;
    @Autowired
    public StickyNoteController(StickyNoteService service) {
        this.service = service;
    }

    //read
    @GetMapping
    public List<StickyNote> getAllNotes() {
        return service.getAllNotes();
    }

    //create
    @PostMapping("/post")
    public StickyNote createNote(@RequestBody StickyNote note) {
        return service.createNote(note);
    }

    //update
    @PutMapping("/post/{id}")
    public ResponseEntity<StickyNote> updateNote(@PathVariable long id, @RequestBody StickyNote note) {
        StickyNote updatedNote = service.updateNode(id, note);
        if (updatedNote != null) {
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //delete
    @DeleteMapping("/post/{id}")
    public ResponseEntity<StickyNote> deleteNode(@PathVariable int id) {
        boolean isdeleted = service.deleteNodebyId(id);
        if(isdeleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }

}
