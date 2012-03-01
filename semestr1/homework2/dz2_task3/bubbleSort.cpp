#include <iostream>

using namespace std;

void swap(int a[], int number1, int number2)
{
	int temp = a[number1];
	a[number1] = a[number2];
	a[number2] = temp;
}

void main()
{
	int const sizeA = 15;
	int a[sizeA];
	
	for (int i = 0; i < sizeA; i++)
		cin >> a[i];

	for (int i = 0; i < sizeA; i++)
		for(int j = 0; j < sizeA - i - 1; j++)
		{
			if (a[j] > a[j + 1])
				swap(a, j, j + 1);
		}
		
	for (int i = 0; i < sizeA; i++)
		cout << a[i] << ' ';
	cout << "\n";
}

