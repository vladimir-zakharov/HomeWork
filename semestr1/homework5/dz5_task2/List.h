#pragma once

struct List;
struct ListElement;
List *createList();
void insert(List *list, int value);
void deleteList(List * list);
int returnAmountEl(List *list);
ListElement *nextElement(List *list, ListElement *position);
ListElement *endElement(List*list);
ListElement *firstElement(List *list);
int returnValuePosition(List *list, ListElement *position);
int deleteHead(List *list);
