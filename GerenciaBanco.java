
package com.mycompany.gerenciabanco;
//importação da biblioteca necessária para utilização do método Scanner
import java.util.*;
 
//criação da classe GerenciaBanco
public class GerenciaBanco {
    //criação dos atributos da classe
    public String nome;
    public String Sobrenome;
    public String CPF;
    public Double saldo = 100.00;
    public Double valor;
    public String opcao;
    
    //criação do método main, necessário para que o java saiba de onde começar
    //esse primeiro metodo irá criar um objeto e guardar as informações de nome,
    //sobrenome e CPF
    public static void main(String[] args) {
        //construtor para criar um novo objeto chamado cliente
        GerenciaBanco cliente = new GerenciaBanco();
        //construtor para utilização do scanner, necessário para capturar o que
        //o usuário digita
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");  //texto no console solicitando
                                                  //a entrada de um nome
        cliente.nome = scanner.nextLine();  //variável nome do objeto cliente 
                                            //recebe o input digitado
        
        //texto no console solicitando a entrada de sobrenome
        System.out.print("Digite seu Sobrenome: "); 
        //variável sobrenome do objeto cliente recebe o input digitado
        cliente.Sobrenome = scanner.nextLine(); 
        //texto no console solicitando a entrada de CPF
        System.out.print("Digite seu CPF: ");  
        //variável CPF do objeto cliente recebe o input digitado
        cliente.CPF = scanner.nextLine(); 
        
        boolean validaCPF = false;  // booleano colocado em FALSO, necessário
                                    //para dar condicional de looping caso o CPF
                                    //não tenha a quantidade correta de digitos
        while(!validaCPF){ //enquanto a variável for FALSA o looping recomeça
            // comando verificador se digitados 11 caracteres do tipo número
            if (cliente.CPF.matches("\\d{11}")){ 
                // troca a variável booleana para TRUE, fim do looping
                validaCPF = true;
            
            
            } else {//caso não atenda as especificações entramos no else que 
                    //informa o usuário e solicita nova entrada de dados
                System.out.println("CPF inválido. O CPF deve conter 11 dígitos numéricos.");
                System.out.print("Digite seu CPF: ");
                cliente.CPF = scanner.nextLine();
            
            }
        }
        
        cliente.menu();// depois de sair do looping, é chamado o metodo menu
        scanner.close();// fecha o metodo scanner para poupar recursos
    }
    
    //metodo para criação de um depósito em conta
    public void  deposito(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor que deseja depositar: ");
        valor = Double.parseDouble(scanner.nextLine());//converte a string 
                                                         //em tipo double
        
        // o saldo recebe ele mesmo + a quantidade da variavel valor
        saldo += valor;
        System.out.println("Seu Saldo Atual é: R$ " + saldo);
        valor = 0.0;//como esta variavel será utilizada tanto para acrescimo 
                    //quanto para retirada, zerei o valor dela para uso futuro
        menu();// finalizado o processo é chamado o metodo menu
        
    } 
    
    //metodo para retirada de valores da conta
    public void saque(){
        Scanner scanner = new Scanner(System.in);
        
        //booleano criado para verificar se o saque é menor que o valor em saldo
        //e criar o sistema de looping
        boolean valorSaque = false;
        while(!valorSaque){
            try{//foi utilizado o try / catch para tratar de excessoes, exemplo:
                //utilizar letras ao invés de numeros
                System.out.print("Digite o valor que deseja sacar: ");
                //convertendo mais uma vez string em double
                valor = Double.parseDouble(scanner.nextLine());
                //se o valor for maior que o saldo, informa o usuário
                if(valor > saldo){
                    System.out.println("Saldo insuficiente. Seu saldo atual é: R$ " + saldo);
                }
                else{//caso o valor requisitado seja menor que o saldo
                    saldo -= valor; //valor abate do saldo
                    System.out.println("Seu Saldo Atual é: R$ " + saldo);
                    valor = 0.0; // zerado variavel valor para uso futuro
                    valorSaque = true;// booleano recebe verdadeiro e sai do looping
                }
            
            //tratamento caso não seja usado o campo numérico
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida. Digite um valor numérico.");
            }
        }
        menu(); //chama o metodo menu
        
    }
    
    //metodo criado para apresentar as opções ao usuário
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem vindo(a) " + nome +" "+ Sobrenome);
        System.out.println("Seu Saldo Atual é: R$ " + saldo);
        System.out.println("O que deseja fazer?");
        System.out.println("Para deposito digite 1");
        System.out.println("Para saque digite 2");
        System.out.println("Para encerrar o aplicativo digite 3");
        opcao = scanner.nextLine();
    
        switch(opcao){//switch/case para selecionar quais dos metodos será chamado
        case "1":
            deposito();
            break;
        case "2":
            saque();
            break;
        case "3":
            encerra();
            break;
            
        default:
                System.out.println("Opção inválida.");
                menu();
        }
        
        
    }
    
    //metodo para finalizar o serviço bancario
    public void encerra(){
        System.out.println("Obrigado por utilizar nossos serviços, sessão encerrada.");
    }
}   