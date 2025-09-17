class FoodRatings {

    class Rating implements Comparable<Rating>{
        String food;
        int rating;

        public Rating(String f, int r){
            this.food = f;
            this.rating = r;
        }

        public int compareTo(Rating r){
            if(this.rating == r.rating){
                return this.food.compareTo(r.food);
            }
            return r.rating - this.rating;
        }
    }

    Map<String, String> foodCuisine = new HashMap<String, String>();
    Map<String, PriorityQueue<Rating>> hm = new HashMap<>();
    Map<String, Integer> foodRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);

            if(hm.get(cuisines[i]) == null){
                PriorityQueue<Rating> ts = new PriorityQueue<>();
                ts.add(new Rating(foods[i], ratings[i]));
                hm.put(cuisines[i], ts);
            }else{
                hm.get(cuisines[i]).add(new Rating(foods[i], ratings[i]));
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);

        String cus = foodCuisine.get(food);
        hm.get(cus).add(new Rating(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        Rating rating = hm.get(cuisine).peek();

        while(rating.rating != foodRating.get(rating.food)){
            hm.get(cuisine).poll();

            rating = hm.get(cuisine).peek();
        }

        return rating.food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */