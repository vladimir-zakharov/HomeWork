#pragma once

struct BinaryTree;
struct BinaryTreeElement;

// создает бинарное дерево поиска
BinaryTree *createBinaryTree();

// добавляет левого сына
BinaryTreeElement *insertLeftChild(BinaryTree *tree, BinaryTreeElement *position, char value);

// добавляет правого сына
BinaryTreeElement *insertRightChild(BinaryTree *tree, BinaryTreeElement *position, char value);

// добавляет корень
BinaryTreeElement *insertRoot(BinaryTree *tree, char value);

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
BinaryTreeElement *returnRightPosition(BinaryTree *tree, BinaryTreeElement *position);

// возвращает позицию родителя
BinaryTreeElement *returnParentPosition(BinaryTree *tree, BinaryTreeElement *position);

// проходит дерево в обратном порядке
void postorder(BinaryTree *tree, BinaryTreeElement *position);

