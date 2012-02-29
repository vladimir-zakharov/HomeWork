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
};

Stack *createStack()
{
	Stack *result = new Stack;
	result->head = NULL;
	return result;
}

void push(Stack *stack, char value)
{
	StackElement *newHead = new StackElement;
	newHead->next = stack->head;
	newHead->value = value;
	stack->head = newHead;
}

char pop(Stack *stack)
{
	if (stack->head != NULL)
	{
		char result = stack->head->value;
		StackElement *temp = stack->head;
		stack->head = stack->head->next;
		delete temp;
		return result;
	}
	else
		return ' ';
}

char returnHeadValue(Stack *stack)
{
	if (stack->head == NULL)
		return ' ';
	else
		return stack->head->value;
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