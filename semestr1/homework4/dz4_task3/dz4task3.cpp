#include <stdio.h>

void main() 
{ 
	FILE* file = fopen("input.txt","r"); 
	int count = 0;

	while (!feof(file))
	{
		char string[256] = " ";
		fgets(string, sizeof(string), file); 

		for (int i = 0; i < sizeof(string); i++)
			if (string[i] != ' ' && string[i] != 9 && string[i] != 10 && string[i] != 0)
				count++;
	}
 
	fclose(file); 
	printf("%d\n", count);
}