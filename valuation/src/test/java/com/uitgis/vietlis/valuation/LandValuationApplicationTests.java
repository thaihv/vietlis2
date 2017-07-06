package com.uitgis.vietlis.valuation;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.uitgis.vietlis.valuation.domain.Author;
import com.uitgis.vietlis.valuation.repository.AuthorRepository;


import org.springframework.security.test.context.support.WithMockUser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class LandValuationApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private AuthorRepository authorRepository;
	
	@Before
	public void before() throws Exception {
		authorRepository.save(new Author("Trần Anh Tuấn",   "Hà Nội",   "0911111222", "tuanta@gmail.com"));
		authorRepository.save(new Author("Albert Einstein", "Princeton","0911111333", "albert@yahoo.com"));
		authorRepository.save(new Author("Roy Fielding",      "Paris",    "0911111444", "tomy_fr@yahoo.comm"));
	}

	@Test
	@WithMockUser(username = "thaihv@gmail.com", password = "123456", roles = "ADMIN")
	public void peopleReflectedInRead() throws Exception {
		MediaType halJson = MediaType.parseMediaType("application/hal+json;charset=UTF-8");
		this.mvc.perform(get("/authors")).andExpect(status().isOk()).andExpect(content().contentType(halJson))
				.andExpect(mvcResult -> {
					String contentAsString = mvcResult.getResponse().getContentAsString();
					assertTrue(
							contentAsString.split("totalElements")[1].split(":")[1].trim().split(",")[0].equals("3"));
				});
	}

	@After
	public void after() throws Exception {
		
		authorRepository.delete(authorRepository.findByname("Trần Anh Tuấn"));
		authorRepository.delete(authorRepository.findByname("Albert Einstein"));
		authorRepository.delete(authorRepository.findByname("Roy Fielding"));
	}

}
