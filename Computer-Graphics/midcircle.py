def midCircle(x0,y0,r):
    x=0
    y=r
    d=1-r #1.25-r
    print("n X  Y  D  P  D")
    i=0
    while x<y:
        s=""
        print(i,(x+x0),(y+y0),d,end=" ")
        if d<0:
            s="E "
            d=d+2*x+3
            x=x+1
        else:
            s="SE"
            d=d+2*x-2*y+5
            x=x+1
            y=y-1
        i=i+1
        print(s,d)

midCircle(0,0,38)

