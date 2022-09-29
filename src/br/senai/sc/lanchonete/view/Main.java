package br.senai.sc.lanchonete.view;

import br.senai.sc.lanchonete.controller.PedidoController;
import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Outro;
import br.senai.sc.lanchonete.model.entities.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kenzo Sato
 * github - Kenzohfs
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Lanche> listaLanche = new ArrayList<Lanche>();
    private static ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();
    private static ArrayList<Outro> listaOutro = new ArrayList<Outro>();

    public static void main(String[] args) {
        menuGeral();
    }

    private static void menuGeral() {
        System.out.println("MENU\n-----------------\n1 - Cadastrar \n2 - Listar \n3 - Editar \n4 - Remover \n5 - Encerrar");
        int opcao = sc.nextInt();
        menu(opcao);
    }

    private static void menu(int opcao) {
        int tipo;
        switch (opcao) {
            case 1:
                tipo = selecionaTipo();
                cadastrar(tipo);
                break;
            case 2:
                tipo = selecionaTipo();
                listar(tipo);
                break;
            case 3:
                tipo = selecionaTipo();
                editar(tipo);
                break;
            case 4:
                tipo = selecionaTipo();
                remover(tipo);
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
        menuGeral();
    }

    private static void cadastrar(int tipo) {
        int confirmacao;
        String tipoPedido = null;
        Pedido pedido = null;
        switch (tipo) {
            case 1:
                pedido = coletaDadosBebida();
                tipoPedido = "Bebida";
                break;
            case 2:
                pedido = coletaDadosLanche();
                tipoPedido = "Lanche";
                break;
            case 3:
                pedido = coletaDadosOutro();
                tipoPedido = "Outro";
                break;
        }

        System.out.println(pedido.toString() + "\nDeseja adicionar o novo " + tipoPedido + "? \n1 - Sim \n2 - Não");
        confirmacao = sc.nextInt();
        switch (confirmacao) {
            case 1:
                PedidoController pedidoController = new PedidoController();
                pedidoController.cadastrarLanche(pedido);
                System.out.println("Cadastramento concluído");
                break;
            case 2:
                System.out.println("Cadastramento cancelado!");
                break;
        }
    }

    private static Lanche coletaDadosLanche() {
        Pedido pedido = coletaDadosPedido(2);
        System.out.println("Peso: ");
        double peso = sc.nextDouble();
        Lanche lanche = new Lanche(pedido.getDescricaoPedido(), pedido.getCodigo(), pedido.getPrecoPedido(), peso);
        return lanche;
    }

    private static Bebida coletaDadosBebida() {
        Pedido pedido = coletaDadosPedido(1);
        System.out.println("Volume: ");
        double volume = sc.nextDouble();
        Bebida bebida = new Bebida();
        bebida.setCodigoPedido(pedido.getCodigo());
        bebida.setDescricaoPedido(pedido.getDescricaoPedido());
        bebida.setPrecoPedido(pedido.getPrecoPedido());
        bebida.setVolumeBebida(volume);
        return bebida;
    }

    private static Outro coletaDadosOutro() {
        Pedido pedido = coletaDadosPedido(3);
        System.out.println("Tamanho: ");
        String tamanho = sc.next();
        Outro outro = new Outro();
        outro.setCodigoPedido(pedido.getCodigo());
        outro.setDescricaoPedido(pedido.getDescricaoPedido());
        outro.setPrecoPedido(pedido.getPrecoPedido());
        outro.setTamanhoOutro(tamanho);
        return outro;
    }

    private static Pedido coletaDadosPedido(int tipo) {
        System.out.println("Informe os dados: \nCódigo:");
        int codigo = sc.nextInt();
        while (valida(tipo, codigo)) {
            System.out.println("Código já cadastrado! \nCódigo:");
            codigo = sc.nextInt();
        }
        System.out.println("Descrição: ");
        String descricao = sc.next();
        System.out.println("Preço: ");
        double preco = sc.nextDouble();
        Pedido pedido = new Pedido(descricao, codigo, preco);
        return pedido;
    }

    private static void listar(int tipo) {
        System.out.println(new PedidoController().listar(tipo));
    }

    private static void editar(int tipo) {
        System.out.println("Informe o código do produto: ");
        int codigo = sc.nextInt();
        while (!valida(tipo, codigo)) {
            System.out.println("Código não registrado! \nCódigo:");
            codigo = sc.nextInt();
        }
        System.out.println("Informe o novo preço: ");
        double preco = sc.nextDouble();
        PedidoController pedidoController = new PedidoController();
        pedidoController.editarPedido(tipo, codigo, preco);
        System.out.println("Edição feita com sucesso!");
    }

    private static void remover(int tipo) {
        System.out.println("Código: ");
        int codigo = sc.nextInt();
        while (!valida(tipo, codigo)) {
            System.out.println("Código inválido! \nCódigo:");
            codigo = sc.nextInt();
        }

        PedidoController controller = new PedidoController();

        Pedido pedido = controller.buscarPedidoPorCodigo(codigo, tipo);
        System.out.println(pedido.toString() + "\nDeseja remover o " + pedido.getDescricaoPedido() + "? \n1 - Sim \n2 - Não");
        int confirmacao = sc.nextInt();
        switch (confirmacao) {
            case 1:
                controller.removerPedido(codigo, tipo);
                System.out.println("Remoção concluída");
                break;
            case 2:
                System.out.println("Remoção cancelada!");
                break;
        }
    }

    private static boolean valida(int tipo, int codigo) {
        return new PedidoController().buscarCodigoPedido(tipo, codigo);
    }

    private static int selecionaTipo() {
        System.out.println("Selecione: \n1 - Bebida \n2 - Lanche \n3 - Outro");
        int tipo = sc.nextInt();
        while (tipo > 4 || tipo < 1) {
            System.out.println("Opção inválida!");
            System.out.println("Selecione: \n1 - Bebida \n2 - Lanche \n3 - Outro");
            tipo = sc.nextInt();
        }
        return tipo;
    }
}
