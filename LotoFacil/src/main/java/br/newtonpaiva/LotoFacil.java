package br.newtonpaiva;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LotoFacil {

    public static void main(String[] args) throws IOException{
        menu();
    }

    private static void menu() throws IOException {
        int opcao = -1;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("**************************");
            System.out.println("Menu LOTOFÁCIL");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A á Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");

            System.out.print("\nEscolha uma opção para jogar: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    aposta1();
                    break;
                case 2:
                    aposta2();
                    break;
                case 3:
                    aposta3();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Você digitou uma opção inválida.\n");
                    break;
            }
        } while (opcao != 0);
    }

    private static void aposta1() {
        System.out.println("\nAposta de 0 a 100 selecionada.");
        Random rnd = new Random();
        int sorteio = rnd.nextInt(101);
        // System.out.println("Numero sorteado: " + sorteio);
        Scanner sc = new Scanner(System.in);
        System.out.print("Escolha um número de 0 a 100 para apostar.: ");
        int aposta = sc.nextInt();
        if(aposta == sorteio){
            System.out.println("Você ganhou R$ 1.000,00 reais.");
        }else {
            System.out.println("Que pena, você perdeu! O número sorteado foi: " + sorteio);
        }
        sc.close();
    }

    private static void aposta2() throws IOException {
        System.out.println("\nAposta de A á Z selecionada");
        char letraSorteada = 'J';
        System.out.print("Escolha uma letra de A á Z para apostar ");
        char letraApostada = (char)System.in.read();

        if(Character.isLetter(letraApostada)){
            char letraApostadaMaiusculo = Character.toUpperCase(letraApostada);
            if(letraApostadaMaiusculo == letraSorteada){
                System.out.println("Você ganhou R$ 500,00 reais.\n");
            }else {
                System.out.println("Que pena, você perdeu! A letra sorteada foi: " + letraSorteada + "\n");
            }
        }else{
            System.out.println("Não é uma letra válida.");
        }
    }

    private static void aposta3() {
        System.out.println("\nAposta em par ou ímpar selecionada.");
        System.out.print("Escolha um número inteiro para apostar: ");
        Scanner sc = new Scanner(System.in);
        int numeroDigitado = sc.nextInt();
        if(numeroDigitado % 2 == 0){
            System.out.println("Você ganhou R$ 100,00 reais.");
        }else{
            System.out.println("Que pena! Você perdeu, o sorteio era para números pares");
        }
    }
}