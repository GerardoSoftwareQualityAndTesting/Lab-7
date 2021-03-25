package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class GoodbyeRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenARequest_whenEmptyName_thenGoodbye() throws Exception {
		this.mockMvc.perform(get("/goodbye"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, see you later!")));
	}
	
	@Test
	public void givenARequest_whenProvidedName_thenGoodbyeName() throws Exception {
		this.mockMvc.perform(get("/goodbye?name=Cersei"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, Cersei!")));
	}
}
