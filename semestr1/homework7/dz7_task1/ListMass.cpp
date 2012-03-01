#include <iostream>
#include "ListMass.h"

struct ListMass
{
	int value[100];
	int last;
	int count;
	int first;
};

ListMass *createList()
{
	ListMass *result = new ListMass;
	result->count = 0;
	result->last = 0;
	result->first = 0;
	return result;
}

void addToEnd(ListMass *list, int value)
{
	list->value[list->last] = value;
	list->last++;
	list->count++;
}

int returnValuePosition(ListMass *list, int position)
{
	return list->value[position];
}

int returnAmountEl(ListMass *list)
{
	return list->count;
}

int endElement(ListMass *list)
{
	return list->last;
}

int nextElement(ListMass *list, int position)
{
	return ++position;
}

void delHead(ListMass *list)
{
	list->value[list->first] = 0;
	list->first++;
	list->count--;
}

int returnHeadValue(ListMass *list)
{
	return list->value[list->first];
}

void deleteList(ListMass *list)
{
	delete list;
}

int firstElement(ListMass *list)
{
	return list->first;
}