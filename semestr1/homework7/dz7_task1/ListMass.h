#pragma once

struct ListMass;

// создает новый список
ListMass *createList();

// добавляет элемент в конец списка
void addToEnd(ListMass *list, int value);

// возвращает значение элемента с данной поизицией
int returnValuePosition(ListMass *list, int position);

// возвращает количество элементов в списке
int returnAmountEl(ListMass *list);

// ставит поизицию на первый элемент списка
int firstElement(ListMass *list);

// ставит поизицию на последний элемент списка
int endElement(ListMass *list);

// ставит позицию на следующий элемент списка
int nextElement(ListMass *list, int position);

// возвращает значение верхнего элемента списка
int returnHeadValue(ListMass *list);

// удаляет верхний элемент списка
void delHead(ListMass *list);

// удалет список
void deleteList(ListMass *list);