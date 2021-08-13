def bfs(src, targets, graph, nodes, edges):
   visited = [False for i in range(nodes)]
   cost = [0 for i in range(nodes)]
   stack=[src]

   while stack:
       src = stack[0]
       if src in targets:
           return [src,cost[src]] 
       else:
           visited[stack.pop(0)] = True
           for i in range(len(graph[src])):
               if visited[graph[src][i]] is False:
                   stack.append(graph[src][i])
                   visited[graph[src][i]] = True
                   cost[graph[src][i]] = cost[src] + 1


f = open("bfs3.txt")
nodes = int(f.readline())
edges = int(f.readline())
graph = [[] for i in range(nodes)]

for i in range(edges):
    u, v = map(int, f.readline().split())
    graph[v].append(u)

src = int(f.readline()) 
targets=[] 
partiNum=int(f.readline())
for i in range(partiNum):
    targets.append(int(f.readline()))
f.close

winner,steps=bfs(src, targets, graph, nodes, edges)
print("Winner is K",winner,sep='')
print("Minimum steps required is {} to go to {}".format(steps,src))
