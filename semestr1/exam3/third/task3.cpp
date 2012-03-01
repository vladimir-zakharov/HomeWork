#include <iostream>
#include <clocale>
#include "analyzer.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	cout << "Введите строку\n";
	char string[256];
	cin >> string;
	bool flag = isSuitable(string);

	if (flag)
		cout << "Введенная строка подходит\n";
	else
		cout << "Введенная строка не подходит\n";
	return 0;
}