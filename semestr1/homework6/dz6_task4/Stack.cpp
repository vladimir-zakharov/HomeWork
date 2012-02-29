#include <iostream>
#include "Stack.h"

struct StackElement
{
	char value;
	StackElement *next;
};

struct Stack
{
	StackElement *head;
	char count;
};

Stack *createStack()
{
	Stack *result = new Stack;
	result->head = NULL;
	result->count = 0;
	return result;
}

void push(Stack *stack, char value)
{
	StackElement *newHead = new StackElement;
	newHead->next = stack->head;
	newHead->value = value;
	stack->head = newHead;
	stack->count++;
}

int pop(Stack *stack)
{
	if (stack->head != NULL)
	{
		int result = stack->head->value;
		StackElement *temp = stack->head;
		stack->head = stack->head->next;
		delete temp;
		stack->count--;
		return result;
	}
	else
		return ' ';
}

int returnHeadValue(Stack *stack)
{
	return (stack->head == NULL) ? ' ' : stack->head->value;
}

void deleteStack(Stack *stack)
{
	StackElement *temp = stack->head;
	
	while (temp != NULL)
	{
		stack->head = stack->head->next;
		delete temp;
		temp = stack->head;
	}
	
	delete stack;
}

int returnAmountElements(Stack *stack)
{
	return stack->count;
}