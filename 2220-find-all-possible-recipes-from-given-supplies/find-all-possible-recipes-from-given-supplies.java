class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<String>();
        Map<String, Boolean> canMake = new HashMap<>();
        for(String s: supplies){
            canMake.put(s, true);
        }

        Map<String, Integer> recipeToIndex = new HashMap<>();
        for(int i = 0; i < recipes.length; i++){
            recipeToIndex.put(recipes[i], i);
        }

        for(String s: supplies){
            canMake.put(s, true);
        }

        for(String rec: recipes){
            checkRecipe(rec, ingredients, new HashSet<String>(), canMake, recipeToIndex);
            if(canMake.get(rec)){
                ans.add(rec);
            }
        }

        return ans;
    }

    public void checkRecipe(
        String rec, List<List<String>> ingredients, Set<String> visited, 
        Map<String, Boolean> canMake, Map<String, Integer> recipeToIndex
    ){
        if(canMake.containsKey(rec) && canMake.get(rec)){
            return;
        }

        if(!recipeToIndex.containsKey(rec) || visited.contains(rec)){
            canMake.put(rec, false);
            return;
        }

        visited.add(rec);
        List<String> req = ingredients.get(recipeToIndex.get(rec));

        for(String ing: req){
            checkRecipe(ing, ingredients, visited, canMake, recipeToIndex);
            if(!canMake.get(ing)){
                canMake.put(rec, false);
                return;
            }
        }

        canMake.put(rec, true);
    }
}