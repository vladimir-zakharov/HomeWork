#include <iostream>
#include <string.h>
#include <clocale>
#include "Kmp.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	char string[256];
	char text[256];
	cin >> string;
	int count = 0;
	bool successfulySearch = false;

	FILE *file = fopen("input.txt","r");
	
	if (file)
	{
		while (!feof(file))
		{
			int temp = 0;
			fgets(text, sizeof(text), file);
			temp = kmp(string, strlen(string), text, strlen(text));

			if (temp + count != count)
			{
				count += temp;
				successfulySearch = true;
				break;
			}

			count += strlen(text) - 1;
		}
	}
	fclose(file);

	if (successfulySearch)
		cout << "Позиция первого вхождения введённой строки в файле: " << count << endl;
	else
		cout << "В файле нет такой строки\n";

	return 0;
}