#include <iostream>

using namespace std;

void swap(int a[], int number1, int number2)
{
	int temp = a[number1];
	a[number1] = a[number2];
	a[number2] = temp;
}
void transform(int a[], int first, int i, int &countS)
{
	if (a[i] <= first && i == countS)
			countS++;
		else
		{
			if (a[i] <= first && i > countS)
			{
				swap(a, i, countS);
				countS++;
			}
		}
}

void main()
{
	int a[10];
		
	for (int i = 0; i < 10; i++)
	{
		a[i] = rand() % 16;
		cout << a[i] << ' ';
	}
	
	cout << "\n";

	int first = a[0], countS = 1;

	for (int i = 1; i < 10; i++)
	{
		transform(a, first, i, countS);
		transform(a, first, 10 - i, countS);
	}

	if (a[1] < a[0])
		swap(a, 0, countS - 1); 

	for (int i = 0; i < 10; i++)
		cout << a[i] << ' ';

	cout << "\n";
}

