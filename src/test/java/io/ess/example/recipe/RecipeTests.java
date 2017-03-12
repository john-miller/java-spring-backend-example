package io.ess.example.recipe;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecipeTests {

	@Test
	public void isMissingIngredientsTest() {
		Recipe recipe = new Recipe("", "dough", "pepperoni", "sauce");
		assertTrue(recipe.isMissingIngredients("dough", "pepperoni"));
	}
	
	@Test
	public void isNotMissingIngredientsTest() {
		Recipe recipe = new Recipe("", "dough", "pepperoni", "sauce");
		assertFalse(recipe.isMissingIngredients("dough", "sauce", "pepperoni"));
	}
	
}
