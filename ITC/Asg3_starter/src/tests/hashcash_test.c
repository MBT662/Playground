#include <stdio.h>
#include <string.h>
#include <CUnit/Basic.h>
#include "../crypto/hashcash.h"

#define EPSILON 0.00001
#define SHA1_HASHLEN 20 /* number of bytes in SHA1 message digest */

#define BYTE_ARRAY_TO_STRING_ARRAY(bytes, chars, hash_length)      \
    {                                                              \
        for (int idx = 0; idx < hash_length; idx++)                \
            \ 
                                                         \
            {                                                      \
                char byte_chars[2];                                \
                \ 
        /* converts byte number into ascii chars for comparison */ \
                    sprintf(byte_chars, "%02x", bytes[idx]);       \
                strcat(chars, byte_chars);                         \
                \ 
                                                     \
            }                                                      \
    }

/* Pointer to the file used by the tests. */
static FILE *temp_file = NULL;

/* The suite initialization function.
 * Opens the temporary file used by the tests.
 * Returns zero on success, non-zero otherwise.
 */
int init_suite1(void)
{
    /* Load the human readable error strings for libcrypto */
    ERR_load_crypto_strings();

    /* Load all digest and cipher algorithms */
    OpenSSL_add_all_algorithms();

    return 0;
}

/* The suite cleanup function.
 * Closes the temporary file used by the tests.
 * Returns zero on success, non-zero otherwise.
 */
int clean_suite1(void)
{
    return 0;
}

void test1(void)
{
    unsigned char hash[40] = {'\0'};
    unsigned int hash_len = 0;
    hash_len = get_digest("Hello World", hash);

    CU_ASSERT_EQUAL(hash_len, SHA1_HASHLEN)

    char actual[41] = "\0";
    BYTE_ARRAY_TO_STRING_ARRAY(hash, actual, hash_len)

    char expected[] = "0a4d55a8d778e5022fab701977c5d840bbc486d0\0";
    CU_ASSERT_STRING_EQUAL(actual, expected)
}

void test2(void)
{
    unsigned char hash[40] = {'\0'};
    unsigned int hash_len = 0;
    hash_len = get_digest("Hashing is so fun! I luv CSC!", hash);

    CU_ASSERT_EQUAL(hash_len, SHA1_HASHLEN)

    char actual[41] = "\0";
    BYTE_ARRAY_TO_STRING_ARRAY(hash, actual, hash_len)

    char expected[] = "c06002d67eabe69d4c719f29a95e5c8f13867725\0";
    CU_ASSERT_STRING_EQUAL(actual, expected)
}

void test3(void)
{
    unsigned char hash[40] = {'\0'};
    unsigned int hash_len = 0;

    char message[] = "Hashing is so fun! I luv CSC! \
These messages can be much longer \
and still produce the same length hash.";

    hash_len = get_digest(message, hash);

    CU_ASSERT_EQUAL(hash_len, SHA1_HASHLEN)

    char actual[41] = "\0";
    BYTE_ARRAY_TO_STRING_ARRAY(hash, actual, hash_len)

    char expected[] = "17f5e7847844fb5ec17d14b559bc2c4fdfc758da\0";
    CU_ASSERT_STRING_EQUAL(actual, expected)
}

void test4(void)
{
    unsigned char hash[40] = {'\0'};
    unsigned int hash_len = 0;
    hash_len = get_digest("See!", hash);

    CU_ASSERT_EQUAL(hash_len, SHA1_HASHLEN)

    char actual[41] = "\0";
    BYTE_ARRAY_TO_STRING_ARRAY(hash, actual, hash_len)

    char expected[] = "407cfc525a8048ce69070f1b6aaa796f395f784c\0";
    CU_ASSERT_STRING_EQUAL(actual, expected)
}

void test5(void)
{
    char message[] = "Hello World!";
    unsigned int nonce = proof_of_work(message, 1); // difficulty level 1

    CU_ASSERT_EQUAL(nonce, 334);
}

void test6(void)
{
    char message[] = "Hello World!";
    unsigned int nonce = proof_of_work(message, 2); // difficulty level 2

    CU_ASSERT_EQUAL(nonce, 9031);
}

void test7(void)
{
    char message[] = "Hello World!";
    unsigned int nonce = proof_of_work(message, 3); // difficulty level 3

    CU_ASSERT_EQUAL(nonce, 1219231);
}

void test8(void)
{
    char message[] = "Hello World, again!";
    unsigned int nonce = proof_of_work(message, 1); // difficulty level 1

    CU_ASSERT_EQUAL(nonce, 288);
}

void test9(void)
{
    char message[] = "Hello World, again!";
    unsigned int nonce = proof_of_work(message, 2); // difficulty level 2

    CU_ASSERT_EQUAL(nonce, 41034);
}

void test10(void)
{
    char message[] = "Hello World, again!";
    unsigned int nonce = proof_of_work(message, 3); // difficulty level 3

    CU_ASSERT_EQUAL(nonce, 73191);
}

/* The main() function for setting up and running the tests.
 * Returns a CUE_SUCCESS on successful running, another
 * CUnit error code on failure.
 */
int main()
{
    CU_pSuite pSuite = NULL;

    /* initialize the CUnit test registry */
    if (CUE_SUCCESS != CU_initialize_registry())
        return CU_get_error();

    /* add a suite to the registry */
    pSuite = CU_add_suite("Suite_1", init_suite1, clean_suite1);
    if (NULL == pSuite)
    {
        CU_cleanup_registry();
        return CU_get_error();
    }

    /* add the tests to the suite */
    /* NOTE - ORDER IS IMPORTANT */
    if (NULL == CU_add_test(pSuite, "test get_digest 1", test1) 
    || NULL == CU_add_test(pSuite, "test get_digest 2", test2) 
    || NULL == CU_add_test(pSuite, "test get_digest 3", test3) 
    || NULL == CU_add_test(pSuite, "test get_digest 4", test4) 
    || NULL == CU_add_test(pSuite, "test proof_of_work w/ difficulty 1", test5) 
    || NULL == CU_add_test(pSuite, "test proof_of_work w/ difficulty 2", test6) 
    || NULL == CU_add_test(pSuite, "test proof_of_work w/ difficulty 3", test7) 
    || NULL == CU_add_test(pSuite, "test proof_of_work w/ difficulty 1", test8) 
    || NULL == CU_add_test(pSuite, "test proof_of_work w/ difficulty 2", test9) 
    || NULL == CU_add_test(pSuite, "test proof_of_work w/ difficulty 3", test10))
    {
        CU_cleanup_registry();
        return CU_get_error();
    }

    /* Run all tests using the CUnit Basic interface */
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();
    return CU_get_error();
}
