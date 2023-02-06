package cadpessoa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CadPessoa {

   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        List<Lista> lista = new ArrayList<>(); // CRIAR UMA LISTA
        Lista pes = new Lista(); // CONECTAR A CLASSE LISTA
        DateTimeFormatter x = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // FORMATAÇÃO PARA DIA/MES/ANO
        LocalDate data; // VARIAVEL PARA DATA DE NASCIMENTO
        LocalDate hoje = LocalDate.now(); // DATA DE HOJE
        
        byte cont = 0; // VARIAVEL
        
        while(cont != 4){
            
            System.out.println("\n\n\t___MENU___");
            System.out.println("\n1 - Cadastrar \n2 - Procurar \n3 - Ordenar a lista \n4 - Sair");
            System.out.print("\nEscolha a opção: ");
            cont = sc.nextByte();
            sc.nextLine();
            
            if(cont == 1){
                System.out.println("\n\n___Cadastrar Pessoa___");
                    System.out.print("\nNome: ");
                    String nome = sc.nextLine();
                        System.out.print("\nSexo: M ou F: ");
                        String sexo = sc.nextLine();
                            System.out.println("\n\tNascimento ");
                            System.out.print("Dia: ");
                            int dia = sc.nextInt();
                            System.out.print("\nMês: ");
                            int mes = sc.nextInt();
                            System.out.print("\nAno: ");
                            int ano = sc.nextInt();
                            data =  LocalDate.of(ano, mes, dia); //SALVAR A DATA DE NASCIMENTO NA ORDEM ISO...
                                pes = new Lista(nome, sexo, data); //SALVAR OS DADOS NA CLASSE LISTA - CONSTRUTOR
                                lista.add(pes); // SALVAR A CLASSE LISTA NA LISTA                               
                System.out.println("\tCadastro efetuadocom sucesso!");
            }//FIM DA OPÇÃO 1
            
            if(cont == 2){
                System.out.println("\n\n___PROCURAR PESSOA___");
                System.out.print("\nNome: ");
                String nome = sc.nextLine();
                
                boolean enc = false;
                
                for(Lista a : lista){
                    if(a.getNome().equals(nome)){
                    enc = true;
                    }
                    if(!a.getNome().equals(nome)){
                        enc = false;
                    }
                    if(enc == true){
                        System.out.println("\n\n\n\t___Pessoa Encontrada___ \nNome: " + a.getNome() 
                                + "\nSexo: " + a.getSexo() + "\nNascimento: " + x.format(a.getNascimento())); 
                        Period idades = Period.between(a.getNascimento(), hoje);
                        int idad = idades.getYears(); // CALCULAR A IDADE EM ANOS
                        System.out.println("A idade de " + a.getNome() + " é " + idad + " anos.");
                    }              
                }       
        }//FIM DA OPÇÃO 2
            
            if(cont == 3){
                System.out.println("\t___ORDENAR A LISTA___");
                System.out.println("\n1 - Do mais velho ao mais novo \n2 - Do mais novo ao mais velho");
                System.out.print("\nEscolha a opção: ");
                byte op = sc.nextByte();
                
                if(op == 1){ // ORDENAR DO MAIS VELHO AO MAIS JOVEM
                Collections.sort(lista, new Comparator <Lista>() {
                    @Override
                    public int compare(Lista o1, Lista o2) {
                       return o1.getNascimento().compareTo(o2.getNascimento());
                    }
                });
                System.out.println("\n\n\t___Mais VELHO ao mais Jovem___");
                for(Lista a : lista){
                    Period idades = Period.between(a.getNascimento(), hoje);
                    int idad = idades.getYears();
                    System.out.println("\n\nNome: " + a.getNome() 
                                + "\nSexo: " + a.getSexo() + "\nIdade: " + idad); 
                }            
            } // FIM DO OP 1 
                if(op == 2){ // ORDENAR DO MAIS JOVEM AO MAIS VELHO
                    Collections.sort(lista, new Comparator <Lista>() {
                    @Override
                    public int compare(Lista o1, Lista o2) {
                       return o2.getNascimento().compareTo(o1.getNascimento());
                    }
                });                          
                    System.out.println("\n\n\t___Mais JOVEM ao mais Velho___");
                for(Lista a : lista){
                    Period idades = Period.between(a.getNascimento(), hoje);
                    int idad = idades.getYears();
                    System.out.println("\n\nNome: " + a.getNome() 
                                + "\nSexo: " + a.getSexo() + "\nIdade: " + idad); 
                }
            } //FIM DA OP 2
            }// FIM DA OPÇÃO 3
            
        }//FIM DO WHILE
        
        System.out.println("\n\n\nObrigado por usar esse PROGRAMA !!!");       
   
        sc.close();
    }
    
    }