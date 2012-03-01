#include <stdio.h>

void main() 
{ 
	FILE* file = fopen("input.txt","r"); 
	char symbol = ' ';

	while (!feof(file))
	{
		char string[256] = " ";
		fscanf(file, "%c", &symbol);
		
		if (symbol == ';')
		{
			fgets(string, sizeof(string), file); 
			printf("%c%s", ';', string);
		}
		
	}
 
	fclose(file);
}