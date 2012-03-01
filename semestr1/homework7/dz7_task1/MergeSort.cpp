#include <iostream>
#include "MergeSort.h"

//#include "ListIndex.h"
#include "ListMass.h"

//typedef ListIndex* List;
//typedef ListElement* Position;

typedef ListMass *List;
typedef int Position;

List merge(List list1, List list2)
{
	List listResult = createList();

	while (returnAmountEl(list1) != 0 && returnAmountEl(list2) != 0)
	{
		int value1 = returnHeadValue(list1);
		int value2 = returnHeadValue(list2);
		
		if (value1 > value2)
		{
			addToEnd(listResult, value2);
			delHead(list2);
		}
		else
		{
			addToEnd(listResult, value1);
			delHead(list1);
		}
	}

	if (returnAmountEl(list1) == 0)
	{
		while (returnAmountEl(list2) != 0)
		{
			int value = returnHeadValue(list2);
			addToEnd(listResult, value);
			delHead(list2);
		}
	}
	else
	{
		if (returnAmountEl(list2) == 0)
			while (returnAmountEl(list1) !=0)
			{
				int value = returnHeadValue(list1);
				addToEnd(listResult, value);
				delHead(list1);
			}
	}

	deleteList(list1);
	deleteList(list2);
	return listResult;
}

List mergeSort(List list)
{
	int amount = returnAmountEl(list);
	
	if (amount == 0)
		return NULL;
	if (amount == 1)
		return list;
	
	int half = amount / 2;
	List list1 = createList();
	List list2 = createList();
	Position position = firstElement(list);

	for (int i = 0; i < half; i++)
	{
		int value = returnValuePosition(list, position);
		addToEnd(list1, value);
		position = nextElement(list, position);
	}

	for (int i = half; i < amount; i++)
	{
		int value = returnValuePosition(list, position);
		addToEnd(list2, value);
		position = nextElement(list, position);
	}

	list1 = mergeSort(list1);
	list2 = mergeSort(list2);
	return merge(list1, list2);
}