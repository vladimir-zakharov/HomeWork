#include <iostream>

using namespace std;

void reversal(int x[], int begin, int end)
{
	for (int i = begin; i < begin + (end - begin) / 2; i++)
	{
		x[i] = x[i] + x[end - i + begin - 1];
		x[end - i + begin - 1] = x[i] - x[end - i + begin - 1];
		x[i] = x[i] - x[end - i + begin - 1];
	}
}

int main()
{
	int m = 0, n = 0;
	cin >>  m >> n;
	int x[20];
	for (int i  = 0; i < m + n; i++)
		cin >> x[i];
	reversal(x, 0, m);
	reversal(x, m, m + n);
	reversal(x, 0, m + n);
	for (int i = 0; i < m + n; i++)
		cout << x[i] << ' ';
	cout << '\n';
	return 0;
}

