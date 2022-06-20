package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Business.Livro;


public class LivroDAO implements DAO<Livro, String> {
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public LivroDAO(String filename) throws IOException {
		file = new File(filename);
		if (file.exists())
			file.delete();
		fos = new FileOutputStream(file, false); 
		outputFile = new ObjectOutputStream(fos);
	}

	public void add(Livro Livro) {
		try {
			outputFile.writeObject(Livro);
		} catch (Exception e) {
			System.out.println("ERRO ao gravar o Livro" + Livro.getTitulo() + "' no disco!");
			e.printStackTrace();
		}
	}

	public Livro get(String chave) {
		Livro Livro = null;

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {
			while (fis.available() > 0) {
				Livro = (Livro) inputFile.readObject();

				if (chave.equals(Livro.getCodigo())) {
					return Livro;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler o Livro '" + chave + "' do disco!");
			e.printStackTrace();
		}
		return null;
	}

	public List<Livro> getAll() {
		List<Livro> Livros = new ArrayList<Livro>();
		Livro Livro = null;
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				Livro = (Livro) inputFile.readObject();
				Livros.add(Livro);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Livro no disco!");
			e.printStackTrace();
		}
		return Livros;
	}

	public void update(Livro p) {
		List<Livro> Livros = getAll();
		int index = Livros.indexOf(p);
		if (index != -1) {
			Livros.set(index, p);
		}
		saveToFile(Livros);
	}

	public void delete(Livro p) {
		List<Livro> Livros = getAll();
		int index = Livros.indexOf(p);
		if (index != -1) {
			Livros.remove(index);
		}
		saveToFile(Livros);
	}

	private void saveToFile(List<Livro> Livros) {
		try {
			close();
			fos = new FileOutputStream(file, false); 
			outputFile = new ObjectOutputStream(fos);

			for (Livro Livro : Livros) {
				outputFile.writeObject(Livro);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Livro no disco!");
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
