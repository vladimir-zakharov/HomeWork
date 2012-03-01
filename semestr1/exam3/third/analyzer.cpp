#include <string.h>
#include "analyzer.h"

bool isSuitable(char *string)
{
	int state = 0;

	for (int i = 0; i < strlen(string); i++)
	{
		switch(state)
		{
			case 0:
			{
				if ((string[i] >= 'A' && string[i] <= 'Z') || (string[i] >= 'a' && string[i] <= 'z'))
					state = 1;
				else
					state = -1;
				break;
			}
			case 1:
			{
				if ((string[i] >= 'A' && string[i] <= 'Z') || (string[i] >= 'a' && string[i] <= 'z'))
					state = 1;
				else if (string[i] >= '0' && string[i] <= '9')
					state = 1;
				else if(string[i] == '_')
					state = 1;
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

	return (state != -1);
}