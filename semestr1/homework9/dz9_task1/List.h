#pragma once

struct List;
struct ListElement;

// создает новый список
List *createList();

// добавляет элемент в конец списка
void addToEnd(List *list, int value, int number);

// удалет список
void deleteList(List * list);

// возвращает количество элементов в списке
int returnAmountList(List *list);

// ставит позицию на следующий элемент списка
ListElement *nextElement(List *list, ListElement *position);

// ставит поизицию на последний элемент списка
ListElement *endElement(List*list);

// ставит поизицию на первый элемент списка
ListElement *firstElement(List *list);

// возвращает значение элемента с данной поизицией
int returnValuePosition(List *list, ListElement *position);

// возвращает значение головы списка
int ListHeadValue(List *list);

// печатает список в консоль
void printList(List *list);

// возвращает номер элемента с заданной позицией
int returnNumberPosition(List *list, ListElement *position);