package io.ess.example.recipe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceImplTests {

	@Autowired
	private RecipeService recipeService;
	
	@Test
	public void injectedTest() {
		assertNotNull(recipeService);
	}
	
	@Test
	public void onePossibleRecipeTest() {
		List<?> recipes = recipeService.getPossibleRecipes(new String[] {"dough"});
		assertEquals(1, recipes.size());
	}
	
	
	
}
