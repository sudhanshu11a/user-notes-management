/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.jpa.repository;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Note Repository 
 * 
 * @author sudhanshusharma
 *
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
