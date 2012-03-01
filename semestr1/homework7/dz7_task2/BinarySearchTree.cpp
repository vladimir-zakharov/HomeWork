#include <iostream>
#include "BinarySearchTree.h"

struct BinaryTreeElement
{
	BinaryTreeElement *left;
	BinaryTreeElement *rigth;
	BinaryTreeElement *parent;
	int value;
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

void insert(BinaryTree *tree, int value)
{
	BinaryTreeElement *temp = tree->root;
	BinaryTreeElement *newElement = new BinaryTreeElement;
	BinaryTreeElement *parentElement = tree->root;
	int direction = 0;

	if (temp == NULL)
	{
		newElement->left = NULL;
		newElement->rigth = NULL;
		newElement->value = value;
		newElement->parent = NULL;
		tree->root = newElement;
	}
	else
	{
		while (temp != NULL)
		{
			parentElement = temp;

			if (value >= temp->value)
			{
				temp = temp->rigth;
				direction = 1;
			}
			else
			{
				temp = temp->left;
				direction = -1;
			}
		}

		newElement->left = NULL;
		newElement->rigth = NULL;
		newElement->parent = parentElement;
		newElement->value = value;
		
		if (direction == 1)
			parentElement->rigth = newElement;
		else
			parentElement->left = newElement;
	}
}

BinaryTreeElement *leftMostChild(BinaryTree *tree, BinaryTreeElement *temp)
{
	while(temp->left != NULL)
		temp = temp->left;
	return temp;
}


bool deleteElement(BinaryTree *tree, int value)
{
	BinaryTreeElement *temp = tree->root;
	bool successfulySearch = false;
	int direction = 0;
	
	if (temp == NULL)
		return false;
	else
	{
		while (temp != NULL)
		{
			if (value == temp->value)
			{
				successfulySearch = true;
				break;
			}
			else
			{
				if (value >= temp->value)
				{
					temp = temp->rigth;
					direction = 1;
				}
				else
				{
					temp = temp->left;
					direction = -1;
				}
			}
		}
	}

	if (successfulySearch)
	{
		if (temp->left == NULL && temp->rigth == NULL)
		{
			BinaryTreeElement *prov = temp;

			if (direction == 0)
				tree->root = NULL;
			else
			{
				if (direction == 1)
					temp->parent->rigth = NULL;
				else
					temp->parent->left = NULL;
			}

			delete prov;
		}
		else
		{
			if (temp->left == NULL)
			{
				BinaryTreeElement *prov = temp->rigth;
				temp->value = prov->value;
				temp->left = prov->left;
				temp->rigth = prov->rigth;
				if (prov->left != NULL)
					prov->left->parent = temp;
				if (prov->rigth != NULL)
					prov->rigth->parent = temp;
				delete prov;
			}
			else
			{
				if (temp->rigth == NULL)
				{
					BinaryTreeElement *prov = temp->left;
					temp->value = prov->value;
					temp->left = prov->left;
					temp->rigth = prov->rigth;
					if (prov->left != NULL)
						prov->left->parent = temp;
					if (prov->rigth != NULL)
						prov->rigth->parent = temp;
					delete prov;
				}
				else
				{
					BinaryTreeElement *prov = temp->rigth;
					prov = leftMostChild(tree, prov);
					temp->value = prov->value;

					if (prov->parent->value <= prov->value)
						prov->parent->rigth = NULL;
					else
						prov->parent->left = NULL;
					delete prov;
				}
			}
		}
		return true;
	}
	
	return false;
}

bool search(BinaryTree *tree, int value)
{
	BinaryTreeElement *temp = tree->root;
	
	if (temp == NULL)
		return false;
	else
	{
		while (temp != NULL)
		{
			if (value == temp->value)
				return true;
			else
			{
				if (value > temp->value)
					temp = temp->rigth;
				else
					temp = temp->left;
			}
		}

		return false;	
	}
}

BinaryTreeElement *returnRootPosition(BinaryTree *tree)
{
	return tree->root;
}

BinaryTreeElement *returnParentPosition(BinaryTree *tree, BinaryTreeElement *position, bool &error)
{
	if (position->parent != NULL)
		return position->parent;
	else
	{
		error = true;
		return position;
	}
}

BinaryTreeElement *returnLeftPosition(BinaryTree *tree, BinaryTreeElement *position)
{
	if (position->left != NULL)
		return position->left;
	else
		return NULL;
}

BinaryTreeElement *returnRigthPosition(BinaryTree *tree, BinaryTreeElement *position)
{
	if (position->rigth != NULL)
		return position->rigth;
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
		return NULL;
}

void inorderDelete(BinaryTree *tree, BinaryTreeElement *position)
{
	BinaryTreeElement *temp = position;
	
	if (temp == NULL) 
		return;
	temp = returnLeftPosition(tree, position);
	inorderDelete(tree, temp);
	delete(temp);
	temp = returnRigthPosition(tree, position);
	inorderDelete(tree, temp);
}

void deleteTree(BinaryTree *tree)
{
	inorderDelete(tree, tree->root);
	delete(tree);
}