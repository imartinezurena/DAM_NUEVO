#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>
#define MD5_LEN 16

void generateMD5(const char *string, unsigned char *str_result)
{
  EVP_MD_CTX *ctx;
  const EVP_MD *md;
  unsigned char result[EVP_MAX_MD_SIZE];

  ctx = EVP_MD_CTX_new();
  md = EVP_md5();

  EVP_DigestInit_ex(ctx, md, NULL);
  EVP_DigestUpdate(ctx, string, strlen(string));
  EVP_DigestFinal_ex(ctx, result, NULL);

  EVP_MD_CTX_free(ctx);

  for (int i = 0; i < MD5_LEN; i++)
  { // MD5 result is always 16 bytes
    sprintf(str_result + (i * 2), "%02x", result[i]);
  }
}
int main(void){
  int i; // variable contador para el bucle
  int j;
  int a;
  int b;
  int d;
  unsigned char result[EVP_MAX_MD_SIZE];
  unsigned int result_len;
  unsigned char resultado[EVP_MAX_MD_SIZE];
  unsigned int resultado_len;
  char string[5] = {i, a, b, j, '\0'};
  char contra[6] = {i, a, b, j, d, '\0'};
   int auxiliar; //variable contador para el bucle
  
 
  /*for(auxiliar=0; auxiliar<256; auxiliar++)//bucle for que recorre los 256 caracteres ASCII
    {
      printf("%d\t-\t%c\n", auxiliar, auxiliar);//imprimimos el número y el caracter
    }*/
  
 for (i = 97; i < 123; i++)
  {
    for (a = 97; a < 123; a++)
    {
      for (b = 97; b < 123; b++)
      {
        for (j = 97; j < 123; j++) // bucle for que recorre los caracteres ASCII
        {
          string[0] = i;
          string[1] = a;
          string[2] = b;
          string[3] = j;
          generateMD5(string, result);
          if(strcmp(result,"582fc884d6299814fbd4f12c1f9ae70f")==0){
          printf("%s da %s \n", string, result); // imprimimos el caracter
          }
          else if(strcmp(result,"74437fabd7c8e8fd178ae89acbe446f2")==0){
          printf("%s da %s \n", string, result); // imprimimos el caracter
          }
          else if(strcmp(result,"28ea19352381b8659df830dd6d5c90a3")==0){
          printf("%s da %s \n", string, result); // imprimimos el caracter
          }
          else if(strcmp(result,"90f077d7759d0d4d21e6867727d4b2bd")==0){
          printf("%s da %s \n", string, result); // imprimimos el caracter
          }
        }
      }
    }
  }
  
  for (i = 65; i < 123; i++)
  {
    for (a = 65; a < 123; a++)
    {
      for (b = 65; b < 123; b++)
      {
        for (j = 65; j < 123; j++) 
        {
          for (d = 65; d < 123; d++) // bucle for que recorre los caracteres ASCII
        {
          contra[0] = i;
          contra[1] = a;
          contra[2] = b;
          contra[3] = j;
          contra[4] = d;
          generateMD5(contra, resultado);
          if(strcmp(resultado,"f4a1c8901a3d406f17af67144a3ec71a")==0){
          printf("%s da %s \n", contra, resultado); 
          }
          else if(strcmp(resultado,"d66e29062829e8ae0313adc5a673f863")==0){
          printf("%s da %s \n", contra, resultado); // imprimimos el caracter
          }
        }
      }
    }
  }
}  

  return 0;
}
