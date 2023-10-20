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
   int auxiliar; 

   pid_t tenedor;
  tenedor=fork();
  if(tenedor!=0){
    for (i = 65; i < 90; i++)
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
        
        
    }else{
      for (i = 97; i <123 ; i++)
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
        
    }
}