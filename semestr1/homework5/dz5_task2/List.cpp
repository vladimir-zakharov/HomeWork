#include <iostream>
#include "List.h"

struct ListElement
{
	char phoneNumber[256];
	char name[256];
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

void addToEnd(List *list, char *name, char *phoneNumber)
{
	ListElement *newElement = new ListElement;
	newElement->next = NULL;
	strcpy(newElement->name, name);
	strcpy(newElement->phoneNumber, phoneNumber);
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

void returnValuePosition(List *list, char *&name, char *&phoneNumber, ListElement *position)
{
	name = position->name;
	phoneNumber = position->phoneNumber;
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
	ListElement *position = list->head;
	while (position->next != NULL)
		position = position->next;
	return position;
}

ListElement *nextElement(List *list, ListElement *position)
{
	return position->next;
}

void delHead(List *list)
{
	if (list->head != NULL)
	{
		ListElement *temp = list->head;
		list->head = list->head->next;
		delete temp;
		list->count--;
	}
}

void returnHeadValue(List *list, char *&name, char *&phoneNumber)
{
	if (list->head != NULL)
	{
		name = list->head->name;
		phoneNumber = list->head->phoneNumber;
	}
}