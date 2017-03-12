package io.ess.example.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.ess.example.common.ErrorMessage;

@Component
public class RecipeControllerImpl implements RecipeController {
	
	private RecipeService recipeService;
	
	@Autowired
	public RecipeControllerImpl(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public ResponseEntity<?> getAllPossibleRecipes(String[] ingredients) {
		
		if(ingredients == null || ingredients.length == 0)
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("You must specify some ingredients"), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Recipe>>(recipeService.getPossibleRecipes(ingredients), HttpStatus.OK);
	}

}
