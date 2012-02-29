/*Тесты
1) ({)} 
Нет баланса скобок
2) ({})
Баланс скобок соблюден
3) ({[]})
Баланс скобок соблюден
4) ([{}](
Нет баланса скобок
5) (
Нет баланса скобок
6) )
Нет баланса скобок

ожидаемое: 40 минут
фактическое: 50 минут
*/
#include <iostream>
#include <clocale>
#include <string.h>
#include "Stack.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	Stack *stack = createStack();
	cout << "Введите последовательность скобок вида {}, [], ()\n";
	char string[256];
	cin >> string;
	int size = strlen(string);
	bool flag = true;
	for (int i = 0; i < size; i++)
	{
		if (string[i] == '{' || string[i] == '[' || string[i] == '(')
			push(stack, string[i]);
		else
		{
			char symbol = returnHeadValue(stack);

			if (symbol == ' ')
			{
				flag = false;
				break;
			}

			if (string[i] == '}')
				if (symbol == '{')
					pop(stack);
				else
					break;
			if (string[i] == ']')
				if (symbol == '[')
					pop(stack);
				else
					break;
			if (string[i] == ')')
				if (symbol == '(')
					pop(stack);
				else
					break;
		}
	}

	if (!flag)
		cout << "Нет баланса скобок\n";
	else
	{
		if (returnHeadValue(stack) == ' ')
			cout << "Баланс скобок соблюден\n";
		else
			cout << "Нет баланса скобок\n";
	}

	deleteStack(stack);
	return 0;
}