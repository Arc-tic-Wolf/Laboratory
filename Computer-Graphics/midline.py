def convertToZero(x,y,z):
    if z==0:
        return x,y
    elif z==1:
        return y,x
    elif z==2:
        return y,-x
    elif z==3:
        return -x,y

def convertFromZero(x,y,z):
    if z==0:
        return x,y
    elif z==1:
        return y,x
    elif z==2:
        return -y,x
    elif z==3:
        return -x,y

def midPoint(X1,Y1,X2,Y2):
    dx = X2 - X1
    dy = Y2 - Y1
 
    d = dy - (dx/2)
    x = X1
    y = Y1

    print("d x y\n")

    while (x < X2):
        x=x+1
        # E or East is chosen
        if(d < 0):
            d = d + dy
            print("E",end=" ")
 
        # NE or North East is chosen
        else:
            d = d + (dy - dx)
            y=y+1
            print("NE",end=" ")
 
        print(d,x,y,"\n")

if __name__=='__main__':
    X1 = 22
    Y1 = 97
    X2 = 48
    Y2 = 210
    midPoint(X1, Y1, X2, Y2)