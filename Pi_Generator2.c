#include <stdio.h>	//this program generates numbered key and saves it in numbered format named piraw-fin.txt
#include <stdlib.h>

int main()
{

    FILE *myFile;
    myFile = fopen("piraw.txt", "r");
    FILE *fp = fopen("piraw-fin.txt", "w");

    //read file into array
    int numberArray[35715];
    int i,a,b,c,d,value;

    if (myFile == NULL)
    {
        printf("Error Reading File\n");
        exit (0);
    }
    for (i = 0; i < 35715; i++)
    {
        fscanf(myFile, "%d,", &numberArray[i] );

    }

    for (i = 0; i < 35715; i++)
    {
    		value= numberArray[i];
    		a=numberArray[i]%10;
    		numberArray[i]=numberArray[i]-a;
    		numberArray[i]=numberArray[i]/10;
    		b=numberArray[i]%10;
    		numberArray[i]=numberArray[i]-b;
    		numberArray[i]=numberArray[i]/10;
    		c=numberArray[i]%10;
    		numberArray[i]=numberArray[i]-c;
    		numberArray[i]=numberArray[i]/10;
    		d=numberArray[i]%10;
    		numberArray[i]=numberArray[i]-d;

           printf("Number is: %d\n", value);
           fprintf(fp,"%d",d);
           fputs("\n",fp);
           fprintf(fp,"%d",c);
           fputs("\n",fp);
           fprintf(fp,"%d",b);
           fputs("\n",fp);
           fprintf(fp,"%d",a);
           fputs("\n",fp);
        }

    fclose(myFile);
    fclose(fp);

    return 0;
}