def cb_t(ni,t,te,tl):
    if ni>=0:
        print("PL",end=" ")
        if t<tl:
            tl=t
    else:
        print("PE",end=" ")
        if t>te:
            te=t
    return te,tl

def cb_left(d1,x1,xmin):
    ni=-1*d1
    t=float(-(x1-xmin)/d1)
    return t,ni

def cb_right(d1,x1,xmax):
    ni=1*d1
    t=float(-(x1-xmax)/d1)
    return t,ni

def cb_bottom(d2,y1,ymin):
    ni=-1*d2
    t=float(-(y1-ymin)/d2)
    return t,ni

def cb_top(d2,y1,ymax):
    ni=1*d2
    t=float(-(y1-ymax)/d2)
    return t,ni

def cyrus_beck(x1,y1,x2,y2):
    print("Cyrus Beck")
    print("t  ni  P  te  tl")
    te=0
    tl=1
    d1=x2-x1
    d2=y2-y1
    t,ni=cb_left(d1,x1,xmin)
    print(t,ni,end=" ")
    te,tl=cb_t(ni,t,te,tl)
    print(te,tl)
    t,ni=cb_right(d1,x1,xmax)
    print(t,ni,end=" ")
    te,tl=cb_t(ni,t,te,tl)
    print(te,tl)
    t,ni=cb_bottom(d2,y1,ymin)
    print(t,ni,end=" ")
    te,tl=cb_t(ni,t,te,tl)
    print(te,tl)
    t,ni=cb_top(d2,y1,ymax)
    print(t,ni,end=" ")
    te,tl=cb_t(ni,t,te,tl)
    print(te,tl)
    if te>tl:
        print("outside clip window")
    else :
        p1x=x1+te*d1
        p1y=y1+te*d2
        p2x=x1+tl*d1
        p2y=y1+tl*d2
        print("True clip intersections are ({},{}),({},{})".format(p1x,p1y,p2x,p2y))
        
        
if __name__ == '__main__':
    f=open("clipping.txt")
    n=int(f.readline())
    for i in range(n):
        a=f.readline().split(" ")
        xmin,ymin,xmax,ymax=int(a[0]),int(a[1]),int(a[2]),int(a[3])
        print(xmin,ymin,xmax,ymax)
        m=int(f.readline())
        for j in range(m):
            b=f.readline().split(" ")
            x1,y1,x2,y2=int(b[0]),int(b[1]),int(b[2]),int(b[3])
            print(x1,y1,x2,y2)
            m=(y2-y1)/(x2-x1)
            print(m)
            cyrus_beck(x1,y1,x2,y2)