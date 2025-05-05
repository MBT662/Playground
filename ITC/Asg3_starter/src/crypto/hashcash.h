#ifndef HASHCASH
#define HASHCASH

#include <openssl/conf.h>
#include <openssl/evp.h>
#include <openssl/err.h>
#include <string.h>
#include <memory.h>
#include <openssl/crypto.h>
#include <math.h>

#define MAX_NONCE 99999999999999999

unsigned int get_digest(char *in, unsigned char *out);
unsigned int proof_of_work(char* message, char difficulty);

#endif
