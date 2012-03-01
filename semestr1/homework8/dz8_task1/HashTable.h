#pragma once

struct HashTable;

// создает новую хеш таблицу
HashTable *createHashTable();

// возвращает размер хэш таблицы
int sizeHashTable(HashTable *hash);

// добавляет элемент в хеш таблицу
void addToHash(HashTable *hash, char *string);

// удаляет хеш таблицу
void deleteHashTable(HashTable *hash);

// выводит хеш таблицу на экран
void printHash(HashTable *hash);