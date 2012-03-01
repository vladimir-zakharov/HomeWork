#include <iostream>
#include "List.h"

struct ListElement
{
	int value;
	int number;
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

void addToEnd(List *list, int value, int number)
{
	ListElement *newElement = new ListElement;
	newElement->next = NULL;
	newElement->value = value;
	newElement->number = number;

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

int returnNumberPosition(List *list, ListElement *position)
{
	return position->number;
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

int returnAmountList(List *list)
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

void printList(List *list)
{
	ListElement *temp = list->head;

	while (temp)
	{
		std::cout << temp->number << ' ';
		temp = temp->next;
	}

	std::cout << std::endl;
}

int ListHeadValue(List *list)
{
	return list->head->value;
}