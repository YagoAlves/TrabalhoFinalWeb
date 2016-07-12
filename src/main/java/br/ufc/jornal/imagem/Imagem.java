package br.ufc.jornal.imagem;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class Imagem {

	public static void salvarImagem (String caminho, MultipartFile imagem){
		File file = new File(caminho);
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
			System.out.println("Salvo em:"+ file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


