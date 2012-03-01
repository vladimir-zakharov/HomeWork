#include <iostream>
#include "cyclicList.h"

typedef int ElementType;

struct ListElement
{
	ElementType value;
	ListElement *next;
};

struct List
{
	ListElement *head;
	ListElement *tail;
};

List *createList()
{
	List *result = new List;
	ListElement *sentinel = new ListElement;
	result->head = sentinel;
	result->tail = sentinel;
	sentinel->next = sentinel;
	return result;
}

//добавляет новый элемент в конец циклического списка
void insertInCyclicList(List *list, int value)
{
	ListElement *newElement = new ListElement;
	newElement->value = value;
	newElement->next = list->head;
	list->tail->next = newElement;
	list->tail = newElement;
}

//удаляет элемент с заданной позицией
int deleteElement(List *list, int position)
{
	ListElement *temp = list->head;
	
	for (int i = 1; i < position; i++)
		temp = temp->next;

	ListElement *add = temp->next;
	temp->next = temp->next->next;
	int number = add->value;
	delete add;
	return number;
}