#include <iostream>

using namespace std;

int exp(int x, int stepen)
{
	int result = 1;

	while (stepen > 0)
	{
		if (stepen % 2 == 0) 
		{
			stepen = stepen / 2;
			x = x * x;
		}
		else 
		{
			stepen--;
			result = result * x;
		}
	}

	return result;
}

void main()
{
	int x = 0, stepen = 0;
	cin >> x >> stepen;
	cout << exp(x, stepen) << "\n";
}

