/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ModuloConexao;
import view.TelaLogin;
import view.TelaPrincipal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GERAL
 */
public class ClienteDAO {
    
    private Connection conexao;
    
    public ClienteDAO() {
        this.conexao = ModuloConexao.conectar();
    }
     
    public List<Cliente> listarCliente() {
        

            //1 passo criar a lista
            List<Cliente> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            
            String sql = "select * from tbclientes";
            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();){
            

                while (rs.next()) {
                    Cliente obj = new Cliente();

                    obj.setId(rs.getInt("idcli"));
                    obj.setNome(rs.getString("nomecli"));
                    obj.setEndereco(rs.getString("endcli"));
                    obj.setFone(rs.getString("fonecli"));
                    obj.setEmail(rs.getString("emailcli"));
                    lista.add(obj);
                }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
    /**
     * Método responsável pela pesquisa de clientes pelo nome com filtro
     */
    public List<Cliente> listarClienteNome(String nome) {
        try {

            //1 passo criar a lista
            List<Cliente> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select idcli as id, nomecli as nome, endcli as endereço, fonecli as fone, emailcli as email from tbclientes where nomecli like ?";
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEndereco(rs.getString("endereço"));
                obj.setFone(rs.getString("fone"));
                obj.setEmail(rs.getString("email"));
                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }
}

