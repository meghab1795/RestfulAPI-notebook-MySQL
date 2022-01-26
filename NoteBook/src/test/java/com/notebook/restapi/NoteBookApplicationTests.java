package com.notebook.restapi;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.notebook.restapi.model.Notes;
import com.notebook.restapi.service.NotesService;

@SpringBootTest
class NoteBookApplicationTests {

	

		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private NotesService notesService;

		Notes notes = new Notes(4,"workout",null,"dance",new Date(),new Date());

		String exampleNotesJson = "{\"id\":\"title\",\"tags\":\"body\",\"createdTimestamps\",\"modifiedTimestamps\"}";

		@Test
		public void getAllNotes() throws Exception {

			Mockito.when(
					notesService.getAllNotes()).thenReturn((List<Notes>) notes);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/api/notes/4");

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			String expected = "{id:4,title:workout,body:dance}";

			

			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		}

	}
