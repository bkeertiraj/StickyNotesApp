package com.example.MyStickyNotes.service;

import com.example.MyStickyNotes.model.StickyNote;
import com.example.MyStickyNotes.repo.StickyNoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StickyNoteService {

    @Autowired
    private StickyNoteRepo repo;

    public List<StickyNote> getAllNotes() {

        return repo.findAll();
    }

    public StickyNote createNote(StickyNote note) {
        return repo.save(note);
    }

    public StickyNote updateNode(long id, StickyNote updatedNode) {

        Optional<StickyNote> existingNoteOpt = repo.findById(id);
        if(existingNoteOpt.isPresent()) {
            StickyNote existingNote = existingNoteOpt.get();
            existingNote.setHeading(updatedNode.getHeading());
            existingNote.setContent(updatedNode.getContent());
            existingNote.setCreatedDate(LocalDateTime.now()); // Update the createdDate (if desired)
            return repo.save(existingNote);
        } else {
            return null;
        }
    }

    public boolean deleteNodebyId(long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        else return false;

    }
}
