class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """

        adj = []
        inc = []
        for el in range(0, numCourses):
            adj.append([])
            inc.append(0)

        for pre in prerequisites:
            a = pre[0];
            b = pre[1];
            inc[a]+=1
            adj[b].append(a)
        
        visited = []
        for el in range(0, numCourses):
            visited.append(0)

        for el in range(0, numCourses):
            if visited[el] == 0 and self.checkCycle(el, adj, visited):
                return []

        stack = []
        for node in range(0, numCourses):
            if inc[node] == 0:
                stack.append(node)

        ans = []
        while len(stack) > 0:
            node = stack.pop()
            ans.append(node)
            for child in adj[node]:
                inc[child]-=1

                if inc[child] == 0:
                    stack.append(child) 

        # print(ans)
        return ans

    def checkCycle(self, node, adj, visited):
        
        visited[node] = 1

        flag = False
        for child in adj[node]:
            if visited[child] == 1:
                return True
            
            if visited[child] == 0:
                visited[child] = 1
                flag = flag or self.checkCycle(child, adj, visited)
                if flag:
                    return True
        
        visited[node] = 2
        return False
        