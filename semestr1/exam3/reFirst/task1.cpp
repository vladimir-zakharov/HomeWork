#include <iostream>

using namespace std;

int main()
{
	char string[256];
	cin >> string;
	int b = 1;
	int result = 0;

	for (int i = strlen(string) - 1; i >= 0; i--)
	{
		result += (string[i] - '0') * b;
		b = b * 2;
	}

	cout << result << endl;
	return 0;
}