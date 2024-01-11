package app;

import java.util.Scanner;

public class FibonacciVetor{
    
    public static void main(String[] args){
        
    	/* Exercício tirado do beecrowd
   	 	Faça um programa que leia um valor e apresente o número de Fibonacci correspondente 
   	 	a este valor lido. Lembre que os 2 primeiros elementos da série de Fibonacci 
   	 	são 0 e 1 e cada próximo termo é a soma dos 2 anteriores a ele. 
   	 	Todos os valores de Fibonacci calculados neste problema devem caber em um 
   	 	inteiro de 64 bits sem sinal.
   	 

		Entrada
		A primeira linha da entrada contém um inteiro T, indicando o número de casos de teste. 
		Cada caso de teste contém um único inteiro N (0 ≤ N ≤ 60), correspondente ao N-esimo 
		termo da série de Fibonacci.

		Saída
		Para cada caso de teste da entrada, imprima a mensagem "Fib(N) = X", 
		onde X é o N-ésimo termo da série de Fibonacci.*/
    	
        Scanner sc = new Scanner(System.in);
        
        int qtdNumeros = sc.nextInt();
        
        int[] vect = new int[qtdNumeros];
        
        adicionarNumeros(qtdNumeros, sc, vect);
        
        int maiorNum = maiorNumeroAdicionado(vect);
        maiorNum += 1;
        int[] fib = new int[maiorNum]; //Para poder ir até o index do maior número
        adicionarSequenciaFibonnaci(maiorNum, fib);
        
        mostrarRelacao(qtdNumeros, vect, fib);
        
        sc.close();
    }
    
    public static void adicionarNumeros(int qtdNumeros, Scanner sc, int[] vect) {
    	for (int i=0; i<vect.length; i++){
            vect[i] = sc.nextInt();
        }
    }
    
    public static int maiorNumeroAdicionado(int[] vect) {
    	int maiorNum = vect[0];
        for (int i=1; i<vect.length; i++){
            if (vect[i] > maiorNum){
                maiorNum = vect[i];
            }
        }
        return maiorNum;
    }
    
    public static void adicionarSequenciaFibonnaci(int maiorNum, int[] fib) {
    	fib[0] = 0;
        fib[1] = 1;
        int termo1 = 0;
        int termo2 = 1;
        int proximoTermo;
        for (int i=2; i<maiorNum; i++){
            proximoTermo = termo1 + termo2;
            fib[i] = proximoTermo;
            termo1 = termo2;
            termo2 = proximoTermo;
        }
    }
    
    public static void mostrarRelacao(int qtdNumeros, int[] vect, int[] fib) {
    	for (int i=0; i<qtdNumeros; i++){
            System.out.printf("Fib(%d) = %d%n", vect[i], fib[vect[i]]);
        }
    }
    
}