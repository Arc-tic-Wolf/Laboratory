def bfs(src,dest,graph,nodes,edges):
   visited=[False for i in range(nodes)]
   cost=[0 for i in range(nodes)]
   stack=[src]

   while stack:
       src=stack[0]
       if src == dest:
           stack.pop(0)
           return cost[src]
       else:
           visited[stack.pop(0)] = True
           for i in range(len(graph[src])):
               if visited[graph[src][i]] is False:
                   stack.append(graph[src][i])
                   visited[graph[src][i]]=True
                   cost[graph[src][i]]=cost[src]+1

f = open("bfs2.txt")
nodes = int(f.readline())
edges = int(f.readline())
graph = [[] for i in range(nodes)]

for i in range(edges):
    u, v = map(int, f.readline().split())
    graph[u].append(v)
    graph[v].append(u)
target = int(f.readline())
noraSrc=int(f.readline())
laraSrc=int(f.readline())
f.close

noraSteps=bfs(noraSrc, target, graph, nodes, edges)
laraSteps=bfs(laraSrc, target, graph, nodes, edges)
print("Nora takes {} steps and Lara takes {} steps to go to {}".format(noraSteps,laraSteps,target))
if laraSteps > noraSteps:
    print("So Nora Wins")
elif laraSrc == noraSrc :
    print("It is a tie")
else:
    print("So Lara Wins")
