#pragma once

struct List;
struct ListElement;
List *createList();
void insert(List *list, char *name, char *phoneNumber);
char* search(List *list, char *ElementOut, char *string);
void returnValuePosition(List *list, char *&name, char *&phoneNumber, ListElement *position);
void deleteList(List *list);
int returnAmountEl(List *list);
ListElement *firstElement(List *list);
ListElement *endElement(List*list);
ListElement *nextElement(List *list, ListElement *position);