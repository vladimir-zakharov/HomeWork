#include <iostream>

using namespace std;

void main()
{
	const int sizeA = 15;
	int a[sizeA], amountAi[10];

	for (int i = 0; i < sizeA; i++)
	{
		cin >> a[i];
	}

	for (int i = 0; i < 10; i++)
		amountAi[i] = 0;

	for (int i = 0; i < sizeA; i++)
		amountAi[a[i]]++;

	for (int i = 0; i < 10; i++)
		while (amountAi[i] > 0)
		{
			cout << i << ' ';
			amountAi[i]--;
		}
		cout << "\n";
}


