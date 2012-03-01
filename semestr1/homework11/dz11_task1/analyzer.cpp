#include "analyzer.h"
#include <string.h>

bool isReal(char *string)
{
	int state = 0;

	for (unsigned int i = 0; i < strlen(string); i++)
	{
		switch (state)
		{
			case 0:
			{
				if (string[i] >= '0' && string[i] <= '9')
					state = 1;
				else
					state = -1;
				break;
			}
			case 1:
			{
				if (string[i] >= '0' && string[i] <= '9')
					state = 1;
				else if (string[i] == '.')
				{
					state = 2;
				}
				else if (string[i] == 'E')
					state = 4;
				else
					state = -1;
				break;
			}
			case 2:
			{
				if (string[i] >= '0' && string[i] <= '9')
					state = 3;
				else
					state = -1;
				break;
			}
			case 3:
			{
				if (string[i] >= '0' && string[i] <= '9')
					state = 3;
				else if (string[i] == 'E')
				{
					state = 4;
				}
				else
					state = -1;
				break;
			}
			case 4:
			{
				if (string [i] == '+' || string[i] == '-')
					state = 5;
				else if (string[i] >= '0' && string[i] <= '9')
					state = 6;
				else
					state = -1;
				break;
			}
			case 5:
			{
				if (string[i] >= '0' && string[i] <= '9')
					state = 6;
				else
					state = -1;
			}
			case 6:
			{
				if (string[i] >= '0' && string[i] <= '9')
					state = 6;
				else
					state = -1;
				break;
			}
			case -1:
			{
				return false;
			}
		}
	}

	return !(state == -1 || state == 2 || state == 4 || state == 5);
}