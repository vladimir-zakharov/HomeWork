#include <iostream>
#include "ListIndex.h"

struct ListElement
{
	int value;
	ListElement *next;
};

struct ListIndex
{
	ListElement *head;
	ListElement *tail;
	int count;
};

ListIndex *createList()
{
	ListIndex *result = new ListIndex;
	result->head = NULL;
	result->tail = NULL;
	result->count = 0;
	return result;
}

void addToEnd(ListIndex *list, int value)
{
	ListElement *newElement = new ListElement;
	newElement->next = NULL;
	newElement->value = value;
	if (list->head == NULL)
	{
		list->head = newElement;
		list->tail = newElement;
	}
	else
	{
		list->tail->next = newElement;
		list->tail = newElement;
	}
	list->count++;
}

int returnValuePosition(ListIndex *list, ListElement *position)
{
	return position->value;
}


void deleteList(ListIndex *list)
{
	ListElement *temp = list->head;
	
	while (temp != NULL)
	{
		list->head = list->head->next;
		delete temp;
		temp = list->head;
	}
	
	delete list;
}

int returnAmountEl(ListIndex *list)
{
	return list->count;
}

ListElement *firstElement(ListIndex *list)
{
	return list->head;
}

ListElement *endElement(ListIndex *list)
{
	return list->tail;
}

ListElement *nextElement(ListIndex *list, ListElement *position)
{
	return position->next;
}

void delHead(ListIndex *list)
{
	if (list->head != NULL)
	{
		ListElement *temp = list->head;
		list->head = list->head->next;
		delete temp;
		list->count--;
	}
}

int returnHeadValue(ListIndex *list)
{
	return list->head->value;
}