class MovieRentingSystem{

    class Movie{

        int shopId;
        int movieId;
        int price;

        Movie(int shopId, int movieId, int price){
            this.shopId = shopId;
            this.movieId = movieId;
            this.price = price;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || this.getClass() != o.getClass()) return false;

            Movie other = (Movie) o;

            return shopId == other.shopId &&
                movieId == other.movieId &&
                price == other.price;
        }

        @Override
        public int hashCode(){
            return Objects.hash(shopId, movieId, price);
        }
    }

    // movie, <>
    Map<Integer, Map<Integer, Integer>> movieMap;
    Map<Integer, TreeSet<Movie>> searchMap;
    TreeSet<Movie> rentedMovies;
    public MovieRentingSystem(int n, int[][] entries) {
        searchMap = new HashMap<>();
        movieMap = new HashMap<>();
        rentedMovies = new TreeSet<Movie>((a, b) -> {
            if(a.price == b.price){
                if(a.shopId == b.shopId){
                    return a.movieId - b.movieId;
                }

                return a.shopId - b.shopId;
            }

            return a.price - b.price;
        });

        for(int[] e: entries){
            if(searchMap.get(e[1]) == null){
                searchMap.put(e[1], new TreeSet<Movie>((a, b) -> a.price == b.price ? a.shopId - b.shopId : a.price - b.price));
            }

            if(movieMap.get(e[1]) == null){
                movieMap.put(e[1], new HashMap<>());
            }

            searchMap.get(e[1]).add(new Movie(e[0], e[1], e[2]));
            movieMap.get(e[1]).put(e[0], e[2]);
        }
    }
    
    public List<Integer> search(int movie) {
        TreeSet<Movie> movs = searchMap.get(movie);
        List<Integer> list = new ArrayList<>();

        if(movs == null || movs.size() == 0){
            return list;
        }

        Iterator<Movie> itr = movs.iterator();
        while(itr.hasNext()){
            Movie mov = itr.next();
            list.add(mov.shopId);
            if(list.size() == 5){
                break;
            }
        }

        return list;
    }
    
    public void rent(int shop, int movie) {
        int price = movieMap.get(movie).get(shop);

        searchMap.get(movie).remove(new Movie(shop, movie, price));

        rentedMovies.add(new Movie(shop, movie, price));
    }
    
    public void drop(int shop, int movie) {
        int price = movieMap.get(movie).get(shop);

        searchMap.get(movie).add(new Movie(shop, movie, price));

        rentedMovies.remove(new Movie(shop, movie, price));
    }
    
    public List<List<Integer>> report() {
        
        Iterator<Movie> itr = rentedMovies.iterator();
        List<List<Integer>> list = new ArrayList<>();

        while(itr.hasNext()){
            Movie mov = itr.next();
            ArrayList<Integer> l = new ArrayList<>();
            l.add(mov.shopId);
            l.add(mov.movieId);

            list.add(l);
            if(list.size() == 5){
                break;
            }
        }

        return list;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */