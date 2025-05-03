class SnakeGame {

    int height = -1;
    int width = -1;

    LinkedList<int[]> foodQueue;
    Set<String> visited;
    LinkedList<int[]> snake = new LinkedList<>();
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        foodQueue = new LinkedList<>();
        visited = new HashSet<>();

        for(int[] f: food){
            foodQueue.addLast(f);
        }
 
        snake.addLast(new int[]{0, 0});
        visited.add(0 + "#" + 0);
    }
    
    public int move(String direction) {
        
        int[] head = snake.peekFirst();
        int[] newHead;

        if(direction.equals("R")){
            newHead = new int[]{head[0], head[1] + 1};
        }else if(direction.equals("L")){
            newHead = new int[]{head[0], head[1] - 1};
        }else if(direction.equals("U")){
            newHead = new int[]{head[0] - 1, head[1]};
        }else{
            newHead = new int[]{head[0] + 1, head[1]};
        }

        if(!foodQueue.isEmpty()){
            int[] food = foodQueue.peekFirst();
            if(food[0] != newHead[0] || food[1] != newHead[1]){
                int[] old = snake.removeLast();
                visited.remove(old[0] + "#" + old[1]);
            }else{
                foodQueue.removeFirst();
            }
        }else{
            int[] old = snake.removeLast();
            visited.remove(old[0] + "#" + old[1]);
        }

        if(newHead[0] == height || newHead[1] == width || 
            newHead[0] < 0 || newHead[1] < 0 || 
            visited.contains(newHead[0] + "#" + newHead[1])){
            return -1;
        }
        
        snake.addFirst(newHead);
        visited.add(newHead[0] + "#" + newHead[1]);

        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */