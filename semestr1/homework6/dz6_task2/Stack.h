#pragma once

struct Stack;

//кладет элемент в стек
void push(Stack *stack, int value);

//снимает элемент со стека и возвращает значение снятого элемента
int pop(Stack *stack);

//создает новый стек
Stack *createStack();

//возвращает значение верхнего элемента стека
int returnHeadValue(Stack *stack);

//возвращает количество элементов в стеке
int returnAmountElements(Stack *stack);

//удалет стек
void deleteStack(Stack *stack);