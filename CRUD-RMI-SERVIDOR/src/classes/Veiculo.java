package classes;

import dao.VeiculoDAO;
import interfaces.InterfaceVeiculo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Veiculo extends UnicastRemoteObject implements InterfaceVeiculo {
    private String marca;
    private String modelo;
    private String placa;

    public Veiculo() throws RemoteException {
        System.out.println("A classe Veiculo está disponível remotamente");
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public String getPlaca() {
        return placa;
    }
    
    @Override
    public void insert(){
        VeiculoDAO.insert(this);
    }

    @Override
    public ArrayList<Veiculo> select() {
        return VeiculoDAO.select();
    }
}
