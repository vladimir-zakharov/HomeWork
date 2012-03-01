/*
Фактическое время: 55 минут
Ожидаемое: 1 час
*/

#include <iostream>
#include <clocale>
using namespace std;

int move(int table[4][4], char symbol, int state)
{
	if (symbol == '/')
		return table[state][1];
	else if (symbol == '*')
		return table[state][2];
	else
		return table[state][3];
}

int main()
{
	setlocale(LC_ALL, "RUS");
	FILE *file = fopen("input.txt", "r");
	char symbol = ' ';

	int table[4][4] =
	{ 
		// /  *  d
		0, 1, 0, 0, // zero state
		1, 1, 2, 0, // first state
		2, 2, 3, 2, // second state
		3, 0, 3, 2  // third state
	};

	int state = 0;
	char result[256];
	int count = 0;
	
	if (file)
	{
		while (!feof(file))
		{
			symbol = fgetc(file);
			if (symbol != -1)
			{
				int prevState = state;
				state = move(table, symbol, state);

				if (prevState == 1 && state == 2)
				{
					result[count] = '/';
					count++;
				}
				if (state == 2)
				{
					result[count] = symbol;
					count++;
				}
				if (state == 3)
				{
					result[count] = symbol;
					count++;
				}
				if (prevState == 3 && state == 0)
				{
					for (int i = 0; i < count; i++)
					{
						cout << result[i];
						result[i] = '\0';
					}
					cout << "/" << endl;
					count = 0;
				}
			}
		}
	}

	cout << endl;
	fclose(file);
	return 0;
}