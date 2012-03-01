#include <iostream>
#include <clocale>
#include "Set.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	int value = 0;
	int mass[50][50];
	int minSpanningTree[50][50];
	int mark[50];
	char symbol = ' ';
	int size = 1;
	FILE *file = fopen("input.txt", "r");
	int i = 0;
	int j = 0;

	if (file)
	{
		while (!feof(file))
		{
				fscanf(file, "%d", &mass[i][j]);
				fscanf(file, "%c", &symbol);
				j++;

				if (symbol == '\n')
				{
					j = 0;
					size++;
					i++;
				}
		}
	}

	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
			cout << mass[i][j] << ' ';
		cout << endl;
	}

	cout << endl;

	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			minSpanningTree[i][j] = 0;

	Set *set = createSet();
	int count = 0;
	mark[count] = 0;
	addToSet(set, 0);

	while(amountSet(set) < size)
	{
		int min = 2000000;
		int indexI = -1;
		int indexJ = -1;
		
		for (int i = 0; i <= count; i++)
		{
			for (j = 0; j < size; j++)	
				if (mass[mark[i]][j] != 0)
				{
					if (mass[mark[i]][j] < min)
						if (!exists(set, j))
						{
							min = mass[mark[i]][j];
							indexI = mark[i];
							indexJ = j;
						}
				}
		}

		minSpanningTree[indexI][indexJ] = min;
		minSpanningTree[indexJ][indexI] = min;
		count++;
		mark[count] = indexJ;
		addToSet(set, indexJ);
	}

	cout << "Минимальное остовное дерево, заданное матрицей смежности:\n";

	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
			cout << minSpanningTree[i][j] << ' ';
		cout << endl;
	}

	deleteSet(set);
	return 0;
}