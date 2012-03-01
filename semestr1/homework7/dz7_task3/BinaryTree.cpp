#include <iostream>
#include "BinaryTree.h"

struct BinaryTreeElement
{
	BinaryTreeElement *left;
	BinaryTreeElement *right;
	BinaryTreeElement *parent;
	char value;
};

struct BinaryTree
{
	BinaryTreeElement *root;
};

BinaryTree *createBinaryTree()
{
	BinaryTree *result = new BinaryTree;
	result->root = NULL;
	return result;
}

BinaryTreeElement *insertRoot(BinaryTree *tree, char value)
{
	BinaryTreeElement *newElement = new BinaryTreeElement;
	newElement->left = NULL;
	newElement->right = NULL;
	newElement->value = value;
	newElement->parent = NULL;
	tree->root = newElement;
	return newElement;
}

BinaryTreeElement *insertLeftChild(BinaryTree *tree, BinaryTreeElement *position, char value)
{
	BinaryTreeElement *newElement = new BinaryTreeElement;
	newElement->left = NULL;
	newElement->right = NULL;
	newElement->value =value;
	newElement->parent = position;
	position->left = newElement;
	return newElement;
}

BinaryTreeElement *insertRightChild(BinaryTree *tree, BinaryTreeElement *position, char value)
{
	BinaryTreeElement *newElement = new BinaryTreeElement;
	newElement->left = NULL;
	newElement->right = NULL;
	newElement->value =value;
	newElement->parent = position;
	position->right = newElement;
	return newElement;
}

BinaryTreeElement *leftMostChild(BinaryTree *tree, BinaryTreeElement *temp)
{
	while (temp->left != NULL)
		temp = temp->left;
	return temp;
}

BinaryTreeElement *returnRootPosition(BinaryTree *tree)
{
	return tree->root;
}

BinaryTreeElement *returnLeftPosition(BinaryTree *tree, BinaryTreeElement *position)
{
	if (position->left != NULL)
		return position->left;
	else
		return NULL;
}

BinaryTreeElement *returnRightPosition(BinaryTree *tree, BinaryTreeElement *position)
{
	if (position->right != NULL)
		return position->right;
	else
		return NULL;
}

int returnValuePosition(BinaryTree *tree, BinaryTreeElement *position)
{
	return position->value;
}

BinaryTreeElement *returnParentPosition(BinaryTree *tree, BinaryTreeElement *position)
{
	if (position->parent != NULL)
		return position->parent;
	else
		return position;
}

void deleteTreeElements(BinaryTree *tree, BinaryTreeElement *position)
{
	if (position != NULL)
	{
		BinaryTreeElement *temp = position->left;
		BinaryTreeElement *prov = position->right;
		delete position;
		deleteTreeElements(tree, temp);
		deleteTreeElements(tree, prov);
	}
}

void deleteTree(BinaryTree *tree)
{
	deleteTreeElements(tree, tree->root);
	delete tree;
}

void postorder(BinaryTree *tree, BinaryTreeElement *position)
{
	BinaryTreeElement *temp = position;
	
	if (temp == NULL) 
		return;
	temp = position->left;
	postorder(tree, temp);
	temp = position->right;
	postorder(tree, temp);
	
	if (position->value == '+' || position->value == '-' || position->value == '*'  || position->value == '/' )
	{
		int valueFirst = position->left->value - '0';
		int valueSecond = position->right->value - '0';

		if (position->value == '+')
			position->value = valueFirst + valueSecond + '0';

		if (position->value == '-')
			position->value = valueFirst - valueSecond + '0';

		if (position->value == '*')
			position->value = valueFirst * valueSecond + '0';

		if (position->value == '/')
		{
			if (valueSecond != 0)
				position->value = valueFirst / valueSecond + '0';
		}
	}
}