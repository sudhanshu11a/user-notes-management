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

	@Query("SELECT n FROM Note n WHERE n.user.email = ?1")
	List<Note> findByUserName(String username);

	@Query("SELECT n FROM Note n WHERE n.id = ?1 AND n.user.email = ?2")
	Note findByIdAndUsername(long id, String username);

}
