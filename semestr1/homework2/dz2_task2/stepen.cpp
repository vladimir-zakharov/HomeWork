#include <iostream>

using namespace std;

void main()
{
	int x = 0, stepen = 0;
	cin >> x >> stepen;
	int result = 1;

	for (int i = 1; i <= stepen; i++)
		result = result * x;

	cout << result << "\n";
}