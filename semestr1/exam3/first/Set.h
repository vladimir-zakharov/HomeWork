#pragma once

struct Set;

// создает новое множество
Set *createSet();

// добавляет элемент в множество
void addToSet(Set *set, int value);

// проверяет, есть ли элемент в множестве
bool exists(Set *set, int value);

// возвращает количество элементов в множестве
int amountSet(Set *set);

// удаляет множество
void deleteSet(Set *set);

// распечатывает множество в возрастающем порядке
void printSetIncreasing(Set *set);