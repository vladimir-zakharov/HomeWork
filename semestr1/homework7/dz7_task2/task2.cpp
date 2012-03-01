/* Тесты:
займут слишком много места

Фактическое время: 3 часа
Ожидаемое время: 2-3 часа
*/

#include <iostream>
#include <clocale>
#include "BinarySearchTree.h"

using namespace std;

void comands()
{
	cout << "\nВведите цифру от 0 до 5:\n";
	cout << "0 - выход\n";
	cout << "1 - добавить значение в множество\n";
	cout << "2 - удалить значение из множества\n"; 
	cout << "3 - проверить, есть ли элемент в множестве\n";
	cout << "4 - распечатать текущие элементы множества в возрастающем порядке\n";
	cout << "5 - распечатать текущие элементы множества в убывающем порядке\n\n";
} 

void inorder(BinaryTree *tree, BinaryTreeElement *position)
{
	BinaryTreeElement *temp = position;
	
	if (temp == NULL) 
		return;
	temp = returnLeftPosition(tree, position);
	inorder(tree, temp);
	cout << returnValuePosition(tree, position) << ' ';
	temp = returnRigthPosition(tree, position);
	inorder(tree, temp);
}

void antiInorder(BinaryTree *tree, BinaryTreeElement *position)
{
	BinaryTreeElement *temp = position;
	
	if (temp == NULL) 
		return;
	temp = returnRigthPosition(tree, position);
	antiInorder(tree, temp);
	cout << returnValuePosition(tree, position) << ' ';
	temp = returnLeftPosition(tree, position);
	antiInorder(tree, temp);
}

int main()
{
	setlocale(LC_ALL, "RUS");
	BinaryTree *tree = createBinaryTree();
	int key = -1;

	while (key != 0)
	{
		comands();
		cin >> key;

		if (key == 1)
		{
			int value = 0;
			cout << "Введите целое число, которое Вы бы хотели добавить в множество\n";
			cin >> value;
			if (search(tree, value))
			{
				cout << "В множестве уже есть элемент с таким значением\n";
			}
			else
			{
				insert(tree, value);
				cout << "Добавлено\n";
			}
		}

		if (key == 2)
		{
			int value = 0;
			cout << "Введите целое число, которое Вы бы хотели удалить из множества\n";
			cin >> value;
			bool successfulyDelete = deleteElement(tree, value);

			if (successfulyDelete)
				cout << "Удалено\n";
			else
				cout << "Нет такого значения\n";
		}

		if (key == 3)
		{
			int value = 0;
			cout << "Введите целое число, которое Вы бы хотели проверить\n";
			cin >> value;
			bool successfulySearch;
			successfulySearch = search(tree, value);

			if (successfulySearch)
				cout << "Есть такое значение\n";
			else
				cout << "Нет такого значения\n";
		}

		if (key == 4)
		{
			cout << "Текущие элементы множества в возрастающем порядке:\n";
			BinaryTreeElement *position = returnRootPosition(tree);
			inorder(tree, position);
		}

		if (key == 5)
		{
			cout << "Текущие элементы множества в убывающем порядке:\n";
			BinaryTreeElement *position = returnRootPosition(tree);
			antiInorder(tree, position);
		}
	}

	deleteTree(tree);
	return 0;
}