package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas aulas tem o curso? ");
        int N = sc.nextInt();

        List<Lesson> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            System.out.printf("\nDados da %da aula:%n", i+1);
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Título: ");
            String titulo = sc.nextLine();

            if(type == 'c'){
                System.out.print("URL do video: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int duracao = sc.nextInt();
                list.add(new Video(titulo, url, duracao));
            } else if (type == 't'){
                System.out.print("Descrição: ");
                String descricao = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int qtdQuestoes = sc.nextInt();
                list.add(new Task(titulo,descricao,qtdQuestoes));
            }
            sc.nextLine();
        }

        int duracaoTotal = 0;
        for(Lesson ls : list){
            duracaoTotal += ls.duration();
        }

        System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + duracaoTotal + " segundos");

        sc.close();
    }
}
