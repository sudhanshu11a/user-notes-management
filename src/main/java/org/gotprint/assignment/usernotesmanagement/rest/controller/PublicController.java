/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhanshusharma
 *
 */

@RestController
@RequestMapping("api/v1/public")
public class PublicController {

	@RequestMapping("/greeting")
	public String greeting() {
		return "Hello";
	}
}
