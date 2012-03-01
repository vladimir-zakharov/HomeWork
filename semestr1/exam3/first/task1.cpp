#include <iostream>
#include <clocale>
#include "Set.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	int n = -1;
	Set *set = createSet();
	
	while (n != 0)
	{
		cin >> n;
		addToSet(set, n);
	}

	cout << "Введенные числа в пордяке возрастания\n";
	printSetIncreasing(set);
	deleteSet(set);
	return 0;
}