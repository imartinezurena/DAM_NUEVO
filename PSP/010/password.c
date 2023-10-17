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
int main(void)
{
  int i; // variable contador para el bucle
  int j;
  int a;
  int b;
  unsigned char result[EVP_MAX_MD_SIZE];
  unsigned int result_len;
  char string[5] = {i, a, b, j, '\0'};
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
          
          printf("%s da %s ", string, result); // imprimimos el caracter

        }
      }
    }
  }

  return 0;
}
