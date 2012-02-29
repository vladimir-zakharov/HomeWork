#pragma once

struct Stack;

// кладет элемент в стек
void push(Stack *stack, char value);

// снимает элемент со стека и возвращает значение снятого элемента
char pop(Stack *stack);

// создает новый стек
Stack *createStack();

// возвращает значение верхнего элемента стека
char returnHeadValue(Stack *stack);

// удалет стек
void deleteStack(Stack *stack);