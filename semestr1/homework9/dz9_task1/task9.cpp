#include <iostream>
#include <clocale>
#include <fstream>
#include "List.h"

using namespace std;

typedef ListElement* Position;

bool isExist(int townsExist[50], int size, int number)
{
	for (int i = 0; i < size; i++)
		if (number == townsExist[i])
			return true;

	return false;
}

int minRoad(int townExist[50], int count, int mass[50][50], int size, int number)
{
	int min = 30000;
	int minNumber = -1;

	for (int i = 0; i < size; i++)
	{
		if (mass[number][i] != 0 && !isExist(townExist, count, i))
		{
			if (mass[number][i] < min)
			{
				min = mass[number][i];
				minNumber = i;
			}
		}
	}

	if (minNumber != -1)
	{
		for (int j = 0; j < size; j++)
		{	
			if (mass[minNumber][j] != 0)
				if (mass[number][j] == 0 || (mass[minNumber][j] < mass[number][j]))
					mass[number][j] = mass[minNumber][j];
		}
	}

	return minNumber;
}

int main()
{
	setlocale(LC_ALL, "RUS");
	int n = 0;
	int mass[50][50];
	List *capital[50];
	int townsExist[50];
	int k = 0;
	int count = 0;

	ifstream in("input.txt");
	
	if (in)
	{
		int m = 0;
		in >> n >> m;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				mass[i][j] = 0;

		int i = 0;
		int j = 0;
		int length = 0;
		
		for (int p = 0; p < m; p++)
		{
			in >> i >> j >> length;
			mass[i][j] = length;
			mass[j][i] = length;
		}
		
		in >> k;
		int capitalNumber = 0;

		for (int i = 0; i < k; i++)
		{
			in >> capitalNumber;
			capital[i] = createList();
			addToEnd(capital[i], 0, capitalNumber);
			townsExist[count] = capitalNumber;
			count++;
		}
	}

	while (count < n)
	{
		for (int i = 0; i < k; i++)
		{
			if (count < n)
			{
				Position position = firstElement(capital[i]);
				int capitalNumber = returnNumberPosition(capital[i], position);
				int minNumber = minRoad(townsExist, count, mass, n, capitalNumber);

				if (minNumber != -1)
				{
					addToEnd(capital[i], 0, minNumber);
					townsExist[count] = minNumber;
					count++;
				}
			}
		}
	}

	for (int i = 0; i < k; i++)
	{
		cout << "Государство " << i + 1 << ": ";
		printList(capital[i]);
	}

	for (int i = 0; i < k; i++)
		deleteList(capital[i]);

	return 0;
}