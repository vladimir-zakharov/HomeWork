#pragma once

struct ListIndex;
struct ListMass;

//typedef ListIndex* List;
typedef ListMass* List;

// сортирует список слиянием
List mergeSort(List list);