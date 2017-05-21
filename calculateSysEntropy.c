#include <windows.h>
#include <winbase.h>
#include <stdio.h>
#include <intrin.h>
#include <signal.h>
#include <conio.h>
#pragma intrinsic(__rdtsc)
#pragma intrinsic(__rdpmc(void))
/*The meaning of "#pragma intrinsic" (note spelling), as with all "#pragma" directives, varies from one compiler to another. Generally, it indicates that a particular thing that looks syntactically like a call to an external function should be replaced with some inline code. In some cases, this may greatly improve performance, especially if the compiler can determine constant values for some or all of the arguments (in the latter situation, the compiler may be able to compute the value of the function and replace it with a constant).

Generally, having functions processed as intrinsic won't pose any particular problem. The biggest danger is that if a user defines in one module a function with the same name as one of the compiler's intrinsic function, and attempts to call that function from another module, the compiler might instead replace the function call with its expected instruction sequence. To prevent this, some compilers don't enable intrinsic functions by default (since doing so would cause the above incompatibility with some standard-conforming programs) but provide #pragma directives to do enable them. Compilers may also use command-line option to enable intrinsics (since the standard allows anything there), or may define some functions like __memcpy() as intrinsic, and within string.h, use a #define directive to convert memcpy into __memcpy (since programs that #include string.h are not allowed to use memcpy for any other purpose).*/
/*void rdtsc()
{
	printf("Inside Unreserverd Function");
}*/
/*void __printf()
{
	__printf("Inside");
}*/
int main()
{
	FILE *fp;
	long long int Par1,Par2,Par3;
	unsigned __int64 Par4,Par5;
	fp=fopen("Entropy.txt","w+");
	Par1=GetTickCount();
	fprintf(fp,"%lld",Par1);
	fprintf(fp,"\n");
	Par2=GetCurrentThreadId();
	fprintf(fp,"%lld",Par2);
	fprintf(fp,"\n");
	Par3=GetCurrentProcessId();
	fprintf(fp,"%lld",Par3);
	fprintf(fp,"\n"); 
	Par4=  __rdtsc();   //Reserved Identifiers
	//Par5= __rdpmc();
	fprintf(fp,"%I64d",Par4);
	fprintf(fp,"\n");
	// rdtsc();  unreserved Implementation.
	fclose(fp);
	return 0;
}