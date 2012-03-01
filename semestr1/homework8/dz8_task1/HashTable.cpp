#include <iostream>
#include "HashTable.h"
#include "List.h"

const int hashSize = 100;

struct HashTable
{
	List *buckets[hashSize];
};

HashTable *createHashTable()
{
	HashTable *result = new HashTable;

	for (int i = 0; i < hashSize; i++)
		result->buckets[i] = createList();

	return result;
}

int sizeHashTable(HashTable *hash)
{
	return hashSize;
}

int hashFunction(char *value)
{
	int result = 0;

	for (int i = 0; value[i] != '\0'; i++)
	{
		result = (result + value[i]) % hashSize;
	}
	
	return result;
}

void addToHash(HashTable *hash, char *string)
{
	int index = hashFunction(string);
	bool successfulySearch = exists(hash->buckets[index], string);

	if (!successfulySearch)
		addToEnd(hash->buckets[index], string);
}

void deleteHashTable(HashTable *hash)
{
	for (int i = 0; i < hashSize; i++)
		deleteList(hash->buckets[i]);

	delete hash;
}

void printHash(HashTable *hash)
{
	for (int i = 0; i < hashSize; i++)
	{
		List *list = hash->buckets[i];
		ListElement *position = firstElement(list);
		int sizeList = returnAmountList(list);

		for (int j = 0; j < sizeList; j++)
		{
			std::cout << returnValuePosition(list, position) << ' ' << returnAmountElement(list, position) << std::endl;;
			position = nextElement(list, position);
		}
	}
}