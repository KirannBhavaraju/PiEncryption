//successful
//pi generator + save values to file
#include<stdio.h> 
#include<stdlib.h>  
  
#define SCALE 10000  
#define ARRINIT 2000  
  
void pi_digits(int digits)
{  
	FILE *fp;
	fp=fopen("piraw.txt","w");
    int carry = 0;
	int count=0;
	int val;  
    int arr[digits + 1];  
    for (int i = 0; i <= digits; ++i)  
        arr[i] = ARRINIT;  
    for (int i = digits; i > 0; i-= 14)
	 {  
        int sum = 0;  
        for (int j = i; j > 0; --j)
		 {  
            sum = sum * j + SCALE * arr[j];  
            arr[j] = sum % (j * 2 - 1);  
            sum /= j * 2 - 1;  
        }  
       // printf("%0.4d", carry + sum / SCALE);
		val=carry+sum/SCALE;
        fprintf(fp,"%d",val);
        //fputs("\n",fp); 
        count++; 
        carry = sum % SCALE;  
    } 
	count=count*4; 
    printf("\n");  
  	printf("%d", count);
  	fclose(fp);
}  
  
int main(int argc, char** argv) {  
    int n = argc == 2 ? atoi(argv[1]) : 100;  
    pi_digits(500000);
    return 0;  
}  