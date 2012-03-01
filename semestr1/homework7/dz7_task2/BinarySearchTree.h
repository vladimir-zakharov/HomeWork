#pragma once

struct BinaryTree;
struct BinaryTreeElement;

// создает бинарное дерево поиска
BinaryTree *createBinaryTree();

// добавляет элемент в бинарное дерево поиска
void insert(BinaryTree *tree, int value);

// удаляет элемент с заданным значением
bool deleteElement(BinaryTree *tree, int value);

/* ищет элемент с заданным значением, возвращает true, если есть элемент,
false, если такого элемента нет в дереве */
bool search(BinaryTree *tree, int value);

// ставит позицию на корень
BinaryTreeElement *returnRootPosition(BinaryTree *tree);

// удаляет дерево
void deleteTree(BinaryTree *tree);

// возвращает значение текущего элемента
int returnValuePosition(BinaryTree *tree, BinaryTreeElement *position);

// возвращает позицию самого левого сына данного элемента
BinaryTreeElement *leftMostChild(BinaryTree *tree, BinaryTreeElement *temp);

// возвращает позицию левого сына
BinaryTreeElement *returnLeftPosition(BinaryTree *tree, BinaryTreeElement *position);

// возвращает позицию правого сына
BinaryTreeElement *returnRigthPosition(BinaryTree *tree, BinaryTreeElement *position);

// возвращает позицию родителя
BinaryTreeElement *returnParentPosition(BinaryTree *tree, BinaryTreeElement *position);

