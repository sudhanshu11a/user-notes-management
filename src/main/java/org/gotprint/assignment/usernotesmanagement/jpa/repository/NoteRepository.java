/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.jpa.repository;

import java.util.List;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Note Repository
 * 
 * @author sudhanshusharma
 *
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUserId(long userId);

	Note findByIdAndUserId(long id, long userId);

	@Modifying
	@Query("update Note n set n.title = ?1, n.note = ?2 where n.id = ?3 and n.userId = ?4")
	int updateNote(String title, String note, long id, long userId);

	@Modifying
	@Query("delete Note n where n.id = ?1 and n.userId = ?2")
	int deleteByIdAndUserId(long id, long userId);
}
