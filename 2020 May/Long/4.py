def getNoOfBits(num):
    ans=0
    while(num!=0):
        ans+=1
        num=num>>1
    return ans

def func(x,y,z):
    # print((x&z)," x ",(y&z))
    return (x&z)*(y&z)

def bruteForce(x,y,l,r):
    # print("getting brute force ans")
    maxAns=0
    num=l
    for z in range(l,r+1):
        currAns=func(x,y,z)
        if(currAns>maxAns):
            maxAns=currAns
            num=z
    return num
            
t=int(input())
for test in range(t):
    x,y,l,r=input().split()
    x=int(x)
    y=int(y)
    l=int(l)
    r=int(r)
    # x=int(input())
    # y=int(input())
    # l=int(input())
    # r=int(input())
    nn=getNoOfBits(r);
    # print("masking with",(1<<nn)-1)
    
    x=x&((1<<nn)-1)
    y=y&((1<<nn)-1)
    # print("x=",x,"y=",y)
    mini=min(x,y)
    maxi=max(x,y)
    # print("min",mini," max",maxi)
    finalAns=0
    firstSet=False
    secondSet=False  
    anda=mini&maxi
    
    
    priority={}
    pList=[]
    for i in range(getNoOfBits(maxi),-1,-1):
        andmask=(1<<i)&anda
        minmask=(1<<i)&mini
        maxmask=(1<<i)&maxi
        if(andmask>0):
            priority[2*andmask+1]=(1<<i);
            pList.append(2*andmask+1)
            # print("priority of:",andmask,":",(2*andmask+1))
        elif(minmask>0):
            priority[minmask]=(1<<i);
            pList.append(minmask)
        elif(maxmask>0):
            priority[maxmask]=(1<<i);
            pList.append(maxmask)
    pList.sort(reverse=True)
    print(pList)
    print(priority)
    for p in pList:
        one=1;
        mask=mini&priority[p]
        # print("trying to set:",one<<i)  
        if(mask>0 and (mask|finalAns)<=r):
            finalAns=finalAns|mask
            firstSet=True
            print("set:",priority[p],"for first")
            break
    for p in pList:
        one=1;
        mask=maxi&priority[p]  
        # print("trying to set:",one<<i)
        if(mask>0 and (mask|finalAns)<=r):
            finalAns=finalAns|mask
            secondSet=True
            print("set:",priority[p],"for second")
            break
    if(firstSet and secondSet):
        
        oro=mini|maxi
        # for i in range(getNoOfBits(oro),-1,-1):
        #     one=1;
        #     mask=(one<<i)&oro;  
        #     if(mask>0 and (mask|finalAns)<=r):
        #         finalAns=finalAns|mask
        for index in range(len(pList)):
            pririty=pList[index]
            pMask=priority[pririty]
            if((pririty&1)==1):
                print("odd priority for",pMask,"checking sp case")
                if(pririty-1 in pList):
                    print("there is an element with priority:",pririty-1)
                    fir=finalAns&x
                    secc=finalAns&y
                    min2=min(fir,secc)
                    if((abs(fir-secc)>priority[pririty-1]) and (min2&priority[pririty-1]>0)):
                        print("special case!(",fir,",",secc,")")
                        p1Mask=priority[pririty-1]
                        if((p1Mask|finalAns)<=r):
                            print("success")
                            finalAns=finalAns|p1Mask
            
            if((pMask|finalAns)<=r):
                finalAns=finalAns|pMask
        print(finalAns)
        if(bruteForce(x,y,l,r)!=finalAns):
            print("wrong answer!!")
        print("brute force ans:",bruteForce(x,y,l,r)) 
        print("for finalAns:",func(x,y,finalAns))
        print("for bruteForce ans:",func(x,y,bruteForce(x,y,l,r)))
        
    else:
        # print("one of them is zero")
        print(0)   
