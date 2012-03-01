#include <iostream>
#include "List.h"

using namespace std;

void comands()
{
	cout << "\nВведите цифру от 0 до 3:\n";
	cout << "0 - выход\n";
	cout << "1 - добавить значение в сортированный список\n";
	cout << "2 - удалить значение из списка\n"; 
	cout << "3 - распечатать список\n";
}

int main()
{
	setlocale(LC_ALL, "RUS");
	List *list = createList();
	comands();

	int key = -1;

	while (key != 0)
	{
		cin >> key;

		if (key == 1)
		{
			cout << "Введите число\n";
			int value = 0;
			cin >> value;
			insert(list, value);
			cout << "Добавлено\n";
			comands();
		}

		if (key == 2)
		{
			cout << "Введите значение списка, которое вы хотите удалить\n";
			int value = 0;
			cin >> value;
			bool successfullyDeleted = deleteElement(list, value);
			if (!successfullyDeleted)
				cout << "Нет такого значения\n";
			else
			{
				cout << "Удалено\n";
			}
			comands();
		}
	
		if (key == 3)
		{
			cout << "Полученный список\n";
			int value = 0;
			ListElement *position = firstElement(list);
			int count = returnAmountEl(list);

			for (int i = 0; i < count; i++)
			{
				cout << returnValuePosition(list, position) << endl;
				position = nextElement(list, position);
			}
			
			comands();
		}
	}

	deleteList(list);
	return 0;
}