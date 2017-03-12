package io.ess.example.recipe;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeControllerImplIntegrationTests {

	@Autowired
	private RecipeController recipeController;
	
	@Test(expected = AccessDeniedException.class)
	@WithAnonymousUser
	public void unAuthorizedResponseTest() {
		recipeController.getAllPossibleRecipes(new String[] {});
	}
	
	@Test
	@WithMockUser(username="john", authorities="ROLE_USER")
	public void authorizedResponseTest() {
		ResponseEntity<?> responseEntity = recipeController.getAllPossibleRecipes(new String[] {"DOUGH"});
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test(expected = AccessDeniedException.class)
	@WithMockUser(username="john", authorities="ROLE_ADMIN")
	public void unauthorizedResponseIncorrectRoleTest() {
		recipeController.getAllPossibleRecipes(new String[] {"DOUGH"});
	}
	
}
