def convertToZero(x,y,z):
    if z==0:
        return x,y
    elif z==1:
        return y,x
    elif z==2:
        return y,-x
    elif z==3:
        return -x,y
    elif z==4:
        return -x,-y
    elif z==5:
        return -y,-x
    elif z==6:
        return -y,x
    elif z==7:
        return x,-y

def convertFromZero(x,y,z):
    if z==0:
        return x,y
    elif z==1:
        return y,x
    elif z==2:
        return -y,x
    elif z==3:
        return -x,y
    elif z==4:
        return -x,-y
    elif z==5:
        return -y,-x
    elif z==6:
        return y,-x
    elif z==7:
        return x,-y
    
    
def zonefinder(X1,Y1,X2,Y2):
    dx=X2-X1
    dy=Y2-Y1
    if(abs(dx)>abs(dy)):
        if(dx>0 and dy>0):
            return 0
        elif(dx<0 and dy>0):
            return 3
        elif(dx<0 and dy<0):
            return 4
        elif(dx>0 and dy<0):
            return 7
    else:
        if(dx>0 and dy>0):
            return 1
        elif(dx<0 and dy>0):
            return 2
        elif(dx<0 and dy<0):
            return 5
        elif(dx>0 and dy<0):
            return 6


def midPoint(X1,Y1,X2,Y2):
    dx = X2 - X1
    dy = Y2 - Y1
    d = 2*dy - dx
    x = X1
    y = Y1
    X=[]
    Y=[]
    print("d x y\n")
    X.append(x)
    Y.append(y)
    print(d,x,y,"\n")
    while (x <= X2):
        x=x+1
        # E or East is chosen
        if(d < 0):
            d = d + 2*dy
 
        # NE or North East is chosen
        else:
            d = d + 2*(dy - dx)
            y=y+1
        X.append(x)
        Y.append(y)
        print(d,x,y,"\n")
    return X,Y

if __name__=='__main__':
    X1 = -10
    Y1 = -20
    X2 = -20
    Y2 = 70
    z=zonefinder(X1, Y1, X2, Y2)
    X_1,Y_1=convertToZero(X1, Y1, z)
    X_2,Y_2=convertToZero(X2, Y2, z)
    X,Y=midPoint(X_1, Y_1, X_2, Y_2)
    print("Return to Original ZONE")
    for i in range (0,len(X)):
        x_3,y_3=convertFromZero(X[i], Y[i], z)
        print(x_3,y_3)
    print("total points "+ str(len(X)))
