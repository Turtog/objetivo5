package br.edu.ifsul.cstsi.objetivo5.animais;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class AnimalController {
    private static final Scanner input = new Scanner(System.in);
    private static AnimalService animalService;

    public AnimalController(AnimalService AnimalService) {
        AnimalController.animalService = AnimalService;
    }

    public static void main(String[] args) {

        int opcao;

        do{
            System.out.print("\n\"-------  MENU animal -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo animal
                        2. Atualizar um animal
                        3. Excluir um animal (tornar inativo)
                        4. Ativar ou Desativar um animal
                        5. Listar todos os animais
                        6. Buscar animal pelo código
                        7. Buscar animal pelo nome
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectanimais();
                case 5 -> selectanimaisById();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
    //opção 1
    private static void inserir() {
        Animal animal = new Animal();
        System.out.println("\n++++++ Cadastro de novo Animal ++++++");
        System.out.print("Digite o nome do Animal: ");
        animal.setNome_animal(input.nextLine());
        System.out.print("\nDigite a idade do Animal: ");
        animal.setIdade_animal(Integer.parseInt(input.nextLine()));
        System.out.print("\nDigite o sexo do Animal: ");
        animal.setSexo_animal(Integer.parseInt(input.nextLine()));
        System.out.println("Animal salvo com sucesso:" + animalService.insert(animal));
    }

    private static void atualizar() {
        System.out.println("\n++++++ Alterar um animal ++++++");
        Animal animal;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do animal (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                animal = animalService.getAnimalById(codigo);
                if (animal == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Nome: " + animal.getNome_animal());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome do Animal: ");
                        animal.setNome_animal(input.nextLine());
                    }
                    System.out.println("Idade: " + animal.getIdade_animal());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a nova idade do Animal: ");
                        animal.setIdade_animal(input.nextInt());
                    }
                    System.out.println("Sexo: " + animal.getSexo_animal());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo sexo do Animal: ");
                        animal.setSexo_animal(input.nextInt());
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void excluir() {
        System.out.println("\n++++++ Excluir um Animal ++++++");
        Animal animal;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do Animal (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                animal = animalService.getAnimalById(codigo);
                if (animal == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(animal);
                    System.out.print("Excluir este Animal? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        animalService.delete(animal.getId());
                        System.out.println("Animal excluído com sucesso:" + animal);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectanimais() {
        System.out.println("\nLista de Animais cadastrados no banco de dados:\n"
                + animalService.getAnimais());
    }

    private static void selectanimaisById() {
        System.out.print("\nDigite o código do animal: ");
        Animal animal = animalService.getAnimalById(input.nextLong());
        input.nextLine();
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Código não localizado.");
        }
    }

    private static void selectanimaisByNome() {
        System.out.print("Digite o nome do Animal: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Animal> animais = animalService.getAnimaisByNome(nome + "%");
        if (animais.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + nome);
        } else {
            System.out.println(animais);
        }
    }

}

