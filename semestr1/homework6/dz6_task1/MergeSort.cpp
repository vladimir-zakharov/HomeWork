#include <iostream>
#include "MergeSort.h"
#include "List.h"

List *merge(List *list1, List *list2, char *string)
{
	List *listResult = createList();
	char *name1 = {0};
	char *phoneNumber1 = {0};
	char *name2 = {0};
	char *phoneNumber2 = {0};

	while (returnAmountEl(list1) != 0 && returnAmountEl(list2) != 0)
	{
		returnHeadValue(list1, name1, phoneNumber1);
		returnHeadValue(list2, name2, phoneNumber2);
		int compare = 0;
		
		if (strcmp(string, "name") == 0)
			compare = strcmp(name1, name2);
		if (strcmp(string ,"phoneNumber") == 0)
			compare = strcmp(phoneNumber1, phoneNumber2);
		
		if (compare > 0)
		{
			addToEnd(listResult, name2, phoneNumber2);
			delHead(list2);
		}
		else
		{
			addToEnd(listResult, name1, phoneNumber1);
			delHead(list1);
		}
	}

	if (returnAmountEl(list1) == 0)
	{
		while (returnAmountEl(list2) != 0)
		{
			returnHeadValue(list2, name2, phoneNumber2);
			addToEnd(listResult, name2, phoneNumber2);
			delHead(list2);
		}
	}
	else
	{
		if (returnAmountEl(list2) == 0)
			while (returnAmountEl(list1) !=0)
			{
				returnHeadValue(list1, name1, phoneNumber1);
				addToEnd(listResult, name1, phoneNumber1);
				delHead(list1);
			}
	}

	deleteList(list1);
	deleteList(list2);
	return listResult;
}

List *mergeSort(List *list, char *string)
{
	int amount = returnAmountEl(list);
	if (amount == 0)
		return NULL;
	if (amount == 1)
		return list;
	
	int half = amount / 2;
	List *list1 = createList();
	List *list2 = createList();
	ListElement *position = firstElement(list);
	char *name = {0};
	char *phoneNumber = {0};

	for (int i = 0; i < half; i++)
	{
		returnValuePosition(list, name, phoneNumber, position);
		addToEnd(list1, name, phoneNumber);
		position = nextElement(list, position);
	}

	for (int i = half; i < amount; i++)
	{
		returnValuePosition(list, name, phoneNumber, position);
		addToEnd(list2, name, phoneNumber);
		position = nextElement(list, position);
	}

	list1 = mergeSort(list1, string);
	list2 = mergeSort(list2, string);
	return merge(list1, list2, string);
}