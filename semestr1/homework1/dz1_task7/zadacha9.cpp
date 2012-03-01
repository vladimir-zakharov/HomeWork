#include<iostream>

using namespace std;
int main()
{
	int n = 0;
	cin >> n;
	bool f = true;
	float sqrtI = 0.0;
	for (int i = 2; i <= n; i++)
	{
		f=true;
		sqrtI = i;
		for (int j = 2; j <= sqrt(sqrtI); j++)
		if (i % j == 0)
			{
				f = false;
				break;
			}
		if (f)
			cout << i << ' ';
	}
	cout << '\n';
	return 0;
}
		