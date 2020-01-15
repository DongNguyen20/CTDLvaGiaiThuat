#include<stdio.h>
#include <conio.h>
#include<iostream> 
#include <windows.h>
#include <stdlib.h>
#include <time.h>
using namespace std;

void xuat(int a[], int n)
{
	cout<<"Xuat mang : ";
	for(int i=0;i<n;i++)
		cout<<a[i]<<"\t";
}
void xuatlr(int a[], int l,int r)
{
	cout<<"Xuat mang : ";
	for(int i=l;i<=r;i++)
		cout<<a[i]<<"\t";
}
void swap(int &a,int &b)
{
	int t=a;
	a=b;
	b=t;
}
void interchangesort(int a[], int n)
{
	for(int i=0;i<n-1;i++)
		for(int j=i+1;j<n;j++)
			if(a[i]>a[j])
			{
				swap(a[i],a[j]);
				cout<<"\nTai i="<<i<<",j="<<j<<" mang thay doi : "<<endl;
				xuat(a,n);
			}
}

void SelectionSort(int a[],int n)
{
	int min,i,j; 
	for (i=0; i<n-1 ; i++) 
	{
		min = i;
		for(j = i+1; j < n ; j++)
			if (a[j ] < a[min]) 
				min = j; 
		swap(a[min],a[i]);
		cout<<"\nTim duoc vi tri min="<<min<<" mang thay doi : "<<endl;
		xuat(a,n);
	}
}
void BubbleSort(int a[],int n)
{
	int i, j;
	for (i = 0 ; i<n-1 ; i++)
		for (j =n-1; j >i ; j --)
			if(a[j]< a[j-1])
			{
				swap(a[j], a[j-1]); 
				cout<<"\nTai j="<<j<<",j-1="<<j-1<<" mang thay doi : "<<endl;
				xuat(a,n);
			}
}
void InsertionSort(int a[],int n)
{
    int pos,key;
    for(int i=1;i<n;i++)
    {
        key = a[i];
        pos = i - 1;
        while((pos >= 0) && (a[pos] > key))
        {
            a[pos + 1] = a[pos];
			cout<<"\nKet qua mang doi cho : "<<endl;
			xuat(a,n);
            pos--;
        }
        a[pos+1] = key;
		cout<<"\nKet qua mang chen phan tu key = "<<key<<" l� : "<<endl;
		xuat(a,n);
    }
}
void  BInsertionSort(int a[],int n )
{ 
    int l,r,m,i;  
    int x;  
    for(int i=1 ; i<n ; i++) 
    { 
        x = a[i]; l = 0;
        r = i-1;  
        while(l<=r) 
        { 
            m = (l+r)/2;             
            if(x < a[m]) r = m-1;  
            else l = m+1;   
        }   
        for(int j = i-1 ; j >=l ; j--)   
		{
			a[j+1] = a[j]; 			
			cout<<"\nKet qua mang doi cho : "<<endl;
			xuat(a,n);
		}
        a[l] = x;  
		cout<<"\nKet qua mang chen phan tu key = "<<x<<" l� : "<<endl;
		xuat(a,n);  
    }
}
void ShakerSort(int a[], int n)
{
    int i, j, left, right, k;
    left = 0;
    right = n - 1;
    k = n - 1;
    while( left < right )
    {
        for ( i = right; i > left; i--)
        {
            if ( a[i] < a [i - 1] )
            {
                swap(a[i], a[i -1]);
                k = i;
            }
        }
        left = k;
		cout<<"\nSap xep doan tu right = "<<right<<" den left = "<<left<<" l� : "<<endl;
		xuat(a,n);
        
        for ( j = left; j < right; j++)
        {
            if ( a[j] > a[j + 1] )
            {
                swap(a[j], a[j + 1]);
                k = j;
            }
        }
        right = k;
		cout<<"\nSap xep doan tu left = "<<left<<" den right = "<<right<<" l� : "<<endl;
		xuat(a,n);
    }
}
void shift(int a[],int l,int r)
{
    int x,i,j;
    i=l;
    j=2*i+1;
    x=a[i];
    while(j<=r)
    { 
        if(j<r)
            if(a[j]<a[j+1])  
                j++;  
        if(a[j]<=x) return;
        else
        { 
            a[i]=a[j];
            a[j]=x;
            i=j;
            j=2*i+1;
            x=a[i];
        }
    }
}
void CreateHeap(int a[],int n)
{ 
    int l;
    l=n/2-1;
    while(l>=0)
    {
        shift(a,l,n-1);
        l=l-1;
    }
}
void HeapSort(int a[],int n)
{ 
    int r;
    CreateHeap(a,n);
	cout<<"\nHieu chinh day ban dau thanh Heap : "<<endl;
	xuat(a,n);
	cout<<"\n-----------------------\n";
    r=n-1;
    while(r>0)
    {
        swap(a[0],a[r]); 		
		cout<<"\nSX day so dua tren Heap : "<<endl;
		xuat(a,n);
		cout<<"\n-----------------------\n";
        r--;
        if(r>0)
			shift(a,0,r);
    }
}

void QuickSort(int a[], int left,  int right)
{ 
	int i, j, x;
	x = a[(left+right)/2];
	i = left; j = right;
	while(i < j)
	{
		while(a[i] < x) i++;
		while(a[j] > x) j--;
		if(i <= j)
		{ 
			swap(a[i],a[j]);
			i++ ; 
			j--;
		}
	}

	cout<<"\nKet qua phan hoach trong khoang left="<<left<<" , right="<<right<<" : "<<endl;
	xuatlr(a,left,right);
	cout<<"\n-----------------------\n";

	if(left<j)
	QuickSort(a, left, j);

	if(i<right)
	QuickSort(a, i, right);
}
void RadixSort(int a[],int n)
{
	int i,b[100],m=0,exp=1;
	for(i=0;i<n;i++)
	{
		if(a[i]>m)
		m=a[i];
	}

	while(m/exp>0)
	{
		int bucket[10]={0};
		for(i=0;i<n;i++)
			bucket[a[i]/exp%10]++;
		for(i=1;i<10;i++)
			bucket[i]+=bucket[i-1];
		for(i=n-1;i>=0;i--)
			b[--bucket[a[i]/exp%10]]=a[i];
		for(i=0;i<n;i++)
			a[i]=b[i];
		exp*=10; 
		cout<<"\n-----------"<<endl;
		xuat(a,n);
	}    
}
void Merge (int a[], int l, int m, int r)
{
    int i, length;
    int l_end = m - 1;
    i = l;
    length = r - l;
     
    int temp[100];
      
    while(l <= l_end && m <= r) {
        if (a[l] <= a[m]) {
            temp[i++] = a[l++];
        } else {
            temp[i++] = a[m++];
        }
    }
      
    while(l <= l_end) {
        temp[i++] = a[l++];
    }
      
    while(m <= r) {
        temp[i++] = a[m++];
    }
     
    for (i = 0; i <= length; i++, r--) {
        a[r] = temp[r];
    }
}
  
void MergeSort(int a[], int l, int r) 
{    
    int m;
    if(l < r) {
        m = (l + r) / 2;

		cout<<"\nPP trong khoang left="<<l<<" , right="<<r<<" ,mid="<<m<<" : "<<endl;
		xuatlr(a,l,r);
		cout<<"\n-----------------------\n";

        MergeSort(a, l, m);
        MergeSort(a, m + 1, r);
        Merge(a, l, m + 1, r);
		
		cout<<"\nSX trong khoang left="<<l<<" , right="<<r<<" ,mid="<<m<<" : "<<endl;
		xuatlr(a,l,r);
		cout<<"\n-----------------------\n";
    } 
}
void Random(int a[],int n)
{
	n=10;
	srand(time(NULL));
	for(int i=0;i<n;i++)
	{
		a[i]=rand()%100;
	}
	cout<<"Mang ban dau : "<<endl;
	for(int i=0;i<n;i++)
		cout<<a[i]<<"\t";
	
}

void main()
{
	int a[8]={12,2,8,5,1,6,4,15},n=8;
	int op;
	do
	{
		system("cls"); 
		cout<<"1.  Interchangesort"<<endl;
		cout<<"2.  SelectionSort"<<endl;
		cout<<"3.  BubbleSort"<<endl;
		cout<<"4.  InsertionSort"<<endl;
		cout<<"5.  BInsertionSort"<<endl;
		cout<<"6.  ShakerSort"<<endl;
		cout<<"7.  HeapSort"<<endl;
		cout<<"8.  QuickSort"<<endl;
		cout<<"9.  MergeSort"<<endl;
		cout<<"10. RadixSort"<<endl;
		cout<<"Ban lua chon chuc nang : ";
		cin>>op;
		switch(op)
		{
			case 1:Random(a,n);interchangesort(a,n);break;
			case 2:Random(a,n);SelectionSort(a,n);break;
			case 3:Random(a,n);BubbleSort(a,n);break;
			case 4:Random(a,n);InsertionSort(a,n);break;
			case 5:Random(a,n);BInsertionSort(a,n);break;
			case 6:Random(a,n);ShakerSort(a,n);break;
			case 7:Random(a,n);HeapSort(a,n);break;
			case 8:Random(a,n);QuickSort(a,0,n-1);break;
			case 9:Random(a,n);MergeSort(a,0,n-1);break;
			case 10:Random(a,n);RadixSort(a,n);break;
			default:cout<<"Nhap sai - Nhap lai"<<endl;break;
		}
		getch();
	}while(op!=0);

	//interchangesort(a,n);
	//SelectionSort(a,n);
	//BubbleSort(a,n);
	//InsertionSort(a,n);
	//BInsertionSort(a,n);
	//ShakerSort(a,n);
	//HeapSort(a,n);
	//QuickSort(a,0,n-1);
	//MergeSort(a,0,n-1);
	//int a[12]={7013,8425,1239,428,1424,7009,4528,3252,9170,999,1725,701},n=12;
	//RadixSort(a,n);
	getch();
}
