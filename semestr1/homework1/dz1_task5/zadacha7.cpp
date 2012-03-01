#include<iostream>
#include<string>

using namespace std;
int main()
{
	char str[20];
	cin >> str;
	int count = 0;
	bool f = true;
	for (int i = 0; i < strlen(str); i++) 
	{
		if (str[i] == '(')
			count++;
		else
			count--;
		if (count < 0)
		{
			cout << "All Bad \n";
			f = false;
			break;
		}
	}
	if (f)
	{
		if (count == 0)
			cout << "Balance \n";
		else
			cout << "No balance \n";
	}
	return 0;
}