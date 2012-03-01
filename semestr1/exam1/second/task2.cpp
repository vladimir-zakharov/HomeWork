#include <iostream>
#include <clocale>

using namespace std;

void swap(int a[], int number1, int number2)
{
	int t = a[number1];
	a[number1] = a[number2];
	a[number2] = t;
}

void main()
{
	int const size = 10;
	setlocale(LC_ALL, "RUS");
	int mass[size];
	cout << "Введите 10 чисел\n";

	for (int i = 0; i < size; i++)
		cin >> mass[i];

	for (int i = 0; i < size; i++)
	{
		int min = mass[i];
		int minNumb = i;
		
		for (int j = i; j < size; j++)
			if (mass[j] < min)
			{
				min = mass[j];
				minNumb = j;
			}

		swap(mass, i, minNumb);
	}

	cout << "Отсортированный массив: ";

	for (int i = 0; i < size; i++)
		cout << mass[i] << ' ';

	cout << '\n';
}




