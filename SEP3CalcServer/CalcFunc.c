#include <stdio.h>
#include "CalcFunc.h"

JNIEXPORT jdouble JNICALL Java_CalcFunc_sum(JNIEnv *env, jclass cls, jdouble a, jdouble b)
{
	double sum = a + b;
	return sum;
}

JNIEXPORT jdouble JNICALL Java_CalcFunc_subtract(JNIEnv *env, jclass cls, jdouble a, jdouble b)
{
	double subtract = a - b;
	return subtract;
}

JNIEXPORT jdouble JNICALL Java_CalcFunc_multiply(JNIEnv *env, jclass cls, jdouble a, jdouble b)
{
	double multiply = a * b;
	return multiply;
}

JNIEXPORT jdouble JNICALL Java_CalcFunc_divide(JNIEnv *env, jclass cls, jdouble a, jdouble b)
{
	double divide = a / b;
	return divide;
}

