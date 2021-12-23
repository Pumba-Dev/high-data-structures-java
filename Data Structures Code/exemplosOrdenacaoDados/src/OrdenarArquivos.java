import java.io.File;

public class OrdenarArquivos {

	public static void main(String[] args) throws Exception {
		System.out.println(args[0]);
		File pasta = new File(args[0]);
		File[] arquivos = pasta.listFiles();		
		
		Insertion.sort(arquivos);
		
		System.out.println("#arquivos: "+arquivos.length);
		for (int i=0; i<arquivos.length; i++)
			System.out.println(arquivos[i].getName());
	}
}