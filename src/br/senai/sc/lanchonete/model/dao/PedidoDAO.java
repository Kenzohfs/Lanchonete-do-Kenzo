package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Outro;
import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.factory.ConexãoFactory;
import br.senai.sc.lanchonete.model.factory.PedidoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PedidoDAO {
    private Connection connection;

    public PedidoDAO() {
        this.connection = new ConexãoFactory().connectDB();
    }

    public void cadastrarPedido(Pedido pedido) {
        String campoAdicional = getTipoPedido(pedido);
        String sql = "INSERT INTO pedido (" +
                "codigopedido, descricaopedido, precopedido, " + campoAdicional + ", tipopedido) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, pedido.getCodigo());
            pstm.setString(2, pedido.getDescricaoPedido());
            pstm.setDouble(3, pedido.getPrecoPedido());
            if (pedido instanceof Bebida) {
                pstm.setDouble(4, ((Bebida) pedido).getVolumeBebida());
            } else if (pedido instanceof Lanche) {
                pstm.setDouble(4, ((Lanche) pedido).getPesoLanche());
            } else {
                pstm.setString(4, ((Outro) pedido).getTamanhoOutro());
            }
            pstm.setInt(5, pedido instanceof Bebida ? 1 :
                    pedido instanceof Lanche ? 2 : 3);
            System.out.println(pstm);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }

    private String getTipoPedido(Pedido pedido) {
        if (pedido instanceof Bebida) {
            return "volumeBebida";
        } else if (pedido instanceof Lanche) {
            return "pesoLanche";
        } else {
            return "tamanhoOutro";
        }
    }

    public ArrayList<Pedido> listarPedidos(int tipo) {
        String sql = "SELECT * FROM pedido WHERE tipopedido = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, tipo == 1 ? "BEBIDA" : tipo == 2 ? "LANCHE" : "OUTRO");
            try (ResultSet resultSet = pstm.executeQuery()) {
                ArrayList<Pedido> pedidos = new ArrayList<>();
                while (resultSet.next() && resultSet != null) {
                    pedidos.add(extrairObjeto(resultSet));
                }
                return pedidos;
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }


    public boolean buscarCodigoPedido(int tipoPedido, int codigoPedido) {
        String sql = "SELECT * FROM pedido WHERE tipopedido = ? AND codigopedido = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, tipoPedido);
            pstm.setInt(2, codigoPedido);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }

    public Pedido buscarPedidoPorCodigo(int codigo, String tipoPedido) {
        String sql = "SELECT * FROM pedido WHERE codigopedido = ? AND tipopedido = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, codigo);
            pstm.setString(2, tipoPedido);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                } else {
                    return null;
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }

    public void removerPedido(int codigo, String tipoPedido) {
        String sql = "DELETE FROM pedido WHERE codigopedido = ? AND tipopedido = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, codigo);
            pstm.setString(2, tipoPedido);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }

    public void editarPedido(String tipoPedido, int codigo, double preco) {
        String sql = "UPDATE pedido SET precopedido = ? WHERE codigopedido = ? AND tipopedido = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setDouble(1, preco);
            pstm.setInt(2, codigo);
            pstm.setString(3, tipoPedido);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }

    private Pedido extrairObjeto(ResultSet resultSet) {
        try {
            Pedido pedido = new PedidoFactory().getPedido(resultSet.getInt("codigopedido"), resultSet.getString("descricaopedido"), resultSet.getDouble("precopedido"), resultSet.getDouble("volumebebida"), resultSet.getDouble("pesolanche"), resultSet.getString("tamanhooutro"), resultSet.getString("tipopedido"));
            return pedido;
        } catch (Exception e) {
            throw new RuntimeException("Erro na extração do objeto");
        }
    }

    public double getVolume(Pedido pedido) {
        if (pedido instanceof Bebida) {
            return ((Bebida) pedido).getVolumeBebida();
        }
        return 0;
    }

    public double getPeso(Pedido pedido) {
        if (pedido instanceof Lanche) {
            return ((Lanche) pedido).getPesoLanche();
        }
        return 0;
    }

    public String getTamanho(Pedido pedido) {
        if (pedido instanceof Outro) {
            return ((Outro) pedido).getTamanhoOutro();
        }
        return null;
    }
}