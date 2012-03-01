#include <iostream>
#include <clocale>

using namespace std;

const int sizeLine = 3;
const int sizeColumn = 3;

void printMass(int mass[sizeLine][sizeColumn])
{
	for (int i = 0; i < sizeLine; i++)
	{
		for (int j = 0; j < sizeColumn; j++)
			cout << mass[i][j] << ' ';
		cout << endl;
	}
}

int main()
{
	setlocale(LC_ALL, "RUS");

	struct LineMin
	{
		int i;
		int j;
		int value;
	};

	struct ColumnMax
	{
		int i;
		int j;
		int value;
	};

	LineMin lineMin[sizeLine];
	ColumnMax columnMax[sizeColumn];
	int mass[sizeLine][sizeColumn];
	
	for (int i = 0; i < sizeLine; i++)
		for (int j = 0; j < sizeColumn; j++)
			cin >> mass[i][j];

	for (int i = 0; i < sizeLine; i++)
	{
		lineMin[i].i = i;
		lineMin[i].j = 0;
		lineMin[i].value = mass[i][0];
	}

	for (int j = 0; j < sizeColumn; j++)
	{
		columnMax[j].i = 0;
		columnMax[j].j = j;
		columnMax[j].value = mass[0][j];
	}
	
	for (int i = 0; i < sizeLine; i++)
	{
		for (int j = 0; j < sizeColumn; j++)
		{
			if (mass[i][j] < lineMin[i].value)
			{
				lineMin[i].value = mass[i][j];
				lineMin[i].i = i;
				lineMin[i].j = j;
			}

			if (mass[i][j] > columnMax[j].value)
			{
				columnMax[j].value = mass[i][j];
				columnMax[j].i = i;
				columnMax[j].j = j;
			}
		}
	}
	cout << "Седловые точки:\n";

	for (int i = 0; i < sizeLine; i++)
	{
		for (int j = 0; j < sizeColumn; j++)
		{
			if (lineMin[i].i == columnMax[j].i && lineMin[i].j == columnMax[j].j)
				cout << lineMin[i].value << ' ';
		}
	}

	cout << endl;
	return 0;
}