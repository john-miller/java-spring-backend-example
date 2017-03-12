package io.ess.example.recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Holds all the important business logic for recipe suggestion
 *
 * Created On Mar 11, 2017
 * @author Jonathan Miller
 */
@Service
public class RecipeServiceImpl implements RecipeService {
	
	private Collection<Recipe> allRecipes = Arrays.asList(
			new Recipe("Pizza", "Dough", "Sauce", "Cheese"),
			new Recipe("Pepperoni Pizza", "Dough", "Sauce", "Cheese", "Pepperoni"),
			new Recipe("Calzones", "Dough", "Ham", "Cheese"),
			new Recipe("Bread", "Dough"),
			new Recipe("Cheesy Bread", "Dough", "Cheese"));

	@Override
	public List<Recipe> getPossibleRecipes(String[] ingredients) {
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		/* Add any recipe that isnt missing ingredients */
		allRecipes.forEach((recipe) -> {
			if(!recipe.isMissingIngredients(ingredients))
				recipes.add(recipe);
		}); 
		
		return recipes;
	}

}
