/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.jpa.repository;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 * 
 * @author sudhanshusharma
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
}
