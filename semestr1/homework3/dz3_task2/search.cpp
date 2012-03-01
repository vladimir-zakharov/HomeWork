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

int search(int a[], int x, int sizeA)
{
	int mid = sizeA / 2;
	int begin = 0;
	int end = sizeA;
	while (begin <= end)
	{
		
		if (x == a[mid])
			return mid;
		
		if (x < a[mid])
			end = mid - 1;
		else
			begin = mid + 1;

		mid = (begin + end) / 2;
		
	}

	return -1;
}

void main()
{
	int a[5000];
	int n = 0;
	cout << "Input n = ";
	cin >> n;
	int k = 0;
	cout << "Input k = ";
	cin >> k;
	srand((unsigned)time(NULL));

	for (int i = 0; i < n; i++)
	{
		a[i] = rand() % 1000000001;
		cout << a[i] << ' ';
	}

	cout << "\n";
	qSort(a, 0, n - 1);

	for (int i = 0; i < k; i++)
	{
		int x = rand() % 1000000001;
		int result = search(a, x, n - 1);
		if (result == -1)
			cout << x << " NO\n";
		else
			cout << x << " YES\n";
	}
}
