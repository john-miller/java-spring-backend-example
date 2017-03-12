package io.ess.example.recipe;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public interface RecipeController {
	
	/**
	 * Given an array of ingredients, returns a list of all possible recipes
	 * @param ingredients
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/recipes")
	public ResponseEntity<?> getAllPossibleRecipes(@RequestParam(name="ingredients", required = false) String[] ingredients);

}
