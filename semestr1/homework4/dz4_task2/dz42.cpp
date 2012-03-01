#include <iostream>
#include <ctime>
#include <fstream>
#include "qSort.h"

using namespace std;
       
void main()
{
	int const sizeA = 15;
	int a[sizeA];
	srand((unsigned)time(NULL));
	ofstream write("input.txt");

	for (int i = 0; i < sizeA - 1; i++)
		write << rand() % 16 << ' ';

	write << rand() % 16;
	write.close();
	ifstream in("input.txt");
	int i = 0;
	
	while (!in.eof())
	{
		in >> a[i];
		i++;
	}

	in.close();
	qSort(a, 0, i - 1);
	int max = 1;
	int elem = a[0];
	int count = 1;

	for (int i = 1; i < sizeA; i++)
	{
		if (a[i] == a[i - 1])
			count++;
		else
		{
			if (count > max)
			{
				max = count;
				elem = a[i - 1];
			}
			count = 1;
		}
	}

	if (count > max)
	{
		max = count;
		elem = a[sizeA - 1];
	}

	cout << elem << "\n";
}