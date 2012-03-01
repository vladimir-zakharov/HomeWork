#include "Set.h"
#include "BinarySearchTree.h"

struct Set
{
	int count;
	BinaryTree *tree;
};

Set *createSet()
{
	Set *result = new Set;
	result->tree = createBinaryTree();
	result->count = 0;
	return result;
}

void addToSet(Set *set, int value)
{
	if (!search(set->tree, value))
	{
			insert(set->tree, value);
			set->count++;
	}
}

bool exists(Set *set, int value)
{
	return search(set->tree, value);
}

int amountSet(Set *set)
{
	return set->count;
}

void deleteSet(Set *set)
{
	deleteTree(set->tree);
	delete set;
}