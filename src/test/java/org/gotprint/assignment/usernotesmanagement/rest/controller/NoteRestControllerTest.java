/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * @author sudhanshusharma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoteRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static long noteId;

	@Test
	public void a_get_notes_Invalid_account_Unauthorized() throws Exception {
		mockMvc.perform(get("/api/v1/secure/user/notes").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser(username = "prabhu@gotprint.com", password = "test", roles = "USER")
	public void b_create_new_note_ok_status() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/api/v1/secure/user/notes/").contentType(MediaType.APPLICATION_JSON)
						.param("note", "NewNote added").param("title", "MyNote added"))
				.andExpect(status().isOk()).andReturn();
		JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
		noteId = jsonObject.getInt("id");
	}

	@Test
	@WithMockUser(username = "prabhu@gotprint.com", password = "test", roles = "USER")
	public void c_get_note_by_id_ok_status() throws Exception {
		mockMvc.perform(get("/api/v1/secure/user/notes/" + noteId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "prabhu@gotprint.com", password = "test", roles = "USER")
	public void d_update_new_ok_status() throws Exception {
		mockMvc.perform(put("/api/v1/secure/user/notes/" + noteId).contentType(MediaType.APPLICATION_JSON)
				.param("note", "NewNote updated").param("title", "MyNote updated")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "prabhu@gotprint.com", password = "test", roles = "USER")
	public void e_delete_note_by_id_ok_status() throws Exception {
		mockMvc.perform(delete("/api/v1/secure/user/notes/" + noteId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
