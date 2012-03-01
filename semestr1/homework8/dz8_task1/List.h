#pragma once

struct List;
struct ListElement;

// создает новый список
List *createList();

// добавляет элемент в конец списка
void addToEnd(List *list, char *string);

// удалет список
void deleteList(List * list);

// возвращает количество элементов в списке
int returnAmountList(List *list);

// возвращает количество элементов с заданной позицией
int returnAmountElement(List *list, ListElement *position);

// ставит позицию на следующий элемент списка
ListElement *nextElement(List *list, ListElement *position);

// ставит поизицию на последний элемент списка
ListElement *endElement(List*list);

// ставит поизицию на первый элемент списка
ListElement *firstElement(List *list);

// возвращает значение элемента с данной поизицией
char *returnValuePosition(List *list, ListElement *position);

/* ищет в списке элемент с заданным значением, если такой
элемент существует, то увеличивает количество этих элементов на 1*/
bool exists(List *list, char *string);