#include <iostream>
#include <fstream>
#include <clocale>
#include "MergeSort.h"

//#include "ListIndex.h"
#include "ListMass.h"

using namespace std;

//typedef ListIndex* List;
//typedef ListElement* Position;

typedef ListMass *List;
typedef int Position;

int main()
{
	setlocale(LC_ALL, "RUS");
	List list = createList();
	ifstream in("List.txt");
	cout << "Начальный список:\n";

	if (in)
	{
		while (!in.eof())
		{
			int value = 0;
			in >> value;
			addToEnd(list, value);
			cout << value << ' ';
		}
		cout << endl;
	}
	in.close();

	list = mergeSort(list);
	int size = returnAmountEl(list);
	Position position = firstElement(list);
	cout << "Отсортированный список:\n";

	for (int i = 0; i < size; i++)
	{
		cout << returnValuePosition(list, position) << ' ';
		position = nextElement(list, position);
	}
	cout << endl;

	deleteList(list);
	return 0;
}