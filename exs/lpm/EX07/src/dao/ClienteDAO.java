package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Business.Cliente;


public class ClienteDAO implements DAO<Cliente, String> {
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public ClienteDAO(String filename) throws IOException {
		file = new File(filename);
		if (file.exists())
			file.delete();
		fos = new FileOutputStream(file, false); 
		outputFile = new ObjectOutputStream(fos);
	}

	public void add(Cliente cliente) {
		try {
			outputFile.writeObject(cliente);
		} catch (Exception e) {
			System.out.println("ERRO ao gravar o Cliente" + cliente.getNome() + "' no disco!");
			e.printStackTrace();
		}
	}

	public Cliente get(String chave) {
		Cliente cliente = null;

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {
			while (fis.available() > 0) {
				cliente = (Cliente) inputFile.readObject();

				if (chave.equals(cliente.getMatricula())) {
					return cliente;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler o Cliente '" + chave + "' do disco!");
			e.printStackTrace();
		}
		return null;
	}

	public List<Cliente> getAll() {
		List<Cliente> Clientes = new ArrayList<Cliente>();
		Cliente Cliente = null;
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				Cliente = (Cliente) inputFile.readObject();
				Clientes.add(Cliente);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Cliente no disco!");
			e.printStackTrace();
		}
		return Clientes;
	}

	public void update(Cliente p) {
		List<Cliente> Clientes = getAll();
		int index = Clientes.indexOf(p);
		if (index != -1) {
			Clientes.set(index, p);
		}
		saveToFile(Clientes);
	}

	public void delete(Cliente p) {
		List<Cliente> Clientes = getAll();
		int index = Clientes.indexOf(p);
		if (index != -1) {
			Clientes.remove(index);
		}
		saveToFile(Clientes);
	}

	private void saveToFile(List<Cliente> Clientes) {
		try {
			close();
			fos = new FileOutputStream(file, false); 
			outputFile = new ObjectOutputStream(fos);

			for (Cliente Cliente : Clientes) {
				outputFile.writeObject(Cliente);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Cliente no disco!");
			e.printStackTrace();
		}
	}
	
	private void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.close();
	}

}
