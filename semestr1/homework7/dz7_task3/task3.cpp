/*Тесты
1)
(* (+ 1 1) 2)
Результат: 4
2)
(* (+ 1 1) (- (+ 5 5) (/ 8 4)))
Результат: 16
*/
#include <iostream>
#include <fstream>
#include <clocale>
#include "BinaryTree.h"

using namespace std;

void initTree(BinaryTree *tree, BinaryTreeElement *position, int &count, int size, char *string, int key)
{	
	if (count < size)
	{
		if (string[count] == ')')
			count++;

		char parent = ' ';
		parent = string[count];
		count++;
		
		switch(key)
		{
			case 0:
			{
				position = insertRoot(tree, parent);
				break;
			}
			case 1:
			{
				position = insertLeftChild(tree, position, parent);
				break;
			}
			case 2:
			{
				position = insertRightChild(tree, position, parent);
				break;
			}
		}

		char left = ' ';
		char right = ' ';

		if (string[count] == ')')
			count++;
		left = string[count];
		count++;

		if (left == '(')
		{
			key = 1;
			initTree(tree, position, count, size, string, key);
		}
		else
			insertLeftChild(tree, position, left);

		if (string[count] == ')')
			count++;
		right = string[count];
		count++;

		if (right == '(')
		{
			key = 2;
			initTree(tree, position, count, size, string, key);
		}
		else 
			insertRightChild(tree, position, right);
	}
}

int main()
{
	setlocale(LC_ALL, "RUS");
	BinaryTree *tree = createBinaryTree();
	BinaryTreeElement *position = returnRootPosition(tree);
	ifstream in("input.txt");
	char string[256];
	int i = 0;

	if (in)
	{
		while (!in.eof())
		{
			char symbol = ' ';
			in >> symbol;
			string[i] = symbol;
			i++;
			cout << symbol << ' ';
		}

		in.close();
	}

	cout << endl;
	int count = 1;
	initTree(tree, position, count, i, string, 0);
	postorder(tree, returnRootPosition(tree));
	position = returnRootPosition(tree);
	int result = returnValuePosition(tree, position) - '0';
	cout << "Результат: " << result << endl;
	deleteTree(tree);
	return 0;
}