package io.ess.example.recipe;

public class Recipe {

	private String name;
	
	private String[] ingredients;
	
	public Recipe() {
		
	}
		
	public Recipe(String name, String... ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}

	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isMissingIngredients(String ... ingredientsOnHand) {	
		
		if(ingredients == null)
			throw new RuntimeException("Recipe needs ingredients!");
		
		for(String ingredient : ingredients) {		
			
			boolean contains = false;
			
			/* Check ingredients on hand */
			for(String ingredientOnHand : ingredientsOnHand)
				if(ingredient.equalsIgnoreCase(ingredientOnHand)) 
					contains = true;
			
			/* If this ingredient is not on hand then false */
			if(!contains)
				return true;
		}
		
		return false;
	}
		
}
