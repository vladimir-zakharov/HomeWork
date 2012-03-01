#include <iostream>
#include <fstream>
#include <clocale>
#include "HashTable.h"
#include "List.h"

using namespace std;

int main()
{
	ifstream in("input.txt");
	HashTable *hash = createHashTable();
	
	if (in)
	{
		while (!in.eof())
		{
			char string[256];
			in >> string;
			if (string[0] != NULL)
			{
				addToHash(hash, string);
			}
		}

		in.close();
	}

	printHash(hash);
	deleteHashTable(hash);
	return 0;
}