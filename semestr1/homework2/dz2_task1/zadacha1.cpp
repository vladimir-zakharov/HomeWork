#include <iostream>

using namespace std;

int fibonach(int number)
{
	int a[200];
	a[0] = 1;
	a[1] = 1;

	if (number == 0 || number == 1)
		return 1;

	for (int i = 2; i <= number; i++)
		a[i] = a[i - 1] + a[i - 2];

	return a[number];
}

int fibRec(int number)
{
	if (number == 0 || number == 1)
		return 1;
	return  fibRec(number - 1) + fibRec(number - 2);
}


void main()
{
	int number = 0;
	cin >> number;
	//int result = fibonach(number);
	int result = fibRec(number);
	cout << result << "\n";
}
	


