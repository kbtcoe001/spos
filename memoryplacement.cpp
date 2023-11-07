#include <iostream>
#include <iomanip>

using namespace std;

void print(int *processSize, int *newblock, int *allocated, int n, int m)
{
    int i;
    cout << "\n\n";
    cout << "\t\t\t" << setw(5) << "Process" << setw(15) << "Size" << setw(15) << "Block" << setw(15)
         << "Block Size\n\n";
    for (i = 0; i < n; i++)
    {
        cout << "\t\t\t" << setw(5) << i + 1 << setw(15) << processSize[i] << setw(15);
        allocated[i] != -1 ? cout << allocated[i] + 1 << setw(15) : cout << "Unallocated" << setw(15);
        allocated[i] != -1 ? cout << newblock[allocated[i]] << "\n" : cout << "Unallocated\n";
    }
    cout << " \n\n";
}

void bestfit(int *blocksize, int m, int *processSize, int n)
{
    int allocated[n], i, j, id;
    int *newblock = new int[m];
    for (i = 0; i < m; i++)
    {
        newblock[i] = blocksize[i];
    }
    for (i = 0; i < n; i++)
    {

        allocated[i] = -1;
    }
    for (i = 0; i < n; i++)
    {
        id = -1;
        for (j = 0; j < m; j++)
        {
            if (blocksize[j] >= processSize[i])
            {
                if (id == -1)
                {
                    id = j;
                }
                else if (blocksize[id] > blocksize[j])
                {
                    id = j;
                }
            }
        }
        if (id != -1)
        {
            allocated[i] = id;
            blocksize[id] -= processSize[i];
        }
    }
    print(processSize, newblock, allocated, n, m);
}

void worstfit(int *blocksize, int m, int *processSize, int n)
{
    int allocated[n], i, j, id;
    int *newblock = new int[m];
    for (i = 0; i < m; i++)
    {
        newblock[i] = blocksize[i];
    }
    for (i = 0; i < n; i++)
    {
        allocated[i] = -1;
    }
    for (i = 0; i < n; i++)
    {

        id = -1;
        for (j = 0; j < m; j++)
        {
            if (blocksize[j] >= processSize[i])
            {
                if (id == -1)
                {
                    id = j;
                }
                else if (blocksize[id] < blocksize[j])
                {
                    id = j;
                }
            }
        }
        if (id != -1)
        {
            allocated[i] = id;
            blocksize[id] -= processSize[i];
        }
    }
    print(processSize, newblock, allocated, n, m);
}

void firstfit(int *blocksize, int m, int *processSize, int n)
{
    int allocated[n], i, j;
    int *newblock = new int[m];
    for (i = 0; i < m; i++)
    {
        newblock[i] = blocksize[i];
    }
    for (i = 0; i < n; i++)
    {
        allocated[i] = -1;
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
        {
            if (blocksize[j] >= processSize[i])
            {
                allocated[i] = j;

                blocksize[j] -= processSize[i];
                break;
            }
        }
    }
    print(processSize, newblock, allocated, n, m);
}

void nextfit(int *blocksize, int m, int *processSize, int n)
{
    int allocated[n], i, j = 0, k;
    int *newblock = new int[m];
    for (i = 0; i < m; i++)
    {
        newblock[i] = blocksize[i];
    }
    for (i = 0; i < n; i++)
    {
        allocated[i] = -1;
    }
    for (i = 0; i < n; i++)
    {
        k = 0;
        while (k < m)
        {
            if (blocksize[j] >= processSize[i])
            {
                allocated[i] = j;
                blocksize[j] -= processSize[i];
                break;
            }
            k++;
            j = (j + 1) % m;
        }
    }
    print(processSize, newblock, allocated, n, m);
}

int main()
{
    cout << "\n\n-----------Memory Management Algorithms ------------\n\n\n";
    int n, m, ch, i;
    while (1)
    {
        cout << "1. First Fit";
        cout << "\n2. Worst Fit";
        cout << "\n3. Best Fit";
        cout << "\n4. Next Fit";
        cout << "\n5. Exit";
        cout << "\nEnter Choice ";
        cin >> ch;
        if (ch >= 5)
        {
            cout << "\n\n\t\t\t-----------Thankyou!!-------------\n\n\n";
            return 0;
        }
        cout << "\n\nEnter no of process ";
        cin >> n;
        int *processSize = new int[n];
        for (i = 0; i < n; i++)
        {
            cout << "\nEnter process size for process " << i + 1 << " ";
            cin >> processSize[i];
        }
        cout << "\n\nEnter no of blocks ";
        cin >> m;
        int *blocksize = new int[m];
        for (i = 0; i < m; i++)
        {
            cout << "\nEnter block size for block " << i + 1 << " ";
            cin >> blocksize[i];
        }

        switch (ch)
        {
        case 1:
            firstfit(blocksize, m, processSize, n);
            break;
        case 2:
            worstfit(blocksize, m, processSize, n);
            break;
        case 3:
            bestfit(blocksize, m, processSize, n);
            break;
        case 4:
            nextfit(blocksize, m, processSize, n);
            break;
        case 5:
            cout << "\n\n\t\t\t-----------Thankyou!!-------------\n\n\n";
            return 0;
        default:
            cout << "\n\nEnter valid choice\n";
            break;
        }
    }

    return 0;
}