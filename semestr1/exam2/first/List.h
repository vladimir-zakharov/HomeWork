#pragma once

struct List;
struct ListElement;

// создает новый список
List *createList();

// добавляет элемент в конец списка
void addToEnd(List *list, int value);

// удалет список
void deleteList(List * list);

// возвращает количество элементов в списке
int returnAmountEl(List *list);

// ставит позицию на следующий элемент списка
ListElement *nextElement(List *list, ListElement *position);

// ставит поизицию на последний элемент списка
ListElement *endElement(List*list);

// ставит поизицию на первый элемент списка
ListElement *firstElement(List *list);

// возвращает значение элемента с данной поизицией
int returnValuePosition(List *list, ListElement *position);

// возвращает значение верхнего элемента списка
int returnHeadValue(List *list);
