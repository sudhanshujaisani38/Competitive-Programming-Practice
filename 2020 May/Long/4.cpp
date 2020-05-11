#include <iostream>
#include <math.h>
#include <string>
using namespace std;
#define ull unsigned long long int

string toBinary(ull z)
{
    string str = "";
    if (z == 0)
    {
        return "0";
    }
    while (z > 0)
    {
        str = "" + (z & 1) + str;
        z = z >> 1;
    }
    return str;
}

ull getNoOfBits(ull num)
{
    ull ans = 0;
    while (num != 0)
    {
        ans++;
        num = num >> 1;
    }
    return ans;
}

ull func(ull x, ull y, ull z)
{
    return ((x & z) * (y & z));
}

void printAns(ull l, ull r, ull z)
{
    cout << "x=" << toBinary(l) << "\n";
    cout << "y=" << toBinary(r) << "\n";
    cout << "z=" << toBinary(z) << "\n";
}
ull solveBruteForce(ull x, ull y, ull l, ull r)
{
    ull maxAns = 0;
    ull num = l;
    for (ull z = l; z <= r; z++)
    {
        ull currAns = func(x, y, z);
        if (currAns > maxAns)
        {
            maxAns = currAns;
            num = z;
        }
    }
    printAns(x, y, num);
    return num;
}
ull getHighestSetBit(ull num)
{
    if (num == 0)
    {
        return 0;
    }
    int msb = 0;
    while (num != 0)
    {
        num = num >> 1;
        msb++;
    }
    return (1 << (msb - 1));
}

ull unsetBit(ull num, ull mask)
{
    return num & (~mask);
}
int main()
{
    int testCases;
    cin >> testCases;
    while (testCases-- > 0)
    {
        ull x, y, l, r;
        cin >> x >> y >> l >> r;

        ull mini = min(x, y);
        ull maxi = max(x, y);
        ull finalAns = 0;
        bool firstSet = false;
        bool secondSet = false;
        for (ull i = getNoOfBits(mini); i >= 0; i--)
        {
            ull one = 1l;
            ull mask = (one << i) & mini;
            // System.out.println("trying to set:" + (1 << i));
            if ((mask > 0) && ((mask | finalAns) <= r))
            {
                finalAns = finalAns | mask;
                firstSet = true;
                break;
            }
            else
            {
                // System.out.println("cannot set:" + (one << i)+"mask:"+i+" res:"+(mask|finalAns));
            }
            if (i == 0)
            {
                break;
            }
        }

        // System.out.println("1 bit set from" + min + ":" + finalAns);
        // System.out.println("got bits of:" + min + "=" + finalAns);
        for (ull i = getNoOfBits(maxi); i >=0; i--)
        {
            ull one = 1l;
            ull mask = (one << i) & maxi;
            // System.out.println("trying to set:" + (1 << i));
            if ((mask > 0) && ((mask | finalAns) <= r))
            {
                finalAns = finalAns | mask;
                secondSet = true;
                break;
            }
            else
            {
                // System.out.println("cannot set:" + (one << i)+"mask:"+i+" res:"+(mask|finalAns));
            }
            if (i == 0)
            {
                break;
            }
        }

        // System.out.println("1 bit set from" + max + ":" + finalAns);
        if (firstSet && secondSet)
        {

            ull oro = mini | maxi;
            long noOfBits = getNoOfBits(oro);
            // cout<<"no of bits in or:"<<noOfBits<<endl;
            for (ull i = noOfBits; i >= 0; i--)
            {
                // if(i>34){break;}
                // cout<<"got the ip:"<<i<<endl;
                ull one = 1;
                ull mask = (one << i) & oro;
                // cout<<"i="<<i<<endl;
                // System.out.println("trying to set:" + (1 << i));
                if ((mask > 0) && ((mask | finalAns) <= r))
                {
                    finalAns = finalAns | mask;
                    // break;
                }
                else
                {
                    // cout<<"cannot set:" + (one << i)+"mask:"+i+" res:"+(mask|finalAns));
                }
                if (i == 0)
                {
                    break;
                }
            }

            // System.out.println(finalAns);
            cout << finalAns << "\n";
        }
        else
        {
            // System.out.println("one of the bits were empty");
            finalAns = 0;
            cout << 0 << "\n";
            // System.out.println(0);
        }
        // ull bruteForceAns=solveBruteForce(x,y,l,r);

        // cout<<"f="<<toBinary(finalAns)<<endl;;
        // if(bruteForceAns!=finalAns){
        //     cout<<"----brute force:"<<bruteForceAns<<",finalAns:"<<finalAns<<"----";
        //     cout<<"for f:"<<func(x,y,finalAns);
        //     cout<<"for b:"<<func(x,y,bruteForceAns);
        // }else{
        //     cout<<bruteForceAns<<"="<<finalAns;
        // }
    }
    return 0;
}
