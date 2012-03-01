#include <iostream>
#include <ctime>

using namespace std;

void swap(int a[], int number1, int number2)
{
	int temp = a[number1];
	a[number1] = a[number2];
	a[number2] = temp;
}

int transform(int a[], int begin, int end)
{
	int countS = begin;
	int countB = end;
	int first = a[begin];

	while (countS <= countB)
	{
		
		while (a[countS] < first)
			countS++;
	
		while (a[countB] > first)
			countB--;

		if (countS <= countB)
		{
			swap(a, countS, countB);
			countS++;
			countB--;
		}

	}

	return countS - 1;
}

void sortInsert(int a[], int begin, int end)
{
	
	for (int i = 0; i <= end; i++)
		for (int j = i; j > 0; j--)
			if (a[j] < a[j - 1])
				swap(a, j, j - 1);

}

void qSort(int a[], int begin, int end)
{
	
	if (begin + 10 < end)
	{
		int block = transform(a, begin, end);
		qSort(a, begin, block);
		qSort(a, block + 1, end);
	}
	else
		sortInsert(a, begin, end);

}
          

void main()
{
	int a[50];
	int sizeA = 50;
	srand((unsigned)time(NULL));

	for (int i = 0; i < sizeA; i++)
	{
		a[i] = rand() % 16;
		cout << a[i] << ' ';
	}
	
	cout << "\n";

	qSort(a, 0, sizeA - 1);

	for (int i = 0; i < sizeA; i++)
		cout << a[i] << ' ';

	cout << "\n";
}
