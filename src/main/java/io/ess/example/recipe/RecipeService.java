package io.ess.example.recipe;

import java.util.List;

public interface RecipeService {
	
	/**
	 * For a given array of ingredients, returns and collection of possible recipes that can be made.
	 * 
	 * @param ingredients
	 * @return List of recipes that can be made
	 */
	public List<Recipe> getPossibleRecipes(String[] ingredients);

}
