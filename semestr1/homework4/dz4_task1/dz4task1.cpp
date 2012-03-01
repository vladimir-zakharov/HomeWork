#include <iostream>
#include <clocale>

using namespace std;

int const size = sizeof(int) * 8;

void convert(bool mass[], int n)
{
	long long int mask = 1;
	
	for (int i = 0; i < size; i++)
	{
		mass[i] = (mask & n) != 0;
		mask = mask << 1;
	}
}

void output(bool mass[])
{
	int t = (size) - 1;
	
	while (!mass[t])
		t--;

	if (t == -1)
		cout << 0;
	else
		for (int i = t; i >= 0; i--)
			cout << mass[i];
	
	cout << "\n";
}

void main()
{
	setlocale(LC_ALL, "RUS");
	int first = 0;
	int second = 0;
	cout << "Введите 2 числа\n";
	cin >> first >> second;
	bool massFirst[size];
	bool massSecond[size];
	bool massSumm[size];
	
	for (int i = 0; i < size; i++)
	{
		massFirst[i] = false;
		massSecond[i] = false;
		massSumm[i] = false;
	}

	convert(massFirst, first);
	convert(massSecond, second);
	cout << "Данные числа в двоичной ситсеме счисления:\n";
	cout << "Первое: ";
	output(massFirst);
	cout << "Второе: ";
	output(massSecond);
	int carry = 0;
	
	for (int i = 0; i < size; i++)
	{
		int summ = massFirst[i] + massSecond[i] + carry;

		if (summ > 1)
		{
			if (summ % 2 == 0)
				massSumm[i] = false;
			else
				massSumm[i] = true;
			carry = 1;
		}
		else
		{
			if (summ == 0)
				massSumm[i] = false;
			else
				massSumm[i] = true;
			carry = 0;
		}
	}
	
	cout << "Их сумма в двоичной системе счисления: ";
	output(massSumm);

	long long int stepen = 1;
	int result = 0;

	for (int i = 0; i < size; i++)
	{
		result = result + massSumm[i] * stepen;
		stepen = stepen << 1;
	}

	cout << "Их сумма в десятичной системе счисления: ";
	cout << result << "\n";
}
