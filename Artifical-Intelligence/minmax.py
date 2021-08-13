inf=9999999
tree=[]
branch=0
num=0
maxi=0
mini=0

def minimaxi(state,depth,alpha,beta,flag):
    global num,maxi,mini
    if depth == 0:
        num+=1
        return tree[state]
    start=branch*state+1
    end=start+3
    if flag:
        maxi=-inf
        for leaf in range(start,end):
            val=minimaxi(leaf,depth-1,alpha,beta,False)
            if val>maxi:
                maxi=val
            if val>alpha:
                alpha=val
            if alpha>=beta:
                break
            tree[state]=alpha
        return maxi
    else:
        mini=inf
        for leaf in range(start,end):
            val=minimaxi(leaf,depth-1,alpha,beta,True)
            if val<mini:
                mini=val
            if val<beta:
                beta=val
            if alpha>=beta:
                break
            tree[state]=beta
        return mini


if __name__ == '__main__':
    f=open("minmax.txt")
    depth=int(f.readline())
    print('Number of turns for Riyad:',depth)
    depth*=2
    branch=int(f.readline())
    print("Number of branches per node:",branch)
    a=f.readline().split(" ")
    print("Range of nodes:",a[0],a[1],end="")
    b=f.readline().split(" ")
    tree=[int(i) for i in b]
    f.close
    leaves=branch**depth
    start=int(a[0])
    end=int(a[1])
    sum=1
    for i in range(1,depth+1):
        sum+=branch**i
    print("Before minimax:",tree)
    m=minimaxi(0,depth,-inf,inf,True)
    print("After minimax:",tree)
    print("Depth:",depth)
    print("Branch:",branch)
    print("Leaf nodes:",leaves)
    print("Riyad collects a maximum of {} funds".format(m))
    print("Before alpha-beta pruning, Comparisons:",leaves)
    print("After alpha-beta pruning, Comparisons:",num)


