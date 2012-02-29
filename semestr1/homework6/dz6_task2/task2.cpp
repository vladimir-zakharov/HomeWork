/*Тесты:
1)
Введите последовательность цифр и опреаций +, -, *, /
96-12+*
Результат: 9
2)
Введите последовательность цифр и опреаций +, -, *, /
11+
Результат: 2
3)
Введите последовательность цифр и опреаций +, -, *, /
12
Ошибка! Неверные входные данные!
4)
Введите последовательность цифр и опреаций +, -, *, /
57+34-*
Результат: -12
5)
Введите последовательность цифр и опреаций +, -, *, /
70/
Ошибка! Неверные входные данные!
6)
Введите последовательность цифр и опреаций +, -, *, /
10+30++
Результат: 4
7)
Введите последовательность цифр и опреаций +, -, *, /
22-
Результат: 0
8)
Введите последовательность цифр и опреаций +, -, *, /
123+
Ошибка! Неверные входные данные!

Ожидаемое время: 40 минут
Фактическое: не знаю даже, я её с перерывами делал,
по-моему чуть больше потратил 
*/

#include <iostream>
#include <clocale>
#include <string.h>
#include "Stack.h"

using namespace std;

bool operation(char symbolOperation, Stack *stack)
{
	int result = 0;
	
	if (returnAmountElements(stack) == 0)
		return false;
	int valueFirst = pop(stack);

	if (returnAmountElements(stack) == 0)
		return false;
	int valueSecond = pop(stack);

	if (symbolOperation == '+')
		result = valueSecond + valueFirst;

	if (symbolOperation == '-')
		result = valueSecond - valueFirst;

	if (symbolOperation == '*')
		result = valueSecond * valueFirst;

	if (symbolOperation == '/')
	{
		if (valueFirst == 0)
			return false;
		else
			result = valueSecond / valueFirst;
	}

	push(stack, result);
	return true;
}

int main()
{
	setlocale(LC_ALL, "RUS");
	Stack *stack = createStack();
	cout << "Введите последовательность цифр и опреаций +, -, *, /\n";
	char string[256];
	cin >> string;
	int size = strlen(string);
	bool successfulyOperation = true;

	for (int i = 0; i < size; i++)
	{
		if (string[i] >= '0' && string[i] <= '9')
			push(stack, string[i] - '0');
		
		if (string[i] == '+' || string[i] == '-' || string[i] == '*'  || string[i] == '/' )
		{
			successfulyOperation = operation(string[i], stack);	
			
			if (!successfulyOperation)
				break;
		}
	}
	
	if (!successfulyOperation)
		cout << "Ошибка! Неверные входные данные!\n";
	else
	{
		int result = pop(stack);
		
		if (returnAmountElements(stack) == 0)
			cout << "Результат: " << result << endl;
		else
			cout << "Ошибка! Неверные входные данные!\n";
	}

	deleteStack(stack);
	return 0;
}