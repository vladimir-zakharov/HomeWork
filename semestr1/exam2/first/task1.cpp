#include <iostream>
#include <fstream>
#include <clocale>
#include "List.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	List *list = createList();
	ifstream in("f.txt");
	cout << "Введите 2 числа\n";
	int a = 0;
	int b = 0;
	cin >> a >> b;

	if (in)
	{
		while (!in.eof())
		{
			int value = 0;
			in >> value;
			addToEnd(list, value);
		}
	}

	in.close();

	int size = returnAmountEl(list);
	ListElement *position = firstElement(list);
	ofstream out("g.txt");

	for (int i = 0; i < size; i++)
	{
		int value = returnValuePosition(list, position);
		if (value < a)
		{	
			out << value;
		}

		position = nextElement(list, position);	
	}

	position = firstElement(list);
	
	for (int i = 0; i < size; i++)
	{
		int value = returnValuePosition(list, position);
		if (value >= a && value <= b)
		{	
			out << value;
		}

		position = nextElement(list, position);		
	}

	position = firstElement(list);
	
	for (int i = 0; i < size; i++)
	{
		int value = returnValuePosition(list, position);
		if (value >b)
		{	
			out << value;
		}

		position = nextElement(list, position);		
	}
	
	out.close();
	deleteList(list);
	return 0;
}
