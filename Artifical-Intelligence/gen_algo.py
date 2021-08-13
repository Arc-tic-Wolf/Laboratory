import random
import numpy as np

def fitness(pops,q): 
    f=[]
    for temp in pops:
        max_fit=(q*(q-1))/2
        mat=np.zeros(shape=(len(temp),len(temp)))
        x=[]
        y=[]
        for i in range(len(temp)): 
            num=temp[i]
            mat[len(temp)-num-1][i]=1
            x.append(len(temp)-num)
            y.append(i)
        #attacking pairs
        horizontal=0
        for i in range(len(temp)):   
            row=np.sum(mat[i],dtype=int)
            pair=(row*(row-1))/2
            horizontal+=pair
        diagonal=0
        for i in range(len(x)):
            attack=0         
            slicedX=x[i+1:]
            slicedY=y[i+1:]
            for j in range(len(slicedX)):
                if(abs(x[i]-slicedX[j]) == abs(y[i]-slicedY[j])):
                    attack= attack+1
            diagonal=diagonal+attack
        sum= diagonal + horizontal
        fit=max_fit-sum
        # print(mat)
        f.append(fit)
    return f

def selection(pop, popnFit):
    probability = []
    for i in range(len(popnFit)):
        probability.append((popnFit[i] / sum(popnFit)))   
    a=[0 for i in range(len(population))]
    for i in range(len(population)):
        a[i]=i
    size=1
    return pop[np.random.choice(a,size,True,probability)[0]]

def crossover(x,y):
    point=np.random.randint(0,queens,dtype=int)
    first=x[point:]
    second=y[:point]
    return first+second

def mutation(ch):
    id=np.random.randint(0,queens)
    pos=np.random.randint(0,queens)
    ch[id]=pos
    return ch

def genetic(pop,q,mut_tr=0.3):
    max_fit=(q*(q-1))/2
    generation=0
    while True:
        generation+=1
        new_pop = []
        total=fitness(pop,q)
        if generation%1000==0:
            print("Gen {} MaxFit {}".format(generation,max(total)))
        if generation==25000 or max(total)==max_fit :
            return (pop,total,generation)
        for i in range(len(pop)):
            x=selection(pop,total)
            y=selection(pop,total)
            child=crossover(x,y)
            if(np.random.random()< mut_tr):
                child=mutation(child)
            new_pop.append(child)
        pop=new_pop


queens = 8
size=10
population = [[random.randint(1,queens) for i in range(queens)] for i in range(size)]
popu,fitu,genu=genetic(population,queens)
print("Child {}\nMaximum Fitness {}, Generation {}".format(popu[fitu.index(max(fitu))],max(fitu),genu))




