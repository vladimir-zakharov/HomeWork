#pragma once

struct ListIndex;
struct ListElement;

// создает новый список
ListIndex *createList();

// добавляет элемент в конец списка
void addToEnd(ListIndex *list, int value);

// удалет список
void deleteList(ListIndex *list);

// возвращает количество элементов в списке
int returnAmountEl(ListIndex *list);

// ставит позицию на следующий элемент списка
ListElement *nextElement(ListIndex *list, ListElement *position);

// ставит поизицию на последний элемент списка
ListElement *endElement(ListIndex *list);

// ставит поизицию на первый элемент списка
ListElement *firstElement(ListIndex *list);

// возвращает значение элемента с данной поизицией
int returnValuePosition(ListIndex *list, ListElement *position);

// удаляет верхний элемент списка
void delHead(ListIndex *list);

// возвращает значение верхнего элемента списка
int returnHeadValue(ListIndex *list);
