#pragma once
#include<iostream>
#include<string>

using namespace std;
void swap(int &a, int &b) {
	int tam = a;
	a = b;
	b = tam;
}

void InterchangeSort(int a[], int n)
{
	int i, j;
	for (i = 0; i < n-1; i++)
	{
		for (j = i + 1; j < n; j++) {
			if (a[j] < a[i])
				swap(a[i], a[j]);
		}
	}
}

void SelectionSort(int a[], int n)
{
	

}