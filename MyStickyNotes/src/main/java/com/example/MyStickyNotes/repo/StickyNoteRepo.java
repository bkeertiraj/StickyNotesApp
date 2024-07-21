package com.example.MyStickyNotes.repo;

import com.example.MyStickyNotes.model.StickyNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickyNoteRepo extends JpaRepository<StickyNote, Long> {

}
