#include <iostream>
#include "List.h"

struct ListElement
{
	int value;
	ListElement *next;
};

struct List
{
	ListElement *head;
	ListElement *tail;
	int count;
};

List *createList()
{
	List *result = new List;
	result->head = NULL;
	result->tail = NULL;
	result->count = 0;
	return result;
}

void addToEnd(List *list, int value)
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

int returnValuePosition(List *list, ListElement *position)
{
	return position->value;
}

void deleteList(List *list)
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

int returnAmountEl(List *list)
{
	return list->count;
}

ListElement *firstElement(List *list)
{
	return list->head;
}

ListElement *endElement(List*list)
{
	return list->tail;
}

ListElement *nextElement(List *list, ListElement *position)
{
	return position->next;
}


int returnHeadValue(List *list)
{
	if (list->head != NULL)
	{
		return list->head->value;
	}
	else
		return -1;
}