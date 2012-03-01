#include <iostream>
#include <clocale>
#include "cyclicList.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	cout << "Введите количество воинов: ";
	int n = 0;
	cin >> n;
	cout << "Убивают каждого m-го. Введите m: ";
	int m = 0;
	cin >> m;
	List *list = createList();

	for (int i = 1; i <= n; i++)
		insertInCyclicList(list, i);

	int amount = n;
	int count = 1;
	int position = 1;
	int number = 0;
	
	while (amount > 0)
	{
		if (count == m)
		{
			number = deleteElement(list, position);
			amount--;
			position--;
		}
		count++;
		position++;
		if (count > m)
			count = 1;
		if (position > amount)
			position = 1;
	}

	cout << "Начальная позиция выжившего воина: " << number << endl;
	return 0;
}