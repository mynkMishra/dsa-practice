class Solution {

    class Node{
        int el;
        int op;

        Node(int el, int op){
            this.el = el;
            this.op = op;
        }
    }

    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x == y){
            return 0;
        }

        int ansx = -1;
        int ansy = -1;

        boolean[] visited = new boolean[10001];

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.op - b.op);
        pq.add(new Node(x, 0));

        while(pq.size() != 0){
            Node node = pq.poll();

            if(node.el == y){
                ansx = node.op;
                break;
            }

            if(node.el < 0 || node.el >= 10001 || visited[node.el]){
                continue;
            }

            visited[node.el] = true;

            pq.add(new Node(node.el - 1, node.op + 1));
            pq.add(new Node(node.el + 1, node.op + 1));

            if(node.el%5 == 0){
                pq.add(new Node(node.el/5, node.op + 1)); 
            }
            if(node.el%11 == 0){
                pq.add(new Node(node.el/11, node.op + 1)); 
            }
        }

        // pq.clear();

        // visited = new boolean[10001];
        // pq.add(new Node(y, 0));

        // while(pq.size() != 0){
        //     Node node = pq.poll();

        //     if(node.el == x){
        //         ansy = node.op;
        //         break;
        //     }

        //     if(node.el < 0 || visited[node.el]){
        //         continue;
        //     }

        //     visited[node.el] = true;

        //     pq.add(new Node(node.el - 1, node.op + 1));
        //     pq.add(new Node(node.el + 1, node.op + 1));

        //     if(node.el%5 == 0){
        //         pq.add(new Node(node.el/5, node.op + 1)); 
        //     }
        //     if(node.el%11 == 0){
        //         pq.add(new Node(node.el/11, node.op + 1)); 
        //     }
        // }

        // return Math.min(ansx, ansy);
        return ansx;
    }
}