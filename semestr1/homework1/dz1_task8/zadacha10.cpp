#include<iostream>

using namespace std;
int main()
{
	int a[10], count = 0;
	for(int i = 0; i < 10; i++)
	{
		cin >> a[i];
		if (a[i] == 0)
			count++;
	}
	cout << count << '\n';
	return 0;
}

