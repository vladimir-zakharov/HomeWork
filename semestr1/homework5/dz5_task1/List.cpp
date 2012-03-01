#include <iostream>
#include <fstream>
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
	int count;
};

List *createList()
{
	List *result = new List;
	result->head = NULL;
	result->count = 0;
	return result;
}

void insert(List *list, char *name, char *phoneNumber)
{
	ListElement *newHead = new ListElement;
	newHead->next = list->head;
	strcpy(newHead->name, name);
	strcpy(newHead->phoneNumber, phoneNumber);
	list->head = newHead;
	list->count++;
}

char* search(List *list, char *ElementOut, char *string)
{
	int i = 0;
	int flag = -1;
	ListElement *temp = list->head;
						
	while (i < list->count)
	{
		if (ElementOut == "phoneNumber")
			flag = strcmp(temp->name, string);
		if (ElementOut == "name")
			flag = strcmp(temp->phoneNumber, string);

		if (flag == 0)
		{
			if (ElementOut == "phoneNumber")
				return temp->phoneNumber;
			if (ElementOut == "name")
				return temp->name;
			break;
		}

		i++;
		temp = temp->next;
	}
				
	return "Не найдено";	
}

void returnValuePosition(List *list, char *&name, char *&phoneNumber, ListElement *position)
{
	name = position->name;
	phoneNumber = position->phoneNumber;
}

void deleteList(List * list)
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