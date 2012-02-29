#pragma once

struct List;
struct ListElement;

// создает новый список
List *createList();

// добавляет элемент в конец списка
void addToEnd(List *list, char *name, char *phoneNumber);

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
void returnValuePosition(List *list, char *&name, char *&phoneNumber, ListElement *position);

// удаляет верхний элемент списка
void delHead(List *list);

// возвращает значение верхнего элемента списка
void returnHeadValue(List *list, char *&name, char *&phoneNumber);
