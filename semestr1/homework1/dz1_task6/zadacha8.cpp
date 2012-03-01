#include<iostream>

using namespace std;
int main()
{
	char s[20], s1[20];
	cin >> s >> s1;
	int count = 0;
	bool f = true;
	for (int i = 0; i < strlen(s)-strlen(s1)+1; i++)
	{
		f = true;
		for (int j = 0; j < strlen(s1); j++)
		{
			if (s[i+j] != s1[j])
				f = false;
		}
		if (f)
			count++;
	}
	cout << count << '\n';
	return 0;
}

