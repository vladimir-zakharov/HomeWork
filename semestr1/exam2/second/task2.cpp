#include <iostream>
#include <fstream>
#include <clocale>
#include "List.h"

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
			int value = 0;
			in >> value;
			addToEnd(list, value);
			cout << value;
		}
	}

	cout << endl;
	in.close();

	bool successful = true;

	int valueEnd = 0;
	int valueHead = 0;

	while (returnAmountEl(list) > 1)
	{
		valueHead = deleteHead(list);
		if (returnAmountEl(list) == 1)
			valueEnd = returnTailValue(list);
		else
			valueEnd = deleteEnd(list);

		if (valueHead != valueEnd)
		{
			successful = false;
			break;
		}
	}

	if (successful)
		cout << "Список симметричен\n";
	else
		cout << "Список не симметричен\n";

	deleteList(list);
	return 0;
}