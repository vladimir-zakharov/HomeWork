#include<iostream>

using namespace std;
int main()
{
	int a[28];
	for(int i = 0; i < 28; i++)
		a[i] = 0;

	for(int i = 0; i < 10; i++)
		for(int j = 0; j < 10; j++)
			for(int k = 0; k < 10; k++)
				a[i + j + k]++;

	int sum = 0;
	for(int i = 0; i < 28; i++)
		sum = sum + a[i] * a[i];
	cout << sum << '\n';
	return 0;
}
