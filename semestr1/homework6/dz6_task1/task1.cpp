/* Тесты: 
1)
Начальный список
olga
777
vanya
341
petr
123
tom
541234

Введите 1, если хотите отсортировать список по имени
Введите 2, если хотите отсортировать список по номеру телефона
1
Отсортированный список:
olga
777
petr
123
tom
541234
vanya
341
2)
Начальный список
olga
777
vanya
341
petr
123
tom
541234

Введите 1, если хотите отсортировать список по имени
Введите 2, если хотите отсортировать список по номеру телефона
2
Отсортированный список:
petr
123
vanya
341
tom
541234
olga
777

Ожидаемое время: 1,5 часа
Фактическое: 2 часа 40 минут
*/
#include <iostream>
#include <fstream>
#include <clocale>
#include "List.h"
#include "MergeSort.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	List *list = createList();
	ifstream in("List.txt");
	cout << "Начальный список\n";

	if (in)
	{
		while (!in.eof())
		{
			char name[256];
			in >> name;
			char phoneNumber[256];
			in >> phoneNumber;
			if (name[0] != 0 && phoneNumber[0] != 0)
			{
				addToEnd(list, name, phoneNumber);
				cout << name << endl;
				cout << phoneNumber << endl;
			}
		}
	}
	in.close();
	cout << "\nВведите 1, если хотите отсортировать список по имени\n";
	cout << "Введите 2, если хотите отсортировать список по номеру телефона\n";
	int number = 0;
	cin >> number;
	char *string = {0};
	
	if (number == 1)
		string = "name";
	if (number == 2)
		string = "phoneNumber";

	list = mergeSort(list, string);
	int size = returnAmountEl(list);
	char *name = {0};
	char *phoneNumber = {0};
	ListElement *position = firstElement(list);
	cout << "Отсортированный список:\n";

	for (int i = 0; i < size; i++)
	{
		returnValuePosition(list, name, phoneNumber, position);
		cout << name << endl;
		cout << phoneNumber << endl;
		position = nextElement(list, position);
	}

	deleteList(list);
	return 0;
}