#include "Kmp.h"

void prefixFunction(char *string, int sizeString, int prefix[])
{
	int j = -1; 
	prefix[0] = -1;

	for (int i = 0; i < sizeString; i++)
	{
		while (j > -1 && string[i] != string[j])
			j = prefix[j];

		j++;

		if (string[i] == string[j])
			prefix[i] = prefix[j];
		else
			prefix[i] = j;
	}
}

int kmp(char *string, int sizeString, char *text, int sizeText)
{
	int i = 0;
	int j = 0;
	int prefix[1000];

	prefixFunction(string, sizeString, prefix);

	while (j < sizeText) 
	{
		while (i > -1 && string[i] != text[j])
			i = prefix[i];

		i++;
		j++;

		if (i == sizeString) 
		{
			return j - i + 1;
		}
	}

	return 0;
}