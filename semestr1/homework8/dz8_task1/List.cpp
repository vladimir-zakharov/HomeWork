#include <iostream>
#include "List.h"

struct ListElement
{
	char string[256];
	int amount;
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

void addToEnd(List *list, char *string)
{
	ListElement *newElement = new ListElement;
	newElement->next = NULL;
	newElement->amount = 1;
	strcpy(newElement->string, string);

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

char *returnValuePosition(List *list, ListElement *position)
{
	return position->string;
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

bool exists(List *list, char *string)
{
	ListElement *temp = list->head;

	while (temp)
	{
		if (strcmp(temp->string, string) == 0)
		{
			temp->amount++;
			return true;
		}

		temp = temp->next;
	}

	return false;
}

int returnAmountList(List *list)
{
	return list->count;
}

int returnAmountElement(List *list, ListElement *position)
{
	return position->amount;
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