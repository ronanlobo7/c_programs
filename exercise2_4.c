/* Implement a C program to read, display and to find the product of two matrices
    using functions with suitable parameters. Note that the matrices should be created
    using dynamic memory allocation functions and the elements are accessed using
    array dereferencing.
*/
#include<stdio.h>
#include<stdlib.h>

int **Alloc(int, int);
void ReadMat(int**, int, int);
void DispMat(int**, int, int);
void MatMul(int**, int**, int**, int, int, int, int);
void FreeMat(int**, int, int);

int main(void) {
    int m1, n1, m2, n2, r1, r2;
    int **A, **B, **R;

    printf("Enter the dimensions of the first matrix: ");
    scanf("%d %d", &m1, &n1);
    printf("Enter the dimensions of the second matrix: ");
    scanf("%d %d", &m2, &n2);

    if(n1 != m2) {
        printf("Invalid matrix dimensions for multiplication of two matrices.\n");
        exit(1);
    } 
    else {
        r1 = m1;
        r2 = n2;
    }

    A = Alloc(m1, n1);
    printf("Enter the elements of the first matrix, A: \n");
    ReadMat(A, m1, n1);

    B = Alloc(m2, n2);
    printf("Enter the elements of the first matrix, B: \n");
    ReadMat(B, m2, n2);

    R = Alloc(r1, r2);
    MatMul(A, B, R, m1, n1, m2, n2);

    printf("The first matrix A read is: \n");
    DispMat(A, m1, n1);

    printf("The second matrix B read is: \n");
    DispMat(B, m2, n2);

    printf("The resultant matrix of the matrix multiplication of A and B: \n");
    DispMat(R, r1, r2);

    FreeMat(A, m1, n1);
    FreeMat(B, m2, n2);
    FreeMat(R, r1, r2);

    return 0;
}

int **Alloc(int m, int n) {
    int **Matrix = (int **) calloc(m, sizeof(int*));
    for(int i=0; i<m; i++) {
        *(Matrix + i) = (int *) calloc(n, sizeof(int));
    }
    return Matrix;
}

void ReadMat(int **Matrix, int m, int n) {
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            scanf("%d", *(Matrix + i) + j);
        }
    }
}

void DispMat(int **Matrix, int m, int n) {
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            printf("%3d\t", *(*(Matrix + i) + j));
        }
        printf("\n");
    }
}

void MatMul(int **A, int **B, int **R, int m1, int n1, int m2, int n2) {
    for(int i=0; i<m1; i++) {
        for(int j=0; j<n2; j++) {
            *(*(R + i) + j) = 0;
            for(int k=0; k<n1; k++) {
                *(*(R + i) + j) += (*(*(A + i) + k)) * (*(*(B + k) + j));
            }
        }
    }
}

void FreeMat(int **Matrix, int m, int n) {
    for(int i=0; i<m; i++) {
        free(*(Matrix + i));
    }
    free(Matrix);
}
