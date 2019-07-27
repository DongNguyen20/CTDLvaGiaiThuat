#include<iostream>
#include"ThuatToanSapXep.h"
using namespace std;

void Nhap(int a[], int n)
{
	cout << "Nhap mang :\n";
	for (int i = 0; i < n; i++)
		cin >> a[i];
}


int TimKiemTT(int a[], int k)
{
	for (int i = 0; i < sizeof(a); i++)
	{
		if (a[i] == k)
		{
			return i + 1;
			break;
		}
	}
	return 0;
}

int TimCay(int a[], int n, int k) 
{
	//Thuat toan sap xep
	InterchangeSort(a, n);
	int  left = 0, right = n - 1;
	int mid;
	do {
		mid = (left + right) / 2;
		if (a[mid] == k)
			return mid;
		else
		{
			if (k < a[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
	} while (left <= right);
	return 0;
}

void Xuat(int a[], int n, int k)
{
	int chon;
	cout << "Nhap lua chon: 1. Xuat mang, 2. Tim k TT, 3. Tim k Nhi Phan ";
	cin >> chon;
	switch (chon)
	{
	case(1):
	{
		for (int i = 0; i < n; i++)
		{
			cout << a[i] << "\t";
		}
		break;
	}
	case(2):
	{
		if (TimKiemTT(a, k) != 0)
			cout << "Tim thay! Vi tri la: " << TimKiemTT(a, k) << endl;
		else
			cout << "Khong tim thay!" << endl;
	}
	case(3):
	{
		TimCay(a, n, k);
		for (int i = 0; i < n; i++)
		{
			cout << a[i] << "\t";
		}
		if (TimCay(a,n, k) != 0)
			cout << "Tim thay! Vi tri la: " << TimCay(a, n, k) << endl;
		else
			cout << "Khong tim thay!" << endl;
		break;
	}
	default:
		break;
	}

}
int main(){
	int A[10];
	int sl, k;
	cout << "Nhap sl:";
	cin >> sl;
	cout << "Nhap khoa k:";
	cin >> k;
	Nhap(A, sl);
	
	Xuat(A, sl, k);
	system("pause");
	return 0;
}