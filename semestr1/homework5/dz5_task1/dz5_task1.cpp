#include <iostream>
#include <fstream>
#include <clocale>
#include <string.h>
#include "List.h"

using namespace std;

void comands()
{
	cout << "\nВведите цифру от 0 до 4:\n";
	cout << "0 - выход\n";
	cout << "1 - добавить запись (имя и телефон)\n"; 
	cout << "2 - найти телефон по имени\n"; 
	cout << "3 - найти имя по телефону\n";
	cout << "4 - сохранить текущие данные в файл\n";
}

void main()
{
	setlocale(LC_ALL, "RUS");
	comands();
	List *list = createList();
	ListElement *position = firstElement(list);
	ifstream in("PhoneBook.txt");

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
				insert(list, name, phoneNumber);
				position = firstElement(list);
			}
		}

		in.close();
	}

	int key = -1;
	while (key != 0)
	{
		cin >> key;
		
		if (key == 1)
		{
			cout << "Введите имя\n";
			char name[256];
			cin >> name;
			cout << "Введите номер телефона\n";
			char phoneNumber[256];
			cin >> phoneNumber;
			insert(list, name, phoneNumber); 
			cout << "Добавлено\n";
			comands();
		}
		
		if (key == 2)
		{
			cout << "Введите имя человека, номер которого вы бы хотели найти\n";
			char name[256];
			cin >> name;
			cout << search(list, "phoneNumber", name) << endl;
			comands();
		}
		
		if (key == 3)
		{
			cout << "Введите номер телефона человека, которого вы бы хотели найти\n";
			char phoneNumber[256];
			cin >> phoneNumber;
			cout << search(list, "name", phoneNumber) << endl;
			comands();
		}

		if (key == 4)
		{
			int count = returnAmountEl(list);
			if (count > 0)
			{
				ofstream out("PhoneBook.txt");
				char *name = {0};
				char *phoneNumber = {0};
				position = firstElement(list);

				for (int i = 0; i < count; i++)
				{
					returnValuePosition(list, name, phoneNumber, position);
					out << name << endl;
					out << phoneNumber << endl;
					position = nextElement(list, position);
				}
				out.close();
			}
			cout << "Информация сохранена\n";
			comands();
		}
	}
	
	deleteList(list);
}